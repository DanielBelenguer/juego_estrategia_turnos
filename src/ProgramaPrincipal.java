import personajes.*;
import tablero.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        // creamos el tablero
        Tablero mapa = new Tablero();
        Ejercito ejerAzul = new Ejercito();
        Ejercito ejerRojo = new Ejercito();

        ejerAzul.crearEjercito();
        //ejerRojo.crearEjercito();

        mapa.mostrarTablero();



    }
     static public void menuAccion(Personaje[] ejer,int opt,int perso){
        switch (opt){
            case 1:
                ejer[perso].mover();
                break;
            case 2:
                ejer[perso].atacar();
                break;
            case 3:
                ejer[perso].curar();
                break;
            default:
        }
    }
}
