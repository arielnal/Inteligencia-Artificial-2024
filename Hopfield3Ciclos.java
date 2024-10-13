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
public class Hopfield3Ciclos {
    int m = 0;
    int[] patronO = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,
                      -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
                      -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
                      -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    
    int[] patron2 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,
                      -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
                      -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
                      -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    int[] patron3 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                     -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,
                      -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
                      -1, -1, 1, 1, -1, -1, 1, 1, -1, -1,
                      -1, -1, 1, 1, 1, 1, 1, 1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,};    

    int[] patronTO = patronO;
    int[] patronT2 = patron2;
    int[] patronT3 = patron3;
    //todo los vectores tienen un largo de 100
    int[] resultado = new int[patronO.length];
    int[][] matrizO = new int[patronO.length][patronTO.length];
    int[][] matriz2 = new int[patron2.length][patronT2.length];
    int[][] matriz3 = new int[patron3.length][patronT3.length];
    int[][] matrizPesos = new int[patronO.length][patronO.length];

    // constructor de la matraz de pesos  
    public Hopfield3Ciclos() {
        /** la matriz de pesos se contruye a partir de 3 (tres) vectores, según los
         * solicitado en la clase.
         */
        for (int i = 0; i<100; i++) {
            for (int j = 0; j<100; j++) {
                if(i==j){
                    matrizO[i][j]=0;
                } else {
                    matrizO[i][j] = patronTO[i] * patronO[j];
                }
            }
        }
        
        for (int i = 0; i<100; i++) {
            for (int j = 0; j<100; j++) {
                if(i==j){
                    matriz2[i][j]=0;
                } else {
                    matriz2[i][j] = patronT2[i] * patron2[j];
                }
            }
        }
        
        
        for (int i = 0; i<100; i++) {
            for (int j = 0; j<100; j++) {
                if(i==j){
                    matriz3[i][j]=0;
                } else {
                    matriz3[i][j] = patronT3[i] * patron3[j];
                }
            }
        }
        
        // matraz de pesos
        for (int i = 0; i<100; i++) {
            for (int j = 0; j<100; j++) {
                if(i==j){
                    matrizPesos[i][j]=0;
                } else {
                    matrizPesos[i][j] = matrizO[i][j] + matriz2[i][j] + matriz3[i][j];
                }
            }
        }
        
/*        opcional: imprimir la matriz de pesos
        System.out.println("Matriz de pesos");
        impH(matriz);
*/    } 
    
    public void secH (int[] inicial3){
        m++;
        int[] x = new int[100];
        int[] auxiliar = new int[100];
        int[] vector = new int[100];
        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                x[j] = inicial3[j] * matrizPesos[i][j];
            }
            
            for (int j=0; j<100; j++){
                auxiliar[i] =+ x[j];
            }  
            
        }
        for (int i=0; i<100; i++){
            if(auxiliar[i]>0){
                vector[i] = 1;
            } else{
                vector[i] = -1;
            }
        }  
        /*
        if(!Arrays.equals(vector, patronO) || !Arrays.equals(vector, patron2) || !Arrays.equals(vector, patron3)){
            secH(vector);
        } else{
            resultado = vector;
        }
        */

        if(Arrays.equals(vector, resultado)){
            System.out.println("No hubo cambios");
        }
                
        resultado = vector;
        
        if(Arrays.equals(resultado, patronO) /*|| Arrays.equals(resultado, patron2) *//*|| Arrays.equals(resultado, patron3)*/){
            System.out.println("coincide con el patrón");
        }        
        //excepción: para la estabilización no seprueba una segunda vez...
    }    
    
    public void ortogonales (int[] a, int[] b){
        int x = 0;
        for (int i = 0; i<100; i++){
            x =+ a[i] * b[i];
        }
        if(x==0){
            System.out.println("Los vectores son Ortogonales");
        } else{
            System.out.println("Los vectores NO son Ortogonales");
            System.out.println("Producto escalar: " + x);
        }
        /** entiendo que al no ser ortogonales, el modelo no los puede
         * diferenciar.
         */
    }    
}
