package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface {
  // Attributes
  private Map<Tenant, AccessKey> validAccess;
  private int failedAttempts;
  private Door door;
  private List<AccessLog> accessLogs;

  // Getters & Setters
  public Map<Tenant, AccessKey> getValidAccess() {
    return this.validAccess;
  }

  public void setValidAccess(Map<Tenant, AccessKey> validAccess) {
    this.validAccess = validAccess;
  }

  public List<AccessLog> getAccessLogs() {
    return accessLogs;
  }

  // Constructors
  public DoorLockController(Map<Tenant, AccessKey> validAccess, Door door) {
    this.validAccess = validAccess;
    this.failedAttempts = 0;
    this.door = door;
    this.accessLogs = new ArrayList<>();
  }

  // Methods
  public DoorStatus enterPin(String pin)
      throws InvalidPinException, TooManyAttemptsException {

    if (failedAttempts >= 3) {
      if (pin == MASTER_KEY) {
        failedAttempts = 0;

        if (door.getStatus() == DoorStatus.OPEN) {
          door.lockDoor();

          accessLogs.add(new AccessLog(
              MASTER_TENANT_NAME,
              LocalDateTime.now(),
              "Door closed using master key",
              DoorStatus.CLOSED,
              null));

          return DoorStatus.CLOSED;
        } else {
          door.unlockDoor();

          accessLogs.add(new AccessLog(
              MASTER_TENANT_NAME,
              LocalDateTime.now(),
              "Door opened using master key",
              DoorStatus.OPEN,
              null));

          return DoorStatus.OPEN;
        }
      } else {
        door.lockDoor();

        String tenantName = null;

        for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
          if (entry.getValue().getPin().equals(pin)) {
            tenantName = entry.getKey().getName();
            break;
          }
        }

        accessLogs.add(new AccessLog(
            tenantName,
            LocalDateTime.now(),
            null,
            DoorStatus.OPEN,
            "Too many failed attempts"));

        throw new TooManyAttemptsException();
      }
    }

    List<AccessKey> accessKeys = new ArrayList<>(validAccess.values());

    for (AccessKey accessKey : accessKeys) {
      if (accessKey.getPin().equals(pin)) {
        failedAttempts = 0;

        if (door.getStatus() == DoorStatus.OPEN) {
          door.lockDoor();

          String tenantName = null;

          for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if (entry.getValue().getPin().equals(pin)) {
              tenantName = entry.getKey().getName();
              break;
            }
          }

          accessLogs.add(new AccessLog(
              tenantName,
              LocalDateTime.now(),
              "Door closed using pin",
              DoorStatus.CLOSED,
              null));

          return DoorStatus.CLOSED;
        } else {
          door.unlockDoor();

          String tenantName = null;

          for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if (entry.getValue().getPin().equals(pin)) {
              tenantName = entry.getKey().getName();
              break;
            }
          }

          accessLogs.add(new AccessLog(
              tenantName,
              LocalDateTime.now(),
              "Door opened using pin",
              DoorStatus.OPEN,
              null));

          return DoorStatus.OPEN;
        }
      }
    }

    failedAttempts++;
    if (failedAttempts >= 3) {
      door.lockDoor();

      accessLogs.add(new AccessLog(
          null,
          LocalDateTime.now(),
          null,
          DoorStatus.OPEN,
          "Too many failed attempts"));

      throw new TooManyAttemptsException();
    }

    door.lockDoor();

    accessLogs.add(new AccessLog(
        null,
        LocalDateTime.now(),
        null,
        DoorStatus.OPEN,
        "Invalid pin"));

    throw new InvalidPinException();
  }

  public void addTenant(String pin, String tenantName)
      throws TenantAlreadyExistsException {
    List<Tenant> tenants = new ArrayList<>(validAccess.keySet());

    for (Tenant tenant : tenants) {
      if (tenant.getName().equals(tenantName)) {
        throw new TenantAlreadyExistsException();
      }
    }

    AccessKey accessKey = new AccessKey(pin);
    Tenant tenant = new Tenant(tenantName);

    validAccess.put(tenant, accessKey);
  }

  public void removeTenant(String name)
      throws TenantNotFoundException {
    for (Tenant tenant : validAccess.keySet()) {
      if (tenant.getName().equals(name)) {
        validAccess.remove(tenant);
        return;
      }
    }

    throw new TenantNotFoundException();
  }
}
