package Students_Vaccine;

import java.io.Serializable;

public class Student implements Serializable {

    private String StudentID;
    private String StudentName;

    public Student() {

    }

    public Student(String studentID, String studentName) {
        this.StudentID = studentID;
        this.StudentName = studentName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    @Override
    public String toString() {
        return StudentID + ", " + StudentName;
    }

}
