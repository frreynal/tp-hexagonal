package app.metier;

import app.api.IBanque;
import listener.TimeListener;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.spi.CommandeService;

@Component
@NoArgsConstructor
@Data
public class Ville implements TimeListener {


    @Autowired
    private CommandeService commandeService;

    @Autowired
    private IBanque banque;


    private int jour;

    private boolean acheteDora = false;




    public void traiterCommande() {
        this.commandeService.traiterCommandes(banque);
    }


    @Override
    public void tempsPasse(int i) {
        jour = i;
        traiterCommande();
        acheteDora = this.banque.acheteDora();
        System.out.println("- Solde banque : " + this.banque.getSolde() + "€");
    }
}
