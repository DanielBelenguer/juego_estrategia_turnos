package personajes;

public class Lancero extends Personaje{
    public Lancero() {
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
