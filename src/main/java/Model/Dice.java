package Model;

public class Dice {
    private int numberOne;
    private int numberTwo;

    public Dice(int numberOne, int numberTwo) {
        this.numberOne = numberOne; 
        this.numberTwo = numberTwo;
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }
}
