/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TP4.IA;

/**
 *
 * @author ariel
 */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class HoughCirculo {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // Cargar la imagen
        String imagePath = "C:/Users/ariel/OneDrive/Documents/NetBeansProjects/"
                + "JavaApplication1/src/imagen/Circulo_BloqueMotor-baliza.jpg";
        Mat src = Imgcodecs.imread(imagePath);
        Mat gray = new Mat();
        Mat blurred = new Mat();
        
        // Convertir a escala de grises
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        // Aplicar desenfoque
        Imgproc.GaussianBlur(gray, blurred, new org.opencv.core.Size(9, 9), 2, 2);


        /**el número 19 representa el umbral que se utiliza para determinar 
         * cuántas "votos" se requieren para considerar que una línea es válida 
         * en el espacio de Hough.
         */          
        
        // Definir el tamaño mínimo y máximo de los círculos
        int minRadius = 19; // Radio mínimo con 19 solo detecta el deseado
        int maxRadius = 30; // Radio máximo

        // Detectar círculos
        Mat circles = new Mat();
        Imgproc.HoughCircles(blurred, circles, Imgproc.CV_HOUGH_GRADIENT, 1,
                blurred.rows()/8, 100, 30, minRadius, maxRadius);

        // Dibujar los círculos detectados
        for (int i = 0; i < circles.cols(); i++) {
            double[] circle = circles.get(0, i);
            int x = (int) circle[0];
            int y = (int) circle[1];
            int radius = (int) circle[2];

            // Dibujar el círculo en la imagen original
            Imgproc.circle(src, new Point(x, y), radius, new Scalar(0, 255, 0), 3);
            Imgproc.circle(src, new Point(x, y), 3, new Scalar(255, 0, 0), 3); // Centro
        }

        // Guardar la imagen resultante
        Imgcodecs.imwrite("resultadoCirculo.jpg", src);
        System.out.println("Círculos detectados y guardados en 'resultadoCirculo.jpg'");
    }
}
