package pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity;


public enum RoleName {

    ADMIN("Admin"),
    DEFAULT("Default"),
    BLOCKED("Blocked"),
    RESTRICTED("Restricted");

    private String role;

    RoleName(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
