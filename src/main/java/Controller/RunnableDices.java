package Controller;

import Model.Player;

import java.util.Random;

public class RunnableDices implements Runnable{
    Player player;

    public RunnableDices(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        while (true){
            player.rollDice();

            player.setFlag(true);
            try {
                Thread.sleep(player.getWaitingTime());
                player.setFlag(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
