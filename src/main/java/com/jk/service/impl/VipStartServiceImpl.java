package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Vip;
import com.jk.bean.vipStart;
import com.jk.mapper.VipStartMapper;
import com.jk.service.VipService;
import com.jk.service.VipStartService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VipStartServiceImpl implements VipStartService {
    @Resource
    VipStartMapper vipStartMapper;

    @Override
    public SendPage getVipStart(ReceivePage rp, vipStart v) {
         List<vipStart> count=vipStartMapper.getVipStart(v);
        PageHelper.startPage(rp.getPage(),rp.getRows());
         List<vipStart> list=vipStartMapper.getVipStart(v);

        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (vipStart vipStart : list) {
            long string = Long.parseLong(vipStart.getStartTime());
            long string2 = Long.parseLong(vipStart.getEndTime());
            Date date =new Date(string);
            Date date2 =new Date(string2);
            vipStart.setStartTime(sp.format(date));
            vipStart.setEndTime(sp.format(date2));

        }
        SendPage sb=new SendPage(count.size(),list);
        return sb;
    }

    @Override
    public vipStart getVipStartById(Integer id) {
        vipStart VipStart= vipStartMapper.getVipStartById(id);
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long string = Long.parseLong(VipStart.getStartTime());
        long string2 = Long.parseLong(VipStart.getEndTime());
        Date date =new Date(string);
        Date date2 =new Date(string2);
        VipStart.setStartTime(sp.format(date));
        VipStart.setEndTime(sp.format(date2));
        return VipStart;
    }

    @Override
    public void addVipStart(vipStart v) {
        System.out.println(v.getEndTime());
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        long time = 0;
        try {
            time = sp.parse(v.getEndTime()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        v.setEndTime(String.valueOf(time));
        vipStartMapper.addVipStart(v);
    }

    @Override
    public String getUser(Integer userid) {
        return vipStartMapper.getUser(userid);
    }
}
