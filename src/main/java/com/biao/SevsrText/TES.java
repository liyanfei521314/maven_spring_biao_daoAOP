package com.biao.SevsrText;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TES {

    @Autowired
    JavaMailSender mailSender;

    @Test
    public void ss(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long endtime=System.currentTimeMillis();
        String date = formatter.format(endtime);
        System.out.println(date);
    }

    @Test
    public void ss1(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("13674966707@163.com");
        mailMessage.setTo("1454614582@qq.com");
        mailMessage.setSubject("放假通知");
        mailMessage.setText("明天放假");
        mailSender.send(mailMessage);
    }
}
