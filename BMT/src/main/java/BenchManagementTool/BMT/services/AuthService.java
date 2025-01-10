package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.UserRepository;
import BenchManagementTool.BMT.lib.JwtUtil;
import BenchManagementTool.BMT.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtUtil jwtUtil;

    private final long verificationCodeExpiration = 10 * 60 * 1000; // 10 minutes

    // Generate a random 6-digit verification code
    private String generateVerificationCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }

    // Helper method to construct the email by appending @bounteous.com to the ID
    private String constructEmail(String emailId) {
        return emailId + "@bounteous.com";
    }

    // Step 1: Handle login request
    public String requestLogin(String emailId) {
        String email = constructEmail(emailId); // Convert ID to full email
        String verificationCode = generateVerificationCode();
        long currentTime = System.currentTimeMillis();

        Optional<User> existingUser = userRepository.findByEmail(email);
        User user;

        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {
            user = new User();
            user.setEmail(email);
        }

        user.setVerificationCode(verificationCode);
        user.setCodeGeneratedTime(currentTime);

        userRepository.save(user);
        emailService.sendVerificationCode(email, verificationCode); // Send email

        return "Verification code sent to your email.";
    }

    // Step 2: Verify the code and authenticate the user
    public String verifyLogin(String emailId, String verificationCode) {
        String email = constructEmail(emailId); // Convert ID to full email
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isEmpty()) {
            return "Invalid email.";
        }

        User user = existingUser.get();
        long currentTime = System.currentTimeMillis();

        // Validate the verification code and expiration
        if (!verificationCode.equals(user.getVerificationCode())) {
            return "Invalid verification code.";
        }

        if (currentTime - user.getCodeGeneratedTime() > verificationCodeExpiration) {
            return "Verification code expired.";
        }

        // Generate JWT token for successful login
        return jwtUtil.generateToken(email);

    }
}
