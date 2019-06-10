/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicados2dobim;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author drmorales4
 */
public class LeerArchivoTexto {
    
    
    public static void leerRegistrosTabla() {

        // 1. Se abre el archivo
        try // lee registros del archivo, usando el objeto Scanner
        {
           Scanner entrada = new Scanner(new File("data/tabula-FWC_2018_"
                   + "Squadlists_4.csv"));
           // variables
           double height; 
           double goals;
           double sumaHeight = 0;
           double sumaGoals = 0;
           double promedioHeight;
           double promedioGoals;
           int cont = 1; // contador de personas
           
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                
                ArrayList<String> linea_partes = new ArrayList<>(
                         Arrays.asList(linea.split("\\|")));
                
                height = Double.parseDouble(linea_partes.get(9));
                goals = Double.parseDouble(linea_partes.get(11));
                sumaHeight = sumaHeight + height; // acumulando la suma de Estatura
                sumaGoals = sumaGoals + goals; // acumulando la suma de Goles
                cont = cont + 1; // para saber cuantas personas hay y poder dividir para ese numero
            } // fin de while
            
            entrada.close();
            promedioHeight = sumaHeight / cont; // obtencion del promedio de estatura
            promedioGoals = sumaGoals / cont; // obtencion del promedio de goles
            
            System.out.printf("El promedio de Height es: %.2f\nPromedio de "
                    + "Goals es: %.2f\n\n", promedioHeight, promedioGoals);
            
        } // fin de try
        catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    }
    
    
    
    
}
