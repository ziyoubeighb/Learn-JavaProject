package com.zyb.commonbase.handler.execption;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zyb
 * @date 2021-02-19 14:42
 */
@Data//需要安装lombok插件，否则不起作用
@AllArgsConstructor//生成所有参数的构造方法
@NoArgsConstructor//无传参构造方法
public class EduException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;//状态码
    private String msg;//异常信息



}
