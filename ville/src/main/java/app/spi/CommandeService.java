package app.spi;

import app.api.IBanque;

public interface CommandeService {


    void traiterCommandes(IBanque banque);
}
