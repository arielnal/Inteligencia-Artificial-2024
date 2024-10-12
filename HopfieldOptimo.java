/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.IA;

import java.util.Arrays;

/**
 *https://www.youtube.com/watch?v=Frp9QRCRVLA
 * @author ariel
 */
public class HopfieldOptimo {
    int n = 0;
    int[] patron = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                      -1, -1, -1, -1, 1, 1, -1, -1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, 1, -1, -1, -1, -1, 1, -1, -1,
                      -1, 1, 1, -1, -1, -1, -1, 1, 1, -1,
                      -1, 1, 1, -1, -1, -1, -1, 1, 1, -1,
                      -1, -1, 1, -1, -1, -1, -1, 1, -1, -1,
                      -1, -1, -1, 1, 1, 1, 1, -1, -1, -1,
                      -1, -1, -1, -1, 1, 1, -1, -1, -1, -1,
                      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    int[] patronT = patron;
    int[] resultado = new int[patron.length];
    int[][] matriz = new int[patron.length][patronT.length];

    // constructor de la matraz de pesos
    public HopfieldOptimo() {
        /** la matriz de pesos se contruye a partir de un único vector, ya que no
         * hay más de un patrón deseado (que se necesite "aprender").
         * por este motivo, no hay necesidad de "estabilizar" el resultado.. es decir,
         * siempre será como el patrón.
         */
        for (int i = 0; i<patron.length; i++) {
            for (int j = 0; j<patronT.length; j++) {
                if(i==j){
                    matriz[i][j]=0;
                } else {
                    matriz[i][j] = patronT[i] * patron[j];
                }
            }
        }
/*        opcional: imprimir la matriz de pesos
        System.out.println("Matriz de pesos");
        impH(matriz);
*/    }
    public void secH (int[] inicial){
        n++;
        int[] x = new int[inicial.length];
        int[] vector = new int[matriz.length];
        for (int i=0; i<inicial.length; i++){
            for (int j=0; j<matriz.length; j++){
                x[j] = inicial[j] * matriz[i][j];
            }
            for (int j=0; j<matriz.length; j++){
                vector[i] =+ x[j];
            }            
        }
        for (int i=0; i<inicial.length; i++){
            if(vector[i]>0){
                vector[i] = 1;
            } else{
                vector[i] = -1;
            }
        }        
        if(!Arrays.equals(vector, patron)){
            secH(vector);
        } else{
            resultado = vector;
        }
        if(Arrays.equals(resultado, patron)){
            System.out.println("coincide con el patrón");
        }
        //excepción: para la estabilización no seprueba una segunda vez...
    }
    
    public void impH (int[] mz){
        int j;
        int k = 0;
        for (int i = 0; i<mz.length; i++) {
            for (j=k; j<(k+10); j++) {
                System.out.print("[" + mz[j] + "] ");
            }
            System.out.println();
            k = (k + 10);
            if(k==100){
                break;
            }
        }
    }
    public void impH (int[][] mz){
        for (int i = 0; i<mz.length; i++) {
            for (int j = 0; j<mz.length; j++) {
                System.out.print("[" + mz[i][j] + "] ");
            }
            System.out.println();
        }
    }
}
