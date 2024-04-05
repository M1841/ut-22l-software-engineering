package isp.lab6.exercise1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestExercise1 {
  @Test
  public void testAddStudent() {
    Student.resetIdCounter();
    Student student1 = new Student("John");

    StudentManagement studentManagement = new StudentManagement();

    studentManagement.displayStudents();

    Assert.assertEquals(
        true,
        student1.equalsByValue(studentManagement.getStudents().get(1)));
  }

  @Test
  public void testAddGrade() {
    Student.resetIdCounter();
    Student student1 = new Student("John");

    StudentManagement studentManagement = new StudentManagement();

    studentManagement.addStudent(student1);
    studentManagement.addGrade(1, "Software Engineering", 10);
    HashMap<String, Integer> expectedGrades = new HashMap<>(Map.of("Software Engineering", 10));

    Assert.assertEquals(
        expectedGrades,
        studentManagement.getStudents().get(1).getGrades());
  }

  @Test
  public void testRemoveStudent() {
    Student.resetIdCounter();
    Student student1 = new Student("John");

    StudentManagement studentManagement = new StudentManagement();

    studentManagement.addStudent(student1);
    studentManagement.removeStudent(1);

    Assert.assertEquals(
        null,
        studentManagement.getStudents().get(1));
  }

  @Test
  public void testUpdateStudentName() {
    Student.resetIdCounter();
    Student student1 = new Student("John");

    StudentManagement studentManagement = new StudentManagement();

    studentManagement.addStudent(student1);
    studentManagement.updateStudentName(1, "Jack");

    Assert.assertEquals(
        "Jack",
        studentManagement.getStudents().get(1).getName());
  }
}
