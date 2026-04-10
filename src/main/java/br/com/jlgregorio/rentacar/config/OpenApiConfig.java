package br.com.jlgregorio.rentacar.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi v1(){
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi v2(){
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/v2/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Rent a Car API")
                        .version("1.0")
                        .description("Documentação Oficial da API Rent a Car")
                        .termsOfService("https://www.fatecjales.edu.br")
                        .license(new License()
                                .name("Apache Licese 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                );
    }

}
