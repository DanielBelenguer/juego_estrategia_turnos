package personajes;

import tablero.Tablero;

public abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio;

    protected Personaje (){}

    abstract public int getCoste();
    abstract public int getAtaque();
    abstract public  int getDefensa();
    abstract public int getVida();
    abstract public int setVida(int restaAtaque);
    abstract public int getRadio();
    abstract public String getInfoPerso();
    public abstract void atacar (Tablero tablero);
    public abstract void mover (Personaje[][] posiciones);
    public abstract void curar ();
    public abstract String toString ();

}
