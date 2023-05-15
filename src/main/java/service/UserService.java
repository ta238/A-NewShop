package service;

import dto.UserDTO;
import model.User;
import org.springframework.data.domain.Page;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    User registerAdmin(UserDTO userDTO);

    org.apache.catalina.User registerUser(UserDTO userDTO);

    void sendVerificationEmail(User user, String verifyURL) throws MessagingException, UnsupportedEncodingException;

    boolean verify(String code);

    void updateResetPasswordToken(String token, String email);

    org.apache.catalina.User getByResetPasswordToken(String token);

    void updatePassword(User user, String newPassword);

    void sendForgotPassword(String email, String resetPasswordLink) throws MessagingException, UnsupportedEncodingException;

    org.apache.catalina.User findByEmail(String email);

    List<model.User> findAll();

    User findById(long id);

    User enabledAccount(long id);

    Page<model.User> pageFindAll(int pageNumber, String sortField, String sortDir);

    long countUser();

}