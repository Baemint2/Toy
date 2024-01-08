package com.luv2code.springboot.thymeleafdemo.entity;

import com.luv2code.springboot.thymeleafdemo.domain.MemberRole;
import com.luv2code.springboot.thymeleafdemo.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@Entity
@Getter
@Table(name="member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;


    private String pw;


    private String address;

    @Enumerated(EnumType.STRING)
    private MemberRole role;


    @Builder
    public Member(String name, String email, String pw, String address, MemberRole role) {
        this.name = name;
        this.email = email;
        this.pw = pw;
        this.address = address;
        this.role = role;
    }

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .name(memberFormDto.getName())
                .email(memberFormDto.getEmail())
                .pw(passwordEncoder.encode(memberFormDto.getPw()))
                .address(memberFormDto.getAddress())
                .role(MemberRole.USER)
                .build();
        return member;

    }
}
