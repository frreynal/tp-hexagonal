package app.metier.impl.spi;

import app.metier.Commande;
import app.spi.StockService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import produits.AProduit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope("singleton")
public class StockServiceImpl implements StockService {

    private HashMap<AProduit, Integer> stock = new HashMap<>();

    @Override
    public void ajouterCommandes(List<Commande> commandes) {
        commandes.forEach(commande -> ajouterCommande(commande));
        System.out.println("Stock après livraison : ");
        afficheStock();
    }

    @Override
    public int vendre(final int nbCommande) {
        System.out.println("- Vente : ");

        AtomicInteger montantVente = new AtomicInteger();
        for (Map.Entry<AProduit, Integer> entry : stock.entrySet()) {
            int quantiteEffective = nbCommande;
            AProduit produit = entry.getKey();
            int quantite = entry.getValue();
            if (nbCommande > quantite) {
                quantiteEffective = quantite;
            }
            entry.setValue(quantite - quantiteEffective);
            int montant = quantiteEffective * produit.getPrixUnitaireVente();
            if (quantiteEffective > 0) {
                System.out.printf(" - %d %s vendus (%d€) %n ", quantiteEffective, produit.getName(), montant);
            }
            montantVente.addAndGet(montant);
        }

        return montantVente.get();
    }

    private void ajouterCommande(Commande commande) {
        AProduit produit = commande.getProduit();
        Integer quantite = commande.getQuantite();

        if (!this.stock.containsKey(produit)) {
            this.stock.put(produit, 0);
        }
        this.stock.compute(produit, (p, quantitePrecedente) -> quantitePrecedente + quantite);
    }


    @Override
    public void afficheStock() {
        stock.forEach((produit, quantite) -> {
            System.out.printf("{ %s : %d } %n", produit.getName(), quantite);
        });
    }


}
