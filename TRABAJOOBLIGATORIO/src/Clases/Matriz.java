/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IMatriz;
import trabajoobligatorio.Retorno;

/**
 *
 * @author 59898
 */
public class Matriz implements IMatriz{

    @Override
    public String mostrarmtriz(String[][] m) {

        String resultado = "";

        for(int i=0; i<m.length; i++){
            
            resultado += " - ";
            
            for(int j=0; j<m[i].length; j++){
                resultado+= m[i][j] + " - ";
            }
            
            resultado+= "\n";
        }
        
        return resultado;    
    }
    
}
