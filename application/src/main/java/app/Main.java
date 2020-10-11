package app;

import app.metier.Client;
import listener.TimeListener;
import app.metier.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import app.api.Marchand;

import javax.swing.event.EventListenerList;


@SpringBootApplication
//@ContextConfiguration(classes = {ConfigurationMain.class})
public class Main implements CommandLineRunner {


    @Autowired
    private Ville ville;

    @Autowired
    @Qualifier("metro")
    public Marchand metro;

    @Autowired
    @Qualifier("amazone")
    public Marchand amazon;

    @Autowired
    @Qualifier("milka")
    public Marchand milka;

    @Autowired
    public Client vikings;

    // un seul objet pour tous les types d'écouteurs
    private final EventListenerList listeners = new EventListenerList();


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);


    }

    @Override
    public void run(String... strings) throws Exception {
        listeners.add(TimeListener.class, ville);
        listeners.add(TimeListener.class, metro);
        listeners.add(TimeListener.class, amazon);
        listeners.add(TimeListener.class, milka);
        listeners.add(TimeListener.class, vikings);
        int nbJours = 300;
        for (int i = 0; i < nbJours; i++) {
            System.out.printf("%n%n =========================== JOUR %d/%d ==============================%n", i, nbJours);
            TimeListener[] listenersArray = this.listeners.getListeners(TimeListener.class);
            for (TimeListener timeListener : listenersArray) {
                timeListener.tempsPasse(i);
            }
            if (ville.isAcheteDora()) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!   GAGNE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.printf("!!!!!!!!!!!!!!!!!!!!!!!!!!!  Statue DORA érigée en %d  jours !!!!!!!!!!!!!!!!!!%n", i);
                break;
            }
        }

    }

}
