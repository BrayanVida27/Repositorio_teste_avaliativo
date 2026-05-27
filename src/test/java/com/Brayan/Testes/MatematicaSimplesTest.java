package com.Brayan.Testes;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DisplayName("Testes de Matematica Operações Simples")
public class MatematicaSimplesTest {

    MatematicaSimples math;


    @BeforeAll

    static void setup() {
        System.out.println("Escrevendo ontes do método");
    }

    @AfterAll
    static void doan() {
        System.out.println("Escrevendo depois do método");
    }

    @BeforeEach
    void beforcecheMathad() {
        math = new MatematicaSimples();
        System.out.println("Escrevendo o metodo odepois da linha");
    }

    @AfterEach
    void afterchMethad() {
        math = new MatematicaSimples();
        System.out.println("Escrevendo o metodo depois da linha");

    }

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void TestSoma() {
        System.out.println("Teste 6.2 + 2 = 8.2");

        double firstNumber = 6.2;
        double secondNumber = 2;
        double expected = 8.2;

        //When/Act
        Double actual = math.sum(firstNumber, secondNumber);
        //Then
        assertEquals(expected, actual,
                () ->firstNumber + "+" + secondNumber + "Valor incorreto !"
                + expected + "!");
    }

    @Test
    @DisplayName("Test 4.5 * 2 = 9")
    void TestMultiplication() {
        System.out.println("Teste 4.5 * 2 = 9");

        double firstNumber = 4.5;
        double secondNumber = 2;
        double expected = 9;

        Double actual = math.multiplication(firstNumber, secondNumber);

        assertEquals(expected, actual,
                () -> firstNumber + "*" + secondNumber +
                "Valor incorreto !" + expected + "!");
    }
}
