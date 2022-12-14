package com.example.controller;

import com.example.domain.MemberModel;
import com.example.repository.MemoryMemberRepository;
import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class DemoController {

   // private final MemoryMemberRepository memoryMemberRepository;

/*    @PersistenceContext
    private MemberModel memberModel;*/
    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("degree")
    public String searchStudentName(@RequestParam(value = "name")String name){
       return memberService.searchStudentName(name);
    }
    @GetMapping("email")
    public String searchStudentEmailByName(@RequestParam(value = "name")String name){
        return memberService.searchStudentEmailByName(name);
    }
    @GetMapping("stat")
    public String searchStudentDegree(@RequestParam(value = "degree")String degree){
        return memberService.searchStudentDegree(degree);
    }
    @PutMapping("register")
    public String putStudent(@RequestParam(value = "name")String name,@RequestParam(value = "email")String email,
    @RequestParam(value = "graduation")Integer graduation,@RequestParam(value = "degree")String degree
    ){
        return memberService.putStudent(degree,name,email,graduation);
    }
}
