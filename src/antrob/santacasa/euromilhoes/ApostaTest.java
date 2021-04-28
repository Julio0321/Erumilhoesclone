package antrob.santacasa.euromilhoes;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ApostaTest {

	@Test
	void testAposta() {
		// fail("Not yet implemented");
		
		
		/* Correcto seria executar o teste Unit�rio repetidas vezes com @RepeatTest  */
		
		// Repetir a cria��o de uma s�rie de apostas aleat�rias e a cria��o,
		// com os seus respectivos numeros e estrelas, de apostas deterministas
		// verificando se a excep��o IllegalArgumentException n�o ocorre
		for( int i=1; i < 100; i++ ) { 	
			assertDoesNotThrow( () -> {
				Aposta aposta1 = new Aposta();
				Aposta aposta2 = new Aposta( aposta1.getNumeros(), aposta1.getEstrelas() ) ;
			}, "Numeros ou Estrelas de Aposta aleat�ria  ");
		}
		
		
		
				
	}

	@Test
	void testApostaIntArrayIntArray() {
			
		// Numero de Numeros diferente de 5
		assertThrows(IllegalArgumentException.class, () -> { 
					Aposta aposta = new Aposta( new int[] { 7, 45, 21, 9 }, new int[] { 12, 1 } ) ;
				}, "O array de n�meros tem de ter um tamanho igual a 5");
		
		// Numero de Estrelas diferente de 2
		assertThrows(IllegalArgumentException.class, () -> { 
					Aposta aposta = new Aposta( new int[] { 4, 7, 45, 21, 9 }, new int[] { 12, 1, 5 } ) ;
				}, "O array de estrelas tem de ter um tamanho igual a 2");

		// Os numeros tem de estar no intervalo de 1 a 50
		assertThrows(IllegalArgumentException.class, () -> { 
					Aposta aposta = new Aposta( new int[] { 4, 7, 51, 21, 9 }, new int[] { 12, 1 } ) ;
				}, "Os numeros tem de estar no intervalo de 1 a 50");
		
		// Os numeros tem de estar no intervalo de 1 a 50
		assertThrows(IllegalArgumentException.class, () -> { 
					Aposta aposta = new Aposta( new int[] { 0, 7, 45, 21, 9 }, new int[] { 12, 1 } ) ;
				}, "Os numeros tem de estar no intervalo de 1 a 50");
		
		// As estrelas tem de estar no intervalo de 1 a 12
		assertThrows(IllegalArgumentException.class, () -> { 
					Aposta aposta = new Aposta( new int[] { 4, 7, 45, 21, 9 }, new int[] { 13, 1 } ) ;
				}, "As estrelas tem de estar no intervalo de 1 a 12");
		
		// As estrelas tem de estar no intervalo de 1 a 12
		assertThrows(IllegalArgumentException.class, () -> { 
					Aposta aposta = new Aposta( new int[] { 4, 7, 45, 21, 9 }, new int[] { 12, 0 } ) ;
				}, "As estrelas tem de estar no intervalo de 1 a 12");
				
		// Nao podem haver numeros iguais
		assertThrows(IllegalArgumentException.class, () -> { 
			Aposta aposta = new Aposta( new int[] { 4, 7, 45, 21, 4 }, new int[] { 12, 1 } ) ;
		}, "Nao podem haver numeros iguais");
		
		// Nao podem haver numeros iguais
		assertThrows(IllegalArgumentException.class, () -> { 
			Aposta aposta = new Aposta( new int[] { 4, 7, 21, 21, 9 }, new int[] { 12, 1 } ) ;
		}, "Nao podem haver numeros iguais");
		
		// Nao podem haver estrelas iguais
		assertThrows(IllegalArgumentException.class, () -> { 
			Aposta aposta = new Aposta( new int[] { 4, 7, 45, 21, 9 }, new int[] { 12, 12 } ) ;
		}, "Nao podem haver estrelas iguais");
				
	}

	@Test
	void testGetNumeros() {
		
		Aposta aposta = new Aposta();
		
		int[] numeros = aposta.getNumeros();
		
		numeros[0] = 21;
		numeros[1] = 11;
		numeros[2] = 22;
		
		// AssertArrayNotEquals n�o existe , tentar uma solu��o 
		// https://stackoverflow.com/questions/7305612/junit-arrays-not-equal-test
		assertFalse( Arrays.equals( numeros, aposta.getNumeros() ), "Array obtido e modificado n�o pode ser igual a um array de novo obtido " );
		
		
	}

	@Test
	void testGetEstrelas() {
		
		Aposta aposta = new Aposta();
		
		int[] estrelas = aposta.getEstrelas();
		
		estrelas[0] = 5;
		estrelas[1] = 5;
		
		// AssertArrayNotEquals n�o existe , tentar uma solu��o 
		// https://stackoverflow.com/questions/7305612/junit-arrays-not-equal-test
		assertFalse( Arrays.equals( estrelas, aposta.getEstrelas() ), "Array obtido e modificado n�o pode ser igual a um array de novo obtido " );
		
		
	}

	@Test
	void testGetAcertos() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		
		Aposta aposta = new Aposta( new int[] { 4, 7, 45, 21, 9 }, new int[] { 12, 1 } ) ;
		
		// Para comparar 2 Strings no JUnit 
		// https://stackoverflow.com/questions/1201927/is-javas-assertequals-method-reliable
		assertEquals( "[4, 7, 9, 21, 45]-[1, 12]" , aposta.toString(), "As strings " + "[4, 7, 9, 21, 45]-[1, 12]" + " e " + aposta.toString() + " deviam ser iguais");
		
		
	}

}
