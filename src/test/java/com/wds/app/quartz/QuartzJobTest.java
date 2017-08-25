package com.wds.app.quartz;

import com.wds.app.user.entity.quartz.ScheduleJob;
import com.wds.app.user.handler.QuartzHandler;
import com.wds.app.user.jobs.TestJob;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-25 9:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzJobTest {

    @Resource
    private QuartzHandler quartzHandler;

    @Test
    public void testQuartzHandler(){
        ScheduleJob scheduleJob = new ScheduleJob("jobId-0", "jobName-0", ScheduleJob.DEFAULT_JOB_GROUP, "0/5 * * * * ?", "haha");
        Date date = quartzHandler.addJob(scheduleJob, TestJob.class);
        Assert.assertNotNull(date);
    }
}
