/*  
The Student Management System project is a software application designed to efficiently manage and organize student-related information within an educational institution. It provides a streamlined platform for administrators, teachers, and staff to handle student records, facilitating tasks such as adding, editing, searching, and displaying student details. The Student Management System project optimizes the process of handling student information, fostering efficient data management, and supporting better decision-making within educational institutions.
*/

import java.util.ArrayList;// The java.util.ArrayList library is used to store a collection of objects in a dynamic array. 
import java.util.Scanner;// java.util.Scanner libary i used to take input from the user

class Student {//class student to represent the indivisual student and declae the private attributes so that they are not accessable outside the class but only from getter and setter methods
    private String name;
    private int rollNumber;
    private String grade;

    //Constructor to initialize the object
    public Student(String name, int rollNumber, String grade) {
        this.name = name;//this refers to the current instance of the class.
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {//getName Method
        return name;
    }

    public int getRollNumber() {//getRollNumber Method
        return rollNumber;
    }

    public String getGrade() {//getGrade Metod
        return grade;
    }

    @Override//@Override indicates that this method overrides the toString() method of the base class (Object). Object class is the parent of all the classes
    public String toString() {//Show details method
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\n";
    }
}

class StudentManagementSystem {//StudentManagementSystem to manage student records.
    private ArrayList<Student> students;//Declare an ArrayList<Student> to store student objects.

    public StudentManagementSystem() {//constructor that initializes the students list as an empty ArrayList.
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {//addStudent() method adds a Student object to the students list.
        students.add(student);
    }

    public void removeStudent(int rollNumber) {//removeStudent() method removes a Student object from the students list based on the provided roll number.
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {//searchStudent() method searches for a Student object in the students list based on the provided roll number and returns it if found, otherwise returns null.
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {//displayAllStudents() method iterates through the students list and prints each student's details using the toString() method.
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Main {//Main class, which serves as the entry point for the application.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Scanner object is used to take input from the user
        StudentManagementSystem sms = new StudentManagementSystem();//Object created of the StudentManagementSystem class

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();//choice selected by user
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: //Choice 1 for adding student
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student student = new Student(name, rollNumber, grade);
                    sms.addStudent(student);//adding the student details
                    System.out.println("Student added successfully.");
                    break;

                case 2: //Choice 2 for removing student
                    System.out.print("Enter roll number of the student to remove: ");
                    int removeRollNumber = scanner.nextInt();//imputting the rollno of student which is gonna removed
                    sms.removeStudent(removeRollNumber);
                    System.out.println("Student removed successfully.");
                    break;

                case 3: // Choice 3 for search student
                    System.out.print("Enter roll number of the student to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student searchedStudent = sms.searchStudent(searchRollNumber);
                    if (searchedStudent != null) {//student found case
                        System.out.println("Student found:\n" + searchedStudent);
                    } else {//if Null is returned means no student is found
                        System.out.println("Student not found.");
                    }
                    break;

                case 4: // Choice 4 for display All Students data
                    System.out.println("All Students:");
                    sms.displayAllStudents();//will call the displayStudent method through sms object and display the details of all the students
                    break;

                case 5: //Choice 5 for exit from the while loop by returning
                    System.out.println("Exiting Student Management System.");
                    scanner.close();//scanner object is closed to prevent it from memory leak
                    return;

                default: // When no matching input is found then this condition willl be executed
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}