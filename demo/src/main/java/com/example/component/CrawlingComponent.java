package com.example.component;

import com.example.domain.MemberDto;
import com.example.domain.MemberModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CrawlingComponent  {

    /**
     * 조회할 URL셋팅 및 Document 객체 로드하기
     */
    private static final String url = "https://apl.hongik.ac.kr/lecture/dbms ";
    public List<MemberModel> process() {
        Connection conn = Jsoup.connect(url);
        //Jsoup 커넥션 생성
        Document document = null;
        try {
            document = conn.get();
            //url의 내용을 HTML Document 객체로 가져온다.
            //https://jsoup.org/apidocs/org/jsoup/nodes/Document.html 참고
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<MemberModel> list = getDataList(document);
        return list;
    }


    /**
     * data가져오기
     */
    public List<MemberModel> getDataList(Document document) {
        List<MemberModel> list = new ArrayList<>();
        Elements selects = document.select("div");	//⭐⭐⭐
        //select 메서드 안에 css selector를 작성하여 Elements를 가져올 수 있다.

        int tmp=0;

        for (Element select : selects) {

           if(select.attr("tabindex").equals("-1")){
               tmp++; // tmp 5일때 정보라인 나옴
               //System.out.println(  select.text() +tmp);
               if(tmp==5){

                   list=createMemberDto(select.select("ul"));
               }
           }

        }
        System.out.println(list);
        return list;
    }

    public List <MemberModel> createMemberDto(Elements el){
        List<MemberModel> list = new ArrayList<>();
        for(int i=0; i<el.size();i++){
            for(int j=0;j<el.get(i).select("li").size();j++){
                MemberModel memberModel=new MemberModel();
                String tmp;
                String[] parse;

                tmp=el.get(i).select("li").get(j).select("p").text();
                parse=tmp.split(",");
                parse[2]=parse[2].substring(1);
                int gradInt= Integer.parseInt(parse[2]);

                memberModel.setName(parse[0]);
                memberModel.setEmail(parse[1]);

                memberModel.setGraduation(gradInt);

                if(i==0){
                    memberModel.setDegree("phd");
                } else if (i==1) {
                    memberModel.setDegree("master");
                }
                else {
                    memberModel.setDegree("undergrad");
                }
                list.add(memberModel);
            }
        }
        return list;
    }

}
