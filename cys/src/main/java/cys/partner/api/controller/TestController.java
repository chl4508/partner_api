package cys.partner.api.controller;

import cys.partner.api.application.repository.TestRepository;
import cys.partner.api.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/jpa")
    public List<Test> TestJpaList(){
        return testRepository.findAll();
    }

    @PostMapping("/jpa")
    public Test TestJpa(){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();

        String chars[] ="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

        for (int i=0 ; i<chars.length ; i++)
        {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        Test test = new Test("테스트", buffer.toString());
        return testRepository.save(test);
    }
}
