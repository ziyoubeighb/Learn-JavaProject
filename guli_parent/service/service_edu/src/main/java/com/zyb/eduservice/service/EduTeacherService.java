package com.zyb.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyb.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author zyb
 * @since 2021-02-16
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

}
