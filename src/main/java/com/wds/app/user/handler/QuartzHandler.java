package com.wds.app.user.handler;

import com.alibaba.fastjson.JSON;
import com.wds.app.user.entity.quartz.ScheduleJob;
import lombok.extern.log4j.Log4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 定时任务工具类
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-25 9:08
 */
@Component
@Log4j
public class QuartzHandler {

    @Resource
    private Scheduler schedulerFactoryBean;

    /**
     * 添加任务
     * @param scheduleJob 要添加的任务信息
     * @param jobClass    任务
     * @return
     */
    public Date addJob(ScheduleJob scheduleJob, Class<? extends Job> jobClass){
        Date date = null;
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
            JobKey jobKey = new JobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
            TriggerKey triggerKey = new TriggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());

            // 定时触发器
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            if(schedulerFactoryBean.checkExists(jobKey)){// 已存在该任务
                date = schedulerFactoryBean.rescheduleJob(triggerKey, trigger);
                log.info(String.format("已存在任务，更新任务内容：%s", JSON.toJSON(scheduleJob)));
            }else {//
                JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup()).build();
                date = schedulerFactoryBean.scheduleJob(jobDetail, trigger);
                log.info(String.format("添加一个新任务，任务内容：%s", JSON.toJSON(scheduleJob)));
            }
        }catch (Exception e){
            log.error("添加quartz任务出现异常，异常信息：{}", e);
        }
        return date;
    }

    /**
     * 删除任务
     * @param scheduleJob
     * @return
     */
    public boolean removeJob(ScheduleJob scheduleJob){
        boolean isDeleted = false;
        JobKey jobKey = new JobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        try {
            isDeleted = schedulerFactoryBean.deleteJob(jobKey);
        } catch (SchedulerException e) {
            log.error("删除quartz任务出现异常，异常信息：{}", e);
        }
        return isDeleted;
    }


}
