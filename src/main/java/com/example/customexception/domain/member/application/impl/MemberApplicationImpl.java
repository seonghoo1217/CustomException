package com.example.customexception.domain.member.application.impl;

import com.example.customexception.domain.member.application.service.MemberApplication;
import com.example.customexception.domain.member.dto.MemberDTO;
import com.example.customexception.domain.member.entity.Member;
import com.example.customexception.domain.member.repository.RedisMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberApplicationImpl implements MemberApplication {

    private final PasswordEncoder passwordEncoder;

    private final RedisMemberRepository repository;

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
