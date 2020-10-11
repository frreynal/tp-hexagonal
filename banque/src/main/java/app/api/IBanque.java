package app.api;

public interface IBanque {

    void deposer( int montant);

    boolean retirer( int montant);

    boolean acheteDora();

    int getSolde();
}
