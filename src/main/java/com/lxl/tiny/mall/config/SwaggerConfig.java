package com.lxl.tiny.mall.config;

import com.lxl.tiny.mall.common.config.BaseSwaggerConfig;
import com.lxl.tiny.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.lxl.tiny.mall.modules.ums")
                .title("tiny-mall项目骨架")
                .description("tiny-mall项目骨架相关接口文档")
                .contactName("lxl")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
