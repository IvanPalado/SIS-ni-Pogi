
public class Subject {

    private int subjectCode;
    private String subjectName;
    private double midtermGrade;
    private double finalGrade;

    public Subject(int subjectCode, String subjectName, double midtermGrade, double finalGrade) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.midtermGrade = midtermGrade;
        this.finalGrade = finalGrade;
    }

    public int getSubjectCode() {
        return this.subjectCode;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public double getMidtermGrade() {
        return this.midtermGrade;
    }

    public double getFinalGrade() {
        return this.finalGrade;
    }
}
