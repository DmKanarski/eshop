package by.kanarski.eshop.mailService;

import org.thymeleaf.context.Context;
import java.util.List;
import by.kanarski.eshop.wrappers.MimeElement;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

public interface IMailSenderHelper {

    void sendMail(String recipientEmail, String subject, String templateName,
                  Context context, List<MimeElement> imageElementList,
                  List<MimeElement> attachmentElementList);

    void sendSimpleMail(String recipientEmail, String subject, String templateName, Context context);

}
