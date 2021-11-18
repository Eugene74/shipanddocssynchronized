package utils;

import docks.Dock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class DocksDispatcher {
    private final BlockingQueue<Dock> blockingQueueDocks = new PriorityBlockingQueue<>();

    public DocksDispatcher() {
    }

    public Dock getBlockingQueueDocks() throws InterruptedException {
        return blockingQueueDocks.take();
    }

    public void setBlockingQueueDocks(Dock dock) {
        this.blockingQueueDocks.add(dock);
    }
}
