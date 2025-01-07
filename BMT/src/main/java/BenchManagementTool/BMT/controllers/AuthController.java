package BenchManagementTool.BMT.controllers;

import BenchManagementTool.BMT.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/request-login")
    public String requestLogin(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        return authService.requestLogin(email);
    }

    @PostMapping("/verify-login")
    public String verifyLogin(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String verificationCode = payload.get("verificationCode");
        return authService.verifyLogin(email, verificationCode);
    }
}
