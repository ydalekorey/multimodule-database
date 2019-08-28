package multimodule.inventory.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.Assert;

@Configuration
@ComponentScan(basePackages = {"multimodule.inventory"}, nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@EnableJpaRepositories(basePackages = {"multimodule.inventory.repository"})
@EntityScan("multimodule.inventory.model")
public class InventoryConfiguration {
}

class FullyQualifiedAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        return beanClassName;
    }

}
