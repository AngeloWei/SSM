package cn.learn.ssm.web;

import cn.learn.ssm.entity.User;
import cn.learn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, Integer offset, Integer limit) {


        offset = offset == null ? 0 : offset;
        limit = limit == null ? 10 : limit;
        System.out.println("offset:" + offset + "  limit:" + limit);
        List<User> userList = userService.getUserByPage(offset, limit);
        model.addAttribute("userlist", userList);
        return "userlist";
    }

}
