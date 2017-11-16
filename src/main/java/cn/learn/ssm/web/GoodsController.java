package cn.learn.ssm.web;

import cn.learn.ssm.dto.BaseResult;
import cn.learn.ssm.entity.Goods;
import cn.learn.ssm.enums.ResultEnum;
import cn.learn.ssm.exception.BizException;
import cn.learn.ssm.service.GoodsService;
import com.alibaba.fastjson.JSON;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /*
        获取商品列表

     */
    @RequestMapping(value="list",method = RequestMethod.GET)
    public String  getGoodsList(Model model,Integer offset,Integer limit){
        offset=offset==null?0:offset;
        limit=limit==null?50:limit;
        List<Goods> list = goodsService.getGoodsByPage(offset, limit);
        model.addAttribute("goodslist",list);
        return "goodslist";
    }
    /*
    购买商品
     */
    @RequestMapping(value="/{goodId}/buy",method = RequestMethod.POST,produces = {"Application/JSON;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> buy(@CookieValue(value="userId",required = false)Long userId,Goods goods){

        if(userId==null){
            return new BaseResult<Object>(false, ResultEnum.USER_INVALIABLE.getMsg());
        }

        try {
            goodsService.buyGoods(userId,goods.getgoodId());
        } catch (BizException e) {
            return new BaseResult<Object>(false,e.getMessage());
        }catch(Exception e){
            return new BaseResult<Object>(false,e.getMessage());
        }
        return new BaseResult<Object>(true,"购买成功");

    }
}
