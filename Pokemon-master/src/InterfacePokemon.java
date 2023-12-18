import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InterfacePokemon {
	
	public static void main(String[] args) throws FileNotFoundException {			
		
		Scanner leitura = new Scanner (System.in);
		
		System.out.println("\nPOOkemon\n");
		System.out.println("Bem vindo! Escolha o que voce deseja fazer:");
		System.out.println("1 - Batalha entre treinadores");
		System.out.println("2 - SAIR");
		
		int tipoJogo = leitura.nextInt(); 
		
		if(tipoJogo == 1){
	
			Scanner treinadores = new Scanner(new FileReader("criaTreinadores.txt")).useDelimiter("\\||\\n");

			//1			
			String nome1 = treinadores.next();
			int quantidade = treinadores.nextInt();				
			Pokemon[] listaPokemon1 = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				String nomePok = treinadores.next();
				String tipo = treinadores.next();
				int hp = treinadores.nextInt();
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = treinadores.next();
					int dano = treinadores.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon1[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador jogador1 = new Treinador (nome1, listaPokemon1);
			
			//2
			String nome2 = treinadores.next();
			quantidade = treinadores.nextInt();				
			Pokemon[] listaPokemon2 = new Pokemon[quantidade];
			for (int i = 0; i < quantidade; i++) {
				String nomePok = treinadores.next();
				String tipo = treinadores.next();
				int hp = treinadores.nextInt();
				Ataque[] listaAtk = new Ataque[4];
				for (int j = 0; j < 4; j++) {
					String nomeAtk = treinadores.next();
					int dano = treinadores.nextInt();
					listaAtk[j] = new Ataque(nomeAtk, dano);
				}	
				listaPokemon2[i] = new Pokemon(nomePok, tipo, hp, listaAtk);
			}
			Treinador jogador2 = new Treinador (nome2, listaPokemon2);

			//Batalha entre os dois treinadores
			Batalha comum = new Batalha();
			comum.batalhaComum(jogador1, jogador2);			
		}
		else{
			System.out.println("Obrigado por jogar!");
		}
	}
}