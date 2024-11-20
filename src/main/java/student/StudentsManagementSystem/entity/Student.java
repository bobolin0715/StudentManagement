package student.StudentsManagementSystem.entity;
import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="student_name")
    private String student_name;

    @Column(name="chinese")
    private double chinese;

    @Column(name="english")
    private double english;

    @Column(name="math")
    private double math;

    @Column(name="average_score")
    private double averageScore;

    // define constructors
    public Student() {}

    public Student(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public void setAverageScore() {
        this.averageScore = (chinese + english + math) / 3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_name='" + student_name + '\'' +
                ", chinese=" + chinese +
                ", english=" + english +
                ", math=" + math +
                ", averageScore=" + averageScore +
                '}';
    }
}
