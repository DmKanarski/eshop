package by.kanarski.eshop.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kanarski.eshop.entities.catalog.UserRole;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IUserRoleDao extends JpaRepository<UserRole, Long> {
}
