package distributed.systems.with.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

// Start zookeeper server before running this.
public class WatchersDemo implements Watcher {

    private static final String ZOOKEEPER_ADDRESS = "localhost:2181";
    private static final int SESSION_TIMEOUT = 3000;
    private static final String ELECTION_NAMESPACE = "/election";
    private static final String TARGET_ZNODE = "/target_znode";
    private ZooKeeper zookeeper;
    private String currentZnodeName;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        WatchersDemo watchersDemo = new WatchersDemo();

        watchersDemo.connectToZookeeper();
        watchersDemo.watchTargetZnode();
        watchersDemo.volunteerForLeadership();
        watchersDemo.electLeader();

        watchersDemo.run();
        watchersDemo.close();

        System.out.println("Disconnected from Zookeeper, exiting application");
    }

    public void volunteerForLeadership() throws InterruptedException, KeeperException {
        String znodePrefix = ELECTION_NAMESPACE + "/c_";
        String znodeFullPath = zookeeper.create(znodePrefix, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println("znode name " + znodeFullPath);
        this.currentZnodeName = znodeFullPath.replace(ELECTION_NAMESPACE + "/", "");
    }

    public void electLeader() throws InterruptedException, KeeperException {
        List<String> children = zookeeper.getChildren(ELECTION_NAMESPACE, false);

        Collections.sort(children);

        String smallestChild = children.get(0);

        if (smallestChild.equals(currentZnodeName)) {
            System.out.println("I am the leader");
            return;
        }

        System.out.println("I am not the leader, " + smallestChild + " is the leader");
    }

    public void connectToZookeeper() throws IOException {
        this.zookeeper = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, this);
    }

    // If we don't add this, the application's main thread will terminate as soon as connectToZookeeper() is done.
    public void run() throws InterruptedException {
        synchronized (zookeeper) {
            zookeeper.wait();
        }
    }

    // gracefully close
    public void close() throws InterruptedException {
        zookeeper.close();
    }

    public void watchTargetZnode() throws InterruptedException, KeeperException {
        Stat stat = zookeeper.exists(TARGET_ZNODE, this);

        if (stat == null) {
            return;
        }

        byte[] data = zookeeper.getData(TARGET_ZNODE, this, stat);
        List<String> children = zookeeper.getChildren(TARGET_ZNODE, this);

        System.out.println("Data: " + new String(data) + ", children : " + children);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getType()) {
            case None:
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("Event received - Successfully connected to Zookeeper");
                } else {
                    synchronized (zookeeper) {
                        System.out.println("Event received - Disconnected from Zookeeper");
                        zookeeper.notifyAll();
                    }
                }
                break;
            case NodeDeleted:
                System.out.println(TARGET_ZNODE + " was deleted");
                break;
            case NodeCreated:
                System.out.println(TARGET_ZNODE + " was created");
                break;
            case NodeDataChanged:
                System.out.println(TARGET_ZNODE + " data changed");
                break;
            case NodeChildrenChanged:
                Changed:
                System.out.println(TARGET_ZNODE + " children changed");
                break;
        }

        try {
            watchTargetZnode();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (KeeperException e) {
            throw new RuntimeException(e);
        }
    }
}
