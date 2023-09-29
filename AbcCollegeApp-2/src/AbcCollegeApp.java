import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Asandile Buthelezi
 */
public class AbcCollegeApp {

    // Declare the scanner class for the user input
    public static Scanner userInput = new Scanner(System.in);


    // Declare the arrayList for the storage of user entries
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static int userOption;

    //Declare the Student class so i can use it fields and objects

    public static void SaveStudent(Student student, ArrayList<Student> studentList) {
        // This method is used to capture a new student

        int initialsize = studentList.size();
        String message = "";
        studentList.add(student);
        //position++;

        if (studentList.size() > initialsize) {
            System.out.println("You have successfully captured the student");
        } else {
            System.out.println("You have not successfully captured the student");
        }

    }

    public static Student searchStudent(int searchId, ArrayList<Student> studentList) {
        // This method is used to search for the student that is needed by the user. the method returns the position in the arrayList

        // while statement = is to check if the id entered in by the user matches anyone in our system
        for (int g = 0; g < studentList.size(); g++) {

            if (searchId == studentList.get(g).getId()) {
                System.out.println("Student was found. Student ID exists");
                return studentList.get(g);
            }

        }

        System.out.println("Student was NOT found. Student ID doesn't exists");
        return null;
    }

    public static void deleteStudent(int deleteId, ArrayList<Student> studentList) {
        // This method is used to delete a student from the arrayList

        for (int g = 0; g < studentList.size(); g++) {

            if (deleteId == studentList.get(g).getId()) {
                studentList.remove(studentList.get(g));
                System.out.println("Student was found and deleted from the lists");
                break;
            }

        }
        System.out.println("Student was NOT  found and NOT deleted from the lists");

    }

    public static String studentReport(ArrayList<Student> studentList) {
        //This method displays the student report. Prints out the arrayList

        int count = 0;
        String temp = "";

        while (count < studentList.size()) {
            temp += studentList.get(count);
            count++;
        }

        return temp;
    }

    public static boolean validStudentAge(Object age) {
        //This method displays the student report. Prints out the arrayList

        if (age instanceof Integer) {
            System.out.println("You have entered the correct student age");
            return (Integer) age > 16;
        } else {
            System.out.println("You have entered a incorrect student age!!!");
            return false;
        }
    }

    public static String exitStudentApplication() {
        //This method is used to when the user is exiting the application

        String message = "You have decided to exit the App. Come back soon!!";
        return message;
    }

    public static void main(String[] args) {

        // First menu the user will see
        int choice = 0;
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*******************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        System.out.print("\nType here: ");
        userOption = userInput.nextInt();
        print_menuScreen(userOption);

        do {
            // Display Menu Screen
            //
            System.out.print("\nType here: ");
            userOption = userInput.nextInt();
            //print_menuScreen(userOption);
            //Student newStudent = new Student();
            // switch statement = is for the different options in the menu 
            switch (userOption) {
                case 1:

                    System.out.println("CAPTURE A NEW STUDENT");
                    System.out.println("************************************");

                    //User data entries
                    System.out.print("\nPlease enter in how many students you would like to capture: ");
                    int amountStudents = userInput.nextInt();
                    int count = 0;

                    while (count < amountStudents) {

                        System.out.print("Enter the student id: ");
                        int id = userInput.nextInt();
                        System.out.print("\nEnter the student name: ");
                        String name = userInput.next();
                        System.out.print("\nEnter the student age: ");
                        int age = userInput.nextInt();

                        // if statement - is for if the age is invalid meaning its less than 16 years of age and invalid character
                        if (!validStudentAge(age)) {
                            System.out.println("You have entered a incorrect student age!!!");
                            System.out.println("Enter the student age >> ");
                            age = userInput.nextInt();
                        }

                        System.out.print("\nEnter the student email: ");
                        String email = userInput.next();
                        System.out.print("\nEnter the student course: ");
                        String course = userInput.next();
                        Student newStudent = new Student(id, name, age, email, course);
                        SaveStudent(newStudent, studentList);
                        //newStudent.storeIds(id);
                        count++;
                    }

                    //System.out.println(newStudent.studentReport());
                    System.out.println("Enter (1) to launch menu or any other key to exit");
                    userOption = userInput.nextInt();
                    break;
                case 2:

                    System.out.print("\nEnter the student id to search: ");
                    int idSearch = userInput.nextInt();

                    Student student = searchStudent(idSearch, studentList); // gives the main method the position of element in the ArrayList
                    //boolean validStudent = newStudent.checkValidSearchStudent(idSearch, position,studentList); // givess the main method vaildity if the student was found or not. In the form of (true or false)

                    //ArrayList<String> studentList = newStudent.getStudentList();

                    // System.out.println("Position is arrayList: " + position);
                    // Display the correct student
                    //System.out.println(newStudent.displaySearchStudent(position,studentList));

                    //System.out.println("Enter (1) to launch menu or any other key to exit");

                    if (student == null) {

                        System.out.println("Student with Student ID: " + idSearch + " was not found!");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Enter (1) to launch menu or any other key to exit");
                    } else {
                        System.out.println(student);
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Enter (1) to launch menu or any other key to exit");
                    }
                    userOption = userInput.nextInt();
                    break;
                case 3:
                    //code
                    System.out.print("\nEnter the student id to delete: ");
                    int idToDelete = userInput.nextInt();

                    System.out.println("\nAre you sure you want to delete student " + idToDelete + " from the system?(Y/N)");
                    System.out.print("\nType here: ");
                    String userConfirmation = userInput.next();

                    if (userConfirmation.equalsIgnoreCase("y")) {
                        // Call the delete method from the Student class
                        deleteStudent(idToDelete, studentList);

                        System.out.println("\nStudent with Student ID: " + idToDelete + " WAS deleted!");
                        System.out.println("\n-----------------------------------------------------------------------");
                        System.out.println("Enter (1) to lauch menu or any other key to exit");
                        userOption = userInput.nextInt();
                    } else {
                        System.out.println("You choose 'N'.Enter (1) to lauch menu or any other key to exit");
                        userOption = userInput.nextInt();
                    }
                    break;

                case 4:
                    //code
                    //Student newStudent = new Student();
                    System.out.println(studentReport(studentList));

                    break;
                case 5:
                    //code
                    System.out.println(exitStudentApplication());
                    break;
            }
            print_menuScreen(userOption);
            //userOption = userInput.nextInt();

        } while (userOption != 5);
    }

    public static void print_menuScreen(int launchApp) { // This method displays the menu screen to the user

        if (launchApp != 5) {
            System.out.println("Please select one of the following menu items");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");
            System.out.println("");

        } else {
            System.out.println("You didn't type 1. You have decided to exit the App. Come back soon!!");
            System.exit(0);
        }

    }
}
