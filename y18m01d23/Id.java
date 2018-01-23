
public class Id {
	
	int YY;
	String GG;
	int Id;
	int pressaoValoresDeVento;
	
	
	
	boolean isValueInvalid = true;
	boolean ventoEmKt;
	
	private String errorMessage = "C�digo inv�lido. Verifique o c�digo e tente novamente.";
	
	
	public void identificacao (String YYGGId) {
		char [] YYGGIdDigitos = YYGGId.toCharArray();
		
		if (YYGGId.matches("^[0-9]*$") && YYGGIdDigitos.length == 5 ) { 
			//a primeira parte do if verifica se todos os caracteres digitados s�o n�meros
			//a segunda parte verifica se h� exatamente 5 caracteres. 
		
			String StringYY = YYGGIdDigitos[0] + "" +  YYGGIdDigitos[1]; //concatena dois chars e transforma numa string
			YY = Integer.parseInt(StringYY); //transforma a string num int
			
			GG = YYGGIdDigitos[2] + "" + YYGGIdDigitos[3]; //concatena os caracteres da terceira e quarta posi��o do array
			
			Id = Character.digit(YYGGIdDigitos[4], 10); //transforma um char num int
			
			if (Id == 2 || Id == 1) {
				
				isValueInvalid = false;
				
				pressaoValoresDeVento = Id * 100;
				
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
				System.out.println("Hora: " + GG + " UTC");
				System.out.println("Informa��es de vento at� " + pressaoValoresDeVento + " hPa" );
				
			} 
			
			else {
				System.out.println(errorMessage);
			}	
			
		}
	}

	public void localizacao (String StrLLiii) {
		
		int LLiii = Integer.parseInt(StrLLiii);
		
		switch (LLiii){
		
		case 83746:
			System.out.println("ESTA��O: Aeroporto Internacional do Rio de Janeiro - RJ (83746 SBGL)");
			break;
		case 83840:
			System.out.println("ESTA��O: Aeroporto Internacional de Curitiba - PR (83840 SBCT)");
			break;
		case 82599:
			System.out.println("ESTA��O: Aeroporto Internacional Augusto Severo - RN (82599 SBNT");
			break;
		case 83649:
			System.out.println("ESTA��O: Vit�ria - ES (83649)");
			break;
		default:
			System.out.println("ESTA��O: " + LLiii);
			
		}
	}
}

