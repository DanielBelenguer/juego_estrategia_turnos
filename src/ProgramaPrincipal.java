import personajes.*;
import java.lang.*;
import java.util.Scanner;

public class ProgramaPrincipal {
    /**
     * Método para crear un Ejército
     * @param opt Para elegir qué personaje quieres crear.
     * @param color Para guardar el color de cada personaje.
     * @param ejeFila Este número es para poder situar en el tablero el personaje.
     * @param ejeColumna Este número es para situar en el tablero el personaje.
     * @param tablero Pasamos el tablero para poder manejarlo desde este método.
     * @return Lo utilizamos para poder sumar el coste del personaje que creamos.
     * */
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
                    System.out.println("Personaje insertado");
                    return sol.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 2:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje cab = new Caballero(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,cab);
                    System.out.println("Personaje insertado");
                    return cab.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 3:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje arq = new Arquero(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,arq);
                    System.out.println("Personaje insertado");
                    return arq.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            case 4:
                if (ejeFila >= minFila && ejeFila <= maxFila && ejeColumna >= minColumna && ejeColumna <= maxColumna){
                    Personaje lan = new Lancero(color);
                    tablero.setPersoTablero(ejeFila,ejeColumna,lan);
                    System.out.println("Personaje insertado");
                    return lan.getCoste();
                }else {
                    System.out.println("Elija entre la columna" + minColumna + " " + maxColumna);
                }
                break;
            default:
                System.out.println("Elija una opción válida");
        }
        return 0;
    }
    /**
     * Función para parar el programa.
     * */
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
        boolean finjuego=true,existePersonaje;
        Color color;
        //--------------------------

        while (finjuego){
            System.out.println("TURNO ACTUAL: "+turno+"\n"+"VIDA EQUIPO "+Personaje.BLUE+"AZUL: "+Personaje.RESET_COLOR+vidaAzul+"\n"+"VIDA EQUIPO "+Personaje.RED+"ROJO "+Personaje.RESET_COLOR+vidaRojo);


            if (turno == 1 || turno == 2) {
                System.out.print("""
                    Soldado:                Caballero:              Arquero:                Lancero:
                    - Ataque: 10            - Ataque: 15            - Ataque: 10            - Ataque: 5
                    - Defensa: 10           - Defensa: 20           - Defensa: 5           - Defensa: 5
                    - Vida: 10              - Vida: 25              - Vida: 10              - Vida: 10
                    - Radio de ataque: 1    - Radio de ataque: 2    - Radio de ataque: 3    - Radio de ataque: 2
                    """);
                enterContinuar();
            }else {
                enterContinuar();
            }

            if (turno == 1){
                sumacoste=0;
                while (sumacoste < 50){
                    System.out.println("Vamos a crear el ejército "+Personaje.BLUE+"Azul "+Personaje.RESET_COLOR+"Tu ejército comenzará en las columnas 6 y 7"+"\n+Tienes un total de 50 puntos para gastar. \n¿Qué quieres crear? \n 1 - Soldado (10)\n 2 - Caballero (25)\n 3 - Arquero (15)\n 4 - Lancero (5)");
                    opt = lector.nextInt();
                    if (opt >= 1 && opt <= 4) {
                        color = Color.AZUL;
                        tablero.mostrarTablero();
                        System.out.println("Elija la fila donde quiera colocarlo: ");
                        ejeFila = lector.nextInt();
                        System.out.println("Elija la columna donde desea colocarlo: ");
                        ejeColumna = lector.nextInt();
                        if(tablero.tablero[ejeFila][ejeColumna] == null){
                            sumacoste = sumacoste + crearEjercito(opt ,color ,ejeFila ,ejeColumna ,tablero);
                            if (tablero.tablero[ejeFila][ejeColumna] != null ){
                                vidaAzul +=1;
                            }
                        }else {
                            System.out.println("Posición ocupada, elija otra vez");
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
                    System.out.println("Vamos a crear el ejército "+Personaje.RED+"Rojo "+Personaje.RESET_COLOR+"Tu ejército comenzará en las columnas 0 y 1"+"\n Tienes un total de 50 puntos para gastar \n¿Qué quieres crear? \n 1 - Soldado (10)\n 2 - Caballero (25)\n 3 - Arquero (15)\n 4 - Lancero (5)");
                    opt = lector.nextInt();
                    color = Color.ROJO;
                    tablero.mostrarTablero();
                    System.out.println("Elija la fila donde quiera colocarlo: ");
                    ejeFila = lector.nextInt();
                    System.out.println("Elija la columna donde desea colocarlo: ");
                    ejeColumna = lector.nextInt();
                    if(tablero.tablero[ejeFila][ejeColumna] == null){
                        sumacoste = sumacoste + crearEjercito(opt ,color ,ejeFila ,ejeColumna ,tablero);
                        if (tablero.tablero[ejeFila][ejeColumna] != null ){
                            vidaRojo +=1;
                        }
                    }else {
                        System.out.println("Posición ocupada, elija otra vez");
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
                    System.out.println("¿Qué personaje quiere realizar la acción?: ");
                    switch (opt) {
                        case 1:
                            tablero.mostrarTablero();
                            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
                            int filaOrigen = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            int columnaOrigen = lector.nextInt();
                            if (filaOrigen >= 0 && filaOrigen <= 7 && columnaOrigen >= 0 && columnaOrigen <= 7){
                                existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
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
                            }else {
                                System.out.println("Casilla elegida fuera del tablero");
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
                            if (filaOrigen >= 0 && filaOrigen <= 7 && columnaOrigen >= 0 && columnaOrigen <= 7){
                                existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
                                if (existePersonaje) {
                                    if (tablero.tablero[filaOrigen][columnaOrigen].getColor().equals(Color.AZUL)){
                                        System.out.println("¿A qué personaje quieres atacar?");
                                        System.out.println("Introduzca Fila: ");
                                        atacaFila = lector.nextInt();
                                        System.out.println("Introduzca Columna: ");
                                        atacaColumna = lector.nextInt();
                                        if (filaOrigen >= 0 && filaOrigen <= 7 && columnaOrigen >= 0 && columnaOrigen <= 7){
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
                                            System.out.println("Casilla elegida fuera del tablero");
                                        }
                                    }else {
                                        System.out.println("El personaje elegido no es de tu equipo");
                                    }
                                }else {
                                    System.out.println("No existe personaje");
                                }
                            }else {
                                System.out.println("Casilla elegida fuera del tablero");
                            }
                            break;
                        case 3:
                            int filaCura,columnaCura;
                            System.out.println("Indique las coordenadas del personaje para Curar\nintroduce la fila: ");
                            filaCura = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            columnaCura = lector.nextInt();
                            if (filaCura >= 0 && filaCura <= 7 && columnaCura >= 0 && columnaCura <= 7){
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
                            }else{
                                System.out.println("la posición elegida está fuera del tablero, elige una válida");
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
                    System.out.println("¿Qué personaje quiere realizar la acción? ");
                    switch (opt) {
                        case 1:
                            tablero.mostrarTablero();
                            System.out.println("Indique las coordenadas del personaje a mover, introduce la fila: ");
                            int filaOrigen = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            int columnaOrigen = lector.nextInt();
                            if (filaOrigen >= 0 && filaOrigen <= 7 && columnaOrigen >= 0 && columnaOrigen <= 7){
                                existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
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
                            }else {
                                System.out.println("Casilla elegida fuera del tablero");
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
                            if (filaOrigen >= 0 && filaOrigen <= 7 && columnaOrigen >= 0 && columnaOrigen <= 7){
                                existePersonaje = tablero.buscaPerso(filaOrigen,columnaOrigen);
                                if (existePersonaje) {
                                    if (tablero.tablero[filaOrigen][columnaOrigen].getColor().equals(Color.ROJO)){
                                        System.out.println("¿A qué personaje quieres atacar?");
                                        System.out.println("Introduzca Fila: ");
                                        atacaFila = lector.nextInt();
                                        System.out.println("Introduzca Columna: ");
                                        atacaColumna = lector.nextInt();
                                        if (filaOrigen >= 0 && filaOrigen <= 7 && columnaOrigen >= 0 && columnaOrigen <= 7){
                                            existePersonaje = tablero.buscaPerso(atacaFila,atacaColumna);
                                            if (existePersonaje){
                                                if (tablero.tablero[atacaFila][atacaColumna].getColor().equals(Color.AZUL)){
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
                                            System.out.println("Casilla elegida fuera del tablero");
                                        }
                                    }else {
                                        System.out.println("El personaje elegido no es de tu equipo");
                                    }
                                }else {
                                    System.out.println("No existe personaje");
                                }
                            }else {
                                System.out.println("Casilla elegida fuera del tablero");
                            }
                            break;
                        case 3:
                            int filaCura,columnaCura;
                            System.out.println("Indique las coordenadas del personaje para Curar\nintroduce la fila: ");
                            filaCura = lector.nextInt();
                            System.out.println("Ahora indique la columna: ");
                            columnaCura = lector.nextInt();
                            if (filaCura >= 0 && filaCura <= 7 && columnaCura >= 0 && columnaCura <= 7){
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
                            }else{
                                System.out.println("la posición elegida está fuera del tablero, elige una válida");
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