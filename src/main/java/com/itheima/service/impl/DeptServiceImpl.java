package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    /* *
     * 查询全部部门数据
     * */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /* *
     * 根据id删除部门
     * */
//    @Transactional(rollbackFor = Exception.class) // Spring事物回滚
    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        try {
            // 1. 根据id删除部门数据
            deptMapper.deleteById(id);

            // 模拟抛出异常
//            int i = 1/0;

            // 2. 根据部门ID删除该部门下员工
            empMapper.deleteByDeptId(id);

        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }

    }

    /* *
     * 新增部门dept
     * */
    @Override
    public void add(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /* *
     * 根据id查询部门dept
     * */
    @Override
    public Dept getById(Integer id){
        return deptMapper.getById(id); // 根据id删除部门数据
    }

    /* *
     * 修改部门dept
     * */
    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}
