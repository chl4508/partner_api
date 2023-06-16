package cys.partner.api.controller;

import cys.partner.api.application.repository.TestRepository;
import cys.partner.api.application.service.impl.AssetServiceImpl;
import cys.partner.api.config.errorcodes.ErrorCode;
import cys.partner.api.config.exception.CustomException;
import cys.partner.api.entity.Test;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/test")
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/jpa")
    @Operation(summary = "jpa Test 조회", description = "jpa 연동 테스트 조회 기능입니다.", tags = { "Test Controller" })
    public List<Test> testJpaList(){
        return testRepository.findAll();
    }

    @PostMapping("/jpa")
    @Operation(summary = "jpa Test 생성", description = "jpa 연동 테스트 생성 기능입니다.", tags = { "Test Controller" })
    public Test testJpaInsert(){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();

        String chars[] ="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

        for (int i=0 ; i<chars.length ; i++)
        {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        Test test = new Test("테스트 생성", buffer.toString());
        return testRepository.save(test);
    }

    @PutMapping("/jpa")
    @Operation(summary = "jpa Test 수정", description = "jpa 연동 테스트 수정 기능입니다.", tags = { "Test Controller" })
    public Test testJpaUpdate() throws Exception{

        Optional<Test> test = testRepository.findById(1L);

        StringBuffer buffer = new StringBuffer();
        Random random = new Random();

        String chars[] ="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

        for (int i=0 ; i<chars.length ; i++)
        {
            buffer.append(chars[random.nextInt(chars.length)]);
        }

        test.orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, "Not Found Item"));
        Test findTest = test.get();
        findTest = new Test("테스트 수정", buffer.toString());
        testRepository.save(findTest);

//        if(test.isPresent()){
//            Test findTest = test.get();
//            findTest = new Test("테스트 수정", buffer.toString());
//            testRepository.save(findTest);
//            return findTest;
//        }else{
//            throw new CustomException(ErrorCode.NOT_FOUND, "Not Found Item");
//        }

//        test.ifPresent(selectTest ->{
//            selectTest = new Test("테스트 수정", buffer.toString());
//            testRepository.save(selectTest);
//        });

        return findTest;
    }

    @DeleteMapping("/jpa")
    @Operation(summary = "jpa Test 삭제", description = "jpa 연동 테스트 삭제 기능입니다.", tags = { "Test Controller" })
    public void testJpaDelete() throws Exception{
        Optional<Test> test = testRepository.findById(1L);
        test.orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, "Not Found Item"));
        testRepository.delete(test.get());
    }
}
