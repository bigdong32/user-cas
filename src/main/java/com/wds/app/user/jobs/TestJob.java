package com.wds.app.user.jobs;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * 测试job
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-24 17:49
 */
// 串行执行job
@DisallowConcurrentExecution
public class TestJob implements Job{

    @Override
    public void execute(JobExecutionContext context)  {
        try {
            Thread.sleep(10000);// 停止10秒
            System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss") + " key:" + context.getJobDetail().getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
