import personajes.*;
import tablero.Tablero;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;
public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        //Declaracion de variables
        int costeTotal=0,posicion=0,opt;
        //--------------------------------

        // Creacion de ejercito Azul
        Personaje [] ejerAzul = new Personaje[1];
        while (costeTotal < 50) {
            System.out.println("Selecciona personaje");
            opt = lector.nextInt();
            switch (opt) {
                case 1:
                    ejerAzul[posicion] = new Soldado();
                    costeTotal += ejerAzul[posicion].getCoste();
                    posicion++;
                    break;
                case 2:
                    ejerAzul[posicion] = new Caballero();
                    costeTotal += ejerAzul[posicion].getCoste();
                    posicion++;
                    break;
                case 3:
                    ejerAzul[posicion] = new Arquero();
                    costeTotal += ejerAzul[posicion].getCoste();
                    posicion++;
                    break;
                case 4:
                    ejerAzul[posicion] = new Lancero();
                    costeTotal += ejerAzul[posicion].getCoste();
                    posicion++;
                    break;
                default:
                    System.out.println("Introduce opcion valida.");
            }
            // if para aumentar la array ejercito azul
            if (costeTotal < 50) {
                ejerAzul = Arrays.copyOf(ejerAzul, ejerAzul.length + 1);
                ejerAzul[ejerAzul.length - 1] = null;
            }
        }
        System.out.println("Ahora a crear el ejercito Rojo");

            // Creacion ejercito Rojo
            Personaje[] ejerRojo = new Personaje[1];
            // Reiniciamos las variables
            costeTotal = 0;
            posicion = 0;
            //--------------------------
            while (costeTotal < 50){
                System.out.println("Selecciona personaje");
                opt = lector.nextInt();
                switch (opt) {
                    case 1:
                        ejerRojo[posicion] = new Soldado();
                        costeTotal += ejerRojo[posicion].getCoste();
                        posicion++;
                        break;
                    case 2:
                        ejerRojo[posicion] = new Caballero();
                        costeTotal += ejerRojo[posicion].getCoste();
                        posicion++;
                        break;
                    case 3:
                        ejerRojo[posicion] = new Arquero();
                        costeTotal += ejerRojo[posicion].getCoste();
                        posicion++;
                        break;
                   case 4:
                       ejerRojo[posicion] = new Lancero();
                       costeTotal += ejerRojo[posicion].getCoste();
                       posicion++;
                       break;
                   default:
                       System.out.println("Introduce opcion valida.");
               }
               // if para aumentar la array ejercito rojo
               if (costeTotal < 50) {
                   ejerRojo = Arrays.copyOf(ejerRojo, ejerRojo.length + 1);
                   ejerRojo[ejerRojo.length - 1] = null;
               }
           }
           // Continua programa.
            for (Personaje perso : ejerAzul){
                System.out.println(perso);
            }
            for (Personaje perso : ejerRojo){
                System.out.println(perso);
            }

       }
   }