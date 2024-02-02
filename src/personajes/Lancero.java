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
    public void info () {
        System.out.println("Lancero");
        System.out.println(coste);
        System.out.println(ataque);
        System.out.println(defensa);
        System.out.println(vida);
        System.out.println(radio);
    }
}
