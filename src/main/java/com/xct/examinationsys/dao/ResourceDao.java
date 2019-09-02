package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.Resource;

import java.util.List;

public interface ResourceDao {
    List<Resource> findAllResources();

    Resource selectResource(Integer id);

    void addResource(Resource resource);

    void updateResource(Resource resource);

    void delete(int[] ids);
}
