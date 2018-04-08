package by.kanarski.eshop.utils.modelmapper.support;

import org.springframework.stereotype.Component;

import by.kanarski.eshop.entities.journal.VerificationToken;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class VerificationTokenToStringConverter extends EntityConverter<VerificationToken, String> {

    @Override
    protected String convert(VerificationToken source) {
        return source.getTokenValue();
    }
}
