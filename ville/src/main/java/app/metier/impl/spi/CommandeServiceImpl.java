package app.metier.impl.spi;

import app.api.IBanque;
import app.api.Marchand;
import app.metier.Commande;
import app.metier.Metro;
import app.spi.CommandeService;
import app.spi.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CommandeServiceImpl implements CommandeService {


    @Autowired
    @Qualifier("metro")
    private Marchand metro;

    @Autowired
    @Qualifier("milka")
    private Marchand milka;

    @Autowired
    private StockService stock;

    private int ratioAchat = 3;


    @Override
    public void traiterCommandes(IBanque banque) {
        System.out.println("- Commande :");
        commander(banque);
        receptionnerLivraison(banque);

    }

    private void commander(IBanque banque) {
        int montantCommande = metro.commander(banque.getSolde() / ratioAchat);
        montantCommande += milka.commander(0);
        banque.retirer(montantCommande);
    }

    private void receptionnerLivraison(IBanque banque) {
        List<Commande> commandes = milka.livrer();
        commandes.addAll(metro.livrer());
        if (commandes.isEmpty()) {
            return;
        }
        this.stock.ajouterCommandes(commandes);
    }
}
