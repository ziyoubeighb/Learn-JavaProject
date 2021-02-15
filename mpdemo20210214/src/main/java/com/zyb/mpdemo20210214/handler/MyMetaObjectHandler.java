package com.zyb.mpdemo20210214.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component //不要忘记添加 @Component 注解,否则扫描不到 ,数据库表中添加自动填充字段
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final Logger logging = LoggerFactory.getLogger(MetaObjectHandler.class);
    @Override
    public void insertFill(MetaObject metaObject) {
        logging.info("start insert auto fill ...");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        //乐观锁，版本控制
        this.setFieldValByName("version", 1, metaObject);
        //元对象处理器接口添加deleted的insert默认值
        this.setFieldValByName("deleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logging.info("start update auto fill ...");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }


}
