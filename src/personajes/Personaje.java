package personajes;

import java.awt.*;
public abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio,vidaMaxima;
    protected Color color;
    public Personaje (){}
    abstract public int getCoste();
    abstract public int getAtaque();
    abstract public  int getDefensa();
    abstract public int getVida();
    abstract public void setVida(int restaAtaque);
    abstract public void setCura (int curacion);
    abstract public int getRadio();
    abstract public Color getColor();
    abstract public int getVidaMaxima();
    abstract public String getInfoPerso();
    public abstract String toString ();

}
