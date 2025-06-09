package Busqueda.Busqueda.ConfigSwagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
                    .title("Microservicio Busqueda de Usuario")
                    .version("1.0")
                    .description("Documentacion de la API para el microservicio busqueda de ususario."));
    }
}
