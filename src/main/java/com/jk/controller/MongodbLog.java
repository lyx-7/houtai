package com.jk.controller;

import com.jk.bean.Log;
import com.jk.bean.LogZF;
import com.jk.service.VipStartService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.beans.SimpleBeanInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class MongodbLog {
 @Resource
    MongoTemplate  mongoTemplate;
 @Resource
 VipStartService vipStartService;
 @RequestMapping("getMongoDbcz")
 public SendPage getMongo(ReceivePage rp) {
     Query query = new Query();
     int count = (int) mongoTemplate.count(query, LogZF.class);
     query.skip((rp.getPage() - 1) * rp.getRows());//
     query.limit(rp.getRows());// 每页展示的条数
     List<LogZF> logs = mongoTemplate.find(query, LogZF.class);
     for (LogZF log : logs) {
         String username=vipStartService.getUser(log.getUserid());
         log.setUsername(username);
     }
     SendPage sendPage = new SendPage(count, logs);// java 的装箱和拆箱
     return sendPage;
 }
}
