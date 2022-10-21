package com.example.customexception.global.entity.redis;

import com.example.customexception.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@RedisHash(value = "member",timeToLive = 600)
public class RedisMember {
    @Id
    private String username;

    private String password;

    private String email;

    private String emailVf;

    private String nickname;

    @Builder
    public RedisMember(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .emailVf(emailVf)
                .build();
    }
}

// 커밋용주석
// 커밋용주석
// 커밋용주석
// 커밋용주석