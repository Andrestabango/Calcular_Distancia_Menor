import java.util.ArrayList;
import java.util.Scanner;

public class CalculadorDistancia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Punto> puntos = new ArrayList<>();

        // Ingreso de n puntos
        System.out.print("¿Cuántos puntos desea ingresar? ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese las coordenadas del punto %d (x,y): ", i + 1);
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            puntos.add(new Punto(x, y));
        }

        // Ingreso del punto de salida y llegada
        System.out.print("Ingrese las coordenadas del punto de salida (x,y): ");
        double xSalida = scanner.nextDouble();
        double ySalida = scanner.nextDouble();
        Punto salida = new Punto(xSalida, ySalida);

        System.out.print("Ingrese las coordenadas del punto de llegada (x,y): ");
        double xLlegada = scanner.nextDouble();
        double yLlegada = scanner.nextDouble();
        Punto llegada = new Punto(xLlegada, yLlegada);

        // Cálculo de la distancia mínima
        double distanciaMinima = Double.MAX_VALUE;
        Punto puntoIntermedio1 = null;
        Punto puntoIntermedio2 = null;
        Punto puntoIntermedio3 = null;
        Punto puntoIntermedio4 = null;

        for (int i = 0; i < puntos.size(); i++) {
            for (int j = 0; j < puntos.size(); j++) {
                if (j != i) {
                    for (int k = 0; k < puntos.size(); k++) {
                        if (k != i && k != j) {
                            for (int l = 0; l < puntos.size(); l++) {
                                if (l != i && l != j && l != k) {
                                    double distancia = salida.distancia(puntos.get(i)) + puntos.get(i).distancia(puntos.get(j)) + puntos.get(j).distancia(puntos.get(k)) + puntos.get(k).distancia(puntos.get(l)) + puntos.get(l).distancia(llegada);
                                    if (distancia < distanciaMinima) {
                                        distanciaMinima = distancia;
                                        puntoIntermedio1 = puntos.get(i);
                                        puntoIntermedio2 = puntos.get(j);
                                        puntoIntermedio3 = puntos.get(k);
                                        puntoIntermedio4 = puntos.get(l);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Resultado
        System.out.println("La distancia mínima para ir del punto de salida al punto de llegada pasando por cuatro puntos intermedios es: " + distanciaMinima);
        System.out.println("Los puntos intermedios son:");
        System.out.printf("Punto 1: (%.2f, %.2f)\n", puntoIntermedio1.getX(), puntoIntermedio1.getY());
        System.out.printf("Punto 2: (%.2f, %.2f)\n", puntoIntermedio2.getX(), puntoIntermedio2.getY());
        System.out.printf("Punto 3: (%.2f, %.2f)\n", puntoIntermedio3.getX(), puntoIntermedio3.getY());
        System.out.printf("Punto 4: (%.2f, %.2f)\n", puntoIntermedio4.getX(), puntoIntermedio4.getY());
    }

}
