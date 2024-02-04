package personajes;

public class Soldado extends Personaje {
    public Soldado() {
        coste = 10;ataque = 10;defensa = 10;vida = 10;radio = 1;
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
