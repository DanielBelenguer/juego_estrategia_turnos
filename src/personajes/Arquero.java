package personajes;

public class Arquero extends Personaje {
    public Arquero(int ejeFila, int ejeColumna) {
        coste = 15; ataque = 10;defensa = 5;vida = 10;radio = 3;this.ejeFila=ejeFila;this.ejeColumna=ejeColumna;
    }
    @Override
    public String toString () {
        return "Arquero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    @Override
    public void atacar(){}
    @Override
    public void mover(){}
    @Override
    public void curar(){}

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
    public  String  getInfoMapa(){
        return "A" + "(" + vida + ")";
    }

}
