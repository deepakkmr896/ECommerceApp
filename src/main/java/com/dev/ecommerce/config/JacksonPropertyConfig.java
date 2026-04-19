package com.dev.ecommerce.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.introspect.VisibilityChecker;


@Configuration
public class JacksonPropertyConfig {

    @Bean
    public JsonMapperBuilderCustomizer jsonFieldsCustomizer() {
        return mapper -> mapper.changeDefaultVisibility(checker -> new VisibilityChecker(JsonAutoDetect.Visibility.ANY));
    }

}
