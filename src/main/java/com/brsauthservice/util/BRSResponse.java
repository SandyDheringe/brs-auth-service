package com.brsauthservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BRSResponse {
    private  RequestStatus status = RequestStatus.SUCCESS;
    private String message;
}
