package personajes;

public class Soldado extends Personaje {
    public Soldado() {
        coste = 10;
        ataque = 10;
        defensa = 10;
        vida = 10;
        radio = 1;
    }

    @Override
    public int getCoste() {
        return this.coste;
    }
    public int getAtaque (){
        return this.ataque;
    }

    @Override
    public String toString () {
        return "\nEl personaje tiene\nCoste: " + coste +"\nAtaque: "+ ataque +
                "\nDefensa: " + defensa + "\nVida: " + vida + "\nRadio: " + radio;
    }
}
