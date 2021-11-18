package docks;

import ships.Ship;
import utils.DocksDispatcher;

public class Dock implements Runnable, Comparable {

    private String name;
    private int workSpeed;
    private DocksDispatcher docksDispatcher;
    private Ship ship;

    public Dock(String name, int workSpeed) {
        this.name = name;
        this.workSpeed = workSpeed;
    }

    public int getWorkSpeed() {
        return workSpeed;
    }

    public void setWorkSpeed(int workSpeed) {
        this.workSpeed = workSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // разгружаем корабль
        int i = 1;
        while (ship.getContainer() != 0) {
            ship.setContainer(ship.getContainer() - 1);
            try {
                System.out.println(i + " container begin unload ship-'" + ship.getNameShip() + "', working - " + this.name);
                Thread.sleep(workSpeed);
                System.out.println(i + " container unloaded from ship-'" + ship.getNameShip() + "'");
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public /*synchronized*/ void shipUnloading(Ship ship) {
        System.out.println("in dock method shipunloading - " + ship.getName() + "  ship '" + ship.getNameShip() + "'");
        this.ship = ship;
        this.run();
        this.ship = null;
    }

    @Override
    public int compareTo(Object o) {
        Dock dock = (Dock) o;
        return this.getName().compareTo(dock.getName());
    }
}
