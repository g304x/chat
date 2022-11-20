package com.sg.rl.threadpool;


import com.sg.rl.common.utils.Threads;
import com.sg.rl.spring.SpringContextComponent;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务管理器
 * 
 * @author steven
 */
public class AsyncManager
{

    private final int OPERATE_DELAY_TIME = 0;

    private ScheduledExecutorService executor = SpringContextComponent.getBean("scheduledExecutorService");

    private AsyncManager(){}

    private static AsyncManager me = new AsyncManager();

    public static AsyncManager me()
    {
        return me;
    }

    public void execute(TimerTask task)
    {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }


    public void execute(TimerTask task,int timeout)
    {
        executor.schedule(task, timeout, TimeUnit.MILLISECONDS);
    }

    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
