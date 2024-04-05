package isp.lab6.exercise1;

import java.util.HashMap;

public class StudentManagement {
  // Attributes
  private HashMap<Integer, Student> students;

  // Getters & Setters
  public HashMap<Integer, Student> getStudents() {
    return students;
  }

  // Constructors
  public StudentManagement() {
    this.students = new HashMap<>();
  }

  // Methods
  public void addStudent(Student student) {
    students.put(student.getId(), student);
  }

  public void addGrade(int id, String subject, int grade) {
    Student student = students.get(id);
    if (student != null) {
      student.addGrade(subject, grade);
    }
  }

  public void removeStudent(int id) {
    students.remove(id);
  }

  public void updateStudentName(int id, String name) {
    Student student = students.get(id);
    if (student != null) {
      student.setName(name);
    }
  }

  public float getStudentAverageGrade(int id) {
    Student student = students.get(id);
    if (student != null) {
      return student.getAverageGrade();
    }
    return -1;
  }

  public void displayStudents() {
    System.out.println(this.students);
  }
}
