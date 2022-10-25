package com.example.customexception.domain.email.application.impl;

import com.example.customexception.domain.email.application.service.EmailApplication;
import com.example.customexception.domain.email.exception.MailException;
import com.example.customexception.domain.email.exception.MailExceptionType;
import com.example.customexception.global.application.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailApplicationImpl implements EmailApplication {

    private final JavaMailSender javaMailSender;

    private static String verifiedKey="";
    private final JwtService jwtService;

    @Override
    public MimeMessage createVerifiedEmail(String toEmail,String nickname) throws MailException {
        StringBuilder sb=new StringBuilder();
        System.out.println("고객 이메일 = "+toEmail);
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.addRecipients(Message.RecipientType.TO, toEmail);
            message.setSubject("TEST E-MAIL Subject");

            sb.append("<div style='margin:100px;'>");
            sb.append("버튼을 누를시에 인증 링크로 넘기고 토큰 발급").append("\n");
            sb.append("본인 서버에서 인증된 메일인지 확인을 위해 이메일 중복 체크").append('\n');
            sb.append("그리고 토큰유효성체크 토큰은 일회성 토큰임").append('\n');
            sb.append("이제 밑에 버튼 2개에 하나는 로컬용 하나는 서버배포시 사용할 링크").append('\n');
            sb.append("<button onclick='location.href='http://localhost:8888/api/v1/emailVerified''></button>");
            sb.append("<br>");
            sb.append("<hr>");
            sb.append("<button disabled='disabled'></button>");
            sb.append("<br>");
            sb.append("</div>");
            message.setText(sb.toString(), "utf-8", "html");
            message.setFrom(new InternetAddress("lsh6451217@gmail.com", "DEMO"));
            return message;
        }catch (Exception m){
            throw new MailException(MailExceptionType.NO_CREATE_EMAIL);
        }

    }


    public static String createVerifiedCode(){
        StringBuilder key=new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    //  a~z  (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }

        return key.toString();
    }
}
