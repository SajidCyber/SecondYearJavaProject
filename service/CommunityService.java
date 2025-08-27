package app.service;

import app.model.Post;
import app.model.User;
import java.util.ArrayList;
import java.util.List;

public class CommunityService {
    private List<User> users;
    private List<Post> posts;

    public CommunityService() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    // Signup
    public boolean signup(String username, String password) {
        for(User u : users) {
            if(u.getUsername().equals(username)) return false; // already exists
        }
        users.add(new User(username, password));
        return true;
    }

    // Login
    public User login(String username, String password) {
        for(User u : users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    // Accept terms
    public void acceptTerms(User user) {
        user.acceptTerms();
    }

    // Add offer/request
    public void addPost(Post post) {
        posts.add(post);
    }

    // View all posts
    public List<Post> getAllPosts() { return posts; }

    // Search compatible posts (matching type)
    public List<Post> matchPosts(Post requestPost) {
        List<Post> matches = new ArrayList<>();
        for(Post p : posts) {
            if(!p.getUsername().equals(requestPost.getUsername()) &&
               !p.getType().equals(requestPost.getType()) &&
               p.getCategory().equalsIgnoreCase(requestPost.getCategory())) {
                matches.add(p);
            }
        }
        return matches;
    }
}
