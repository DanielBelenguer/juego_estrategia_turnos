package personajes;

import java.util.Random;

public class Caballero extends Personaje{
    public Caballero(int ejeFila, int ejeColumna) {
        coste = 25;ataque = 20;defensa = 20;vida = 25;radio = 2;this.ejeFila=ejeFila;this.ejeColumna=ejeColumna;
    }
    @Override
    public String toString () {
        return "Caballero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    @Override
    public void atacar(Personaje perso){
        int randomDefensa , randomAtaque, resultAtaque;

        Random random = new Random();
        randomAtaque = random.nextInt(ataque); // Generamos un número random para el ataque de este personaje
        randomDefensa = random.nextInt(perso.getDefensa()); // Generamos otro random para la defensa del otro personaje
        resultAtaque = randomDefensa - randomAtaque;
        perso.setVida(resultAtaque);
    }
    @Override
    public void mover(int ejeFila, int ejeColumna){
        setEjeFila(ejeFila);
        setEjeColumna(ejeColumna);
    }
    @Override
    public void curar(){
        int curacion;
        Random random = new Random();
        curacion = random.nextInt(0,25);
        if (vida < 10){
            vida+=curacion;
        } else if (vida > 10) {
            vida = 10;
        }
        System.out.println("Tu personaje se curo" + curacion + "\n Ahora tiene un total de vida: " + vida);
    }
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
    @Override
    public int setVida(int restaAtaque) {
        if (restaAtaque <= 0){
            System.out.println("La fuerza del ataque fue demasiado baja y falla el ataque " + restaAtaque);
        }else {
            if (vida >= restaAtaque){
                System.out.println("Un ataque muy efectivo, le quita " + restaAtaque);
                return this.vida-=restaAtaque;
            }else {
                return 0;
            }
        }
        return 0;
    }
    public int getRadio(){
        return radio;
    }
    @Override
    public int getEjeFila() {
        return ejeFila;
    }
    @Override
    public void setEjeFila(int ejeFila) {
        if (ejeFila >= 0 && ejeFila <=7 ){
            this.ejeFila=ejeFila;
        }
    }
    @Override
    public int getEjeColumna() {
        return ejeColumna;
    }
    @Override
    public void setEjeColumna(int ejeColumna) {
        if (ejeColumna >= 0 && ejeColumna <=7 ){
            this.ejeColumna=ejeColumna;
        }
    }
    @Override
    public  String getInfoPerso(){
        return "C" + "(" + vida + ")";
    }
}
