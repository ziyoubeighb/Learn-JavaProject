package com.zyb.mpdemo20210214.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyb.mpdemo20210214.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
