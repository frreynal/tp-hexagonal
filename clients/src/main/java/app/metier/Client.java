package app.metier;

import listener.TimeListener;

public interface Client extends TimeListener {

    void acheter();

    @Override
    void tempsPasse(int i);

}
