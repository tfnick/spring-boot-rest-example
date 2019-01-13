package com.gr.springboot.rest.endpoint;


import com.gr.springboot.rest.common.IResult;
import com.gr.springboot.rest.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApproveController {

    @RequestMapping("/hello")
    @ResponseBody
    public IResult hello(String cid, String gid){
        System.out.println("cid is " + cid);
        System.out.println("gid is " + gid);

        return IResult.buildSucces(new Person(1L,cid,gid));
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public IResult welcome(String cid, String gid){
        System.out.println("cid is " + cid);
        System.out.println("gid is " + gid);

        return IResult.buildFail();
    }


    @RequestMapping("/demo.html")
    public String demo(String cid, String gid){
        return "demo";
    }
}
