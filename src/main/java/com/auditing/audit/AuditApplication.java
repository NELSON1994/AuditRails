package com.auditing.audit;

import com.auditing.audit.audit.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditApplication {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
    public static void main(String[] args) {
        SpringApplication.run(AuditApplication.class, args);
    }

}


//Now, we want to enable JPA auditing by specifying @EnableJpaAuditing
//on one of our configuration classes, in this example, I have specified
//@EnableJpaAuditing on main Springboot2JpaAuditingApplication class.
//@EnableJpaAuditing accepts one argument.auditorAwareRef, where we need
//        to pass the name of the AuditorAware bean.
