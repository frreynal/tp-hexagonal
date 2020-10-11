package app.spi;

import app.metier.Commande;

import java.util.List;

public interface StockService {


    void ajouterCommandes(List<Commande> commandes);

    int vendre(final int quantite);
    void afficheStock();
}
