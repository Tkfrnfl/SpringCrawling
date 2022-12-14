package com.example.service;

import com.example.domain.MemberModel;
import com.example.repository.MemberRepository;
import com.example.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    MemoryMemberRepository memoryMemberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

   public MemberModel save(MemberModel memberModel){
        memberRepository.save(memberModel);
        return memberModel;
   }

   public String searchStudentName(String name){
       List<MemberModel> ans=memberRepository.findMemberModelByName(name);

       if(ans.size()==0)
       {
           return  "No such student";
       } else if (ans.size()==1) {
           //System.out.println((ans.get(0).getName())+(ans.get(0).getDegree()));
           return (ans.get(0).getName())+":"+(ans.get(0).getDegree());
       }
       else {
           return"There are multiple students with the same name. Please provide an email address instead. " ;
       }

   }
    public String searchStudentEmailByName(String name){
        List<MemberModel> ans=memberRepository.findMemberModelByName(name);

        if(ans.size()==0)
        {
            return  "No such student";
        } else if (ans.size()==1) {
            System.out.println((ans.get(0).getName())+(ans.get(0).getDegree()));
            return (ans.get(0).getName())+":"+(ans.get(0).getEmail());
        }
        else {
            return"There are multiple students with the same name. Please contact the administrator by phone." ;
        }

    }
    public String searchStudentDegree(String degree){
        List<MemberModel> count=memberRepository.findMemberModelByDegree(degree);
        //System.out.println("Number of "+degree+"'s student :"+String.valueOf(count.size()));
        return "Number of "+degree+"'s student :"+String.valueOf(count.size());

    }public String putStudent(String degree,String name,String email, Integer graduation){
        MemberModel memberModel=new MemberModel();
        memberModel.setGraduation(graduation);
        memberModel.setDegree(degree);
        memberModel.setName(name);
        memberModel.setEmail(email);

        //memberRepository.save(memberModel);
        List<MemberModel>tmp= memberRepository.findMemberModelByName(name);
        List<MemberModel>tmpEmail=memberRepository.findMemberModelByEmail(email);
        if(tmp.size()>0){
            return  "Already registered";
        } else if (tmpEmail.size()>0) {
            return "Email Already registered";

        } else {
            memberRepository.save(memberModel);
            return "Registration successful";
        }

    }
}
