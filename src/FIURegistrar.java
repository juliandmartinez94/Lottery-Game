/**
 * Julian Martinez 3966887
 * Title: Array of Students
 * Semester: COP 2210, Fall 2023
 * Professor's Name(s): Prof. Charters , Niki Zarkub
 * Description of Program's Functionality:
 *      This program creates a Student object that is made up of a students first name, last name, Panther ID and
 *      GPA. This object is then used to create an array of Students that is determined by the amount of students
 *      the user wishes to process. The program then determines the highest GPA, lowest GPA, average GPA and also
 *      lists the student(s) with the above average GPAs.
 */

// Driver Class
import java.util.Scanner;
public class FIURegistrar {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Student[] students = createArrayOfStudents();
        processArrayOfStudents(students);
    }

    // In this method, an array of students is made depending on how many students the user wants to process
    public static Student[] createArrayOfStudents() {
        String firstName, lastName, pantherId;
        double gpa =0;


        System.out.println("How many students do you wish to process?");
        int numOfStudents = keyboard.nextInt();
        keyboard.nextLine();

        Student[] students = new Student[numOfStudents];

        for (int i = 0; i < students.length; i++) {
            System.out.println("What is the students last name?");
            lastName = keyboard.nextLine();
            System.out.println("What is the students first name?");
            firstName = keyboard.nextLine();
            System.out.println("What is the students Panther ID?");
            pantherId = keyboard.nextLine();

            boolean validGPA = false;
            while (!validGPA) {
                System.out.println("What is the students GPA?");
                gpa = keyboard.nextDouble();
                keyboard.nextLine();

                // Validation loop to ensure GPA entered is between 0 and 4.0
                if (gpa >= 0 && gpa <= 4.0) {
                    validGPA = true;
                } else {
                    System.out.println("Please enter a GPA between 0 and 4.0");
                }
            }
            Student someStudent = new Student(lastName, firstName, pantherId, gpa);
            students[i] = someStudent;
        }

        return students;
    }

    // In this method, the student object is passed as a parameter to determine the highest, lowest, and average GPAs
    public static void processArrayOfStudents(Student[] students){
        double highest = students[0].getGpa();
        double lowest = students[0].getGpa();
        Student studentHighestGPA = students[0];
        Student studentLowestGPA = students[0];
        double sum = 0.0;
        double avg;


        for(int i =0; i < students.length;i++){
            Student val = students[i];
            double gpa = val.getGpa();

            if (gpa > highest)
            {

                studentHighestGPA = val;
            }

            if (gpa < lowest)
            {

                studentLowestGPA = val;
            }

            sum += gpa;

            // the toString() method is used to print out the array of students
            System.out.println(val.toString());
        }

        avg = sum/students.length;

        // The average GPA, student with highest GPA, and student with lowest GPA are printed

        System.out.println();
        System.out.printf("Average GPA: %.2f", avg);
        System.out.println();
        System.out.println("Student with the highest GPA: " + studentHighestGPA.getFirstName() +
                ", " + studentHighestGPA.getLastName());
        System.out.println("Student with the lowest GPA: " + studentLowestGPA.getFirstName() +
                ", " + studentLowestGPA.getLastName());

        // Student(s) with a GPA above average are printed

        System.out.println("These are the student(s) with above average GPAs: ");
        for (int i = 0; i < students.length; i++){
            Student student = students[i];
            if(student.getGpa() > avg){
                System.out.println(student.getFirstName() +", "+ student.getLastName() );
            }
        }

    }
}
