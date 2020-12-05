package fr.istv.Bugtracking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("fr.istv.Bugtracking.route"))
        		.paths(PathSelectors.any())
        		.build();
    }
    
    //Describe your Apis
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    			.title("Bugtracking Api")
    			.description("API to manage bugs")
    			.version("0.0.1-SNAPSHOT")
    			.build();
    }
}