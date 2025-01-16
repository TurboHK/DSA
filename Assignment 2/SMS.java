/*Part 2*/
import java.io.*;
import java.util.Scanner;

public class SMS {
    private AVLTree AT;

    public SMS() {
        AT = new AVLTree();
    }

    public void loadStudents(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName)); // Read the file using BufferedReader as it can read line by line
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(","); // Split the line by ","
            String firstName = data[0].trim(); // The trim() method is used to remove spaces at the beginning and end
            String surname = data[1].trim();
            String gender = data[2].trim();
            String id = data[3].trim(); // ID is not converted to an integer as integers may not be able to store large IDs
            int age = Integer.parseInt(data[4].trim()); // Convert the age to an integer
            Student student = new Student(firstName, surname, gender, id, age);
            AT.insertStudent(student);
        }
		System.out.println("=================================================");
		System.out.println("|       Student list loaded successfully!       |");
        br.close();
    }

    public void handleCommand(String command) {
        try{
            if (command.startsWith("q")) { // Query
                int id = Integer.parseInt(command.substring(1).trim()); // Extract the ID
                Student student = AT.findStudent(id); // Find the student with the ID
                if (student == null) {
                    System.out.println("No records found.");
                }
                else {
                    System.out.println(student.getFullName() + " (" + student.getId() + ") is a " + student.getGender() + " of age " + student.getAge() + ".\n");
                }
            }
            else if (command.startsWith("u")) { // Unenroll
                int id = Integer.parseInt(command.substring(1).trim());
                Student student = AT.findStudent(id);
                if (student == null) {
                    System.out.println("No records found.");
                } else {
                    System.out.println(student.getFullName() + " (" + student.getId() + ") is unenrolled.\n");
                    AT.deleteStudent(id);
                }
            }
            else if (command.equals("e")) { // Exit
                System.out.println("Exiting system. Have a nice day!");
                System.exit(0);
            }
            else {
                throw new IllegalArgumentException(); // The command is invalid
            }
        }
        catch (NumberFormatException e) { // If the ID is not a number
            System.out.println("Invalid ID format. Please enter a valid numeric ID after the command.\n");
        }
        catch (IllegalArgumentException e) { // If the command is neither q, u, nor e
            System.out.println("Invalid command format.\n");
        }
        catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage() + "\n");
        }
    }
    public static void main(String[] args) throws IOException {
        SMS sms = new SMS();
        sms.loadStudents("studentList.txt");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=================================================");
            System.out.println("Enter 'q<ID>' to query a student.");
            System.out.println("Enter 'u<ID>' to unenroll a student.");
            System.out.println("Enter 'e' to exit.");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter command >> ");
            String command = scanner.nextLine();
            sms.handleCommand(command);
        }
    }
}
