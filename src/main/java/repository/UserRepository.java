package repository;


import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByVerificationCode(String code);
    User findByResetPasswordToken(String token);
}
