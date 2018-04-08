package by.kanarski.eshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.kanarski.eshop.dao.interfaces.IUserDao;
import by.kanarski.eshop.entities.registry.User;
import by.kanarski.eshop.utils.modelmapper.service.ModelMapperWrapper;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserDao userDao;
    private final ModelMapperWrapper modelMapper;

    @Autowired
    public UserDetailsServiceImpl(final IUserDao userDao, final ModelMapperWrapper modelMapper) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userDao.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return modelMapper.map(user, UserDetailsImpl.class);
    }

}
