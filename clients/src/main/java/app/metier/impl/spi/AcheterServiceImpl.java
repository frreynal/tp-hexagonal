package app.metier.impl.spi;


import app.api.PatisserieBoutique;
import app.spi.AcheterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcheterServiceImpl implements AcheterService {


    @Autowired
    PatisserieBoutique patisserie;

    @Override
    public void achete(int quantite) {
        this.patisserie.vendTarteAuxFraisesChantilly(quantite);
    }
}
