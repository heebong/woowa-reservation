package com.h3.reservation;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-27
 */
public class TokenDto {
    private String token;
    private String challenge;
    private String type;

    public TokenDto() {
    }

    public TokenDto(String token, String challenge, String type) {
        this.token = token;
        this.challenge = challenge;
        this.type = type;
    }

    public String getChallenge() {
        return challenge;
    }
}
