package com.agorohov.spring.spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan("com.agorohov.spring.spring_introduction")
@PropertySource("classpath:myApp.properties")
public class MyConfig {
    
    @Bean
    @Scope("singleton")
    public Pet catBean(){
        System.out.println("catBean method inside");
        return new Cat();
    }
    
    @Bean
    public Person personBean(){
        System.out.println("personBean method inside");
        return new Person(catBean());
    }
}
