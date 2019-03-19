package com.jk.service;

import com.jk.bean.Advert;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface AdvertService {
    SendPage queryAdvert(ReceivePage receivePage, Advert advert);

    void addInfo(Advert advert);

    Advert getById(Integer id);

    void deletes(String ids);

    void upOrDown(Integer id, Integer flag);
}
