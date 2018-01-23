import java.util.Scanner;

public class TTAA {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		
		Scanner scanner = new Scanner(System.in);
		Id id = new Id ();
		Pressao pressao = new Pressao();
		Temperatura temp = new Temperatura();
		Vento vento = new Vento();
		
		String ansMessage = "Há mais algum código nessa seção? (Digite S para sim e N para não)";

		System.out.println("Bem vindo ao decodificador de código TEMP - Versão BETA y18m01d23");
		System.out.println();
		System.out.println("TTAA");
		System.out.println();
		
		//IDENTIFICAÇÃO E LOCALIZAÇÃO ------------------------------------------------------------------
		System.out.println("SEÇÃO 1 - Identificação e localização: ");
		System.out.println();
		do {
			id.identificacao(scanner.nextLine());
			System.out.println();
		}while(id.isValueInvalid);
		vento.ventoEmKt = id.ventoEmKt;
		id.localizacao(scanner.nextLine());
		System.out.println();
		
		//SUPERFÍCIE ------------------------------------------------------------------
		System.out.println("SEÇÃO 2 - Superfície: ");
		System.out.println();
		do{
			
			pressao.superficie(scanner.nextLine());
			System.out.println();
		
		}while (pressao.isSupInvalid);
		
		do {
			
			temp.mostra(scanner.nextLine());
			System.out.println();
		}while(temp.isTempInvalid);
		
		do {
			vento.mostra(scanner.nextLine());
			System.out.println();
		}while(vento.isVentoInvalid);
		
		//PADRÕES ------------------------------------------------------------------
		System.out.println("SEÇÃO 2 - Níveis padrões (além da superfície): ");
		System.out.println();
		
		int niveis = 10;
		int repete = 0;
		boolean ultimoNivel = true;
		
		if (id.Id == 2) {
			niveis = 8;
		}
		
		while (repete <= niveis && ultimoNivel) {
			
			pressao.isPadInvalid = true;
			while(pressao.isPadInvalid) {	
				pressao.padrao(scanner.nextLine());
				System.out.println();
			}
			
			temp.isTempInvalid = true;
			while(temp.isTempInvalid) {
				temp.mostra(scanner.nextLine());
				System.out.println();
			}
			
			vento.isVentoInvalid = true;
			while (vento.isVentoInvalid) {
				vento.mostra(scanner.nextLine());
				System.out.println();
			}
			if (niveis == 10) {
				if(repete == 9 ) {
					System.out.println(ansMessage);
					char resposta = scanner.findWithinHorizon(".", 0).charAt(0);
					if (resposta == 'n' || resposta == 'N') {
						ultimoNivel = false;
						scanner.nextLine();
					}
					else {
						scanner.nextLine();
					}
				}
			} 
			else {
				
				if (repete == 7) {
					System.out.println(ansMessage);
					char resposta = scanner.findWithinHorizon(".", 0).charAt(0);
					if (resposta == 'n' || resposta == 'N') {
						ultimoNivel = false;
						scanner.nextLine();
					}
					else {
						scanner.nextLine();
					}
				}
			}
			
			
			repete++;
		}
		
		
		//TROPOPAUSAS ------------------------------------------------------------------
		System.out.println();
		System.out.println("SEÇÃO 3 - Tropopausas: ");
		System.out.println();
		
		while(pressao.isMoreTrop) {
			pressao.isTropInvalid = true;
			while (pressao.isTropInvalid) {
				pressao.tropopausa(scanner.nextLine());
				System.out.println();
			}
			if (pressao.isMoreTrop) {
				
				temp.isTempInvalid = true;
				while(temp.isTempInvalid) {
					temp.mostra(scanner.nextLine());
					System.out.println();
				}
				
				vento.isVentoInvalid = true;
				while(vento.isVentoInvalid) {
					vento.mostra(scanner.nextLine());
					System.out.println();
				}
				
				System.out.println(ansMessage);
				if (scanner.findWithinHorizon(".", 0).charAt(0) == 'N' || scanner.findWithinHorizon(".", 0).charAt(0) == 'n' ) {
					pressao.isMoreTrop = false;
					scanner.nextLine();
				}
				else {
					scanner.nextLine();
				}
			}
		}
		//VENTO MÁXIMO ------------------------------------------------------------------
		System.out.println();
		System.out.println("SEÇÃO 4 - Ventos Máximos");
		System.out.println();
		pressao.isVentoMaxInvalid = true;
		while(pressao.isMoreVentoMax) {
			while (pressao.isVentoMaxInvalid) {
				pressao.ventoMax(scanner.nextLine());
				System.out.println();
			}
			if (pressao.isMoreVentoMax) {
				
				vento.isVentoInvalid = true;
				while(vento.isVentoInvalid) {
					vento.mostra(scanner.nextLine());
					System.out.println();
				}
				System.out.println(ansMessage);
				if (scanner.findWithinHorizon(".", 0).charAt(0) == 'N' || scanner.findWithinHorizon(".", 0).charAt(0) == 'n' ) {
					pressao.isMoreVentoMax = false;
					scanner.nextLine();
				}
				else {
					scanner.nextLine();
				}
			}
		}
		
		System.out.println("Obrigado por usar o decodificador de código TEMP - Versão BETA y18m01d23");
	}

}
