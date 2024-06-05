
public class Card {
    private String name;
    private int power;
    private int attack;
    private int defence;

    private String imagePath;

    private int overall;

    public Card(String name, int power, int attack, int defence) {
        this.name = name;
        this.power = power;
        this.attack = attack;
        this.defence = defence;
setOverall();
    }

    public void setOverall() {
        this.overall = power + attack + defence;
    }

    // Getters for attributes
    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public int getDefence() {
        return this.defence;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getOverall() {
        return this.overall;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n  Power: " + power + " \n  Attack: " + attack + " \n Defence: " + defence+"\n Overall: "+ overall+"\n";
    }


}
