package com.online.shopping.service;

import com.online.shopping.entity.PageResult;
import com.online.shopping.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * 品牌接口
 */
public interface BrandService {
    /**
     * 分页功能
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(Integer pageNum,Integer pageSize);

    /**
     * 添加品牌
     * @param brand
     * @return
     */
    void addBrand(TbBrand brand);
    /**
     * 修改品牌
     * @param brand
     * @return
     */
    void updateBrand(TbBrand brand);

    /**
     * 根据id获取品牌信息
     * @param id
     * @return
     */
    TbBrand findBrandDetail(Long id);

    /**
     * 删除品牌信息
     * @param ids
     * @return
     */
    void delete(Long[] ids);
    /**
     * 返回下拉列表数据
     * @return
     */
    public List<Map> selectOptionList();
}
