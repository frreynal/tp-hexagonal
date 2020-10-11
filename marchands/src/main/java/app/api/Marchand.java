package app.api;

import app.metier.Commande;
import listener.TimeListener;

import java.util.List;


public interface Marchand extends TimeListener {

    /**
     *
     * @param montant maximal d'achat
     * @return le montant de la commande
     */
    int commander(int montant);

    @Override
    void tempsPasse(int i);

    public List<Commande> livrer();
}
