package com.imooc.config;

import com.imooc.service.OrderService;
import com.imooc.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderJob {

    @Autowired
    private OrderService orderService;

//    @Scheduled(cron = "0/3 * * * * ? ")
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void autoCloseJob(){
        System.out.println("执行定时任务,当前时间为"+
                DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
