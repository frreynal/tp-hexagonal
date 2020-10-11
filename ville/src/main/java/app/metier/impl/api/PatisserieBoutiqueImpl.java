package app.metier.impl.api;

import app.api.PatisserieBoutique;
import app.metier.Banque;
import app.metier.Ville;
import app.spi.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatisserieBoutiqueImpl implements PatisserieBoutique {


    @Autowired
    private StockService stock;

    @Autowired
    Banque banque;



    @Override
    public void vendTarteAuxFraisesChantilly(int quantite) {
        int montantVente = stock.vendre(quantite);
        if (montantVente > 0) {
            System.out.println("Vente de tarte aux fraises chantilly : " + montantVente + "€");
        }
        this.banque.deposer(montantVente);
    }
}
