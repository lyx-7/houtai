package com.jk.mapper;

import com.jk.bean.Staff;

import java.util.List;

public interface StaffMapper {
    void addStaff(Staff staff);

    List<Staff> getPageList(Staff staff);

    void delStaff(String id);



    void updateStaff(Staff staff);

    Staff queryStaff(Integer id);
}
