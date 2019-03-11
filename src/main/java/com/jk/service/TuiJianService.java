package com.jk.service;

import com.jk.bean.TuiJian;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface TuiJianService {
    SendPage getTuiJianList(TuiJian tuiJian, ReceivePage receivePage);

    void updateToPass(Integer id);

    void updateToNoPass(Integer id);
}
