package cys.partner.api;

import cys.partner.service.TestService;
import cys.partner.vo.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/test/list")
    public List<Test> GetTestList() throws Exception{
        return testService.getTestList();
    }

}
