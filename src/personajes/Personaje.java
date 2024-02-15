package personajes;

import java.awt.*;
public abstract class Personaje {
    //C O L O R E S
    public static final String RED = "\u001B[31m";

    public static final String BLUE = "\u001B[34m";

    public static final String RESET_COLOR = "\u001B[0m";

    //------------------------------------------------------------------------------
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
