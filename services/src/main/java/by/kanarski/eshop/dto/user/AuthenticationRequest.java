package by.kanarski.eshop.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -424591740284197904L;
    private String username;
    private String password;

}
