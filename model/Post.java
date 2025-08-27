package app.model;

public class Post {
    private String type;        // "Offer" or "Request"
    private String category;    // Skill / Item
    private String description;
    private String duration;    // e.g., "5 hours", "permanent"
    private String dayTime;     // e.g., "Saturday 3-6 PM"
    private String username;    // user who posted

    public Post(String type, String category, String description, String duration, String dayTime, String username) {
        this.type = type;
        this.category = category;
        this.description = description;
        this.duration = duration;
        this.dayTime = dayTime;
        this.username = username;
    }

    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getDuration() { return duration; }
    public String getDayTime() { return dayTime; }
    public String getUsername() { return username; }

    public void display() {
        System.out.println(type + " | " + category + " | " + description + " | " + duration + " | " + dayTime + " | by " + username);
    }
}
