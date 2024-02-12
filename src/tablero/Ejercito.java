package tablero;

import personajes.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercito {

    //Declaracion de variables
    Personaje[] ejercito = new Personaje[1];

    public Personaje getPerso (){
        return ejercito[0];
    }


    public Personaje[] crearEjercito (String color, Tablero tablero){
        Scanner lector = new Scanner(System.in);
        int sumacoste=0,ejeFila,ejeColumna;
        int minFila=0,maxFila=7,minColumna=10,maxColumna=236;
        if (color.equals("azul")){
            minColumna = 6;
            maxColumna = 7;
        } else if (color.equals("rojo")) {
            minColumna = 0;
            maxColumna = 1;
        }

        while (sumacoste < 50) {
            System.out.println("Tienes un total de 50 puntos y llevas gastados:" + " " + sumacoste + " " +
                    "\nElige personaje para crear:" + "\n1 - Soldado 10 puntos\n2 - Caballero  25 puntos\n3 - Arquero 15 puntos\n4 - Lancero 5 puntos"
            );
            int opt= lector.nextInt();
            switch (opt){
                case 1:
                    System.out.println("Elija la fila donde quiera colocarlo: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija la columna donde desea colocarlo: ");
                    ejeColumna = lector.nextInt();

                    //Comprobación de columna introducida es correcta
                    if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                        Personaje sol = new Soldado();
                        sumacoste+=sol.getCoste();
                        ejercito[ejercito.length-1] = sol;
                        ejercito = Arrays.copyOf(ejercito,ejercito.length+1);
                        tablero.tablero[ejeFila][ejeColumna]=sol;
                        System.out.println("personaje insertado");
                    }else {
                        System.out.println("Elija entra la columna 6 o 7 ");
                    }
                break;

                case 2:
                    System.out.println("Elija la fila donde quiera colocarlo: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija la columna donde desea colocarlo: ");
                    ejeColumna = lector.nextInt();

                    if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                        Personaje cab = new Caballero();
                        sumacoste+=cab.getCoste();
                        ejercito[ejercito.length-1] = cab;
                        ejercito = Arrays.copyOf(ejercito,ejercito.length+1);
                        tablero.tablero[ejeFila][ejeColumna]=cab;
                    }
                break;

                case 3:
                    System.out.println("Elija la fila donde quiera colocarlo: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija la columna donde desea colocarlo: ");
                    ejeColumna = lector.nextInt();

                    if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                        Personaje arq = new Arquero();
                        sumacoste+=arq.getCoste();
                        ejercito[ejercito.length-1] = arq;
                        ejercito = Arrays.copyOf(ejercito,ejercito.length+1);
                    }
                break;

                case 4:
                    System.out.println("Elija la fila donde quiera colocarlo: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija la columna donde desea colocarlo: ");
                    ejeColumna = lector.nextInt();

                    if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                        Personaje lan = new Lancero();
                        sumacoste+=lan.getCoste();
                        ejercito[ejercito.length-1] = lan;
                        ejercito = Arrays.copyOf(ejercito,ejercito.length+1);

                    }
                break;

                default:
                    System.out.println("Introduce opción válida.");
            }
        }
        ejercito = Arrays.copyOf(ejercito,ejercito.length-1);
        return ejercito;
    }
}