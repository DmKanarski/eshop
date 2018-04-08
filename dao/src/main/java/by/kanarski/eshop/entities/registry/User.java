package by.kanarski.eshop.entities.registry;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import by.kanarski.eshop.entities.AbstractEntity;
import by.kanarski.eshop.entities.catalog.UserRole;
import by.kanarski.eshop.entities.catalog.UserStatus;
import by.kanarski.eshop.entities.journal.PasswordResetToken;
import by.kanarski.eshop.entities.journal.VerificationToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
@PrimaryKeyJoinColumn
public class User extends AbstractEntity {

    private static final long serialVersionUID = 1136347196170327885L;

    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobilePhone;
    private UserRole userRole;
    private UserStatus userStatus;
    private VerificationToken verificationToken;
    private PasswordResetToken passwordResetToken;


    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column
    public String getMiddleName() {
        return middleName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(nullable = false)
    public String getMobilePhone() {
        return mobilePhone;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_role_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_user_c_user_role")
    )
    public UserRole getUserRole() {
        return userRole;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_user_c_user_status")
    )
    public UserStatus getUserStatus() {
        return userStatus;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    public PasswordResetToken getPasswordResetToken() {
        return passwordResetToken;
    }

}
