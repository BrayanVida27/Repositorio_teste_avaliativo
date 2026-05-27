package com.Brayan.Testes;

public class DescontoService {
   public double aplicarDesconto(double vlCompra){
    double resultado = 0;

        if (vlCompra >= 500){
            return resultado = vlCompra * 0.90;
        }
        return vlCompra;
    }
}
