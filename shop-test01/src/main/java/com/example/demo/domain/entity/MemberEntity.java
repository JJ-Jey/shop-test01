package com.example.demo.domain.entity;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.security.MyRole;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor//jpa resultType 매핑시 없으면 오류 발생
@Table(name = "nowon6")//green_member
@Entity
public class MemberEntity extends BaseDateEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@Column(unique = true, nullable = false, columnDefinition = "varchar(255) collate 'utf8mb4_bin' ")
	private String email;
	
	@Column(nullable = false)
	private String pass;
	
	
	
	
	//ROLE
	@Builder.Default
	@Enumerated(EnumType.STRING)//DB에서 저장시 문자열기반으로 저장
	@CollectionTable(name = "MyRole")//my_role //GreenMemberEntityRoles==green_member_entity_roles
	@ElementCollection(fetch = FetchType.EAGER)//1:N 회원은 여러 Role을 갖을수 있어요
	Set<MyRole> roles=new HashSet<>(); //green_member_entity_roles
	
	public MemberEntity addRole(MyRole myRole) {
		roles.add(myRole);
		return this;
	}
	
}
