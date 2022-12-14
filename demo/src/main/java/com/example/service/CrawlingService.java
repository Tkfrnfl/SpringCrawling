package com.example.service;

import com.example.AppConfig;
import com.example.component.CrawlingComponent;
import com.example.domain.MemberDto;
import com.example.domain.MemberModel;
import com.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrawlingService implements ApplicationRunner {

    private  final  MemberRepository memberRepository;
    private final CrawlingComponent crawlingComponent;

    public List<MemberModel>process(){
        return crawlingComponent.process();
    }

   /* ApplicationContext applicationContext =new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);*/
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<MemberModel> memberModels= process();
        //System.out.println(memberModels.get(0));
        for(int i=0; i<memberModels.size();i++) {
            memberRepository.save(memberModels.get(i));
        }

    }
}
