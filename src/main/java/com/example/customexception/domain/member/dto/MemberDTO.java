package com.example.customexception.domain.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SignUpDTO{
        private String username;

    }
}
