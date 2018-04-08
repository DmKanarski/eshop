package by.kanarski.eshop.entities.catalog;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import by.kanarski.eshop.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "user_role_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserRole extends AbstractEntity {

    private static final long serialVersionUID = 694427070718261542L;

    public static final String ROLE_SIMPLE_USER = "ROLE_SIMPLE_USER";

    private String userFunctionName;

    @Builder
    public UserRole(Long userFunctionId, String userFunctionName) {
        super(userFunctionId);
        this.userFunctionName = userFunctionName;
    }

    @Column(nullable = false, unique = true, length = 30)
    public String getUserFunctionName() {
        return userFunctionName;
    }

}
