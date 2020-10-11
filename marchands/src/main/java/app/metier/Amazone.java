package app.metier;

import app.api.Marchand;
import org.springframework.stereotype.Component;
import produits.PateFraise;

import java.util.LinkedList;

@Component("amazone")
public class Amazone extends AMarchand implements Marchand {


    public Amazone() {
      this.commandes = new LinkedList<Commande>();
      this.delaiLivraison = 2;
      this.jour = 0;
      this.produit = new PateFraise();

    }
}
