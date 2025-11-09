public class Teste {

	public static void main(String[] args) {
        DLL<Integer> lista = new DLL<Integer>();
        DLL<Integer> lista2 = new DLL<Integer>();

        int ids1[] = { 5, 2, 15, 7, 35, 77, 81, 15, 12, 115, 17, 135, 177, 181  };
	    
		// Insere o vetor ids1 no final da lista 
		for (int i = 0; i < ids1.length; ++i)
			lista.insertAscending(i, ids1[i]);
		System.out.println(lista.toString());

        for (int i = 0; i < ids1.length; ++i)
			lista2.insertAscending(i, ids1[i]);

        lista.concatena(lista2);
        System.out.println(lista);

    }
}