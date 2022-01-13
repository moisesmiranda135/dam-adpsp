package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int valorMinimo = -36;
        int valorMaximo = 12;
        int nAleatorios = valorMaximo - valorMinimo;
        if (valorMinimo < valorMaximo){
            NumerosAleatorios na = new NumerosAleatorios(valorMinimo,valorMaximo);
            System.out.print(na.generar()+",");
            for(int i = nAleatorios; i > 1;i--){
                System.out.print(na.generar()+",");
            }
        }else{
            System.out.print("Los números introducidos no son válidos");
        }

    }
}
