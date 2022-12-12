package com.leyou.item.api;

import com.leyou.item.pojo.Category;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("category")
public interface CategoryApi {


    @GetMapping("list")
    public List<Category> queryCategoriesByPid(@RequestParam("pid") Long pid);

    @GetMapping
    public List<String> queryNamesByIds(@RequestParam("ids") List<Long> ids);

}

