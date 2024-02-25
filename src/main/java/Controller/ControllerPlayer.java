package Controller;

import Model.Player;
import Utilities.JsonStorageUtilities;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerPlayer{
    JsonStorageUtilities json;
    List<Player> players;
    List<Player> playersClone = new ArrayList<>();

    public ControllerPlayer() {
        json = new JsonStorageUtilities();
        players = json.readContentFromFile();
        playersClone.addAll(players);
    }

    public void initialisePlayers(){
        for (Player aux: players) {
            aux.calculateHour();
            aux.rollDice();
            aux.setWaitingTime(3000);
//            aux.calculateWaitingTime();
        }
    }

    public void sumPoints(Player player, int sumDices){
        if(!player.isFlag()){
            player.setPoints(player.getPoints() + sumDices);
        }
        findPlayer(player.getName()).setNumberGames(player.getNumberGames() - 1);
    }

    private Player findPlayer(String name) {
        for (Player player : playersClone) {
            if(player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }

    public boolean isWinner(Player player){
        if(player.getPoints() >= player.getPointsToComplete()){
            return true;
        }
        return false;
    }

    public List<Player> playerRankings(){
        return playersClone.stream()
                .sorted(Comparator.comparingInt(Player::getNumberGames))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

}
