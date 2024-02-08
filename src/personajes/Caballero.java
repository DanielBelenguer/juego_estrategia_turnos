package personajes;

public class Caballero extends Personaje{
    public Caballero() {
        coste = 25;ataque = 20;defensa = 20;vida = 25;radio = 2;
    }
    @Override
    public String toString () {
        return "Caballero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    @Override
    public void atacar(){}
    @Override
    public void mover(){}
    @Override
    public void curar(){}
    public int getCoste() { return coste;}
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
        return "C" + "(" + vida + ")";
    }
}
