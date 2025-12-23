package ma.formation.msa.userservice.dto;

import ma.formation.msa.userservice.model.Role;

public class UserResponseDTO {

    private Long id;
    private String email;
    private Role role;
    private String fullName;
    private String matricule;

    public UserResponseDTO(
            Long id,
            String email,
            Role role,
            String fullName,
            String matricule
    ) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.fullName = fullName;
        this.matricule = matricule;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMatricule() {
        return matricule;
    }
}
