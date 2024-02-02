package personajes;

public class Personaje {
    protected int coste, ataque, defensa, vida, radio;

    protected Personaje (){

    }
    public void atacar (){

    }
    public void mover (){

    }
    public void curar (){

    }
    public void info () {
        System.out.println(coste);
        System.out.println(ataque);
        System.out.println(defensa);
        System.out.println(vida);
        System.out.println(radio);
    }

    public int getCoste() {
        return coste;
    }
}
