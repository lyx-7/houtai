package com.jk.controller;

import com.jk.bean.Staff;
import com.jk.service.StaffService;
import com.jk.utils.FileUtil;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    /**
     * 新增员工
     * @param staff
     * @return
     */
    @RequiresPermissions(value = "add")
    @ResponseBody
    @RequestMapping("addStaff")
    public String addStaff(Staff staff){
        if(staff.getId()==null){
            staffService.addStaff(staff);
        }else if(staff.getId()!=null){
            staffService.updateStaff(staff);
        }
        return "";
    }

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request){

        return FileUtil.upload(file,request);
    }

    /**
     * 分页查询
     * @param staff
     * @param receivePage
     * @return
     */
    @RequiresPermissions(value = "query")
    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(Staff staff, ReceivePage receivePage) {
        SendPage  sp = staffService.getPageList(staff, receivePage);
        return sp;
    }
    /**
     * 删除
     */
    @RequiresPermissions(value = "del")
    @ResponseBody
    @RequestMapping("delStaff")
    public String delStaff(String id){

        return staffService.delStaff(id);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequiresPermissions(value = "query")
    @RequestMapping("queryStaff")
    @ResponseBody
    public Staff queryStaff(Integer id) {
        Staff staff =  staffService.queryStaff(id);
        return staff;
    }
}
