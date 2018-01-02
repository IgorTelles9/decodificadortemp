import java.util.Scanner;

public class principal {
	
	public static void main (String args []) {
		
		Scanner scanner = new Scanner(System.in);
		temp temp = new temp();
		
		System.out.println("Bem vindo ao decodificador de c�digo TEMP - Vers�o BETA y18m01d02");
		System.out.println("TTAA");
		
		//Parte de identificadores (YYGGId)
		
		boolean YYGGIdInvalido = true; //boolean e while s� liberam o c�digo se forem inseridos cinco d�gitos
		
		int YY;
		int Id = 0;
		boolean ventoEmKt = true;
		
		
		while (YYGGIdInvalido) {
		
			String YYGGId = scanner.nextLine(); //transforma o que for digitado numa string
			char[] YYGGIdDigitos = YYGGId.toCharArray(); //transforma a string num array de chars
			
			if (YYGGId.matches("^[0-9]*$") && YYGGIdDigitos.length == 5 ) { 
			/*a primeira parte do if verifica se todos os caracteres digitados s�o n�meros
			 a segunda parte verifica se h� exatamente 5 caracteres. */
				
				YYGGIdInvalido = false;
				
				String StringYY = YYGGIdDigitos[0] + "" +  YYGGIdDigitos[1]; //concatena dois chars e transforma numa string
				YY = Integer.parseInt(StringYY); //transforma a string num int
				
				String StringGG = YYGGIdDigitos[2] + "" + YYGGIdDigitos[3]; //concatena os caracteres da terceira e quarta posi��o do array
				
				Id = Character.digit(YYGGIdDigitos[4], 10) * 100; //transforma um char num int
				
				if (YY > 31) {   //verifica se foi somado 50 ao dia, isso signfica que a unidade de vento � n�s
					YY = YY - 50;
					System.out.println("Vento em n�s (kt)");
					ventoEmKt = true;
				}
				else { //caso n�o, a unidade de vento � m/s
					System.out.println("Vento em metros por segundo (m/s)");
					ventoEmKt = false;
				}
				
				
				System.out.println("Dia: " + YY);
				System.out.println("Hora: " + StringGG + " UTC");
				System.out.println("Informa��es de vento at� " + Id + " hPa" );
		
			}
			else {
				System.out.println("C�digo inv�lido. Verifique o c�digo e tente novamente.");
			}
		}	
		
		//LOCALIZA��O DA ESTA��O 
		
		String LLiii = scanner.nextLine();
		System.out.println("C�digo da esta��o pela OMM: " + LLiii);
		
		//SUPERF�CIE TTAA
		System.out.println();
		System.out.println("SUPERF�CIE: ");
		System.out.println();
		
		String pressaoDoTeclado = scanner.nextLine();
		String imprimirPressao = temp.pressao(pressaoDoTeclado);
		System.out.println(imprimirPressao);
		
		String temperaturaDoTeclado = scanner.nextLine();
		String imprimirTemperatura = temp.temperatura(temperaturaDoTeclado);
		System.out.println(imprimirTemperatura);
		System.out.println();
		
		String ventoDoTeclado = scanner.nextLine();
		String imprimirVento = temp.vento(ventoDoTeclado);
		System.out.print(imprimirVento);
		
		if (ventoEmKt) {
			System.out.println(" KT");
		}
		else {
			System.out.println(" m/s");
		}
		
		System.out.println();
		
		
		//PADR�O TTAA
		System.out.println("N�VEIS PADR�O: ");
		System.out.println();
		int niveis = 10;
		int repete = 0;
		boolean ultimoNivel = true;
		
		if (Id == 200) {
			niveis = (Id/20) - (Id/100); 
		}
		
		while (repete <= niveis && ultimoNivel) {
			
			String pressaoScanner = scanner.findWithinHorizon("\\d\\d\\d\\d\\d" , 0);
			String mostraPressao = temp.pressao(pressaoScanner);
			System.out.println(mostraPressao);
			
			String temperaturaScanner = scanner.findWithinHorizon("\\d\\d\\d\\d\\d" , 0);
			String mostraTemperatura = temp.temperatura(temperaturaScanner);
			System.out.println(mostraTemperatura);
			
			String ventoScanner = scanner.findWithinHorizon("\\d\\d\\d\\d\\d" , 0);
			String mostraVento = temp.vento(ventoScanner);
			System.out.print(mostraVento);
			
			if (ventoEmKt) {
				System.out.println(" KT");
			}
			else {
				System.out.println(" m/s");
			}
			
			System.out.println();
			
			if (repete >= 7) {
				System.out.println("H� mais algum n�vel padr�o para ser decodificado? (Digite S para sim e N para n�o.)");
				char resposta = scanner.findWithinHorizon(".", 0).charAt(0);
				if (resposta == 'n' || resposta == 'N') {
					ultimoNivel = false;
				}
			}
				
			repete++;
		}
		
		
		System.out.println("Obrigado por usar o decodificador de c�digo TEMP - Vers�o BETA y18m01d02");
	}
}

