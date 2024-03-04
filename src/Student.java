// Domain class
public class Student {

    //Attributes
    private String lastName, firstName;
    private String pantherId;
    private double gpa;

    //Constructor
    public Student(String firstName, String lastName, String pantherId, double gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pantherId = pantherId;
        this.gpa = gpa;
    }

    //Getters/Setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPantherId() {
        return pantherId;
    }

    public void setPantherId(String pantherId) {
        this.pantherId = pantherId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // toString() method

    public String toString(){
        return " Student " + pantherId + ": " + firstName + ", " + lastName + ", " + gpa;
    }
}
