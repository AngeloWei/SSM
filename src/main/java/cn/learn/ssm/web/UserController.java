package cn.learn.ssm.web;

import cn.learn.ssm.dto.BaseResult;
import cn.learn.ssm.entity.User;
import cn.learn.ssm.service.UserService;
import cn.learn.ssm.validation.Not100;
import cn.learn.ssm.web.paramEntity.UserList1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value="list1",method = RequestMethod.POST,consumes = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult list1(
            @RequestParam @Valid @Not100 Long number,
            @RequestBody @Valid UserList1 userList1,
            BindingResult result
            ){
       System.out.println("limit:"+userList1.getLimit() +"  offset:"+userList1.getOffset());
       if (userList1.getLimit()==100) {
           throw new RuntimeException("运行一场");
       }

       return new BaseResult(true,"成功了");
    }

}
