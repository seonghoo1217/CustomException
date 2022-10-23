package com.example.customexception.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQUENCE")
    private Long seq;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EMAIL_VERIFY")
    private String emailVf;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "ROLE")
    private Role role;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;
    @Builder
    public Member(String username, String password, String email, String nickname,String emailVf) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.emailVf=emailVf;
    }

    //권한 추가
    public void addMemberAuthority(){
        this.role=Role.MEMBER;
    }

    public void encodeToPassword(PasswordEncoder passwordEncoder){
        this.password=passwordEncoder.encode(password);
    }

    public void addRefreshToken(String refreshToken){
        this.refreshToken=refreshToken;
    }
}
