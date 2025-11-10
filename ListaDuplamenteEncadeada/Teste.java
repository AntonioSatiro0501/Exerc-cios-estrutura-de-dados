public class Teste {

	public static void main(String[] args) {
        DLL<Integer> lista = new DLL<Integer>();
        DLL<Integer> lista2 = new DLL<Integer>();

        Integer ids1[] = { 5, 2, 15, 7, 35, 77, 81, 15, 12, 115, 17, 135, 177, 181  };
	    
		// Insere o vetor ids1 no final da lista 
		lista.insertListaDecrescente(ids1);
        System.out.print(lista);

    }
}