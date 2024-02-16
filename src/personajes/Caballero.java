package personajes;

import java.awt.*;

public class Caballero extends Personaje{

    Color color;
    /**
     * Constructor de la clase Caballero, tiene atributos solo para esta clase (coste,ataque,defensa,vida,radio,vidaMaxima).
     * @param color Trae el Color para guardarlo.
     * */
    public Caballero(Color color) {
        coste = 25;ataque = 15;defensa = 20;vida = 25;radio = 2;vidaMaxima=25;this.color=color;
    }
    @Override
    public String toString () {
        return "Caballero\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }

    public int getCoste() { return coste; }
    public int getAtaque(){ return ataque; }
    public int getDefensa(){ return defensa; }
    public int getVida(){ return vida; }
    /**
     * Funcion para setear la vida del personaje
     * @param restaAtaque Esta es para poder restar la vida del personaje.
     * */
    @Override
    public void setVida(int restaAtaque) {
        if (restaAtaque <= 0){
            System.out.println("La fuerza del ataque fue demasiado baja y falla el ataque " + restaAtaque);
        }else {
            System.out.println("Un ataque muy efectivo, le quita " + restaAtaque);
            this.vida-=restaAtaque;
        }
    }
    /**
     * Método para curar el personaje
     * @param curacion Número entero para curar el personaje.
     * */
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
    /**
     * Metodo para mostrar en el tablero el personaje y la vida
     * @return Retornamos un String para mostrar en el tablero.
     * Utilizamos constantes BLUE y RED para pintar de color en el tablero.
     * */
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
