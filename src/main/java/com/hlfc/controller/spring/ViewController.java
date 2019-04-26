package com.hlfc.controller.spring;

import com.hlfc.controller.util.ResponseResult;
import com.hlfc.db.mybatislpus.bean.User;
import com.hlfc.nio.nettyAddWebSocket.WebsocketServer;
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
     * 首页
     * @return
     */
    @GetMapping("/index")
    public String  index(){
        return "index";
    }


    /**
     * socket
     * @return
     */
    @GetMapping("/nettySocket")
    public String  nettySocket(){
        try {
            WebsocketServer.connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "view/nettyAndWebSocket/socket";
    }

}
