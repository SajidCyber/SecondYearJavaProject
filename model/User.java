package app.model;

public class User {
    private String username;
    private String password;
    private boolean acceptedTerms;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.acceptedTerms = false;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean hasAcceptedTerms() { return acceptedTerms; }
    public void acceptTerms() { this.acceptedTerms = true; }
}
