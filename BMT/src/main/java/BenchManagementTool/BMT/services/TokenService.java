package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.dto.AuthRequest;
import BenchManagementTool.BMT.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {

    private String token;
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${base.url}")
    private String baseUrl;

    @Value("${user}")
    private String user;

    @Value("${pass}")
    private String pass;

    public String getToken(){
        if(token == null || isTokenExpired() ){
            token = fetchNewToken();
        }
        return token;
    }

    private boolean isTokenExpired() {
        return false;
    }

    private String fetchNewToken() {

        AuthRequest authRequest = new AuthRequest(user, pass);

        AuthResponse authResponse = restTemplate.postForObject(baseUrl,authRequest, AuthResponse.class);
        return authResponse.getToken();
    }
}
