package personajes;

public class Caballero extends Personaje{
    public Caballero(int ejeFila, int ejeColumna) {
        coste = 25;ataque = 20;defensa = 20;vida = 25;radio = 2;this.ejeFila=ejeFila;this.ejeColumna=ejeColumna;
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
        return "C" + "(" + vida + ")";
    }
}
