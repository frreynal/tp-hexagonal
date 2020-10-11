package app.metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import produits.AProduit;


@Data
@AllArgsConstructor
public class Commande {

    private AProduit produit;
    private int quantite;
    private int jourLivraison;

}
