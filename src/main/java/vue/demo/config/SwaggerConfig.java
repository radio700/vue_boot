package vue.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${server.servlet.context-path:/}")
    private String contextPath;

    @Bean 
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                    new Server().url("http://localhost:8080" + contextPath).description("개발 서버")
//                    new Server().url("https://api.myapp.com" + contextPath).description("운영 서버")
                ))
                .info(new Info()
                    .title("My App API")
                    .version("1.0.0")
                    .description("Spring Boot 3 + Vue 3 + PostgreSQL + MyBatis API 문서")
//                    .contact(new Contact()
//                        .name("개발팀")
//                        .email("dev@myapp.com")
//                        .url("https://myapp.com"))
//                    .license(new License()
//                        .name("MIT License")
//                        .url("https://opensource.org/licenses/MIT"))
                );
    }
}