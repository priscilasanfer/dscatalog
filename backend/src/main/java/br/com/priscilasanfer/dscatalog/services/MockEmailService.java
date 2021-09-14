package br.com.priscilasanfer.dscatalog.services;

import br.com.priscilasanfer.dscatalog.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockEmailService implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(MockEmailService.class);

    public void sendEmail(EmailDTO dto) {
        logger.info("Sending email to:" + dto.getTo());
        logger.info("Email sent!");
    }
}
