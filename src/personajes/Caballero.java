package personajes;

public class Caballero extends Personaje{
    public Caballero() {
        coste = 25;ataque = 20;defensa = 20;vida = 25;radio = 2;
    }
    @Override
    public String toString () {
        return "\nEl personaje tiene\nCoste: " + coste +"\nAtaque: "+ ataque +
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
