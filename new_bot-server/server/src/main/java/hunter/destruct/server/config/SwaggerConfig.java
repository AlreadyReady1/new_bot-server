package hunter.destruct.server.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.List;

@Configuration
@ConditionalOnProperty(name = "application.swagger.enabled", havingValue = "true")
public class SwaggerConfig {

    @Value("${application.swagger.title}")
    private String swaggerTitle;

    @Value("${application.swagger.description}")
    private String swaggerDescription;

    @Value("${application.swagger.version}")
    private String swaggerVersion;

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
                .info(info())
                .servers(servers());
    }

    private Info info() {
        return new Info()
                .title(swaggerTitle)
                .description(swaggerDescription)
                .version(swaggerVersion)
                .contact(new Contact().name("Moiseew Andrew").url(""));
    }

    //TODO: брать сервера из конфига. В конфиг добавить адрес прямой, и через шлюз.
    private List<Server> servers() {
        return List.of(
                new Server().url("http://localhost:8080/destruct-hunter").description("Destruct Hunter - API"));
    }
}
