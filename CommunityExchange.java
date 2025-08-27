package app;

import app.model.User;
import app.model.Post;
import app.service.CommunityService;
import java.util.List;
import java.util.Scanner;

public class CommunityExchange {
    private static Scanner sc = new Scanner(System.in);
    private static CommunityService service = new CommunityService();
    private static User currentUser;

    public static void main(String[] args) {
        System.out.println("=== Community Skill & Resource Exchange ===");

        while(true) {
            if(currentUser == null) {
                showLoginMenu();
            } else {
                if(!currentUser.hasAcceptedTerms()) {
                    acceptTerms();
                } else {
                    showMainMenu();
                }
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("\n1. Login\n2. Signup\n3. Exit");
        System.out.print("Choose: ");
        int choice = sc.nextInt(); sc.nextLine();

        switch(choice) {
            case 1: login(); break;
            case 2: signup(); break;
            case 3: System.exit(0);
            default: System.out.println("Invalid choice");
        }
    }

    private static void login() {
        System.out.print("Username: "); String username = sc.nextLine();
        System.out.print("Password: "); String password = sc.nextLine();
        User u = service.login(username, password);
        if(u != null) {
            currentUser = u;
            System.out.println("Login successful! Welcome " + currentUser.getUsername());
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void signup() {
        System.out.print("Choose Username: "); String username = sc.nextLine();
        System.out.print("Choose Password: "); String password = sc.nextLine();
        if(service.signup(username, password)) {
            System.out.println("Signup successful! Please login.");
        } else {
            System.out.println("Username already exists!");
        }
    }

    private static void acceptTerms() {
        System.out.println("\nPlease accept Terms & Policies to continue (yes/no): ");
        String ans = sc.nextLine();
        if(ans.equalsIgnoreCase("yes")) {
            service.acceptTerms(currentUser);
            System.out.println("Terms accepted!");
        } else {
            System.out.println("You must accept terms to continue.");
        }
    }

    private static void showMainMenu() {
        System.out.println("\n1. Make an Offer\n2. Make a Request\n3. View All Posts\n4. Logout");
        System.out.print("Choose: ");
        int choice = sc.nextInt(); sc.nextLine();

        switch(choice) {
            case 1: createPost("Offer"); break;
            case 2: createPost("Request"); break;
            case 3: viewPosts(); break;
            case 4: logout(); break;
            default: System.out.println("Invalid choice");
        }
    }

    private static void createPost(String type) {
        System.out.print("Category (Skill/Item): "); String category = sc.nextLine();
        System.out.print("Description: "); String desc = sc.nextLine();
        System.out.print("Duration (e.g., 5 hours/permanent): "); String duration = sc.nextLine();
        System.out.print("Day & Time (e.g., Saturday 3-6 PM): "); String dayTime = sc.nextLine();

        Post post = new Post(type, category, desc, duration, dayTime, currentUser.getUsername());
        service.addPost(post);
        System.out.println(type + " added successfully!");

        // Show matches
        if(type.equalsIgnoreCase("Request")) {
            List<Post> matches = service.matchPosts(post);
            if(matches.isEmpty()) System.out.println("No matching offers found yet.");
            else {
                System.out.println("\n--- Matching Offers ---");
                for(Post p : matches) p.display();
            }
        }
    }

    private static void viewPosts() {
        List<Post> posts = service.getAllPosts();
        if(posts.isEmpty()) System.out.println("No posts yet.");
        else {
            System.out.println("\n--- All Posts ---");
            for(Post p : posts) p.display();
        }
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Logged out.");
    }
}
