import java.util.Scanner;

public class Ex1Deque {

    public static void main(String[] args){

        DequeGenerico<Character>  D = new DequeGenerico<Character>();
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escreva a frase: ");
        String frase = entrada.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            try {
            D.enqueueLeft(frase.charAt(i));
            } catch(Exception e) {
                System.out.print("Erro");
            }
        }

        int n = D.totalElementos();

        for (int i = 0; i < n; i++){
            try{
            System.out.print(D.dequeueLeft());
            } catch (Exception e) {
                System.out.print("Erro");
            }
        }
    
    }
}