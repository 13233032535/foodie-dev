package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
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
public class Swagger2 {



    //配置swagger的核心配置 docket
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())  //指定api类型为swagger2
                    .select()
                    .apis(RequestHandlerSelectors
                            .basePackage("com.imooc.controller"))   //扫描controller包
                    .paths(PathSelectors.any())                    //所有controller
                    .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台对接接口api")  //文档标题页
                .contact(new Contact("imooc",
                        "http://www.imooc.com",
                        "61429364@qq.com"))  //联系人信息
                        .description("专为天天吃货提供的api文档")  //详细信息
                        .version("1.0.1")
                        .termsOfServiceUrl("http://www.imooc.com")  //网站地址
                        .build();
    }
}
