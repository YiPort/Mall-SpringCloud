package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryService() {
    }

    /**
     * 根据parentId查询子类目
     * @param pid
     * @return
     */
    public List<Category> queryCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }

    /**
     * 根据多个分类id查询分类名称
     * @param ids
     * @return
     */
    public List<String> queryCategoriesByIds(List<Long> ids){

        List<Category> categories = this.categoryMapper.selectByIdList(ids);

        //把List<Category>转换成List<String>
        return categories.stream().map(category -> category.getName()).collect(Collectors.toList());

    }

}
