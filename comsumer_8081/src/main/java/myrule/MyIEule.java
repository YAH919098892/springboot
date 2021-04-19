package myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyIEule extends AbstractLoadBalancerRule {

    public Server choose(ILoadBalancer lb, Object key) {
        System.out.println("走进了我的算法");
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
//            获取可用的服务
            List<Server> upList = lb.getReachableServers();
//            所有服务
            List<Server> allList = lb.getAllServers();
//服务大小
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
//获取随机的的服务
//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);
            int top = 0;
            int currentindex = 0;
            if (top < 5) {
                System.out.println("执行次数"+top);
                top++;
                server = upList.get(currentindex);
            }
            else {
                top = 0;
                currentindex++;
                if (currentindex>upList.size()) {
                    currentindex = 0;
                }
               server = upList.get(currentindex);
            }


            if (server == null) {

                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {



}

}
