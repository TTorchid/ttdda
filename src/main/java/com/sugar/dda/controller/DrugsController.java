package com.sugar.dda.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sugar.dda.common.R;
import com.sugar.dda.entity.Drugs;
import com.sugar.dda.service.DrugsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/drugs")
public class DrugsController {
    @Autowired
    private DrugsService drugsService;
    /**
     * 新增药物
     * @param drugs
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Drugs drugs){
        log.info("新增药物，药物信息：{}",drugs.toString());

        //设置初始密码123456，需要进行md5加密处理
//        drugs.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        drugs.setCreateTime(LocalDateTime.now());

        drugs.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的id
        Long empId = (Long) request.getSession().getAttribute("employee");

        drugs.setCreateUser(empId);
        drugs.setUpdateUser(empId);


        drugsService.save(drugs);

        return R.success("新增药物成功");
    }

    /**
     * 药物信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Drugs> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name),Drugs::getDrugname,name);
        //添加排序条件
        queryWrapper.orderByDesc(Drugs::getUpdateTime);

        //执行查询
        drugsService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 根据id修改药物信息
     * @param drugs
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Drugs drugs){
        log.info(drugs.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        //Long empId = (Long)request.getSession().getAttribute("employee");
        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(empId);
        drugsService.updateById(drugs);

        return R.success("药物信息修改成功");
    }

    /**
     * 根据id查询yao信息
     * @param drugbankid
     * @return
     */
    @GetMapping("/{drugbankid}")
    public R<Drugs> getById(@PathVariable String drugbankid){
        log.info("根据id查询员工信息...");
        Drugs drugs = drugsService.getById(drugbankid);
        if(drugs != null){
            return R.success(drugs);
        }
        return R.error("没有查询到对应药物信息");
    }
}
