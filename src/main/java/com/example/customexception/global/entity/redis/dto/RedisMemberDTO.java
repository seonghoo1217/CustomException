package com.example.customexception.global.entity.redis.dto;

import com.example.customexception.global.entity.redis.RedisMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RedisMemberDTO {
    private String username;
    private String password;
    private String email;
    private String nickname;

    public RedisMember toRedisEntity(){
        return RedisMember.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .build();
    }
}
