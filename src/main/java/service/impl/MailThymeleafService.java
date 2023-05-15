package service.impl;

import dto.MailThymeleafDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class MailThymeleafService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public boolean sendMailWithTemplateThymeleaf(MailThymeleafDTO mailThymeleafDTO) throws MessagingException, UnsupportedEncodingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            Context context = new Context();
            context.setVariables(mailThymeleafDTO.getProps());

            String html = templateEngine.process(mailThymeleafDTO.getTemplateName(), context);

            helper.setFrom("vutuananh160297@gmail.com", "vu tuan anh");

            helper.setTo(mailThymeleafDTO.getEmailTo());
            helper.setSubject(mailThymeleafDTO.getSubject());
            helper.setText(html, true);


            mailSender.send(message);
            return true;

        } catch (MessagingException | UnsupportedEncodingException e) {
            return false;
        }
    }

}