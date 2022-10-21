package com.example.customexception.domain.member.application.impl;

import com.example.customexception.domain.member.application.service.MemberApplication;
import com.example.customexception.domain.member.dto.MemberDTO;
import com.example.customexception.domain.member.entity.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MemberApplicationImpl implements MemberApplication {

    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(MemberDTO.MemberSignUpDto memberSignUpDto) throws Exception {

    }

    @Override
    public void update(MemberDTO.MemberUpdateDto memberUpdateDto, String username) throws Exception {

    }

    @Override
    public void changePassword(String asIsPassword, String toBePassword, String username) throws Exception {

    }

    @Override
    public void withdraw(String checkPassword, String username) throws Exception {

    }

    @Override
    public MemberDTO.MemberInfoDto getInfo(Long seq) throws Exception {
        return null;
    }
}
