package cys.partner.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public String GetItem(@PathVariable("itemId") String itemId)throws Exception{

        return "Controller 테스트 "+itemId;
    }

}
