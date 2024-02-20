import java.util.Scanner;
import motor3R.TresEnRaya;

public class InterfaceConsola {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        System.out.println("¡Bienvenido al juego del Tres en Raya!");

        while (!juego.tableroLleno() && !juego.hayGanador()) {
            juego.imprimirTablero();
            if (juego.getJugador() == 'X') {
                System.out.println("Tu turno (X):");
                turnoJugador(juego);
            } else {
                System.out.println("Turno de la CPU (O):");
                turnoMaquina(juego);
            }
        }

        juego.imprimirTablero();

        if (juego.hayGanador()) {
            if (juego.getJugador() == 'X') {
                System.out.println("¡Has ganado!");
            } else {
                System.out.println("¡Has perdido!");
            }
        } else {
            System.out.println("¡Empate! ¡El juego ha terminado!");
        }
    }

    public static void turnoJugador(TresEnRaya juego) {
        int fila, columna;
        do {

            System.out.print("Introduce la fila (0-2): ");
            fila = scanner.nextInt();
            System.out.print("Introduce la columna (0-2): ");
            columna = scanner.nextInt();
            if (!juego.movimientoValido(fila, columna)) {
                System.out.println("Ese valor está fuera de la matriz. Inténtalo de nuevo.");
            }
        } while (!juego.movimientoValido(fila, columna));
        juego.jugar(fila, columna);
    }

    public static void turnoMaquina(TresEnRaya juego) {
        juego.jugar(-1, -1);
    }

    public static void dificultadMaquina() {
        System.out.println("Selecciona la dificultad del juego:");
        System.out.println("1. Simple");
        System.out.println("2. Intermedio");
        System.out.println("3. Difícil");
        int dificultad =  scanner.nextInt();

        switch (dificultad) {
            case 1:
                juego.movimientoNivelFacil();
                break;
        
            default:
                break;
        }
    }
}
