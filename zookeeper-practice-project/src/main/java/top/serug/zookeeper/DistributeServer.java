package top.serug.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/4  16:41
 */
public class DistributeServer {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();

        //1：连接zookeeper
        server.getConnect();
        //2：注册节点
        server.regist("server101");
        //3：业务逻辑处理
        server.business();

    }

    private String connectString = "101.37.204.222:2181";
    private int sessionTimeout = 200000;
    private ZooKeeper zkClient;

    private void getConnect() throws IOException {
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


    private void regist(String hostName) throws KeeperException, InterruptedException {
        String path = zkClient.create("/servers/server1",hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(path);
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }


}

