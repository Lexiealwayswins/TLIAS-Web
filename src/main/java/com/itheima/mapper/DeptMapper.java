package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface DeptMapper {
    /* *
     * 查询全部部门
     * @return
     * */
    @Select("select * from dept")
    List<Dept> list();

    /* *
     * 根据id删除部门
     * @param id
     * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /* *
     * 新增部门dept
     * @param dept
     * */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /* *
     * 根据id查询部门dept
     * @param dept
     * */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    /* *
     * 修改部门dept
     * @param dept
     * */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
