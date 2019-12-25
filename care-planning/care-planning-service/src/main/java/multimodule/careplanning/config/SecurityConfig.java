package multimodule.careplanning.config;

import multimodule.common.spring.context.security.WebSecurityMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean("carePlanningSecurityMapping")
    public WebSecurityMapping webSecurityMapping() {
        return registry -> registry
                .antMatchers("/care-planning/**").authenticated();
    }
}
