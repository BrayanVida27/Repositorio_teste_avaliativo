
    /**
     * como cliente da loja,
     * quero receber desconto em conpras acima de R$500,00
     * para economizar em pedidos maiores
     *
     * RN001 - se o valor da compra for meior que R$500,00 -> aplicar 10% de desconto
     * se não, não aplica o desconto.  *
     *
     * **/

    package com.Brayan.Testes;

    import com.Brayan.Testes.DescontoService;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;

    import java.util.Arrays;

    import static org.junit.jupiter.api.Assertions.assertEquals;

    public class ExercicioTesteHU {
        /**
         * Como cliente da loja.
         * Quero receber desconto em compras acima de R$500,00
         * Para economizar em pedidos maiores.
         *
         * RN001 - Se o valor da compra for maior que
         * R$500,00 -> aplicar 10% de desconto
         * se não, não aplica o desconto.
         */
        @Test
        @DisplayName("Desconto será aplicado")
        void deveAplicarDesconto() {
            DescontoService deveService = new DescontoService();
            double resultado = 0;
            double vlCompra = 501;
            resultado = deveService.aplicarDesconto(vlCompra);
            boolean condicional = resultado > 450.00 ? true : false;
            assertEquals(true, condicional,
                    ()-> "O valor do pedido deve ser maior que R$500.00\n" +
                            "Valor da compra foi: " +  vlCompra
            );
            System.out.printf("Desconto aprovado, valor da compra foi: %.2f\n" +
                    "valor da compra com desconto %.2f", vlCompra, resultado);
        }
        @Test
        @DisplayName("Desconto não será aplicado")
        void naoAplicarDesconto(){
            DescontoService DeveService = new DescontoService();
            double resultado = DeveService.aplicarDesconto(500);
            assertEquals(500, resultado);
        }
        @Test
        @DisplayName("Desconto não será aplicado")
        void naoAplicarDesconto2(){
            DescontoService nDeveService = new DescontoService();
            double resultado = nDeveService.aplicarDesconto(300);
            assertEquals(300, resultado);
        }
    }
