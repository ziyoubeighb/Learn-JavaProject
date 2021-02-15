package com.zyb.mpdemo20210214.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //@TableId(type = IdType.ID_WORKER)//mp自带策略，生成19位值，数字类型使用这种策略,切记使用包装类
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT) //数据库表中添加自动填充
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE) //数据库表中添加自动填充
    private Date updateTime;
    //并添加 @Version 注解
    @Version
    @TableField(fill = FieldFill.INSERT)
    /**
     * 支持的数据类型只有 int,Integer,long,Long,Date,Timestamp,LocalDateTime
     * 整数类型下 newVersion = oldVersion + 1
     * newVersion 会回写到 entity 中
     * 仅支持 updateById(id) 与 update(entity, wrapper) 方法,在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
     */
    private Integer version; //当要更新一条记录的时候，希望这条记录没有被别人更新，也就是说实现线程安全的数据更新
    //逻辑删除
    @TableLogic //由此注解，delete时，将改为update逻辑删除
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
