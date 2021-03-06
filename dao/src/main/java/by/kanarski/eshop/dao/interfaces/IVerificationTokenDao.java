package by.kanarski.eshop.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kanarski.eshop.entities.journal.VerificationToken;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IVerificationTokenDao extends JpaRepository<VerificationToken, Long> {

    VerificationToken getByTokenValue(String tokenValue);

}
