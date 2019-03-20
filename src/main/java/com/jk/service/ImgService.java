package com.jk.service;

import com.jk.bean.ImgInfo;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface ImgService {
    SendPage queryImgInfo(ReceivePage receivePage, ImgInfo imgInfo);

    void addImgInfo(ImgInfo imgInfo);

    ImgInfo getImgById(Integer id);

    void deleteImg(String ids);
}
