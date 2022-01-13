package com.company;

import java.util.ArrayList;

public class NumerosAleatorios {
    private int valorInicial;
    private int valorFinal;
    private ArrayList listaNumero;

    public NumerosAleatorios(int valorInicial, int valorFinal){
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        listaNumero = new ArrayList();
    }

    private int numeroAleatorio(){
        return (int)(Math.random()*(valorFinal-valorInicial+1)+valorInicial);
    }

    public int generar(){
        if(listaNumero.size() < (valorFinal - valorInicial) +1){
            int numero = numeroAleatorio();
            if(listaNumero.isEmpty()){
                listaNumero.add(numero);
                return numero;
            }else{
                if(listaNumero.contains(numero)){
                    return generar();
                }else{
                    listaNumero.add(numero);
                    return numero;
                }
            }
        }else{
            return -1;
        }
    }
}

