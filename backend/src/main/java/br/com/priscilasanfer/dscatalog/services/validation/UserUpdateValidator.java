package br.com.priscilasanfer.dscatalog.services.validation;

import br.com.priscilasanfer.dscatalog.controller.exceptions.FieldMessage;
import br.com.priscilasanfer.dscatalog.dto.UserDTO;
import br.com.priscilasanfer.dscatalog.dto.UserInsertDTO;
import br.com.priscilasanfer.dscatalog.dto.UserUpdateDTO;
import br.com.priscilasanfer.dscatalog.entities.User;
import br.com.priscilasanfer.dscatalog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

    @Autowired
    private UserRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long userId = Long.parseLong(uriVars.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        User user = repository.findByEmail(dto.getEmail());

        if (user != null && userId != user.getId()) {
            list.add(new FieldMessage("email", "Esse email já existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
