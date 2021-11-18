package ships;

import docks.Dock;
import utils.DocksDispatcher;

public class Ship extends Thread {
    private String name;
    private int container;
    DocksDispatcher docksDispatcher;

    public Ship(String name, int container, DocksDispatcher docksDispatcher) {
        this.name = name;
        this.container = container;
        this.docksDispatcher = docksDispatcher;
    }

    public String getNameShip() {
        return name;
    }

    public void setNameShip(String name) {
        this.name = name;
    }

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    @Override
    public void run() {
        Dock dock = null;
        try {
            dock = docksDispatcher.getBlockingQueueDocks();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ship '" + this.getNameShip() + "' run to Dock unload,  dock-" + dock.getName());

        while (this.container != 0) {
            dock.shipUnloading(this);
        }
        docksDispatcher.setBlockingQueueDocks(dock);
        System.out.println("\u001B[34m" + "Ship '" + this.getNameShip() + "' unloaded " + "\u001B[0m");
    }
}
