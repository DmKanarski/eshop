package by.kanarski.eshop.dto.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import by.core.profito.dto.CompanyDto;
import by.core.profito.dto.PhoneDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends User {

    private static final long serialVersionUID = 4892635165008523575L;
    private Integer userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String skype;
    private Set<PhoneDto> phoneSet;
    private CompanyDto company;
    private Set<UserDto> childUsersSet;
    private UserDto parentUser;
    private Date createTime;
    private Set<String> roleSet;
    private String userStatus;

    @Builder
    public UserDto(Integer userId, String password, String firstName, String middleName, String lastName, String email,
                   String skype, Set<PhoneDto> phoneSet, CompanyDto company, Set<UserDto> childUsersSet,
                   UserDto parentUser, Date createTime, Set<String> roleSet, String userStatus) {
        super(email, password, getGrantedAuthorities(roleSet));
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.skype = skype;
        this.phoneSet = phoneSet;
        this.company = company;
        this.childUsersSet = childUsersSet;
        this.parentUser = parentUser;
        this.createTime = createTime;
        this.roleSet = roleSet;
        this.userStatus = userStatus;
    }

    public UserDto() {
        super("blank", "blank", getAnnonymous());
    }

    private static List<GrantedAuthority> getGrantedAuthorities(Set<String> roleSet) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roleSet) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        }
        return authorities;
    }

    private static List<GrantedAuthority> getAnnonymous() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        return authorities;
    }

}
