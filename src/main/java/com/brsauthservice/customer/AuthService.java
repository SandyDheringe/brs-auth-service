package com.brsauthservice.customer;

import com.brsauthservice.exception.BRSFieldException;
import com.brsauthservice.util.BRSResponse;
import com.brsauthservice.util.RequestStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthService(CustomerRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public BRSResponse registerCustomer(Customer customer) {
        Optional<Customer> oldCustomer = repository.findByUserName(customer.getUserName());
        if (oldCustomer.isPresent())
            throw new BRSFieldException("username already taken");

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        repository.save(customer);
        return new BRSResponse(RequestStatus.SUCCESS, "Registration successful");
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}