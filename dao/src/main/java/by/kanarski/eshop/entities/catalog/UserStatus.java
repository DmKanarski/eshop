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
@AttributeOverride(name = "id", column = @Column(name = "user_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserStatus extends AbstractEntity {

    private static final long serialVersionUID = 2311595513154602828L;

    public static final String STATUS_UNACTIVATED = "STATUS_UNACTIVATED";
    public static final String STATUS_ACTIVATED = "STATUS_ACTIVATED";

    private String userStatusName;

    @Builder
    public UserStatus(Long userStatusId, String userStatusName) {
        super(userStatusId);
        this.userStatusName = userStatusName;
    }

    @Column(nullable = false, unique = true, length = 145)
    public String getUserStatusName() {
        return userStatusName;
    }

}
