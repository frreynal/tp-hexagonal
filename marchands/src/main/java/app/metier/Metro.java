package app.metier;

import app.api.Marchand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import produits.PateFraise;

import java.util.LinkedList;

@Component("metro")
public class Metro extends AMarchand implements Marchand {


    public Metro() {
      this.commandes = new LinkedList<Commande>();
      this.delaiLivraison = 7;
      this.jour = 0;
      this.produit = new PateFraise();

    }
}
