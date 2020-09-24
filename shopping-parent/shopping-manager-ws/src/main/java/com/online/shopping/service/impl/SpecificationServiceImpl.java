package com.online.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.online.shopping.entity.PageResult;
import com.online.shopping.mapper.TbSpecificationMapper;
import com.online.shopping.mapper.TbSpecificationOptionMapper;
import com.online.shopping.pojo.TbSpecification;
import com.online.shopping.pojo.TbSpecificationExample;
import com.online.shopping.pojo.TbSpecificationOption;
import com.online.shopping.pojo.TbSpecificationOptionExample;
import com.online.shopping.pojogroup.Specification;
import com.online.shopping.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Override
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findPage(TbSpecification specification, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbSpecificationExample specificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = specificationExample.createCriteria();
        if (specification!=null){
            if (specification.getSpecName()!=null&&specification.getSpecName().length()>0){
                criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
            }
        }
        Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(specificationExample);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;
    @Override
    public void add(Specification specification) {
        //保存规格 一方的数据
        specificationMapper.insert(specification.getSpecification());

        //保存规格选项 多方的数据
        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {
            //设置规格的id：主键回填
            specificationOption.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(specificationOption);
        }

    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            //删除规格
            specificationMapper.deleteByPrimaryKey(id);
            //删除规格选项
            TbSpecificationOptionExample specificationOptionExample = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = specificationOptionExample.createCriteria();
            criteria.andSpecIdEqualTo(id);
            specificationOptionMapper.deleteByExample(specificationOptionExample);
        }
    }

    @Override
    public void update(Specification specification) {
        //修改规格
        specificationMapper.updateByPrimaryKey(specification.getSpecification());
        //先删除规格选项，再添加规格选项
        TbSpecificationOptionExample specificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = specificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());
        specificationOptionMapper.deleteByExample(specificationOptionExample);

        //保存规格选项
        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {
            //设置规格的id
            specificationOption.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public Specification findOne(Long id) {
        Specification specification = new Specification();
        //根据规格id查询规格对象
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        specification.setSpecification(tbSpecification);

        //根据规格id查询规格选项
        TbSpecificationOptionExample specificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = specificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> tbSpecificationOptions = specificationOptionMapper.selectByExample(specificationOptionExample);
        specification.setSpecificationOptionList(tbSpecificationOptions);
        return specification;
    }

    @Override
    public List<Map> selectOptionList() {
        return specificationMapper.selectOptionList();
    }
}
