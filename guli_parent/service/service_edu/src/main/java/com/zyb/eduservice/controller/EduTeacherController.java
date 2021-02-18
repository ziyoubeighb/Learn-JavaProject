package com.zyb.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyb.commonbase.utils.R;
import com.zyb.eduservice.entity.EduTeacher;
import com.zyb.eduservice.entity.vo.TeacherQuery;
import com.zyb.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zyb
 * @since 2021-02-16
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    //1.查询所有讲师
    @GetMapping("findAll")
    public R findAllTeacher(){
        //调用service方法
        List<EduTeacher> list = eduTeacherService.list(null);

        return R.ok().data("items",list);
    }
    //2.逻辑删除
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable String id){

        boolean b = eduTeacherService.removeById(id);

        if (b) {
            return R.ok();
        }else
            return R.error();
    }

    //3 分页查询方法
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,@PathVariable long limit){
        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page,null);
        long total = page.getTotal();
        List<EduTeacher> list = page.getRecords();
        return R.ok().data("total",total).data("rows",list);
    }

    //4 条件查询带分页
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,@RequestBody(required = false) TeacherQuery teacherQuery){
        //RequestBody 注意点，需要post提交，加上requested=false，查询条件空送空
        //创建page对象
        Page<EduTeacher> page = new Page<>(current,limit);

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        //构建查询条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件是否为空
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",end);
        }
        eduTeacherService.page(page,queryWrapper);
        return R.ok().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    /**
     * 5 添加讲师的方法
     */
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //6 根据id查询讲师信息
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable Integer id){
        EduTeacher byId = eduTeacherService.getById(id);
        return R.ok().data("teacher",byId);
    }

    //7 根据id更新讲师信息
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean update = eduTeacherService.updateById(eduTeacher);
        if(update){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

