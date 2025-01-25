package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/* *
 * 部门管理Service
 * */
public interface DeptService {
    /* *
     * 查询全部部门数据
     * */
    List<Dept> list();

    /* *
     * 根据id删除部门
     * */
    void delete(Integer id) throws Exception;

    /* *
     * 新增部门dept
     * */
    void add(Dept dept);

    /* *
     * 根据id查询部门
     * */
    Dept getById(Integer id);

    /* *
     * 修改部门dept
     * */
    void update(Dept dept);

}
