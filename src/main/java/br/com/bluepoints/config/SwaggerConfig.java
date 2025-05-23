package br.com.bluepoints.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bluepointsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BluePoints API")
                        .version("v1")
                        .description("Documentação da API BluePoints - gerenciamento de pontos de reciclagem"));
    }
}
