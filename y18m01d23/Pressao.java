
public class Pressao {
	
	private int pressao;
	private int altura;
	public boolean isSupInvalid = true;
	public boolean isPadInvalid = true;
	public boolean isTropInvalid = true;
	public boolean isMoreTrop = true;
	public boolean isMoreVentoMax = true;
	public boolean isVentoMaxInvalid =true;
	private String errorMessage = "Código inválido. Verifique o código e tente novamente.";
	
	public void padrao (String pphhh) {
		
		char[] pphhhDigitos = pphhh.toCharArray();

		if (pphhh.matches("^[0-9]*$") && pphhhDigitos.length == 5) { // verifica se o código tá nos conformes	
			// PADRÃO!
				
			isPadInvalid = false;
			String pressaoStr = pphhhDigitos[0] + "" + pphhhDigitos[1];
			String alturaStr = pphhhDigitos[2] + "" + pphhhDigitos[3] + "" + pphhhDigitos[4];
			pressao = Integer.parseInt(pressaoStr);
			altura = Integer.parseInt(alturaStr);

			// o codigo de pressao é muito doido
			if (pressao == 92) {
				pressao = 925;
			} else if (pressao == 00) {
					pressao = 1000;
			} else {
				pressao *= 10;
			}
			
			if (pressao == 1000 || pressao == 925) {
				altura = altura;
			}
			else if (pressao == 850) {
					altura += 1000;
			} else if (pressao == 700) {
				altura += 3000;
			} else if (pressao < 700 && pressao >= 300) {
				altura *= 10;
			} else if (pressao < 300 && pressao >= 70) {
				altura = altura * 10 + 10000;
			} else if (pressao < 70 && pressao >= 20) {
				altura = altura * 10 + 20000;
			} else {
				altura = altura * 10 + 30000;
			}
			
			System.out.println("PRESSÃO: " + pressao + " hPa" );
		System.out.println("ALTURA GEOPOTENCIAL: " + altura + " m");
							
		}
		else {
			System.out.println(errorMessage);
		}
	}
		
	
	public void superficie (String nnppp) {
			
			char [] nnpppDigitos = nnppp.toCharArray();
			
			if (nnppp.matches("^[0-9]*$") && nnpppDigitos.length == 5 && nnpppDigitos[0] == '9' && nnpppDigitos[1] == '9') {
				 // Pressão na superfície!
				
				isSupInvalid = false;
				String pressaosupStr = nnpppDigitos[2] + "" + nnpppDigitos[3] + "" + nnpppDigitos[4];
				int pressaosupInt = Integer.parseInt(pressaosupStr);
		
				if (pressaosupInt < 51) {
					pressaosupInt += 1000;
				}
				
					System.out.println("PRESSÃO: " + pressaosupInt + " hPa");
			}
			else {
				System.out.println(errorMessage);
			}
	
	}
		
	
	public void tropopausa (String mmppp) { 
		char [] mmpppDigitos = mmppp.toCharArray();
		
		if (mmppp.matches("^[0-9]*$") && mmpppDigitos.length == 5 && 
				mmpppDigitos[2] == '9' && mmpppDigitos[3] == '9' && mmpppDigitos [4] == '9') {
			isTropInvalid = false;
			isMoreTrop = false;
			System.out.println("Nenhuma tropopausa foi identificada na sondagem");
			
		}
		else if (mmppp.matches("^[0-9]*$") && mmpppDigitos.length == 5 && mmpppDigitos[0] == '8' && mmpppDigitos[1] == '8') {
			
			isTropInvalid = false;
			String pressaotropStr = mmpppDigitos[2] + "" + mmpppDigitos[3] + "" + mmpppDigitos[4];
			int pressaotropInt = Integer.parseInt(pressaotropStr);
	
			if (pressaotropInt < 51) {
				pressaotropInt += 1000;
			}
			
				System.out.println("PRESSÃO: " + pressaotropInt + " hPa");
		}
		else {
			System.out.println(errorMessage);
		}
	}

	public void ventoMax (String xxppp) {
char [] xxpppDigitos = xxppp.toCharArray();
		
		if (xxppp.matches("^[0-9]*$") &&xxpppDigitos.length == 5 && 
				xxpppDigitos[2] == '9' && xxpppDigitos[3] == '9' && xxpppDigitos [4] == '9') {
			isVentoMaxInvalid = false;
			isMoreVentoMax = false;
			System.out.println("Nenhum vento máximo foi identificado na sondagem");
			
		}
		else if (xxppp.matches("^[0-9]*$") && xxpppDigitos.length == 5 
				&& ( (xxpppDigitos[0] == '7' && xxpppDigitos[1] == '7')||
				(xxpppDigitos[0] == '6' && xxpppDigitos[1] == '6') ) ) {
			
			isVentoMaxInvalid = false;
			String pressaoVentoMaxStr = xxpppDigitos[2] + "" + xxpppDigitos[3] + "" + xxpppDigitos[4];
			int pressaoVentoMaxInt = Integer.parseInt(pressaoVentoMaxStr);
	
			if (pressaoVentoMaxInt < 51) {
				pressaoVentoMaxInt += 1000;
			}
			
				System.out.println("PRESSÃO: " + pressaoVentoMaxInt + " hPa");
		}
		else {
			System.out.println(errorMessage);
		}
	}
}


