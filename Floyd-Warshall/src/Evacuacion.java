import java.util.Arrays;

public class Evacuacion {
    public static void main(String[] args) {
        int[][] matrizAdyacencia = {
                {0, 5, 2, 0, 0},
                {3, 0, 0, 4, 0},
                {0, 1, 0, 2, 3},
                {0, 0, 0, 0, 1},
                {0, 9, 0, 5, 0}
        };
        int[][] rutasOptimas = aplicarFloydWarshall(matrizAdyacencia);

        System.out.println("Matriz de Distancias:");
        imprimirMatriz(rutasOptimas);
        System.out.println("\nDistancia más corta desde la Ubicación 1:");
        for (int i = 0; i < rutasOptimas.length; i++) {
            System.out.println("Hacia la Ubicación " + (i + 1) + ": " + rutasOptimas[0][i]);
        }
    }

    private static int[][] aplicarFloydWarshall(int[][] matrizAdyacencia) {
        int n = matrizAdyacencia.length;
        int[][] distancias = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distancias[i][j] = 0;
                } else if (matrizAdyacencia[i][j] != 0) {
                    distancias[i][j] = matrizAdyacencia[i][j];
                } else {
                    distancias[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE &&
                            distancias[k][j] != Integer.MAX_VALUE &&
                            distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }
        return distancias;
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }
}
