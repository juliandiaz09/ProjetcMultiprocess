package Controller;

import Model.Player;

public class RunnableTime implements Runnable{
    Player player;

    public RunnableTime(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        while (true) {
            player.calculateHour();
            try {
                Thread.sleep(1000); // Esperar 1 segundo antes de actualizar la hora nuevamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
