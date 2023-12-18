import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Batalha extends Controller {

	public void batalhaComum (Treinador jogador1, Treinador jogador2) throws FileNotFoundException {	
		System.out.println("");
		Scanner leitura = new Scanner(System.in);
		System.out.println(jogador1.getNome() + " x " + jogador2.getNome());
		while (jogador1.temPokemonVivo() && jogador2.temPokemonVivo()){
			Batalha simulacao = new Batalha();
			int opcao;

			//1
			System.out.println("O que o treinador " + jogador1.getNome() + " deseja fazer?");
			System.out.println("1 - Atacar\n");
			opcao = leitura.nextInt();			
			if (opcao == 1) {
				System.out.println("Escolha o ataque: ");
				Pokemon aux = jogador1.getPokemonAtual();
				aux.imprimeAtaques();
				opcao = leitura.nextInt();
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar (tm, jogador1, jogador2, opcao));
			}
			
			//2
			System.out.println("\nO que o treinador " + jogador2.getNome() + " deseja fazer?");
			System.out.println("1 - Atacar\n");
			opcao = leitura.nextInt();
			if (opcao == 1) {
				System.out.println("Escolha o ataque: ");
				Pokemon aux = jogador2.getPokemonAtual();
				aux.imprimeAtaques();
				opcao = leitura.nextInt();
				long tm = System.currentTimeMillis();
				simulacao.addEvent (new Atacar (tm, jogador2, jogador1, opcao));
			}

			simulacao.run();
		}		
	}
	
	//Evento: Treinador ataca outro
	public class Atacar extends Event {
		private Treinador quemAtaca;
		private Treinador alvo;
		private int ataque;
		public 	Atacar(long eventTime, Treinador quemAtaca, Treinador alvo, int ataque) {
			super(eventTime);
			this.quemAtaca = quemAtaca;
			this.alvo = alvo;
			this.ataque = ataque;
		}
		public void action() {
			Pokemon aux = alvo.getPokemonAtual();
			double k = quemAtaca.getPokemonAtual().vantagem(aux);
			if (aux.estaVivo()) {
				aux.diminuiHP(k * quemAtaca.getDanoAtual(ataque));
				System.out.println(quemAtaca.getNome() + " decidiu atacar:");
				System.out.println(quemAtaca.getPokemonAtual().getNome() + 
						" usou " + quemAtaca.getAtaqueAtual(ataque) + "!");	
				if (k == 0)
					System.out.println("O ataque não surtiu efeito.");
				else if (k == 0.5)
					System.out.println("O ataque não foi muito efetivo.");
				else if (k == 2)
					System.out.println("O ataque foi muito efetivo!");
			}	
			if (aux.estaVivo()){				
				System.out.println(aux.getNome() + " agora tem " + alvo.getPokemonAtual().getHp() + "HP.\n");
			}
			else {
				
				System.out.println(aux.getNome() + " foi derrotado.");
			}
				
		}
		@Override
		public int prioridade() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public boolean treinadorDerrotado() {
			// TODO Auto-generated method stub
			return false;
		}
	}
}