package com.xct.examinationsys.controller;


import com.github.pagehelper.Page;
import com.xct.examinationsys.common.JsonResult;
import com.xct.examinationsys.entity.Resource;
import com.xct.examinationsys.service.ResourceService;
import com.xct.examinationsys.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource")
public class resourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/list.do")
    @ResponseBody
    public Map<String, Object> listResources(Integer page, Integer limit) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Resource> list = resourceService.findAllResources(pageMap);

        long total = ((Page) list).getTotal();

        return PageUtil.pubPage(total, list);
    }

    @RequestMapping("/query")
    public JsonResult<Object> queryResource(Integer resourceId) {
        if (resourceId == null) {
            return new JsonResult<Object>(0, "ID为空");
        }

        return new JsonResult<>(1, resourceService.selectResource(resourceId));
    }

    @RequestMapping(value = "/addOrUpdate")
    public JsonResult<String> addOrUpdateResource(Resource resource) {
        if (resource.getResourceId() == null || resource.getResourceId().equals("")) {
            resourceService.addResource(resource);
        } else {
            resourceService.updateResource(resource);
        }
        return new JsonResult<>(1, "保存成功");
    }

    @RequestMapping("/delete")
    public JsonResult<String> delete(int[] id) {
        resourceService.delete(id);
        return new JsonResult<>(1, "删除成功");
    }


}
