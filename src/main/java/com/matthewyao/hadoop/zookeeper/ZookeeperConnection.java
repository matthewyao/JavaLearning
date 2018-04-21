package com.matthewyao.hadoop.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yaokuan on 2018/4/12.
 */
public class ZookeeperConnection {

    private ZooKeeper zooKeeper;

    private static final int TIMEOUT = 2000;
    private static final String CONNECTION_STR = "172.22.80.172:2181,172.22.80.173:2181,172.22.80.174:2181";

    final CountDownLatch connectedSignal = new CountDownLatch(1);

    public ZooKeeper connect() throws IOException, InterruptedException {
        System.out.println("连接zookeeper中...");

        zooKeeper = new ZooKeeper(CONNECTION_STR, TIMEOUT, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    connectedSignal.countDown();//连接成功，countdown
                }
            }
        });

        connectedSignal.await();
        System.out.println("连接zookeeper成功");
        return zooKeeper;
    }

    public void close() throws InterruptedException {
        if (zooKeeper == null) {
            System.out.println("zookeeper is null");
        }
        zooKeeper.close();
    }

    public static void main(String[] args) {
        ZooKeeper zooKeeper;
        ZookeeperConnection conn = new ZookeeperConnection();

        try {
            zooKeeper = conn.connect();
            zooKeeper.create("/auto", "My code first create".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

}
