package by.kanarski.eshop.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kanarski.eshop.entities.registry.User;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
