package com.xct.examinationsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xct.examinationsys.dao.ResourceDao;
import com.xct.examinationsys.entity.Resource;
import com.xct.examinationsys.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> findAllResources(Map<String, Integer> pageMap) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return resourceDao.findAllResources();
    }

    @Override
    public Resource selectResource(Integer id) {
        return resourceDao.selectResource(id);
    }

    @Override
    public void addResource(Resource resource) {
        resourceDao.addResource(resource);
    }

    @Override
    public void updateResource(Resource resource) {
        resourceDao.updateResource(resource);
    }

    @Override
    public void delete(int id) {
        resourceDao.delete(id);
    }
}
