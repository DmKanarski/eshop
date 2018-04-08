package by.kanarski.eshop.dto.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Very simple user dto, which is used to register the first user
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
//@PasswordMatches(message = ValidationMessages.PASSWORDS_DONT_MATCH)
public class NewUserDto implements Serializable {

    private static final long serialVersionUID = 4151799960482680421L;

//    @Pattern(regexp = ValidationRegExps.EMAIL_REGEXP, message = ValidationMessages.EMAIL_ERROR)
//    @NotNull(message = ValidationMessages.EMPTY_FIELD_ERROR)
//    @NotEmpty(message = ValidationMessages.EMPTY_FIELD_ERROR)
    private String email;
    private String password;
    private String passwordConfirmation;

}
