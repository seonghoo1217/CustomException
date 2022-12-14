package com.example.customexception.domain.member.application.impl;

import com.example.customexception.domain.email.application.service.EmailApplication;
import com.example.customexception.domain.member.application.service.MemberApplication;
import com.example.customexception.domain.member.dto.MemberDTO;
import com.example.customexception.domain.member.repository.RedisMemberRepository;
import com.example.customexception.global.entity.redis.RedisMember;
import com.example.customexception.global.entity.redis.dto.RedisMemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberApplicationImpl implements MemberApplication {

    private final PasswordEncoder passwordEncoder;

    private final RedisMemberRepository repository;

    private final EmailApplication emailApplication;

    @Override
    public void signUp(RedisMemberDTO redisMemberDTO) throws Exception {
        RedisMember r_member = repository.save(redisMemberDTO.toRedisEntity());
        emailApplication.createVerifiedEmail(r_member.getEmail(),r_member.getNickname());
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
