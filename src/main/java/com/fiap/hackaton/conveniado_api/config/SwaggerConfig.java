package com.fiap.hackaton.conveniado_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    //@Value("${spring.application.name}")
    @Value("Credenciado API")
    private String name;

    //@Value("${spring.application.version}")
    @Value("1.0")
    private String version;

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title(name)
                .description("Esta aplicação expõe os endpoints responsáveis por ações referentes ao Credenciado.")
                .version(version));
    }
}
