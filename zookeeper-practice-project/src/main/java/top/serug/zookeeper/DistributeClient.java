package top.serug.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/4  17:01
 */
public class DistributeClient {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient client = new DistributeClient();
        
        //1：连接zookeeper
        client.getConnect();
        //2：注册监听
        client.getChildren();
        //3：业务逻辑处理
        client.business();
    }

    private String connectString = "192.168.1.4:2181";
    private int sessionTimeout = 200000;
    private ZooKeeper zkClient;

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }


    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/servers", true);

        List<String> hosts = new ArrayList<>();
        for (String child : children) {
            byte[] data = zkClient.getData("/servers/"+child, true, null);
            hosts.add(new String(data));
        }

        System.out.println(hosts);
    }



    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }



}
