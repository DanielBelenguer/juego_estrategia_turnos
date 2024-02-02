import personajes.*;
import tablero.Tablero;

import java.lang.*;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    int sumacoste=0,opt;

    //creamos el tablero
        Tablero mapa = new Tablero();
        Personaje p1 = new Soldado();
        System.out.println(p1.toString());
        /*
    do {
        System.out.println("""
                Que personaje quieres cear:
                1 - Soldado
                2 - Lancero
                3 - Caballero
                4 - Arquero
                """);
        opt= lector.nextInt();

        switch (opt) {
            case 1:
                Personaje personaje = new Soldado();
                //mapa.setpersonajestablero();
                sumacoste+=personaje.getCoste();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;

        }

    }while (sumacoste==50);
*/





       /* Tablero tablero = new Tablero();
        tablero.mostrarTablero();*/


        /*Personaje sol1 = new Soldado();
        sol1.info();
        System.out.println("_____________________");
        Personaje lan1 = new Lancero();
        lan1.info();
        System.out.println("_____________________");
        Personaje cab1 = new Caballero();
        cab1.info();
        System.out.println("_____________________");
        Personaje arq1 = new Arquero();
        arq1.info();
        System.out.println("_____________________");*/
    }
}
