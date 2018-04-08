package by.kanarski.eshop.services.interfaces;

import by.kanarski.eshop.dto.user.ConfirmationUser;
import by.kanarski.eshop.dto.user.NewUserDto;

public interface UserService {

    ConfirmationUser registerUser(NewUserDto newUserDto);

}
