package com.sasken.website.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sasken.website.SaskenWebApplication;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration freemarkerConfig;

	private static Logger log = LoggerFactory.getLogger(SaskenWebApplication.class);

	public void sendEmail(Mail mail) throws Exception {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		// Using a subfolder such as /templates here
		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");

		Template t = freemarkerConfig.getTemplate(mail.getTemplateName());
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

		helper.setTo(mail.getTo());
		helper.setText(text, true);
		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());  

		// determines if there is an upload file, attach it to the e-mail
		MultipartFile attachFile = mail.getAttachment();
		if (attachFile!=null && !attachFile.equals("")) {
			String attachName = attachFile.getOriginalFilename();
			log.info("Attach resume :: "+mail.getSubject());
			helper.addAttachment(attachName, new InputStreamSource() {

				@Override
				public InputStream getInputStream() throws IOException {
					return attachFile.getInputStream();
				}
			});
		}
		//

		System.out.println("Sending email to " + mail.getTo() + "in mail Service " + mail.getModel().get("name"));
		sender.send(message);
		System.out.println("Email Sent to " + mail.getTo() + " in mail Service " + mail.getModel().get("name"));
	}

	public void sendEmailWithoutAttach(Mail mail) throws Exception {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		// Using a subfolder such as /templates here
		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");

		Template t = freemarkerConfig.getTemplate(mail.getTemplateName());
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

		helper.setTo(mail.getTo());
		helper.setText(text, true);
		helper.setSubject(mail.getSubject());
		System.out.println("Sending email to " + mail.getTo() + "in mail Service " + mail.getModel().get("name"));
		sender.send(message);
		System.out.println("Email Sent to " + mail.getTo() + " in mail Service " + mail.getModel().get("name"));
	}

	public void sendEmail2(Mail mail) throws Exception {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		// Using a subfolder such as /templates here
		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");

		Template t = freemarkerConfig.getTemplate(mail.getTemplateName());
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
//
		helper.setTo(mail.getTo());

		String addressTo = mail.getTo();
//		InternetAddress[] toIAdressArray = InternetAddress.parse(addressTo);
//		message.setRecipients(Message.RecipientType.TO, toIAdressArray);
//		
//		if(mail.getCc()!=null && !mail.getCc().equals("")) {
//			String addressCC = mail.getCc();
//			InternetAddress[] ccIAdressArray = InternetAddress.parse(addressCC);
//			message.setRecipients(Message.RecipientType.CC, ccIAdressArray);	
//		}

		//

		helper.setText(text, true);
		helper.setSubject(mail.getSubject());
		System.out.println("Sending email to " + mail.getTo() + "in mail Service " + mail.getModel().get("name"));
		sender.send(message);
		System.out.println("Email Sent to " + mail.getTo() + " in mail Service " + mail.getModel().get("name"));

	}
}
