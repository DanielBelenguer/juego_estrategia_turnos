package personajes;

public class Soldado extends Personaje {
    Color color;

    public Soldado(Color color) {
        coste = 10;ataque = 10;defensa = 10;vida = 10;radio = 1;this.color=color;
    }
    @Override
    public String toString () {
        return "Soldado\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
    }
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
    public Color getColor() {
        return color;
    }
    @Override
    public  String getInfoPerso(){
//        if (color.equals(color)){
//            return "AZUL";
//        }else {
//            return "ROJO";
//        }


        return "S" + "(" + vida + ")" + color;
    }
}
