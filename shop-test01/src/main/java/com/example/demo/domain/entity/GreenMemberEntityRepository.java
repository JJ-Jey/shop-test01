package com.example.demo.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.dto.MemberDTO;

public interface GreenMemberEntityRepository extends JpaRepository<MemberEntity, Long> {
	
	Optional<MemberEntity> findByEmail(String email);

	void save(MemberDTO dto);

}
