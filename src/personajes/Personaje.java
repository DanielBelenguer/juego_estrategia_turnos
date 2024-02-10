package personajes;

public abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio,ejeFila, ejeColumna;

    protected Personaje (){}

    abstract public int getCoste();
    abstract public int getAtaque();
    abstract public  int getDefensa();
    abstract public int getVida();
    abstract public int setVida(int restaAtaque);
    abstract public int getRadio();
    abstract public int getEjeFila();
    abstract public void setEjeFila(int ejeFila);
    abstract public int getEjeColumna();
    abstract public void setEjeColumna(int ejeColumna);
    abstract public String getInfoMapa();
    public abstract void atacar (Personaje perso);
    public abstract void mover ();
    public abstract void curar ();
    public abstract String toString ();

}
