package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Staff;
import com.jk.mapper.StaffMapper;
import com.jk.service.StaffService;
import com.jk.utils.FileUtil;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper StaffMapper;
    @Override
    public void addStaff(Staff staff) {
        StaffMapper.addStaff(staff);
    }
    @Override
    public String upload(MultipartFile file, HttpServletRequest request) {

        return FileUtil.upload(file,request);
    }
    @Override
    public SendPage getPageList(Staff staff, ReceivePage receivePage) {
        List<Staff> count = StaffMapper.getPageList(staff); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Staff> list = StaffMapper.getPageList(staff); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    @Override
    public String delStaff(String id) {
        StaffMapper.delStaff(id);
        return null;
    }


    @Override
    public void updateStaff(Staff staff) {
        StaffMapper.updateStaff(staff);
    }

    @Override
    public Staff queryStaff(Integer id) {

        return StaffMapper.queryStaff(id);
    }
}
