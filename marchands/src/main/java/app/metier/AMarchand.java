package app.metier;

import app.api.Marchand;
import listener.TimeListener;
import lombok.Data;
import org.springframework.stereotype.Component;
import produits.AProduit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class AMarchand implements Marchand, TimeListener {

    protected AProduit produit;
    protected LinkedList<Commande> commandes;
    protected int delaiLivraison;
    protected int jour;


    @Override
    public int commander(int montant) {
        int nbItems = montant / this.produit.getPrixUnitaireAchat();
        this.ajouterCommande(nbItems);
        System.out.printf(" - %d %s commandés%n", nbItems, this.produit.getName());
        return nbItems * this.produit.getPrixUnitaireAchat();
    }



    @Override
    public void tempsPasse(int i) {
        jour=i;
    }

    @Override
    public List<Commande> livrer() {
        List<Commande> alivrer = new ArrayList<Commande>();
        if (commandes.isEmpty()) {
            return alivrer;
        }
        int jourlivraison = commandes.peek().getJourLivraison();

        while (jourlivraison <= jour) {
            Commande commande = commandes.removeFirst();
            alivrer.add(commande);
            if (commandes.isEmpty()) {
                return alivrer;
            }
            else{
                jourlivraison = commandes.peek().getJourLivraison();
            }
        }
        return alivrer;
    }


    protected void ajouterCommande(int nbItems) {
        Commande commande = new Commande(this.produit, nbItems, jour + delaiLivraison);
        commandes.add(commande); // == addlast
    }



}
