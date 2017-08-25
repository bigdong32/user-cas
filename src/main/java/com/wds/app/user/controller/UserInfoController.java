package com.wds.app.user.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.wds.app.user.entity.UserInfo;
import com.wds.app.user.entity.quartz.ScheduleJob;
import com.wds.app.user.handler.QuartzHandler;
import com.wds.app.user.jobs.TestJob;
import com.wds.app.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-10 16:25
 */
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Resource
    private QuartzHandler quartzHandler;

    @RequestMapping("/getAll")
    public void testU(){
        UserInfo userInfo = new UserInfo();
        List<UserInfo> userInfos = userInfo.selectAll();
        userInfos.forEach(userInfoEntity -> {
            System.out.println(userInfoEntity.getName());
        });

        List<UserInfo> userInfoList = iUserInfoService.selectList(null);
        userInfoList.forEach(userInfo1 -> {
            System.out.println(userInfo1.getName());
        });
    }

    @RequestMapping("/getAllUserRole")
    public void testUR(){
        Page<UserInfo> page = iUserInfoService.getUserInfosByPage(new Page<UserInfo>(1, 3));
        page.getRecords().forEach(userInfo -> {
            System.out.println(userInfo.getId());
        });
    }

    @RequestMapping("/testQuartz")
    public void testQuartz(){
        ScheduleJob scheduleJob = new ScheduleJob("jobId-0", "jobName-0", ScheduleJob.DEFAULT_JOB_GROUP, "0/5 * * * * ?", "haha");
        System.out.println(quartzHandler.addJob(scheduleJob, TestJob.class).toString());
    }
}
