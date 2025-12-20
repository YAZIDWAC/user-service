package ma.formation.msa.userservice.controller;

import ma.formation.msa.userservice.dto.UpdateProfileRequest;
import ma.formation.msa.userservice.dto.UserResponseDTO;
import ma.formation.msa.userservice.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 👁️ PROFIL (LECTURE SEULE)
    @GetMapping("/me")
    public UserResponseDTO getMyProfile() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userService.getByEmail(email);
    }
}
