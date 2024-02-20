package motor3R;
import java.util.Random;

public class TresEnRaya {
    private char[][] tablero;
    private char jugador;
    private char maquina;
    private boolean turnoJugador;
    private Random random;

    public TresEnRaya() {
        tablero = new char[3][3];
        jugador = 'X';
        maquina = 'O';
        turnoJugador = true;
        random = new Random();
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean movimientoValido(int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-';
    }

    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hayGanador() {
        return (tablero[0][0] != '-' && tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2])
                || (tablero[1][0] != '-' && tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2])
                || (tablero[2][0] != '-' && tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2])
                || (tablero[0][0] != '-' && tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0])
                || (tablero[0][1] != '-' && tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1])
                || (tablero[0][2] != '-' && tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2])
                || (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])
                || (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]);
    }

    public void jugar(int fila, int columna) {
        if (turnoJugador && movimientoValido(fila, columna)) {
            tablero[fila][columna] = jugador;
            turnoJugador = false;
        }

        if (!turnoJugador && !tableroLleno() && !hayGanador()) {
            turnoJugador = true;
        }
    }

    public void movimientoNivelFacil() {
        int fila, columna;
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!movimientoValido(fila, columna));
        tablero[fila][columna] = maquina;
    }

    public char getJugador() {
        return jugador;
    }

    public char getMaquina() {
        return maquina;
    }
}
