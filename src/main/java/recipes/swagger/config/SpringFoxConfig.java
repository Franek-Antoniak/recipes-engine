package recipes.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		                                              .apis(RequestHandlerSelectors.basePackage("recipes"))
		                                              .paths(PathSelectors.any())
		                                              .build()
		                                              .apiInfo(apiInfo())
		                                              .useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RecipesEngine API")
		                           .description("Your recipes in our hands")
		                           .version("1.0")
		                           .contact(new Contact("Franciszek Antoniak",
				                           "https://www.linkedin.com/in/franciszek-antoniak",
				                           "franekant123@gmaill.com"))
		                           .build();
	}
}
