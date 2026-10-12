
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private ArrayList<Subject> subjects;

    public Student(int id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public String getFullName() {
        return this.lastName + ", " + this.firstName + " " + this.middleName + ".";
    }

    public void displayInfo() {
        System.out.printf("Student ID: %d", this.id + "\n");
        System.out.println(getFullName());
        System.out.printf("\nMidterm avarage : %.2f", calculateMidtermAverage());
        System.out.printf("\nFinal avarage : %.2f", calculateFinalAverage());
        System.out.printf("\nGWA : %.2f", calculateGwa());

    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(int subjectCode) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getSubjectCode() == subjectCode) {
                subjects.remove(i);
                return;
            }
        }

        System.out.println("Subject not found.");
    }

    public void displaySubjects() {
        for (Subject subject : subjects) {
            System.out.println(
                    "Code: " + subject.getSubjectCode()
                    + " Subject: " + subject.getSubjectName()
            );
        }
    }

    public double calculateMidtermAverage() {
        double total = 0;
        for (Subject subject : subjects) {
            total += subject.getMidtermGrade();
        }

        return total / subjects.size();
    }

    public double calculateFinalAverage() {
        double total = 0;
        for (Subject subject : subjects) {
            total += subject.getFinalGrade();
        }

        return total / subjects.size();
    }

    public double calculateGwa() {
        return (calculateMidtermAverage() + calculateFinalAverage()) / 2;
    }

    // TODO: Add this methods
    /*
    calculateGwa()
    calculateFinalAverage()
    calculateMidtermAverage()
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student(1, "Palado", "Ivan", "Inigo");
        System.out.print("Enter number of subject: ");
        int numberOfSubject = sc.nextInt();

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

        student.displaySubjects();

        System.out.print("Enter subject code to remove: ");
        int code = sc.nextInt();
        student.removeSubject(code);
        student.displaySubjects();

        System.out.println("Midterm average: " + student.calculateMidtermAverage());
        System.out.println("Final average: " + student.calculateFinalAverage());
        System.out.println("GWA: " + student.calculateGwa());
    }
}
