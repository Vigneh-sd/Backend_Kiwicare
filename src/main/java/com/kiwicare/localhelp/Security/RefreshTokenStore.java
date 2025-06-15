package com.kiwicare.localhelp.Security;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RefreshTokenStore {

    private final Map<String, String> refreshTokenMap = new ConcurrentHashMap<>();

    public void store(String email, String refreshToken) {
        refreshTokenMap.put(email, refreshToken);
    }

    public boolean isValid(String email, String refreshToken) {
        return refreshToken.equals(refreshTokenMap.get(email));
    }

    public void remove(String email) {
        refreshTokenMap.remove(email);
    }
}
