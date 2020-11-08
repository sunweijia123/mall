package com.wuhan.mall.exector;

import com.wuhan.mall.util.DingDingUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DingJob {

    @Scheduled(cron = "0 0 9,15,21 * * ? ")
    public void sendMsg(){
        Set<String> set = new HashSet<>();
        set.add("姜顺青，别脱裤子！！！");
        set.add("刘忠伟已经被媳妇按在地上使劲摩擦了!");
        set.add("张维维是超级兵！！");
        set.add("顾文旭是个屌丝！！！");
        for (String str : set) {
            DingDingUtil.sendMsg(str);
        }
    }
}
