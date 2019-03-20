package com.jk.controller;

import com.jk.bean.Count;
import com.jk.bean.Title;
import com.jk.service.EchartsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("echarts")
public class EchartsController {

    @Autowired
    private EchartsService echartsService;

    /**
     * 关注量
     */
    @RequestMapping("getGuanZhu")
    @ResponseBody
    public Map<String, Object> getGuanZhu() {
        Map<String, Object> params = new HashMap<>();
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        /*查询月关注量*/
        List<Count> counta = echartsService.getYueGuanZhu();
        for (Count counta1 : counta) {
            a.add(counta1.getName());
            a1.add(Integer.valueOf(counta1.getValue()));
        }
        params.put("categories1", a);
        params.put("data1", a1);
        /*查询总关注量*/
        ArrayList<String> b = new ArrayList<>();
        ArrayList<Integer> b1 = new ArrayList<>();
        List<Count> countb = echartsService.getZongGuanZhu();
        for (Count countb1 : countb) {
            b.add(countb1.getName());
            b1.add(Integer.valueOf(countb1.getValue()));
        }
        params.put("categories2", b);
        params.put("data2", b1);

        System.out.println(params);
        return params;
    }

    /**
     * 点击量日
     */
    @RequestMapping("getRidj")
    @ResponseBody
    public Map<String, Object> getRidj() {
        Map<String, Object> params = new HashMap<>();
        /*查询日点击量*/
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        List<Count> counta = echartsService.getRidj();
        for (Count counta1 : counta) {
            a.add(counta1.getName());
            a1.add(Integer.valueOf(counta1.getValue()));
        }
        params.put("categories1", a);
        params.put("data1", a1);
        System.out.println(params);
        return params;
    }
    /**
     * 点击量周
     */
    @RequestMapping("getZhoudj")
    @ResponseBody
    public Map<String, Object> getZhoudj() {
        /*查询周点击量*/
        Map<String, Object> params = new HashMap<>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<Integer> b1 = new ArrayList<>();
        List<Count> countb = echartsService.getZhoudj();
        for (Count countb1 : countb) {
            b.add(countb1.getName());
            b1.add(Integer.valueOf(countb1.getValue()));
        }
        params.put("categories2", b);
        params.put("data2", b1);
        System.out.println(params);
        return params;
    }
    /**
     * 点击量周
     */
    @RequestMapping("getYuedj")
    @ResponseBody
    public List<Count> getYuedj() {
        /*查询月点击量*/
        List<Count> countc = echartsService.getYuedj();
        System.out.println(countc);
        return countc;
    }
    /**
     * 会员数量查询
     */
    @RequestMapping("getVip")
    @ResponseBody
    public List<Count> getVip(){
        List<Count> count = echartsService.getVip();
        return count;
    }

    /**
     * 日周月
     */
    @RequestMapping("getrzy")
    @ResponseBody
    public Map<String, Object> getrzy() {
        /*查询日周月点击量*/
        Map<String, Object> params = new HashMap<>();
        List<String> list = echartsService.getrzy();
        ArrayList<Integer> a = new ArrayList<>();
        //ArrayList<String> a1 = new ArrayList<>();
        List<Count> counta = echartsService.getRidj();
        for (Count counta1 : counta) {
            //a1.add(counta1.getName());
            a.add(Integer.valueOf(counta1.getValue()));
        }
        ArrayList<Integer> b = new ArrayList<>();
        //ArrayList<String> b1 = new ArrayList<>();
        List<Count> countb = echartsService.getZhoudj();

        for (Count countb1 : countb) {
            //b1.add(countb1.getName());
            b.add(Integer.valueOf(countb1.getValue()));
        }
        ArrayList<Integer> c = new ArrayList<>();
        //ArrayList<String> c1 = new ArrayList<>();
        List<Count> countc = echartsService.getYuedj();
        for (Count countc1 : countc) {
            //c1.add(countc1.getName());
            c.add(Integer.valueOf(countc1.getValue()));
        }
        params.put("data1", a);
        params.put("data2", b);
        params.put("data3", c);
        params.put("categories", list);
        //params.put("categories1", a1);
        //params.put("categories2", b1);
        //params.put("categories3", c1);
        System.out.println(params);
        return params;
    }

    /**
     * 用户积分
     */
    @RequestMapping("getyonghujifen")
    @ResponseBody
    public Map<String, Object> getyonghujifen() {
        Map<String, Object> params = new HashMap<>();
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        List<Count> count = echartsService.getyonghujifen();
        for (Count count1 : count) {
            a.add(count1.getName());
            b.add(Integer.valueOf(count1.getValue()));
        }
        params.put("categories", a);
        params.put("data", b);
        System.out.println(params);
        return params;
    }

}
