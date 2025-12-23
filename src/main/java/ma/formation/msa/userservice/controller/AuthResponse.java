package ma.formation.msa.userservice.controller;

public class    AuthResponse {

    private String token;
    private String email;
    private String role;
    private String matricule;


    public AuthResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.matricule = matricule;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
