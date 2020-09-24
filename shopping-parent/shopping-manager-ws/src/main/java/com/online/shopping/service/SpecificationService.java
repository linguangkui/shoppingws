package com.online.shopping.service;

import com.online.shopping.entity.PageResult;
import com.online.shopping.pojo.TbSpecification;
import com.online.shopping.pojogroup.Specification;

import java.util.List;
import java.util.Map;

/**
 * 规格接口
 */
public interface SpecificationService {
    /**
     * 分页功能
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(Integer pageNum, Integer pageSize);

    /**
     * 分页+模糊查询
     * @param specification
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbSpecification specification,Integer pageNum, Integer pageSize);
    /**
     * 添加规格管理信息
     * @param specification
     */
    void add(Specification specification);

    /**
     * 根据ids删除规格管理信息
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 修改规格管理信息
     * @param specification
     */
    void update(Specification specification);
    /**
     * 根据id查询规格管理信息
     * @param id
     * @return
     */
    Specification findOne(Long id);

    public List<Map> selectOptionList();
}
