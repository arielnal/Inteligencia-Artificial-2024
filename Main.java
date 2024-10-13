/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.IA;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ariel
 */
public class Main {
    
    public static void main(String[] args) {

        int w = 0;
        Random aleatorio = new Random(System.currentTimeMillis());
        int[] inicial = new int[100];
        HopfieldOptimo hp = new HopfieldOptimo();


        // imprimo el patrón deseado, el cúal simula la sección del motor
        System.out.println("Patrón deseado: HopfieldOptimo");
        hp.impH(hp.patron);
        System.out.println();
        System.out.println();        
       
        // creo una secuancia inicial aleatoria para armonizar
        for(int i=0; i<inicial.length; i++){
                int x = aleatorio.nextInt(100);
                if(x<50){
                    inicial[i] = -1;
                } else{
                    inicial[i] = 1;
                }
        }
        hp.secH(inicial);
        // imprimo la matriz de partida para conocerla, y luego comparar el resultado
        System.out.println("Patrón inicial");
        hp.impH(inicial);
        System.out.println();
        System.out.println();
        // aplico el método Hopfield y lo imprimo para ver el resultado
        System.out.println("Patrón hallado por el método Hopfield");
        //hp.secH(inicial);
        hp.impH(hp.resultado);
        System.out.println("La cantidad de resultados necesarios fueron: " + hp.n);
        
        //En general el método funciona con uno o máximo dos intentos.
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("");
        Random aleatorio3 = new Random(System.currentTimeMillis());
        int[] inicial3 = new int[100];
        Hopfield3Ciclos hp3 = new Hopfield3Ciclos();

        // imprimo el patrón deseado, el cúal simula la sección del motor
        System.out.println("Matriz de Pesos. Puede imprimirse pero es muy grande");
//        hp.impH(hp3.matrizPesos);
        System.out.println();
        System.out.println();              
       
        // creo una secuancia inicial aleatoria para armonizar
        for(int i=0; i<inicial3.length; i++){
                int x = aleatorio3.nextInt(100);
                if(x<50){
                    inicial3[i] = -1;
                } else{
                    inicial3[i] = 1;
                }
        }
        
        // imprimo la matriz de partida para conocerla, y luego comparar el resultado
        System.out.println("Patrón inicial: Hopfield3Ciclos");
        hp.impH(inicial3);
        System.out.println();
        System.out.println();
        System.out.println("Patrón hallado por el método Hopfield");
        hp3.secH(inicial3);
        hp3.secH(hp3.resultado);
        hp.impH(hp3.resultado);     
        
        /** el código sigiuente lo utilicé para hacer pruebas, y me sirvió para 
         * comprender como funcionaba el modelo en vivo.
         */
        // aplico el método Hopfield y lo impeimo para ver el resultado
        //System.out.println("Patrón hallado por el método Hopfield");
        //hp3.secH(inicial3);
        //hp.impH(hp3.resultado);
        //System.out.println("La cantidad de resultados necesarios fueron: " + hp3.m);        
        /*
        do {
            System.out.println("Elija opción");
            Scanner sc = new Scanner(System.in);
            w = sc.nextInt();
                   
            if (w == 1){
                System.out.println("La matriz de pesos es:");
                hp.impH(hp3.matrizPesos);
            } if (w == 2){
                hp3.secH(hp3.resultado);
                hp.impH(hp3.resultado);                
            } if (w == 3){
                System.out.println("La cantidad de resultados necesarios fueron: " + hp3.m);
            } if (w == 4){
                hp3.secH(inicial3); 
                //hp3.ortogonales(hp3.patronO, hp3.patron2);
                //hp3.ortogonales(hp3.patronO, hp3.patron3);
                //p3.ortogonales(hp3.patron2, hp3.patron3);
            } if (w == 5){
                System.out.println("La cantidad de resultados necesarios fueron: " + hp.n);
                hp.impH(hp3.resultado);
            }
                    
            
        } while (w != 6);
        
        
        Random aleatorio3 = new Random(System.currentTimeMillis());
        int[] inicial60 = new int[60];
        HopfieldIndividual hpI = new HopfieldIndividual();  
        // creo una secuancia inicial aleatoria para armonizar
        for(int i=0; i<60; i++){
                int x = aleatorio3.nextInt(100);
                if(x<50){
                    inicial60[i] = -1;
                } else{
                    inicial60[i] = 1;
                }
        }  
        
        System.out.println("La matriz de pesos 5 (6ta.) es:");
        hp.impH(hpI.matrizP2);
        System.out.println("El vector inicial es: ");
        hp.impH60(inicial60);       
        hpI.secH(inicial60);
        
        do {
            System.out.println("");
            System.out.print("Elija opción: ");
            Scanner sc = new Scanner(System.in);
            w = sc.nextInt();

                
            if (w == 1){

            } if (w == 2){
              
            } if (w == 3){
                //System.out.println("La cantidad de resultados necesarios fueron: " + hp3.m);
                //hpI.secH(hpI.resultado);
                //hp.impH60(hpI.resultado);                
            } if (w == 4){
 
                //hp3.secH(inicial3); 
                //hp3.ortogonales(hp3.patronO, hp3.patron2);
                //hp3.ortogonales(hp3.patronO, hp3.patron3);
                //p3.ortogonales(hp3.patron2, hp3.patron3);
            } if (w == 5){
                //System.out.println("La cantidad de resultados necesarios fueron: " + hp.n);
                //hp.impH(hp3.resultado);
            }
                    
            
        } while (w != 6);   
*/
    }

}
