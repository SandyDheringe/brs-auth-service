package com.brsauthservice.customer;

import com.brsauthservice.auth.AuthRequest;
import com.brsauthservice.auth.AuthResponse;
import com.brsauthservice.exception.BRSAuthException;
import com.brsauthservice.util.BRSResponse;
import com.brsauthservice.util.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthService service;

    private final AuthenticationManager authenticationManager;

    @Autowired
    AuthController(AuthService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/customers/register")
    public ResponseEntity<BRSResponse> registerCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(service.registerCustomer(customer));
    }

    @PostMapping("/customers/login")
    public ResponseEntity<AuthResponse> loginCustomer(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
           return  ResponseEntity.ok().body(new AuthResponse(RequestStatus.SUCCESS,service.generateToken(authRequest.getUserName())));
        } else {
            throw new BRSAuthException("Invalid credentials");
        }
    }

    @GetMapping("/customers/validate")
    public ResponseEntity validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return ResponseEntity.ok().build();
    }
}