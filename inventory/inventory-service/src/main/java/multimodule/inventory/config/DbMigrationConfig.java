package multimodule.inventory.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbMigrationConfig {

    @Autowired
    private DataSource dataSource;

    @Bean("inventoryLiquibase")
    public SpringLiquibase inventoryLiquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase-changeLog-inventory.xml");
        liquibase.setDefaultSchema("inventory");
        return liquibase;
    }
}
