package app.metier;

import app.spi.AcheterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Vikings implements Client {

    @Autowired
    AcheterService acheterService;

    private int jour;

    private int frequenceAchat = 4;

    @Override
    public void tempsPasse(int i) {
        jour = i;
        if (jourDuMarche()) {
            this.acheter();
        }
    }

    @Override
    public void acheter() {
            Random random = new Random(123L);
            int quantite = random.nextInt(200);
            this.acheterService.achete(quantite);
    }

    private boolean jourDuMarche() {
        return jour % frequenceAchat == 0;
    }
}
