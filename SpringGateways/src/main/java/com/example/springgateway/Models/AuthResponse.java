package com.example.springgateway.Models;

import lombok.*;

import java.util.Collection;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String userId;
    private String refreshToken;
    private String accessToken;
    private Long expiresAt;
    private Collection<String> authorities;
}
