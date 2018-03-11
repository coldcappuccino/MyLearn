package edu.neusoft.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.CategoryDao;
import edu.neusoft.springmvc.model.Category;

@Service
public class CategoryService {
    
    @Resource
    private CategoryDao categoryDao;
    
    public List<Category>selectAllCategory(){
        
        return categoryDao.selectAllCategory();
    }
}