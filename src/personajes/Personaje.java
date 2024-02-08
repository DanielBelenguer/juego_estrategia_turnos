package personajes;

public abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio;

    protected Personaje (){}

    abstract public int getCoste();
    abstract public int getAtaque();
    abstract public  int getDefensa();
    abstract public int getVida();
    abstract public int getRadio();
    abstract public String getInfoMapa();
    public abstract void atacar ();
    public abstract void mover ();
    public abstract void curar ();
    public abstract String toString ();

}
