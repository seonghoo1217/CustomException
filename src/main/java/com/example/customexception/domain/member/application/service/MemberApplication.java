package com.example.customexception.domain.member.application.service;

import com.example.customexception.domain.member.dto.MemberDTO;
import com.example.customexception.global.entity.redis.dto.RedisMemberDTO;
import org.springframework.stereotype.Service;

public interface MemberApplication {

    void signUp(RedisMemberDTO redisMemberDTO) throws Exception;

    void update(MemberDTO.MemberUpdateDto memberUpdateDto, String username) throws Exception;

    void changePassword(String asIsPassword, String toBePassword, String username) throws Exception;

    void withdraw(String checkPassword, String username) throws Exception;

    MemberDTO.MemberInfoDto getInfo(Long seq) throws Exception;
}
