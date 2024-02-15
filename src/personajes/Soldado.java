package personajes;

public class Soldado extends Personaje {
    Color color;

    public Soldado(Color color) {
        coste = 10;ataque = 10;defensa = 10;vida = 10;radio = 1;vidaMaxima=10;this.color=color;
    }
    @Override
    public String toString () {
        return "Soldado\n - Ataque: " + ataque + "\n - Defensa: " + defensa + "\n - Vida: " + vida + "\n - Radio de ataque: " + radio;
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
    public  String getInfoPerso(){
//        if (color.equals(color)){
//            return "AZUL";
//        }else {
//            return "ROJO";
//        }
        return "S" + "(" + vida + ")";
    }
}
