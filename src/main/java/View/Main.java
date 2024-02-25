package View;

import Controller.ControllerPlayer;
import Controller.RunnableDices;
import Controller.RunnableTime;
import Model.Player;
import Utilities.JsonStorageUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonStorageUtilities j = new JsonStorageUtilities();
        List<Player> aux = j.readContentFromFile();
        ControllerPlayer controllerPlayer = new ControllerPlayer();
        controllerPlayer.initialisePlayers();

        JFrame frame = new JFrame("Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3));

        // Agregar componentes a la rejilla
        JLabel jLabel = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        panel.add(jLabel);
        panel.add(jLabel1);
        panel.add(jLabel2);
        frame.add(panel);
        frame.setVisible(true);

        RunnableDices runnableDices = new RunnableDices(controllerPlayer.getPlayers().get(0));
        RunnableTime runnableTime = new RunnableTime(controllerPlayer.getPlayers().get(0));

        Thread thr1 = new Thread(runnableDices);
        Thread thr2 = new Thread(runnableTime);

        thr1.start();
        thr2.start();

        while (true){
            jLabel.setText(controllerPlayer.getPlayers().get(0).getCurrentTime());
            jLabel1.setText(String.valueOf(controllerPlayer.getPlayers().get(0).getDiceOne().getNumber()));
            jLabel2.setText(String.valueOf(controllerPlayer.getPlayers().get(0).getDiceTwo().getNumber()));
            try {
                Thread.sleep(1000); // Esperar 1 segundo antes de actualizar los horarios nuevamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        /*

                while (true) {
            graphic.getLabel1().setText(time.countryName +"  " + time.getCurrentTime() + "           ");
            graphic.getLabel2().setText(time1.countryName + "  " + time1.getCurrentTime() + "           ");
            graphic.getLabel3().setText(time2.countryName + "  " + time2.getCurrentTime() + "           ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         */


    }
}
