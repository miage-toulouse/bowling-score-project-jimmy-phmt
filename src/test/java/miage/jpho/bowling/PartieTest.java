package miage.jpho.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartieTest {
    // On fait les TDD sous cet ordre
    // 1) les cas nominaux (cas standard) :
    //      - chaque jeu on fait tomber 6 quilles
    // 2) cas d'erreurs (cas limites) :
    //      - strike et spare

    @Test
    public void testCalculScorePartieSansStrikeSansSpare() {
        //given : une partie de 10 jeux avec 6 quilles tombées dans chaque jeu
        Jeu leJeu = new Jeu(6, 0);
        Partie laPartie = new Partie(leJeu);
        //when : on calcule le score de la partie
        Integer score = laPartie.calculScore(); // Integer car la valeur peut être null (dans le cas d'un strike)
        //then : on obtient un score de 60
        assertEquals(Integer.valueOf(60), score);
    }

    @Test
    public void testCalculScorePartieAvecQueDesSpare() {
        //given : une partie de 10 jeux avec 5 quilles et 5 quilles tombées dans chaque jeu
        Jeu leJeu = new Jeu(5, 5);
        Partie laPartie = new Partie(leJeu);
        //when : on calcule le score de la partie
        Integer score = laPartie.calculScore(); // Integer car la valeur peut être null (dans le cas d'un strike)
        //then : on obtient un score de 150
        assertEquals(Integer.valueOf(150), score);
    }

    @Test
    public void testCalculScorePartieAvecQueDesStrike() {
        //given : une partie de 10 jeux avec que des strike dans chaque jeu
        Jeu leJeu = new Jeu(10);
        Partie laPartie = new Partie(leJeu);
        //when : on calcule le score de la partie
        Integer score = laPartie.calculScore(); // Integer car la valeur peut être null (dans le cas d'un strike)
        //then : on obtient un score de 150
        assertEquals(Integer.valueOf(300), score);
    }
}