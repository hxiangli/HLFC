package com.hlfc.controller.spring;

import com.hlfc.controller.util.ResponseResult;
import com.hlfc.db.mybatislpus.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: HXL
 * @Date: 2018/11/5 13:51
 */
@Controller
@RequestMapping("/")
public class ViewController {

    /**
     * 视图解析器作用。
     * @return
     */
    @GetMapping("/index")
    public String  index(){
        return "index";
    }
}
