/*
1) Существуют три корабля. На каждом из них 10 ящиков груза.
Они одновременно прибыли в порт в котором только два
дока. Скорость разгрузки 1 ящик в 0.5 сек. Напишите
программу которая управляя кораблями позволит им
правильно разгрузить груз.
 */

import docks.Dock;
import ships.Ship;
import utils.DocksDispatcher;

public class Main {
    public static DocksDispatcher docksDispatcher = new DocksDispatcher();
    ;

    public static void main(String[] args) {
        Dock dock1 = new Dock("Dock1", 500);
        Dock dock2 = new Dock("Dock2", 500);
        Dock dock3 = new Dock("Dock3", 500);
        Dock dock4 = new Dock("Dock4", 500);

        docksDispatcher.setBlockingQueueDocks(dock1);
        docksDispatcher.setBlockingQueueDocks(dock2);
        //docksDispatcher.setBlockingQueueDocks(dock3);
        //docksDispatcher.setBlockingQueueDocks(dock4);
        Ship ship1 = new Ship("One", 2, docksDispatcher);
        Ship ship2 = new Ship("Two", 3, docksDispatcher);
        Ship ship3 = new Ship("Tree", 2, docksDispatcher);
        ship1.start();
        ship2.start();
        ship3.start();
    }
}
