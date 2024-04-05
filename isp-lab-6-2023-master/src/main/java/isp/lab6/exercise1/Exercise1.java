package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Student student1 = new Student("John");
        Student student2 = new Student("Jane");

        StudentManagement studentManagement = new StudentManagement();

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);

        studentManagement.addGrade(1, "Software Engineering", 10);
        studentManagement.addGrade(2, "Software Engineering", 9);
        studentManagement.addGrade(1, "Mechanical Engineering", 7);
        studentManagement.addGrade(2, "Mechanical Engineering", 8);

        studentManagement.updateStudentName(1, "Jack");

        studentManagement.displayStudents();

        System.out.println(
                "student1 average grade: " + studentManagement.getStudentAverageGrade(1));
        System.out.println(
                "student2 average grade: " + studentManagement.getStudentAverageGrade(2));
    }
}
