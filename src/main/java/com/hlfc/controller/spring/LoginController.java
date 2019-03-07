package com.hlfc.controller.spring;

import com.baomidou.mybatisplus.plugins.Page;
import com.hlfc.db.mybatislpus.bean.Dept;
import com.hlfc.db.mybatislpus.bean.User;
import com.hlfc.db.mybatislpus.service.IDeptService;
import com.hlfc.db.mybatislpus.service.IUserService;
import com.hlfc.controller.util.ResponseResult;
import com.hlfc.util.EnvironmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * spring控制类
 * Created by HXL on 2018/8/31.
 */
@Controller
@RequestMapping("/spring")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDeptService deptService;

    /**
     * 根据用户名查询（get url参数）++++++++++++++++++++++++++++++++++++++++++++
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseResult query(@RequestParam( "name" ) String  name,@RequestParam( "password" ) String  password){

        //mybatiseplus 查询
        List<User> user = userService.getByName(name);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(user);
        return responseResult;
    }

    /**
     * 根据用户名查询（get url参数）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get11",method = RequestMethod.GET)
    public ResponseResult query(User user){

        //mybatiseplus 查询
//        List<User> user = userService.getByName(name);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(user);
        return responseResult;
    }

    /**
     * 保存用户（Content-Type:application/json）+++++++++++++++++++++++++++++++++++++++++
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponseResult save(@RequestBody User user){

        //mybatiseplus 保存
        boolean result =  userService.save(user);

       String a =  EnvironmentUtil.getInstance().getWebInfPath();

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(result);
        return responseResult;
    }

    /**
     * 保存用户（Content-Type:application/json，使用map接收）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveMap",method = RequestMethod.POST)
    public ResponseResult saveMap(@RequestBody Map<String,Object> user){
//        User user = secretLevelConfigService.queryByType(secretLevelType);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(user);
        return responseResult;
    }

    /**
     * 保存用户（Content-Type: application/x-www-form-urlencoded）+++++++++++++++++++++++++++++++==
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveForm",method = RequestMethod.POST)
    public ResponseResult saveForm(@RequestParam( "name" ) String  name,@RequestParam( "password" ) String  password){
//        User user = secretLevelConfigService.queryByType(secretLevelType);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(name);
        return responseResult;
    }


    /**
     * 更新用户
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "udapte",method = RequestMethod.POST)
    public ResponseResult udapte(@RequestBody User user){

        boolean result = userService.updateById(user);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(result);
        return responseResult;
    }

    /**
     * 删除用户
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public ResponseResult delete(@RequestParam("id") String id){

        boolean result = userService.removeById(id);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(result);
        return responseResult;
    }


    /**
     * 分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getPageByName",method = RequestMethod.GET)
    public ResponseResult getPageByName(){

        Page<User> pageUsers = new Page<User>(1,3);
        pageUsers =  userService.queryPageByNam(pageUsers,"123");
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(pageUsers);
        return responseResult;
    }


    /**
     * 关联查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUsersByDeptId",method = RequestMethod.GET)
    public ResponseResult getUsersByDeptId(String deptId){
        List<User> users = userService.getUsersByDeptId(deptId);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(users);
        return responseResult;
    }

    /**
     * 关联查询，返回map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUsersAndDeptByDeptId",method = RequestMethod.GET)
    public ResponseResult getUsersAndDeptByDeptId(String deptId){
        List<Map<String,Object>> users = userService.getUsersAndDeptByDeptId(deptId);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(users);
        return responseResult;
    }

    /**
     * 关联查询，返回部门对象（包含用户）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getDeptUsersByName",method = RequestMethod.GET)
    public ResponseResult getDeptUsersByName(String name){
        List<Dept> depts = deptService.getDeptUsersByName(name);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(depts);
        System.out.println(depts.get(0).getUsers().get(0).getName());
        List<Dept> depts11 = new ArrayList<Dept>();
        Dept dept = new Dept();
        dept.setDeptName("123");
        depts11.add(dept);
        return responseResult;
    }

}
