package personajes;

public class Arquero extends Personaje {
    public Arquero() {
        super();
        coste = 5;
        ataque = 5;
        defensa = 5;
        vida = 10;
        radio = 2;
    }

    @Override
    public String toString () {
        return "\nEl personaje tiene\nCoste: " + coste +"\nAtaque: "+ ataque +
                "\nDefensa: " + defensa + "\nVida: " + vida + "\nRadio: " + radio;
    }
}
