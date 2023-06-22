package cys.partner.service.impl;

import cys.partner.service.TestService;
import cys.partner.vo.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public List<Test> getTestList() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        ResponseEntity<Test[]> result = restTemplate.getForEntity("http://localhost:8080/test/jpa", Test[].class);
        return Arrays.asList(result.getBody());
    }
}
