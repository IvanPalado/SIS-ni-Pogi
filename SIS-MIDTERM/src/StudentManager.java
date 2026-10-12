
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public boolean findStudent(int studentId) {
        for (Student stud : students) {
            if (stud.getId() == studentId) {
                stud.displayInfo();
                return true;
            }
        }

        return false;
    }

    public void addStudent(Student student) {
        if (!findStudent(student.getId())) {
            students.add(student);
            return;
        }

        System.out.println("Student is already in list");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter student first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter student middle name: ");
        String middleName = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int numberOfSubject = sc.nextInt();
        
        Student student = new Student(id, lastName, firstName, middleName);

        for (int i = 0; i < numberOfSubject; i++) {
            System.out.println("\n===== Enter subject ====");
            System.out.print("Enter subject code: ");
            int subjectCode = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter subject name: ");
            String subjectName = sc.nextLine();

            System.out.print("Enter midterm grade: ");
            double midtermGrade = sc.nextDouble();

            System.out.print("Enter final grade: ");
            double finalGrade = sc.nextDouble();

            Subject subject = new Subject(subjectCode, subjectName, midtermGrade, finalGrade);
            student.addSubject(subject);
        }

        manager.addStudent(student);
        manager.findStudent(1);
    }

}
