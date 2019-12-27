package multimodule.missioncontrol.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbMigrationConfig {

    @Autowired
    private DataSource dataSource;

    @Bean("missionControlLiquibase")
    public SpringLiquibase missionControlLiquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase-changeLog-missionControl.xml");
        liquibase.setDefaultSchema("missioncontrol");
        return liquibase;
    }
}
