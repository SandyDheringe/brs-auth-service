package com.brsauthservice.auth;

import com.brsauthservice.util.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private RequestStatus status;
    private String token;
    private Integer customerId;
}
