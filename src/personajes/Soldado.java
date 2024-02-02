package personajes;

public class Soldado extends Personaje {
    public Soldado() {
        super();
        coste = 10;
        ataque = 10;
        defensa = 10;
        vida = 10;
        radio = 1;
    }

    @Override
    public void info () {
        System.out.println("Soldado");
        System.out.println(coste);
        System.out.println(ataque);
        System.out.println(defensa);
        System.out.println(vida);
        System.out.println(radio);
    }
}
