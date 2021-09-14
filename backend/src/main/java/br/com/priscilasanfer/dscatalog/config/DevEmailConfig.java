package br.com.priscilasanfer.dscatalog.config;

import br.com.priscilasanfer.dscatalog.services.EmailService;
import br.com.priscilasanfer.dscatalog.services.SendGridEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevEmailConfig {

    @Bean
    public EmailService serviceService(){
        return new SendGridEmailService();
    }

}
