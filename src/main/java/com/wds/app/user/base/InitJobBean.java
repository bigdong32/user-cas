package com.wds.app.user.base;

import com.wds.app.user.entity.quartz.ScheduleJob;
import com.wds.app.user.handler.QuartzHandler;
import com.wds.app.user.jobs.TestJob;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;

/**
 * spring容器加载完后执行
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-25 15:09
 */
public class InitJobBean implements InitializingBean {

    @Resource
    private QuartzHandler quartzHandler;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("### InitJobBean.............");
        ScheduleJob scheduleJob = new ScheduleJob("jobId-0", "jobName-0", ScheduleJob.DEFAULT_JOB_GROUP, "0/5 * * * * ?", "haha");
        System.out.println(quartzHandler.addJob(scheduleJob, TestJob.class).toString());
    }
}
