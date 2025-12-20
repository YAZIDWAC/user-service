package ma.formation.msa.userservice.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔐 Auth
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // 👤 Infos personnelles
    private String fullName;
    private String phone;
    private String address;

    private LocalDate birthDate;
    private String birthPlace;

    // 🎓 Infos académiques
    private String campus;
    private String program;
    private String section;

    @Column(unique = true)
    private String matricule;

    @Column(unique = true)
    private String cne;

    private String nationalCode;
    private String academicYear;

    // getters & setters


    public String getPassword() {
        return password;
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

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getCampus() {
        return campus;
    }

    public String getProgram() {
        return program;
    }

    public String getSection() {
        return section;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getCne() {
        return cne;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
}
