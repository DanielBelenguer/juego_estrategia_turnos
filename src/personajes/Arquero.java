package personajes;

public class Arquero extends Personaje {
    public Arquero() {
        coste = 15; ataque = 10;defensa = 5;vida = 10;radio = 3;
    }
    @Override
    public String toString () {
        return "Arquero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    @Override
    protected void atacar(){}
    @Override
    protected void mover(){}
    @Override
    protected void curar(){}

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
    @Override
    public  String  getInfoMapa(){
        return "S" + "(" + vida + ")";
    }

}
