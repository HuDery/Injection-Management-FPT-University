package Injection;

public class Injection {

    String injectionID;
    String studentID;
    String vaccineID;
    String place1;
    String date1;
    String place2 ;
    String date2 ;
    boolean mui1;
    boolean mui2;

    public Injection(String injectionID, String studentID, String place1, String date1, String vaccineID, boolean mui1, String place2, String date2, boolean mui2) {
        this.injectionID = injectionID;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
        this.place1 = place1;
        this.date1 = date1;
        this.place2 = place2;
        this.date2 = date2;
        this.mui1 = mui1;
        this.mui2 = mui2;
    }

    Injection() {

    }

    public String getInjectionID() {
        return injectionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public String getPlace1() {
        return place1;
    }

    public String getDate1() {
        return date1;
    }

    public String getPlace2() {
        return place2;
    }

    public String getDate2() {
        return date2;
    }

    public boolean isMui1() {
        return mui1;
    }

    public boolean isMui2() {
        return mui2;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public void setMui1(boolean mui1) {
        this.mui1 = mui1;
    }

    public void setMui2(boolean mui2) {
        this.mui2 = mui2;
    }

    @Override
    public String toString() {
        return output();
    }

    public String output() {
        String out = String.format("|%-13s|%-11s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-13s|", injectionID, studentID, vaccineID, place1, date1, mui1, place2, date2, mui2);
        return "|-------------|-----------|---------------|---------------|---------------|---------------|---------------|---------------|-------------| \n" + out;
    }

    public String outputTable() {
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("|%-58s%-77s| \n", "", "List of injections");
        System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("|%-13s|%-11s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-9s| \n", "InjectionID", "StudentID", "VacineID", "1st Place", "1st Date ", "1st Injection", "2nd Place", "2nd Date", "2nd Injection");
        return null;
    }
}
