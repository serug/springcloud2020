package top.serug.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/4  09:58
 */
public class TestZookeeper {

    private String connectString = "101.37.204.222:2181";
    private int sessionTimeout = 200000;
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {

        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("=========== start ==========");

                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (String child : children) {
                    System.out.println(child);
                }

                System.out.println("=========== end ========");
            }
        });
    }


    /**
     * @Description: 1:创建子节点，并写入数据
     * @Param:
     * @return:
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkClient.create("/anode","this is firstNode! ".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    /**
     * @Description: 2:获取子节点，并监听上面的数据变化
     * @Param:
     * @return:
     */
    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }

        //延时阻塞
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * @Description: 3、判断节点是否有数据
     * @Param:
     * @return:
     */
    @Test
    public void isExist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/anode",false);
        System.out.println(stat==null?"节点不存在":"节点存在");
    }

}
