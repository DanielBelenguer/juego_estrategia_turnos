package tablero;

import personajes.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercito {

    //Declaracion de variables
    Personaje[] ejercito = new Personaje[1];



    public void crearEjercito (){
        Scanner lector = new Scanner(System.in);
        int sumacoste=0,contador=0,ejeFila,ejeColumna;
        while (sumacoste < 50) {
            System.out.println("Tienes un total de 50 puntos y llevas gastados:" + " " + sumacoste + " " +
                    "\nElige personaje para crear:" + "\n1 - Soldado 10 puntos\n2 - Caballero  25 puntos\n3 - Arquero 15 puntos\n4 - Lancero 5 puntos"
            );
            int opt= lector.nextInt();
            switch (opt){
                case 1:
                    System.out.println("Donde quieres colocar tu personaje: ");
                    System.out.println("Elija Fila: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija Columna: ");
                    ejeColumna = lector.nextInt();
                    Personaje sol = new Soldado(ejeFila,ejeColumna);

                    sumacoste+=sol.getCoste();
                    contador++;
                    break;
                case 2:
                    System.out.println("Donde quieres colocar tu personaje: ");
                    System.out.println("Elija Fila: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija Columna: ");
                    ejeColumna = lector.nextInt();
                    Personaje cab = new Caballero(ejeFila,ejeColumna);
                    sumacoste+=cab.getCoste();
                    contador++;
                    break;
                case 3:
                    System.out.println("Donde quieres colocar tu personaje: ");
                    System.out.println("Elija Fila: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija Columna: ");
                    ejeColumna = lector.nextInt();
                    Personaje arq = new Arquero(ejeFila,ejeColumna);
                    sumacoste+=arq.getCoste();
                    contador++;
                    break;
                case 4:
                    System.out.println("Donde quieres colocar tu personaje: ");
                    System.out.println("Elija Fila: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija Columna: ");
                    ejeColumna = lector.nextInt();
                    Personaje lan = new Lancero(ejeFila,ejeColumna);
                    sumacoste+=lan.getCoste();
                    contador++;
                    break;
                default:
                    System.out.println("Introduce opción válida.");
            }
            if (sumacoste < 50){
                //Crea una copia con longitud + 1 y la asigna a la variable array
                ejercito = Arrays.copyOf(ejercito,ejercito.length+1);
                ejercito[ejercito.length-1] = null;
            }
        }
    }
}
