package ma.formation.msa.userservice.controller;

import ma.formation.msa.userservice.dto.UserResponseDTO;
import ma.formation.msa.userservice.model.User;
import ma.formation.msa.userservice.security.JwtService;
import ma.formation.msa.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService,
                          JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        UserResponseDTO user = userService.login(
                request.getEmail(),
                request.getPassword()
        );


        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole().name(),
                user.getMatricule()
        );


        return ResponseEntity.ok(
                new AuthResponse(
                        token,
                        user.getEmail(),
                        user.getRole().name()
                )
        );
    }
}
