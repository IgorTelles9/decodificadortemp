
public class Vento {
	public int direcao;
	public int velocidade;
	public boolean isVentoInvalid = true;
	public boolean ventoEmKt;
	private String errorMessage = "Código inválido. Verifique o código e tente novamente.";
	
	public void mostra (String ddfff) {
		
		char[] ddfffDigitos = ddfff.toCharArray();

		if (ddfff.matches("^[0-9]*$") && ddfff.length() == 5) {
			
			isVentoInvalid = false;
			
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
				velocidade = velocidade + ((direcaoUltimoDigito - 5) *100);
			}
			
			System.out.println("DIREÇÃO DO VENTO: " + direcao + " °");
			System.out.print("VELOCIDADE DO VENTO: " + velocidade);
			if(ventoEmKt) {
				System.out.println(" KT");
			}
			else {
				System.out.println(" m/s");
			}
			
		}
		else {
			System.out.println(errorMessage);
		}
	}
}
