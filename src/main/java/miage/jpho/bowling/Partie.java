package miage.jpho.bowling;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List <Jeu> jeux = new ArrayList<>();

    public Partie(Jeu unJeu) {
        for(int i=0; i<10;i++){
            this.jeux.add(unJeu);
        }
        //pour gérer si au dernier coup on a un spare
        if(this.jeux.get(9).isSpare() || this.jeux.get(9).isStrike()){
            this.jeux.add(unJeu);
        }
    }

    public Integer calculScore() {
        Integer score = 0;
        for (int i=0; i<10 ; i++) {
            Jeu jeuCourant = this.jeux.get(i);
            score += jeuCourant.nombreQuillesTombees();

            if(jeuCourant.isSpare()){
                score+=this.jeux.get(i+1).nombreQuillesTombeesLancer1();
            }

            if(jeuCourant.isStrike()){
                score+=this.jeux.get(i+1).nombreQuillesTombeesLancer1()+this.jeux.get(i+1).nombreQuillesTombeesLancer2();
            }
        }
        return score;
    }
}
