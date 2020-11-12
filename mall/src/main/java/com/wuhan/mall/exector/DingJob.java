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
//        Set<String> set = new HashSet<>();
//        set.add("姜顺青，别脱裤子！！！");
//        set.add("刘忠伟已经被媳妇按在地上使劲摩擦了!");
//        set.add("张维维是超级兵！！");
//        set.add("顾文旭是个屌丝！！！");
//        for (String str : set) {
//            DingDingUtil.sendMsg(str);
//        }
        String str = "- 各位牛逼的大神们，周五晚开黑，战斗之夜，有媳妇的安排明白，没媳妇的抓紧回家。9:30 - 10:00开始组队，凑满开车！！！\n" +
                "![](http://118.178.254.125:8081/upload/6LP8lpnc.jpg)";
        DingDingUtil.sendMsg(str);
    }

}
