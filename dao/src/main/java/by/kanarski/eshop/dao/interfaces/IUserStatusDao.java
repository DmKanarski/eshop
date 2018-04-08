package by.kanarski.eshop.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kanarski.eshop.entities.catalog.UserStatus;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserStatusDao extends JpaRepository<UserStatus, Long> {

    UserStatus getByUserStatusName(String userStatusName);

}
