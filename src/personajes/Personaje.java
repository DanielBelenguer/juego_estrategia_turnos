package personajes;

public abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio;

    protected Personaje (){}
    protected abstract void atacar ();
    protected abstract void mover ();
    protected abstract void curar ();
    public abstract String toString ();

}
