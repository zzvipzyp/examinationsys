package com.xct.examinationsys.service;

import com.xct.examinationsys.entity.Resource;

import java.util.List;
import java.util.Map;

public interface ResourceService {
    List<Resource> findAllResources(Map<String, Integer> pageMap);

    Resource selectResource(Integer id);

    void addResource(Resource resource);

    void updateResource(Resource resource);

    void delete(int id);
}
