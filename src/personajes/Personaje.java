package personajes;

public  abstract class Personaje {
    protected int coste, ataque, defensa, vida, radio;

    protected Personaje (){

    }
    public void atacar (){

    }
    public void mover (){

    }
    public void curar (){

    }
    @Override
    public abstract String toString ();

    public int getCoste() {
        return coste;
    }
}
