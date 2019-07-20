package br.letsmovie.task.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* This class implements the Swagger API to provide documentation to the services inside this package/project
*
* @author Wanessa Nascimento
*/

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket detail() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.letsmovie.task"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.information().build());
	}
 
	private ApiInfoBuilder information() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Lets Movie API")
		.description("Documentation API.")
		.version("1.0").termsOfServiceUrl("")
		.license("Open Source")
		.licenseUrl("")
		.contact(new Contact("Wanessa Nascimento", "", "nessarodnasc@gmail.com"));
		return apiInfoBuilder;
	}
}