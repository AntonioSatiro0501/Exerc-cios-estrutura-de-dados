import java.util.Scanner;

public class ExercicioGenerics {

    private final static int TAM_PILHA = 200;

    public static void main(String[] args) {

        PilhaGenerica<Integer> p = new PilhaGenerica<Integer>(TAM_PILHA);
        int n, cont = 0;
        char resp;
        Scanner s = new Scanner(System.in);

        try {

        do {// leitura dos números
            System.out.print("Deseja fornecer um nro (S/N): ");
            resp = s.next().toUpperCase().charAt(0);

            if (resp == 'S') {
                System.out.print("Forneça o "+ ++cont + "o nro: ");
                n = s.nextInt();
                p.push(n);
            }

        } while(( resp == 'S') && (cont < TAM_PILHA));

        PilhaGenerica<Integer> pAuxiliar = new PilhaGenerica<Integer>(TAM_PILHA);

        while (!p.isEmpty()) {
                int valor = p.pop();
                if (!(valor % 3 == 0 && valor % 5 == 0)) {
                    pAuxiliar.push(valor);
                }
            }

        while(!pAuxiliar.isEmpty()){
            p.push(pAuxiliar.pop());
        }

        while(!p.isEmpty()){
            System.out.print(p.pop()+ "\n");
        }

    } catch (Exception e) {
            System.out.println("Erro na pilha: " + e.getMessage()); 
    }
    }
}