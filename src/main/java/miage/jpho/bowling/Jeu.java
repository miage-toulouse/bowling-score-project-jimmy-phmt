package miage.jpho.bowling;

public class Jeu {
    private int lancer1;
    private int lancer2;

    public Jeu(int unLancer1, int unLancer2) {
        this.lancer1 = unLancer1;
        this.lancer2 = unLancer2;
    }

    //contructeur pour un strike
    public Jeu(int unLancer1) {
        this.lancer1 = unLancer1;
    }

    public int nombreQuillesTombees() {
        return this.lancer1 + this.lancer2;
    }

    public int nombreQuillesTombeesLancer1() {
        return this.lancer1;
    }

    public int nombreQuillesTombeesLancer2() {
        return this.lancer2;
    }

    public boolean isSpare() {
        return this.lancer1+this.lancer2==10;
    }

    public boolean isStrike() {
        return this.lancer1 ==10;
    }
}
