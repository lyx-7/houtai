package com.jk.service;

import com.jk.bean.Staff;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface StaffService {
    void addStaff(Staff staff);

    String upload(MultipartFile file, HttpServletRequest request);

    SendPage getPageList(Staff staff, ReceivePage receivePage);

    String delStaff(String id);

   

    void updateStaff(Staff staff);

    Staff queryStaff(Integer id);
}
