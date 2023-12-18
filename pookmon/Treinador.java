public class Treinador {
    private String nome;
    private Pokemon[] equipe;
    private int pokemonAtivo;

    public Treinador(String nome, Pokemon[] equipe) {
        this.nome = nome;
        this.equipe = equipe;
        this.pokemonAtivo = 0; // Começa com o primeiro Pokémon da equipe ativo
    }

    public int pokemonsVivos() {
        int count = 0;
        for (Pokemon pokemon : equipe) {
            if (pokemon.getHP() > 0) {
                count++;
            }
        }
        return count;
    }

    public Pokemon getPokemonAtivo() {
        return equipe[pokemonAtivo];
    }

    public String getNome() {
        return nome;
    }
}