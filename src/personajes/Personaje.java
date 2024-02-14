package personajes;

import java.awt.*;

public abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio;
    Color color;

    Personaje (){}

    abstract public int getCoste();
    abstract public int getAtaque();
    abstract public  int getDefensa();
    abstract public int getVida();
    abstract public int setVida(int restaAtaque);
    abstract public int getRadio();
    abstract public String getInfoPerso();
    public abstract String toString ();

}
