package personajes;

import java.awt.*;

public class Lancero extends Personaje{
    Color color;
    public Lancero(Color color) {
        super();
        coste = 5;ataque = 5;defensa = 5;vida = 10;radio = 2;vidaMaxima=10;this.color=color;
    }
    @Override
    public String toString () {
        return "Lancero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
    public int getCoste() { return coste; }
    public int getAtaque(){ return ataque; }
    public int getDefensa(){ return defensa; }
    public int getVida(){ return vida; }
    @Override
    public void setVida(int restaAtaque) {
        if (restaAtaque <= 0){
            System.out.println("La fuerza del ataque fue demasiado baja y falla el ataque " + restaAtaque);
        }else {
            System.out.println("Un ataque muy efectivo, le quita " + restaAtaque);
            this.vida-=restaAtaque;
        }
    }
    public void setCura (int curacion){
        if ((curacion+vida) > vidaMaxima ){
            vida = vidaMaxima;
        }else {
            vida +=curacion;
        }
    }
    public int getRadio(){
        return radio;
    }
    public Color getColor() {
        return color;
    }
    public int getVidaMaxima(){return vidaMaxima;}
    @Override
    public  String getInfoPerso() {
        if (color.equals(Color.AZUL)) {

            if (vida < 10)
                return BLUE+"C" + "(" + " " + vida + ")" + RESET_COLOR;
            else
                return BLUE+"C" + "(" + vida + ")"+RESET_COLOR;
        }else {
            if (vida < 10)
                return RED+"C" + "(" + " " + vida + ")" +RESET_COLOR;
            else
                return RED+"C" + "(" + vida + ")"+RESET_COLOR;
        }
    }
}
