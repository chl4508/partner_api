package cys.partner.api;

import cys.partner.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/test/list")
    public ModelAndView GetTestList() throws Exception{
        ModelAndView view = new ModelAndView();

        view.setViewName("static/test/list");
        view.addObject("list", testService.getTestList());
        return view;
    }

}
