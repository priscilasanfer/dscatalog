package br.com.priscilasanfer.dscatalog.services;

import br.com.priscilasanfer.dscatalog.dto.EmailDTO;

public interface EmailService {
    void sendEmail(EmailDTO dto);
}
