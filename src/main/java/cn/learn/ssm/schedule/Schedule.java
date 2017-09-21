package cn.learn.ssm.schedule;

import cn.learn.ssm.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
       private Logger log = LoggerFactory.getLogger(this.getClass());
       @Autowired
       private UserDao userDao;

       /*
       定时任务,积分每分钟+1
        */
       @Scheduled(cron = "0 0/1 0-23 * * ?")
       public void addScore(){
              userDao.addScore(1);
              log.info("addScore success");
       }




}
