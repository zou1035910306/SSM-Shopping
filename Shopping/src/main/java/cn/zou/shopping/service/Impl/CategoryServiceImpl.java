package cn.zou.shopping.service.Impl;

import cn.zou.shopping.bean.Category;
import cn.zou.shopping.bean.CategoryExample;
import cn.zou.shopping.dao.CategoryMapper;
import cn.zou.shopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 邹创基 on 2018/5/21 9:38
 *
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getParentTypeList() {
        return categoryMapper.getParentTypeList();
    }
}
