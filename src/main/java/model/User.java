package model;

import lombok.*;
import org.apache.catalina.Group;
import org.apache.catalina.UserDatabase;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class User implements Serializable, org.apache.catalina.User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "full_name", nullable = false, length = 20)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    private boolean enabled;

    @Column(name = "reset_password_token", length = 30)
    private String resetPasswordToken;

    @Override
    public Iterator<Group> getGroups() {
        return null;
    }

    @Override
    public Iterator<org.apache.catalina.Role> getRoles() {
        return null;
    }

    @Override
    public UserDatabase getUserDatabase() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public void addRole(org.apache.catalina.Role role) {

    }

    @Override
    public boolean isInGroup(Group group) {
        return false;
    }

    @Override
    public boolean isInRole(org.apache.catalina.Role role) {
        return false;
    }

    @Override
    public void removeGroup(Group group) {

    }

    @Override
    public void removeGroups() {

    }

    @Override
    public void removeRole(org.apache.catalina.Role role) {

    }

    @Override
    public void removeRoles() {

    }

    @Override
    public String getName() {
        return null;
    }
}