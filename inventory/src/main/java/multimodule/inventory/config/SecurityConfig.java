package multimodule.inventory.config;

import multimodule.common.spring.context.security.WebSecurityMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean("inventorySecurityMapping")
    public WebSecurityMapping webSecurityMapping() {
        return registry -> registry
                .antMatchers("/inventory/**").authenticated();
    }
}
