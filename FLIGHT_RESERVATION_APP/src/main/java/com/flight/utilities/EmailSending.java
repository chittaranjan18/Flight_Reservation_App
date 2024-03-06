package com.flight.utilities;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSending {
   
	/*
	 * @Autowired private JavaMailSender sender;
	 * 
	 * public void sendItinerary(String toAddress, String filePath) { MimeMessage
	 * message=sender.createMimeMessage(); try { MimeMessageHelper messageHelper=new
	 * MimeMessageHelper(message,true); messageHelper.setTo(toAddress);
	 * messageHelper.setSubject("Itineary of Flight");
	 * messageHelper.setText("please find the attached");
	 * messageHelper.addAttachment("Itinerary",new File(filepath));
	 * sender.send(message); }catch (MessagingException e) { e.printStackTrace(); }
	 * }
	 */
}
