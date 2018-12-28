package com.springboot.study.springbootshiro.controller;


import com.springboot.study.springbootshiro.service.MailService;
import com.springboot.study.springbootshiro.vo.MailInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 发送邮件类
 * @author huangsm
 */
@Api(value = "/mail",tags = "邮件服务")
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/simpleMail")
    @ApiOperation(value = "发送简单邮件" )
    public void sendSimpleMail(@RequestBody @Validated MailInfoVO mailInfoVO){
        mailService.sendSimpleMail(mailInfoVO.getTo(),mailInfoVO.getSubject(),mailInfoVO.getContent());
    }

    @PostMapping("/htmlMail")
    @ApiOperation(value = "发送HTML格式邮件" )
    public void sendHtmlMail(@RequestBody @Validated MailInfoVO mailInfoVO){
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>"+mailInfoVO.getContent()+"，😍!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(mailInfoVO.getTo(),mailInfoVO.getSubject(),content);
    }
    @Autowired
    private TemplateEngine templateEngine;
    @PostMapping("/templateMail")
    @ApiOperation(value = "推上云端" )
    public void sendTemplateMail(@RequestBody @Validated MailInfoVO mailInfoVO){
        //创建邮件正文
        Context context = new Context();
        context.setVariable("content",mailInfoVO.getContent());
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail(mailInfoVO.getTo(),mailInfoVO.getContent(),emailContent);
    }
}
