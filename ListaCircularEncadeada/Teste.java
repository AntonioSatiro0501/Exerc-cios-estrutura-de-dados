public class Teste {

	public static void main(String[] args) {
        CircleLinkedList<Integer> lista = new CircleLinkedList<Integer>();
        CircleLinkedList<Integer> lista2 = new CircleLinkedList<Integer>();

        int ids1[] = { 5, 2, 15, 7, 35, 77, 81, 15, 12, 115, 17, 135, 177, 181  };
	    
		// Insere o vetor ids1 no final da lista 
		for (int i = 0; i < ids1.length ; ++i)
			lista.insertTail(ids1[i]);
		
	    
        lista.removeParImpar(2);

        System.out.println(lista);
        System.out.println(lista.getSize());
    }
}