package com.temquare.base.controller;

import com.temquare.base.pojo.Label;
import com.temquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
   public Result findAll(){
       return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
   }

    @RequestMapping(value="/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable String labelId){
        System.out.println("22222222222222222");
        return new Result(true, StatusCode.OK,"查询成功",labelService.findId(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,"保存成功");
    }

    @RequestMapping(value="/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    @RequestMapping(value="/{labelId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId){
        labelService.delete(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list =  labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label, @PathVariable Integer page, @PathVariable Integer size){
        Page<Label> pageData =  labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }
}
