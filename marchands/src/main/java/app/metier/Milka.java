package app.metier;

import app.api.Marchand;
import org.springframework.stereotype.Component;
import produits.Lait;
import produits.PateFraise;

import java.util.LinkedList;

@Component("milka")
public class Milka extends AMarchand implements Marchand {


    public Milka() {
        this.commandes = new LinkedList<Commande>();
        this.delaiLivraison = 4;
        this.jour = 0;
        this.produit = new Lait();
    }


    @Override
    public int commander(int montant) {
        int nbItems = 10;
        this.ajouterCommande(nbItems);
        return 0 ;
    }
}
