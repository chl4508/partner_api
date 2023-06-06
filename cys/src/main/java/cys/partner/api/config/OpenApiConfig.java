package cys.partner.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
        Info info = new Info()
                .title("Cys Partner API")
                .version(appVersion)
                .description("Spring Boot 3.1.1을 이용한 Cys Partner API입니다.")
                //.termsOfService("http://swagger.io/terms/")
                .contact(new Contact()
                        .name("choiyeonsik")
                        //.url("https://jeonyoungho.github.io")
                        .email("chl4508@naver.com"));

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
