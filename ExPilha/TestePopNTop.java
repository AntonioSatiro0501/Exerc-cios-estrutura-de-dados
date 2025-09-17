public class TestePopNTop {

    private final static int TAM_PILHA = 200;

    public static void main(String[] args) {
        try {
            PilhaGenerica<Integer> pilha = new PilhaGenerica<Integer>(TAM_PILHA);

            pilha.push(13);
            pilha.push(23);
            pilha.push(35);
            pilha.push(42);
            System.out.println(pilha.sizeElements() + " elementos");

            pilha.popNTop(3);
            System.out.println(pilha.sizeElements() + " elementos");
            System.out.println("Elemento no topo: " + pilha.topo());

            pilha.popNTop(5); 

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
