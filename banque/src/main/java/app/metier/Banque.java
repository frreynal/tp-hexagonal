package app.metier;

import app.api.IBanque;
import lombok.Data;
import app.metier.Compte;
import org.springframework.stereotype.Component;

@Data
@Component
public class Banque implements IBanque {

    int doraPrix = 3000;

    private Compte compte = new Compte();


    @Override
    public void deposer(int montant) {
        compte.setSolde(compte.getSolde() + montant);
    }

    @Override
    public boolean retirer(int montant) {
        if (montant > compte.getSolde()) {
            System.out.printf("Solde (%d €) insuffisant pour le retrait de %d€ %n", compte.getSolde(), montant);
            return false;
        }
        compte.setSolde(compte.getSolde() - montant);
        return true;
    }

    @Override
    public boolean acheteDora() {
        return compte.getSolde() >= doraPrix;
    }

    @Override
    public int getSolde() {
        return this.compte.getSolde();
    }
}
