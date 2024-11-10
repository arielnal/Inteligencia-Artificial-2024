/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class HoughRecta {
    
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
        Mat edges = new Mat();

        // Convertir a escala de grises
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        
        // Aplicar la transformada de Hough para detectar líneas
        /**el número 1 - 10 representa el umbral que se utiliza para determinar 
         * cuántas "votos" se requieren para considerar que una línea es válida 
         * en el espacio de Hough. El valor 135 es el que hace que encuentren 
         * una única línea.
         */        
        
        
        // Aplicar desenfoque
        Imgproc.GaussianBlur(gray, blurred, new Size(5, 5), 1, 1);

        // Detectar bordes usando Canny
        Imgproc.Canny(blurred, edges, 50, 150);

        // Detectar líneas usando la Transformada de Hough
        Mat lines = new Mat();
        Imgproc.HoughLinesP(edges, lines, 1, Math.PI / 180, 100, 100, 1);

        // Dibujar las líneas detectadas
        for (int i = 0; i < lines.rows(); i++) {
            double[] line = lines.get(i, 0);
            int x1 = (int) line[0];
            int y1 = (int) line[1];
            int x2 = (int) line[2];
            int y2 = (int) line[3];

            // Dibujar la línea en la imagen original
            Imgproc.line(src, new Point(x1, y1), new Point(x2, y2), new Scalar(0, 255, 0), 3);
        }

        // Guardar la imagen resultante
        Imgcodecs.imwrite("resultadoRecta.jpg", src);
        System.out.println("Líneas detectadas y guardadas en 'resultadoRecta.jpg'");
    }
}



