package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
  // Attributes
  private final int id;
  private String name;
  private HashMap<String, Integer> grades;
  private static int idCounter = 0;

  // Getters & Setters
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashMap<String, Integer> getGrades() {
    return grades;
  }

  public static void resetIdCounter() {
    idCounter = 0;
  }

  // Constructors
  public Student(String name) {
    this.name = name;
    this.id = ++idCounter;
    this.grades = new HashMap<>();
  }

  // Methods
  public void addGrade(String subject, int grade) {
    grades.put(subject, grade);
  }

  public float getAverageGrade() {
    if (grades.isEmpty()) {
      return 0;
    }

    float sum = 0;
    for (int grade : grades.values()) {
      sum += grade;
    }

    return sum / grades.size();
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", grades=" + grades +
        '}';
  }

  public boolean equalsByValue(Student student) {
    return this.id == student.id && this.name.equals(student.name) && this.grades.equals(student.grades);
  }
}
