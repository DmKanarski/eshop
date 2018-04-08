package by.kanarski.eshop.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kanarski.eshop.entities.journal.PasswordResetToken;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IPasswordResetTokenDao extends JpaRepository<PasswordResetToken, Long> {
}
