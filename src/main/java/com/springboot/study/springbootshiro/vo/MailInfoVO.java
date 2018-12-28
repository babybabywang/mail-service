package com.springboot.study.springbootshiro.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *
 * 接收前端传递的固定邮箱所需信息
 *
 * @author huang
 * @version V1.0
 * @since 18/12/26
 */
@Data
@ApiModel("邮件所需信息")
public class MailInfoVO {
    @ApiModelProperty(value = "收件人")
    @NotBlank(message = "收件人不能为空")
    private String to;
    @ApiModelProperty(value = "邮件标题")
    @NotBlank(message = "邮件标题不能为空")
    private String subject;
    @ApiModelProperty(value = "邮件内容")
    @NotBlank(message = "邮件内容不能为空")
    private String content;
}
