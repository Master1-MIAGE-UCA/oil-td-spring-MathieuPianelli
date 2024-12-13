package unica.M1.Miage;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {

    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    /**
     * Simule un lancer de dé.
     * @param sides le nombre de faces du dé (par exemple, 6 pour un dé classique)
     * @return un entier aléatoire entre 1 et le nombre de faces inclus
     */
    public int roll(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("Le nombre de faces doit être supérieur ou égal à 1.");
        }
        return random.nextInt(sides) + 1;
    }
}