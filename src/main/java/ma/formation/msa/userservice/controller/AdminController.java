package ma.formation.msa.userservice.controller;

import ma.formation.msa.userservice.dto.CreateStudentRequest;
import ma.formation.msa.userservice.dto.UpdateStudentRequest;
import ma.formation.msa.userservice.dto.UserResponseDTO;
import ma.formation.msa.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import ma.formation.msa.userservice.dto.ResetPasswordRequest;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // 🔒 ADMIN : list all users
    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // 🔒 ADMIN : create student
    @PostMapping("/students")
    public UserResponseDTO createStudent(
            @RequestBody CreateStudentRequest request
    ) {
        return userService.createStudent(request);
    }

    // 🔒 ADMIN : update student
    @PutMapping("/students/{id}")
    public UserResponseDTO updateStudent(
            @PathVariable Long id,
            @RequestBody UpdateStudentRequest request
    ) {
        return userService.updateStudent(id, request);
    }

    // 🔒 ADMIN : delete student
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        userService.deleteStudent(id);
    }

    @PutMapping("/students/{id}/reset-password")
    public void resetStudentPassword(
            @PathVariable Long id,
            @RequestBody ResetPasswordRequest request
    ) {
        userService.resetStudentPassword(id, request.getNewPassword());
    }

}
