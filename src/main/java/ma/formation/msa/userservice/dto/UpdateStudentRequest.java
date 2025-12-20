package ma.formation.msa.userservice.dto;

public class UpdateStudentRequest {

    private String fullName;
    private String phone;
    private String address;
    private String campus;
    private String program;
    private String section;

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
