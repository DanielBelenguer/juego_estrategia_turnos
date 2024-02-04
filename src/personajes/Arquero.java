package personajes;

public class Arquero extends Personaje {
    public Arquero() {
        coste = 15; ataque = 10;defensa = 5;vida = 10;radio = 3;
    }
    @Override
    public String toString () {
        return "\nEl Arquero tiene\nCoste: " + coste +"\nAtaque: "+ ataque +
                "\nDefensa: " + defensa + "\nVida: " + vida + "\nRadio: " + radio;
    }
    @Override
    protected void atacar(){

    }
    @Override
    protected void mover(){

    }
    @Override
    protected void curar(){

    }

    public int getCoste() {
        return coste;
    }
    public int getAtaque(){
        return ataque;
    }
    public int getDefensa(){
        return defensa;
    }
    public int getVida(){
        return vida;
    }
    public int getRadio(){
        return radio;
    }

}
