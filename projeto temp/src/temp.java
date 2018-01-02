
public class temp {

	public String pphhh;
	public int pressao;
	public int altura;

	public String tttdd;
	public double tempAr;
	public double tempOrv;

	public String ddfff;
	public int direcao;
	public int velocidade;

	public String pressao(String pphhh) {

		char[] pphhhDigitos = pphhh.toCharArray();

		if (pphhh.matches("^[0-9]*$") && pphhhDigitos.length == 5 && pphhhDigitos[0] == '9' && pphhhDigitos[1] == '9') {
			// Pressão na superfície!

			String pressaosupStr = pphhhDigitos[2] + "" + pphhhDigitos[3] + "" + pphhhDigitos[4];
			int pressaosupInt = Integer.parseInt(pressaosupStr);

			if (pressaosupInt < 51) {
				pressaosupInt += 1000;
			}

			pressao = pressaosupInt;
			altura = 000;
		} else if (pphhh.matches("^[0-9]*$") && pphhhDigitos.length == 5) { // verifica se o código tá nos conformes
			// PADRÃO!

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
			} else if (pressao == 850) {
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
		}

		// cria uma mensagem e retorna
		String pphhhMensagem = "Pressão: " + pressao + " hPa" + "\n" + "Altura Geopotencial: " + altura + " m";
		return pphhhMensagem;
	}

	public String temperatura(String tttdd) {

		char[] tttddDigitos = tttdd.toCharArray();

		if (tttdd.matches("^[0-9]*$") && tttddDigitos.length == 5) {

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

		}

		String tttddMensagem = "Temperatura do ar: " + tempAr + " °C" + "\n" + "Temperatura do ponto de orvalho: "
				+ tempOrv + " °C";
		return tttddMensagem;

	}
	
	public String vento (String ddfff) {
		
		char[] ddfffDigitos = ddfff.toCharArray();
		
		if (ddfff.matches("^[0-9]*$") && ddfff.length() == 5);
		
		String direcaoStr = ddfffDigitos[0] + "" + ddfffDigitos[1] + "" + ddfffDigitos[2];
		String velocidadeStr = ddfffDigitos[3] + "" + ddfffDigitos[4];
		String direcaoUltimoDigitoStr = ddfffDigitos[2] + "";
		
		direcao = Integer.parseInt(direcaoStr);
		velocidade = Integer.parseInt(velocidadeStr);
		int direcaoUltimoDigito = Integer.parseInt(direcaoUltimoDigitoStr);
		
		if (direcaoUltimoDigito > 0 && direcaoUltimoDigito < 5) {
			direcao -= direcaoUltimoDigito;
			velocidade = velocidade + (direcaoUltimoDigito * 100);
		}
		else if (direcaoUltimoDigito > 5) {
			direcao = direcao - direcaoUltimoDigito + 5;
			velocidade = velocidade + (direcaoUltimoDigito - 5 *100);
		}
		
		String ddfffMensagem = "Direção do vento: " + direcao + "°" + "\n" + "Velocidade do vento: " + velocidade;
		return ddfffMensagem;
		
	}
}
