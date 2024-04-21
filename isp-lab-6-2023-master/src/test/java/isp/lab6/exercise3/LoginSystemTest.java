package isp.lab6.exercise3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

import static org.junit.Assert.*;

public class LoginSystemTest {
    private LoginSystem loginSystem;
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        user1 = new User("user1", "password1");
        user2 = new User("user2", "password2");
        loginSystem = new LoginSystem(new HashSet<>(), new OnlineStore(new ArrayList<>(), new HashMap<>()));
    }

    @Test
    public void testRegister() {
        loginSystem.register(user1.getUsername(), user1.getPassword());

        assertTrue(loginSystem.getUsers().contains(user1));
        assertFalse(loginSystem.getUsers().contains(user2));
    }

    @Test
    public void testLogin() {
        loginSystem.register(user1.getUsername(), user1.getPassword());
        loginSystem.register(user2.getUsername(), user2.getPassword());

        assertTrue(loginSystem.login(user1.getUsername(), user1.getPassword()));
        assertFalse(loginSystem.login(user2.getUsername(), user1.getPassword()));
    }

    @Test
    public void testLogout() {
        loginSystem.register(user1.getUsername(), user1.getPassword());
        loginSystem.login(user1.getUsername(), user1.getPassword());

        assertTrue(loginSystem.logout(user1.getUsername()));
    }
}