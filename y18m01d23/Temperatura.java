import java.text.NumberFormat;

public class Temperatura {
	public double tempAr;
	public double tempOrv;
	public boolean isTempInvalid = true;
	private String errorMessage = "Código inválido. Verifique o código e tente novamente.";
	
	NumberFormat number = NumberFormat.getCurrencyInstance();
	
	public void mostra (String tttdd) {
		
		char [] tttddDigitos = tttdd.toCharArray();
		
		if (tttdd.matches("^[0-9]*$") && tttddDigitos.length == 5) {
			
			isTempInvalid = false;
			
			String tempArStr = tttddDigitos[0] + "" + tttddDigitos[1];
			String tempDecimalStr = tttddDigitos[2] + "";
			String tempOrvCodigoStr = tttddDigitos[3] + "" + tttddDigitos[4];

			tempAr = Integer.parseInt(tempArStr);
			int tempDecimal = Integer.parseInt(tempDecimalStr);
			int tempOrvCodigo = Integer.parseInt(tempOrvCodigoStr);

			tempAr = tempAr + (tempDecimal * 0.1);

			if (tempDecimal % 2 != 0) { // se essa parte do código for impar, a temperatura do ar é negativa
				tempAr *= -1;
			}

			if (tempOrvCodigo < 51) {
				tempOrvCodigo *= 0.1;

			} else {
				tempOrvCodigo -= 50;
			}

			tempOrv = tempAr - tempOrvCodigo;
			
			System.out.println("TEMPERATURA DO AR: " + tempAr + " °C");
			System.out.println("TEMPERATURA DO PONTO DE ORVALHO: " + tempOrv + " °C");

		}
		else {
			System.out.println(errorMessage);
		}


	}
}

