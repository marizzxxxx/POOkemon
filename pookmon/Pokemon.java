public class Pokemon {
    private String nome;
    private String tipo;
    private int hp;
    private Ataque[] listaAtaques;

    public Pokemon(String nome, String tipo, int hp, Ataque[] listaAtaques) {
        this.nome = nome;
        this.tipo = tipo;
        this.hp = hp;
        this.listaAtaques = listaAtaques;
    }

    public void receberDano(int dano) {
        hp -= dano;
        if (hp < 0) {
            hp = 0;
        }
    }

    public int getHP() {
        return hp;
    }

    public Ataque[] getListaAtaques() {
        return listaAtaques;
    }

    public String getNome() {
        return nome;
    }
}
