package com.example;

import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;
import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
   /* @Bean
    public MemberService memberService(){

        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(MemberRepository memberRepository);
    }*/
/*    @Bean
    public MemberRepository memberRepository() {

        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }*/
}
