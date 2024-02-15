import personajes.*;
import java.lang.*;
import java.util.Scanner;

public class ProgramaPrincipal {

    /*
    * El resultado de las acciones realizadas se indicará por pantalla.
    * Realizar pruebas generales
    * Revisar SYSOS (Formatearlo correctamente)
    * Añadir enter para continuar (Donde se necesite)
    * Revisar ortografía
    * Revisar enunciado de la práctica
    * Si tenemos tiempo documentación (Entornos)*/
    static int crearEjercito (int opt, Color color,int ejeFila,int ejeColumna, Tablero tablero){
        //Variables
        int minFila=0,maxFila=7,minColumna=10,maxColumna=236;
        if (color.equals(Color.AZUL)){
            minColumna = 6;
            maxColumna = 7;
        } else if (color.equals(Color.ROJO)) {
            minColumna = 0;
            maxColumna = 1;
        }
        switch (opt){
            case 1:
                //Comprobación de columna introducida es correcta
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje sol = new Soldado(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,sol);
                    System.out.println("personaje insertado");
                    return sol.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 2:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje cab = new Caballero(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,cab);
                    System.out.println("personaje insertado");
                    return cab.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 3:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje arq = new Arquero(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,arq);
                    System.out.println("personaje insertado");
                    return arq.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 4:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje lan = new Lancero(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,lan);
                    System.out.println("personaje insertado");
                    return lan.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            default:
                System.out.println("Elija una opcion válida");
        }
        return 0;
    }
    static void enterContinuar () {
            Scanner lector = new Scanner(System.in);
            System.out.println();
            System.out.println("Presiona ENTER para continuar...");
            lector.nextLine();
        }
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Tablero tablero = new Tablero();

        //Variables
        int opt,ejeFila,ejeColumna,sumacoste,vidaAzul=0,vidaRojo=0,turno=1;
        boolean finjuego=true;
        Color color;
        //--------------------------

        while (finjuego){
            System.out.println("TURNO ACTUAL: "+turno+"\n"+"VIDA EQUIPO "+Personaje.BLUE+"AZUL: "+Personaje.RESET_COLOR+vidaAzul+"\n"+"VIDA EQUIPO "+Personaje.RED+"ROJO "+Personaje.RESET_COLOR+vidaRojo);

            enterContinuar();

            if (turno == 1){
                sumacoste=0;
                while (sumacoste < 50){
                    System.out.println("Vamos a crear el ejercito "+Personaje.BLUE+"Azul "+Personaje.RESET_COLOR+"\nTienes un total de 50 puntos para gastar. \n¿Que quieres crear? \n 1 - Soldado (10)\n 2 - Caballero (25)\n 3 - Arquero (15)\n 4 - Lancero (5)");
                    opt = lector.nextInt();
                    if (opt >= 1 && opt <= 4) {
                        color = Color.AZUL;
                        tablero.mostrarTablero();
                        System.out.println("Elija la fila donde quiera colocarlo: ");
                        ejeFila = lector.nextInt();
                        System.out.println("Elija la columna donde desea colocarlo: ");
                        ejeColumna = lector.nextInt();
                        sumacoste = sumacoste + crearEjercito(opt ,color ,ejeFila ,ejeColumna ,tablero);
                        if (tablero.tablero[ejeFila][ejeColumna] != null ){
                            vidaAzul +=1;
                        }
                        tablero.mostrarTablero();
                        System.out.println("Llevas gastado "+sumacoste+" de un total de 50 puntos.");
                        enterContinuar();
                    }else {
                        System.out.println("Número no válido 1-4");
                    }
                }
                turno+=1;
            } else if (turno == 2) {
                sumacoste=0;
                while (sumacoste < 50){
                    System.out.println("Vamos a crear el ejercito "+Personaje.RED+"Rojo "+Personaje.RESET_COLOR+"\n Tienes un total de 50 puntos para gastar \n¿Que quieres crear? \n 1 - Soldado (10)\n 2 - Caballero (25)\n 3 - Arquero (15)\n 4 - Lancero (5)");
                    opt = lector.nextInt();
                    color = Color.ROJO;
                    tablero.mostrarTablero();
                    System.out.println("Elija la fila donde quiera colocarlo: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija la columna donde desea colocarlo: ");
                    ejeColumna = lector.nextInt();
                    sumacoste = sumacoste + crearEjercito(opt ,color ,ejeFila ,ejeColumna ,tablero);
                    if (tablero.tablero[ejeFila][ejeColumna] != null ){
                        vidaRojo +=1;
                    }
                    tablero.mostrarTablero();
                    System.out.println("Llevas gastado "+sumacoste+" de un total de 50 puntos.");
                    enterContinuar();
                }
                turno+=1;
            }else {
                if (turno % 2 != 0){
                    //Turno AZUL
                    System.out.println("Turno de equipo "+Personaje.BLUE+"Azul"+Personaje.RESET_COLOR+"\n Elija una acción: \n 1 - Mover \n 2 - Atacar \n 3 - Curar \n ----------------------------");
                    opt = lector.nextInt();
                    System.out.println("Que personaje quiere realizar la acción: ");
                    switch (opt) {
                        case 1:
                            tablero.mostrarTablero();
                            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
                            int filaOrigen = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            int columnaOrigen = lector.nextInt();

                            boolean existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
                            if (existePersonaje) {
                                if (tablero.tablero[filaOrigen][columnaOrigen].getColor().equals(Color.AZUL)) {
                                    System.out.println("Indique las nuevas coordenadas del personaje, introduce fila");
                                    int filaNueva = lector.nextInt();
                                    System.out.println("Ahora indique la columna");
                                    int columnaNueva = lector.nextInt();
                                    if (filaNueva >= 0 && filaNueva <= 7 && columnaNueva >= 0 && columnaNueva <= 7){
                                        if (tablero.tablero[filaNueva][columnaNueva] == null){
                                            tablero.mover(filaOrigen,columnaOrigen,filaNueva,columnaNueva);
                                            System.out.println("El personaje se ha movido de forma exitosa");
                                            turno +=1;
                                        }else {
                                            System.out.println("No se puede realizar el movimiento, esa casilla está ocupada");
                                        }
                                    }else {
                                        System.out.println("Casilla elegida fuera del tablero");
                                    }
                                }else{
                                    System.out.println("Elegiste un personaje contrario");
                                }

                            }else {
                                System.out.println("En esta casilla no existe ningún personaje");
                            }
                            tablero.mostrarTablero();
                            break;
                        case 2:
                            tablero.mostrarTablero();
                            int atacaFila, atacaColumna;
                            System.out.println("Indique las coordenadas del personaje que va a atacar\nintroduce la fila: ");
                            filaOrigen = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            columnaOrigen = lector.nextInt();
                             existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
                            if (existePersonaje) {
                                if (tablero.tablero[filaOrigen][columnaOrigen].getColor().equals(Color.AZUL)){
                                    System.out.println("A que personaje quieres atacar");
                                    System.out.println("Introduzca Fila: ");
                                    atacaFila = lector.nextInt();
                                    System.out.println("Introduzca Columna: ");
                                    atacaColumna = lector.nextInt();
                                    existePersonaje = tablero.buscaPerso(atacaFila,atacaColumna);
                                    if (existePersonaje){
                                        if (tablero.tablero[atacaFila][atacaColumna].getColor().equals(Color.ROJO)){
                                            //Vamos a comprobar que el rango sea válido tanto en las columnas como las filas
                                            if (tablero.compruebaRangoColumna(columnaOrigen, atacaColumna) <= tablero.tablero[filaOrigen][columnaOrigen].getRadio() && tablero.compruebaRangoFila(filaOrigen,atacaFila) <= tablero.tablero[filaOrigen][columnaOrigen].getRadio()) {
                                                tablero.atacar(filaOrigen,columnaOrigen,atacaFila,atacaColumna);
                                                System.out.println("El personaje ha realizado su ataque");
                                                turno +=1;
                                            }else {
                                                System.out.println("No estás en rango de ataque, asegúrese de estarlo");
                                            }
                                            if (tablero.tablero[atacaFila][atacaColumna].getVida() <= 0){
                                                tablero.tablero[atacaFila][atacaColumna] = null;
                                                vidaRojo-=1;
                                            }

                                        }else {
                                            System.out.println("No puedes atacar a tu equipo Ratón!!!");
                                        }
                                    }else {
                                        System.out.println("La casilla elegida está vacía");
                                    }
                                }else {
                                    System.out.println("El personaje elegido no es de tu equipo");
                                }
                            }else {
                                System.out.println("No existe personaje");
                            }
                            break;
                        case 3:
                            int filaCura,columnaCura;
                            System.out.println("Indique las coordenadas del personaje para Curar\nintroduce la fila: ");
                            filaCura = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            columnaCura = lector.nextInt();
                            existePersonaje = tablero.buscaPerso(filaCura,columnaCura);
                            if (existePersonaje) {
                                if (tablero.tablero[filaCura][columnaCura].getColor().equals(Color.AZUL)){
                                    tablero.curar(filaCura,columnaCura);
                                    System.out.println("El personaje ha realizado la curación");
                                    turno+=1;
                                }else {
                                    System.out.println("El personaje elegido no es de tu equipo");
                                }
                            }else {
                                System.out.println("No existe personaje");
                            }
                            break;
                        }
                    System.out.println("Turno finalizado");
                    if (vidaRojo == 0){
                        System.out.println("Se acabó el juego, Ganan los Azules");
                        finjuego = false;
                    }
                }else {
                    // Turno ROJO
                    System.out.println("Turno de equipo "+Personaje.RED+"Rojo"+Personaje.RESET_COLOR+"\n Elija una acción: \n 1 - Mover \n 2 - Atacar \n 3 - Curar \n ----------------------------");
                    opt = lector.nextInt();
                    System.out.println("Que personaje quiere realizar la acción: ");
                    switch (opt) {
                        case 1:
                            tablero.mostrarTablero();
                            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
                            int filaOrigen = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            int columnaOrigen = lector.nextInt();

                                boolean existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
                                if (existePersonaje) {
                                    if (tablero.tablero[filaOrigen][columnaOrigen].getColor().equals(Color.ROJO)) {
                                        System.out.println("Indique las nuevas coordenadas del personaje, introduce fila");
                                        int filaNueva = lector.nextInt();
                                        System.out.println("Ahora indique la columna");
                                        int columnaNueva = lector.nextInt();
                                        if (filaNueva >= 0 && filaNueva <= 7 && columnaNueva >= 0 && columnaNueva <= 7){
                                            if (tablero.tablero[filaNueva][columnaNueva] == null){
                                                tablero.mover(filaOrigen,columnaOrigen,filaNueva,columnaNueva);
                                                System.out.println("El personaje se ha movido de forma exitosa");
                                                turno +=1;
                                            }else {
                                                System.out.println("No se puede realizar el movimiento, esa casilla está ocupada");
                                            }
                                        }else {
                                            System.out.println("Casilla elegida fuera del tablero");
                                        }
                                    }else{
                                        System.out.println("Elegiste un personaje contrario");
                                    }

                                }else {
                                    System.out.println("En esta casilla no existe ningún personaje");
                                }
                            tablero.mostrarTablero();
                            break;
                        case 2:
                            tablero.mostrarTablero();
                            int atacaFila, atacaColumna;
                            System.out.println("Indique las coordenadas del personaje que va a atacar\nintroduce la fila: ");
                            filaOrigen = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            columnaOrigen = lector.nextInt();
                             existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
                            if (existePersonaje) {
                                if (tablero.tablero[filaOrigen][columnaOrigen].getColor().equals(Color.ROJO)){
                                    System.out.println("A que personaje quieres atacar");
                                    System.out.println("Introduzca Fila: ");
                                    atacaFila = lector.nextInt();
                                    System.out.println("Introduzca Columna: ");
                                    atacaColumna = lector.nextInt();
                                    existePersonaje = tablero.buscaPerso(atacaFila,atacaColumna);
                                    if (existePersonaje){
                                        if (tablero.tablero[atacaFila][atacaColumna].getColor().equals(Color.AZUL)){
                                            if (tablero.compruebaRangoColumna(columnaOrigen, atacaColumna) <= tablero.tablero[filaOrigen][columnaOrigen].getRadio() && tablero.compruebaRangoFila(filaOrigen,atacaFila) <= tablero.tablero[filaOrigen][columnaOrigen].getRadio()) {
                                                tablero.atacar(filaOrigen,columnaOrigen,atacaFila,atacaColumna);
                                                System.out.println("El personaje ha realizado su ataque");
                                                turno +=1;
                                            }else {
                                                System.out.println("No estás en rango de ataque, asegúrese de estarlo");
                                            }
                                            if (tablero.tablero[atacaFila][atacaColumna].getVida() <= 0){
                                                tablero.tablero[atacaFila][atacaColumna] = null;
                                                vidaAzul-=1;
                                            }
                                            turno +=1;
                                        }else {
                                            System.out.println("No puedes atacar a tu equipo Ratón!!!");
                                        }
                                    }else {
                                        System.out.println("La casilla elegida está vacía");
                                    }
                                }else {
                                    System.out.println("El personaje elegido no es de tu equipo");
                                }
                            }else {
                                System.out.println("No existe personaje");
                            }
                            break;
                        case 3:
                            int filaCura,columnaCura;
                            System.out.println("Indique las coordenadas del personaje para Curar\nintroduce la fila: ");
                            filaCura = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            columnaCura = lector.nextInt();
                            existePersonaje = tablero.buscaPerso(filaCura,columnaCura);
                            if (existePersonaje) {
                                if (tablero.tablero[filaCura][columnaCura].getColor().equals(Color.ROJO)){
                                    tablero.curar(filaCura,columnaCura);
                                    System.out.println("El personaje ha realizado la curación");
                                    turno+=1;
                                }else {
                                    System.out.println("El personaje elegido no es de tu equipo");
                                }
                            }else {
                                System.out.println("No existe personaje");
                            }
                            break;
                    }
                    System.out.println("Turno finalizado");
                    if (vidaAzul == 0){
                        System.out.println("Se acabó el juego, Ganan los Rojos");
                        finjuego = false;
                    }
                }
            }
        }
    }
}