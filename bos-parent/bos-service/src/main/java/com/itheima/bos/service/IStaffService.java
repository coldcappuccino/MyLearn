package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.utils.PageBean;

public interface IStaffService {
    public void save(Staff model);

    public void pageQuery(PageBean pagebean);

    public void deleteBatch(String ids);

    public void update(Staff model);

    public Staff findById(String id);

    public List<Staff> findListNotDelete();
}
