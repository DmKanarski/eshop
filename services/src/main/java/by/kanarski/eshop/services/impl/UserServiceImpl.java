package by.kanarski.eshop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.kanarski.eshop.dao.interfaces.IUserDao;
import by.kanarski.eshop.dto.user.ConfirmationUser;
import by.kanarski.eshop.dto.user.NewUserDto;
import by.kanarski.eshop.services.interfaces.UserService;
import by.kanarski.eshop.utils.modelmapper.service.ModelMapperWrapper;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
class UserServiceImpl implements UserService {

    private ModelMapperWrapper modelMapper;
    private IUserDao userDao;

    @Override
    public ConfirmationUser registerUser(NewUserDto newUserDto) {
        
        return null;
    }
}