package com.example.customexception.domain.member.repository;

import com.example.customexception.global.entity.redis.RedisMember;
import org.springframework.data.repository.CrudRepository;

public interface RedisMemberRepository extends CrudRepository<RedisMember,String> {
}
