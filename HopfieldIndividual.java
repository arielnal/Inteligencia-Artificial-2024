/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.IA;

import java.util.Arrays;

/**
 *
 * @author ariel
 */
public class HopfieldIndividual {
    int l = 0;
    int[] optimo = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, 1, 1, -1, -1, -1, -1,
    -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
    -1, -1, 1, -1, -1, -1, -1, 1, -1, -1,
    -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
    -1, 1, 1, -1, -1, -1, -1, 1, 1, -1};
    
    int[] patron0a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int[] patron0b = {-1, -1, -1, 1, 1, -1, -1, -1, -1, -1};
    
    int[] patron1a = {-1, -1, -1, -1, 1, 1, -1, -1, -1, -1};
    int[] patron1b = {-1, -1, 1, 1, 1, 1, -1, -1, -1, -1};
    int[] patron1c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    
    /**ya observo que los resultados obtenidos ubican los "1" de acuerdo con las 
     * posiciones donde más se repiten. Para este segmento son las posiciones 
     * 6 y 7.
     */
    int[] patron2a = {-1, -1, -1, 1, 1, 1, 1, -1, -1, -1};
    int[] patron2b = {-1, 1, -1, -1, -1, -1, 1, -1, -1, -1};
    int[] patron2c = {-1, -1, -1, -1, -1, 1, 1, -1, -1, -1};
    
    /** Para este segmento son las posiciones 7 y 8.
     */
    int[] patron3a = {-1, -1, 1, -1, -1, -1, -1, 1, -1, -1};
    int[] patron3b = {1, 1, -1, -1, -1, -1, 1, 1, -1, -1};
    int[] patron3c = {-1, -1, -1, -1, 1, 1, 1, 1, -1, -1};

    /** Para este segmento son las posiciones 2, 3 y 8.
     */
    int[] patron5a = {-1, 1, 1, -1, -1, -1, -1, 1, 1, -1};
    int[] patron5b = {-1, 1, -1, -1, -1, -1, 1, -1, -1, -1};
    int[] patron5c = {-1, -1, 1, 1, -1, -1, -1, -1, 1, 1};

    /** Habiendo descubierto el meollo del asunto de no poder lograr el patrón adecuado,
     * voy a a signarle más peso al vector óptimo. Para esto se me ocurren dos ideas
     * 1. Repetir más veces el óptimo. Lo cual searía "medio trucho".
     * 2. Adecuar el contorno del círulo, de modo que la red pueda "ver" el patrón circular,
     * aunque no sea el óptimo. Por ejemplo, mejorando la definición de pixels.
     */
    int[] patron4a = {-1, -1, 1, 1, -1, -1, 1, 1, -1, -1};
    int[] patron4b = {-1, 1, 1, -1, -1, 1, 1, -1, -1, -1};
    int[] patron4c = {-1, -1, -1, 1, 1, 1, 1, 1, 1, -1};
    // espero 1 en posiciones 3, 4, 6, 7 y 8
    
    int[] resultado = new int[40];
    int[][] matriz0a = new int[10][10];
    int[][] matriz0b = new int[10][10];
    int[][] matrizP0 = new int[10][10];

    int[][] matriz1a = new int[10][10];
    int[][] matriz1b = new int[10][10];
    int[][] matriz1c = new int[10][10];
    int[][] matrizP1 = new int[10][10];

    int[][] matriz2a = new int[10][10];
    int[][] matriz2b = new int[10][10];
    int[][] matriz2c = new int[10][10];
    int[][] matrizP2 = new int[10][10];

    int[][] matriz3a = new int[10][10];
    int[][] matriz3b = new int[10][10];
    int[][] matriz3c = new int[10][10];
    int[][] matrizP3 = new int[10][10];

    int[][] matriz5a = new int[10][10];
    int[][] matriz5b = new int[10][10];
    int[][] matriz5c = new int[10][10];
    int[][] matrizP5 = new int[10][10];

    int[][] matriz4a = new int[10][10];
    int[][] matriz4b = new int[10][10];
    int[][] matriz4c = new int[10][10];
    int[][] matrizP4 = new int[10][10];
    


    // constructor de la matraz de pesos
    public HopfieldIndividual() {
        /** la matriz de pesos se contruye a partir de un único vector, ya que no
         * hay más de un patrón deseado (que se necesite "aprender").
         * por este motivo, no hay necesidad de "estabilizar" el resultado.. es decir,
         * siempre será como el patrón.
         */
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    matriz0a[i][j]=0;
                    matriz1a[i][j]=0;
                    matriz2a[i][j]=0;
                    matriz3a[i][j]=0;
                    matriz5a[i][j]=0;
                    matriz4a[i][j]=0;
                } else {
                    matriz0a[i][j] = patron0a[i] * patron0a[j];
                    matriz1a[i][j] = patron1a[i] * patron1a[j];
                    matriz2a[i][j] = patron2a[i] * patron2a[j];
                    matriz3a[i][j] = patron3a[i] * patron3a[j];
                    matriz5a[i][j] = patron5a[i] * patron5a[j];
                    matriz4a[i][j] = patron4a[i] * patron4a[j];
                }
            }
        }
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    matriz0b[i][j]=0;
                    matriz1b[i][j]=0;
                    matriz2b[i][j]=0;
                    matriz3b[i][j]=0;
                    matriz5b[i][j]=0;
                    matriz4b[i][j]=0;
                } else {
                    matriz0b[i][j] = patron0b[i] * patron0b[j];
                    matriz1b[i][j] = patron1b[i] * patron1b[j];
                    matriz2b[i][j] = patron2b[i] * patron2b[j];
                    matriz3b[i][j] = patron3b[i] * patron3b[j];
                    matriz5b[i][j] = patron5b[i] * patron5b[j];
                    matriz4b[i][j] = patron4b[i] * patron4b[j];
                }
            }
        }
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    matriz1c[i][j]=0;
                    matriz2c[i][j]=0;
                    matriz3c[i][j]=0;
                    matriz5c[i][j]=0;
                    matriz4c[i][j]=0;
                } else {
                    matriz1c[i][j] = patron1c[i] * patron1c[j];
                    matriz2c[i][j] = patron2c[i] * patron2c[j];
                    matriz3c[i][j] = patron3c[i] * patron3c[j];
                    matriz5c[i][j] = patron5c[i] * patron5c[j];
                    matriz4c[i][j] = patron4c[i] * patron4c[j];
                }
            }
        }
        
        // matraz de pesos
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    matrizP0[i][j]=0;
                    matrizP1[i][j]=0;
                    matrizP2[i][j]=0;
                    matrizP3[i][j]=0;
                    matrizP5[i][j]=0;
                    matrizP4[i][j]=0;
                } else {
                    matrizP0[i][j] = matriz0a[i][j] + matriz0b[i][j];
                    matrizP1[i][j] = matriz1a[i][j] + matriz1b[i][j] + matriz1c[i][j];
                    matrizP2[i][j] = matriz2a[i][j] + matriz2b[i][j] + matriz2c[i][j];
                    matrizP3[i][j] = matriz3a[i][j] + matriz3b[i][j] + matriz3c[i][j];
                    matrizP5[i][j] = matriz5a[i][j] + matriz5b[i][j] + matriz5c[i][j];
                    matrizP4[i][j] = matriz4a[i][j] + matriz4b[i][j] + matriz4c[i][j];
                }
            }
        }        
        
/*        opcional: imprimir la matriz de pesos
        System.out.println("Matriz de pesos");
        impH(matriz);
*/    }
    
    //vector de 60
    public void secH (int[] inicial){

        if(Arrays.equals(resultado, inicial)){
            System.out.println("Imágen estable. "+
                    "Cantidad de ciclos: " + l);
        }  
        
        l++;
        int[] x0 = new int[10];
        int[] x1 = new int[10];
        int[] x2 = new int[10];
        int[] x3 = new int[10];
        int[] x5 = new int[10];
        int[] x4 = new int[10];
        int[] vector = new int[60];
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                x0[j] = inicial[j] * matrizP0[i][j];
                x1[j] = inicial[j+10] * matrizP1[i][j];
                x2[j] = inicial[j+20] * matrizP2[i][j];
                x3[j] = inicial[j+30] * matrizP3[i][j];
                x5[j] = inicial[j+40] * matrizP5[i][j];
                x4[j] = inicial[j+50] * matrizP4[i][j];
            }
            for (int j=0; j<10; j++){
                vector[i] =+ x0[j];
                vector[i+10] =+ x1[j];
                vector[i+20] =+ x2[j];
                vector[i+30] =+ x3[j];
                vector[i+40] =+ x5[j];
                vector[i+50] =+ x4[j];
            }            
        }
        for (int i=0; i<60; i++){
            if(vector[i]>0){
                vector[i] = 1;
            } else{
                vector[i] = -1;
            }
        }
        /*
        if(!Arrays.equals(vector, patron0a)){
            secH(vector);
        } else{
            resultado = vector;
        }
        */
        
        resultado= vector;
        //excepción: para la estabilización no seprueba una segunda vez...
        if(Arrays.equals(resultado, optimo)){
            System.out.println("coincide con el patrón Óptimo"+
                    "Cantidad de ciclos: " + l);
        }  
        
    }
    
    
    
}
