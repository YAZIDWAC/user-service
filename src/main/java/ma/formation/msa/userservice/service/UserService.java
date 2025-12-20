    package ma.formation.msa.userservice.service;


    import ma.formation.msa.userservice.dto.CreateStudentRequest;
    import ma.formation.msa.userservice.dto.UpdateProfileRequest;
    import ma.formation.msa.userservice.dto.UpdateStudentRequest;
    import ma.formation.msa.userservice.dto.UserResponseDTO;
    import ma.formation.msa.userservice.model.Role;
    import ma.formation.msa.userservice.model.User;
    import ma.formation.msa.userservice.repository.UserRepository;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class UserService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public UserService(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        // =====================
        // LOGIN
        // =====================
        public UserResponseDTO login(String email, String password) {

            User user = userRepository.findByEmail(email)
                    .orElseThrow(() ->
                            new RuntimeException("Utilisateur introuvable"));

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new RuntimeException("Mot de passe incorrect");
            }

            return toDTO(user);
        }

        // =====================
        // PROFIL
        // =====================
        public UserResponseDTO getByEmail(String email) {
            return userRepository.findByEmail(email)
                    .map(this::toDTO)
                    .orElseThrow(() ->
                            new RuntimeException("Utilisateur introuvable"));
        }

        // =====================
        // ADMIN : LIST USERS
        // =====================
        public List<UserResponseDTO> getAllUsers() {
            return userRepository.findAll()
                    .stream()
                    .map(this::toDTO)
                    .toList();
        }


        // =====================
        // MAPPER
        // =====================
        private UserResponseDTO toDTO(User user) {
            return new UserResponseDTO(
                    user.getId(),
                    user.getEmail(),
                    user.getRole(),
                    user.getFullName()
            );
        }

        // =====================
    // ADMIN : CREATE STUDENT
    // =====================
        public UserResponseDTO createStudent(CreateStudentRequest request) {

            User student = new User();
            student.setEmail(request.getEmail());
            student.setFullName(request.getFullName());
            student.setRole(Role.STUDENT);

            student.setPassword(
                    passwordEncoder.encode(request.getPassword())
            );

            User saved = userRepository.save(student);
            return toDTO(saved);
        }


        // =====================
    // STUDENT : UPDATE PROFILE
    // =====================
        // =====================
    // ADMIN : UPDATE STUDENT
    // =====================
        public UserResponseDTO updateStudent(
                Long studentId,
                UpdateStudentRequest request
        ) {
            User student = userRepository.findById(studentId)
                    .orElseThrow(() ->
                            new RuntimeException("Étudiant introuvable"));

            if (student.getRole() != Role.STUDENT) {
                throw new RuntimeException("Utilisateur non étudiant");
            }

            student.setFullName(request.getFullName());
            student.setPhone(request.getPhone());
            student.setAddress(request.getAddress());
            student.setCampus(request.getCampus());
            student.setProgram(request.getProgram());
            student.setSection(request.getSection());

            return toDTO(userRepository.save(student));
        }

        // =====================
    // ADMIN : DELETE STUDENT
    // =====================
        public void deleteStudent(Long studentId) {

            User student = userRepository.findById(studentId)
                    .orElseThrow(() ->
                            new RuntimeException("Étudiant introuvable"));

            if (student.getRole() != Role.STUDENT) {
                throw new RuntimeException("Suppression autorisée uniquement pour les étudiants");
            }

            userRepository.delete(student);
        }


        // =====================
    // ADMIN : RESET PASSWORD
    // =====================
        public void resetStudentPassword(
                Long studentId,
                String newPassword
        ) {
            User student = userRepository.findById(studentId)
                    .orElseThrow(() ->
                            new RuntimeException("Étudiant introuvable"));

            if (student.getRole() != Role.STUDENT) {
                throw new RuntimeException("Reset autorisé uniquement pour les étudiants");
            }

            student.setPassword(
                    passwordEncoder.encode(newPassword)
            );

            userRepository.save(student);
        }



    }
