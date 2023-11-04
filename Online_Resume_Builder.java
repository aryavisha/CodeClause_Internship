package CodeClause_Internship;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

    public class Online_Resume_Builder {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Resume Builder");
            System.out.println("Let's get started!");

            System.out.print("Enter your full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter your email address: ");
            String email = scanner.nextLine();

            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter your education: ");
            String education = scanner.nextLine();

            System.out.print("Enter your work experience: ");
            String workExperience = scanner.nextLine();

            System.out.print("Enter your skills: ");
            String skills = scanner.nextLine();

            String resume = "Resume:\n\n" +
                    "Name: " + fullName + "\n" +
                    "Email: " + email + "\n" +
                    "Phone: " + phoneNumber + "\n\n" +
                    "Education: " + education + "\n\n" +
                    "Work Experience: " + workExperience + "\n\n" +
                    "Skills: " + skills;

            System.out.println("\nYour resume:\n");
            System.out.println(resume);

            // Save the resume to a file
            saveResumeToFile(resume);

            System.out.println("\nYour resume has been saved to 'resume.txt'.");
        }
        private static void saveResumeToFile(String resume) {
            try (FileWriter writer = new FileWriter("resume.txt")) {
                writer.write(resume);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

