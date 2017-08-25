package com.wds.app.user.entity.quartz;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 计划任务实体
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-25 9:34
 */
@Setter
@Getter
public class ScheduleJob implements Serializable{

    private static final long serialVersionUID = -8876033246308443137L;

    // 默认任务分组
    public static final String DEFAULT_JOB_GROUP = "user_case";

    /**
     * 任务id
     */
    private String jobId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * 任务运行时间表达式
     */
    private String cronExpression;

    /**
     * 任务描述
     */
    private String desc;

    public ScheduleJob(String jobId, String jobName, String jobGroup, String cronExpression, String desc) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.cronExpression = cronExpression;
        this.desc = desc;
    }
}
