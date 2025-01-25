package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/* *
   * 部门管理Controller
   * */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    /* *
     * 查询部门数据
     * */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET) // 指定请求方式为get
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        // 调用Service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }
    /* *
     * 删除部门
     * */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门：{}", id);
        // 调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /* *
     * 新增部门
     * @return
     * */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /* *
     * 根据ID查询部门
     * @return
     * */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询部门{}:", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /* *
     * 修改部门
     * @return
     * */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
