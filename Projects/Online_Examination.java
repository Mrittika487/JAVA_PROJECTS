import java.util.*;

class User {
    String username;
    String password;
    String name;

    User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public boolean validate(String userId, String pin) {
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
}

public class Online_Examination {
    static Scanner sc = new Scanner(System.in);
    static User user = new User("user123", "pass123", "Mrittika Das");
    public static void main(String[] args) {
        System.out.println("----- Welcome to Online Examination System -----");
        if (login()) {
            showMenu();
        } else {
            System.out.println("Too many failed attempts. Exiting...");
        }
    }

    static boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter Username: ");
            String uname = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            if (uname.equals(user.username) && pass.equals(user.password)) {
                System.out.println("Login Successful!\n");
                return true;
            } else {
                System.out.println("Invalid credentials. Try again.\n");
                attempts++;
            }
        }
        return false;
    }

    static void showMenu() {
        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Update Profile & Password");
            System.out.println("2. Take MCQ Exam");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    updateProfile();
                    break;
                case 2:
                    takeExam();
                    break;
                case 3:
                    System.out.println("Logging out... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void updateProfile() {
        System.out.print("Enter New Name: ");
        user.name = sc.nextLine();
        System.out.print("Enter New Password: ");
        user.password = sc.nextLine();
        System.out.println("Profile updated successfully.");
    }

    static void takeExam() {
        String[] questions = {
            "What is the capital of India?\n1) Delhi\n2) Mumbai\n3) Kolkata\n4) Chennai",
            "Which language is platform-independent?\n1) C++\n2) Java\n3) Python\n4) C",
            "Who is known as the father of Indian constitution?\n1) B.R Ambedkar\n2) Rajendra Prasad\n3) Jawaharlal Neheru\n4) Subhas Chandra Bose",
            "Who invented Java?\n1) Dennis Ritchie\n2) James Gosling\n3) Guido van Rossum\n4) Bjarne Stroustrup"
        };
        int[] answers = {1, 2, 1, 2};
        int score = 0;
        int totalTime = 50; 

        System.out.println("\nExam Started! You have " + totalTime + " seconds.");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < questions.length; i++) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - startTime) / 1000 >= totalTime) {
                System.out.println("\nTime's up! Auto-submitting your exam...");
                break;
            }
            System.out.println("\nQ" + (i + 1) + ". " + questions[i]);
            System.out.print("Your Answer: ");
            int ans = sc.nextInt();

            if (ans == answers[i]) {
                score++;
            }
        }

        System.out.println("\nExam Completed. Your Score: " + score + "/" + questions.length);
    }
}

