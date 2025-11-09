
public class DLL<T> {
	private	Node2<T> head;
	private int size;
	
	
	public DLL(){
		this.head = null;
		this.size = 0;
	}
	
	public boolean isEmpty() { // Verifica se DLL está vazia
		return head == null;
	}

	
	public boolean isFull() {
		Node2<T> aux = new Node2<T>();
		return aux == null;
	}
	

	public int getSize() { return size; }
	
	

	public Node2<T> getHead() { return head; }
	
	
	public void showAscending(){
		// Percorre a lista e imprime os valores
		// em ordem Crescente
		if (isEmpty()) System.out.print( "Lista vazia!\n");
		else{
			System.out.print( "Lista: [ ");
			Node2<T> pAnda = this.head;
			while (pAnda.getRight() != this.head){
				System.out.print( pAnda.getData());
				pAnda= pAnda.getRight();
			}
			System.out.print( pAnda.getData() +"]");
		}
	}
	

	public void showDescending(){
		// Percorre a lista e imprime os valores
		// em ordem decrescente
		if (isEmpty()) System.out.print( "Lista vazia!\n" );
		else{
			System.out.print( "Lista: [ " );
			Node2<T> pAnda = this.head;
			while (pAnda.getLeft() != this.head){
				pAnda= pAnda.getLeft();
				System.out.print( pAnda.getData() );
			}
			System.out.print( pAnda.getLeft().getData() + "]");
		}
	}

	
	public boolean insertAscending(int Key, T data){
		if (isFull()) return false;
		
		// Cria um novo no
		Node2<T> novoNo = new Node2<T>(Key, data, null, null);

		// se lista vazia, insere o nó no ponteiro cabeça
		// e faz o nó apontar para ele mesmo
		if (isEmpty()) {
			this.head = novoNo;
			novoNo.setRight(novoNo);
			novoNo.setLeft(novoNo);
		} else { 
		    // Caso contrário, procura posição de inserção
		    // na ordem crescente de valores
			Node2<T> pAnda = this.head, pAnt = null;
			while (pAnda.getRight() != head && pAnda.getKey() < Key){
					pAnt = pAnda;
					pAnda = pAnda.getRight();
			}	
			// Se não andou na lista e a Key que pAnda aponta
		    // é maior que a Key a ser inserida, significa que a Key
			// a ser inserida é antes do cabeça
			// e cabeça precisa ser redefinido
			if (pAnt == null && pAnda.getKey() > Key){
				novoNo.setLeft(this.head.getLeft());
				this.head.getLeft().setRight(novoNo);
				this.head.setLeft(novoNo);
				novoNo.setRight(this.head);
				this.head = novoNo;
			} else {
				// Caso pAnda tenha caminhado na lista e
				// a Key que o pAnda aponta é maior do que a Key a ser inserido
				// insere o nó depois do ponteiro anterior pAnt
			 	if (pAnda.getKey() > Key && pAnt != null) {	 
					pAnt.getRight().setLeft(novoNo);
					novoNo.setRight(pAnda);
					pAnt.setRight(novoNo);
					novoNo.setLeft(pAnt);
				} else {// Senão, insere a Key depois do pAnda
			    	pAnda.getRight().setLeft(novoNo);
					novoNo.setRight(pAnda.getRight());
					pAnda.setRight(novoNo);
					novoNo.setLeft(pAnda);
				}
			}
		}
		this.size++;
		return true;
	}	
	

	public Node2<T> search(int Key){
			// Lista vazia
		if (isEmpty()) return null;
		
		// Procura o elemento 
		Node2<T> pAnda = this.head;
		while (pAnda.getRight() != this.head && pAnda.getKey() != Key){
			pAnda = pAnda.getRight();
		}
		
		if (pAnda.getRight() == this.head && pAnda.getKey() != Key){// elemento não encontrado
			return null;
		} else { // elemento encontrado
			return pAnda;
		}
	}
	

	public Node2<T> get(int pos){
	   if (isEmpty()) return null;
	   if (pos <= 0 || pos > size) return null;
	   int cont = 1;
	   Node2<T> pAnda = head;
	   while (cont != pos){
		pAnda = pAnda.getRight();
		cont++;
	   }
	   return pAnda; 
	}
	// clear(): limpa a lista ligada original, deixando-a vazia
	public void clear(){
	   Node2<T> pAnt, pAnda = head;
	   int total = size;
	   int cont = 0;
	   while(cont != total){
		pAnt = pAnda; // Libera o nó
		pAnda = pAnda.getRight();
		pAnt.setRight(null);
		pAnt.setLeft(null);
		pAnt = null;
	   }
	   size = 0;
	   head = null; 
	}

	
	public boolean remove(int Key) {
		// Lista vazia
		if (isEmpty()) return false;
		
		// Procura o elemento a ser removido
		Node2<T> pAnda = this.head, pAnt = null;
		while (pAnda.getRight() != this.head && pAnda.getKey() != Key){
			pAnt = pAnda;
			pAnda = pAnda.getRight();
		}
		
		if (pAnda.getRight() == this.head && pAnda.getKey() != Key){// elemento não encontrado
			return false;
		} else {
			// elemento encontrado no cabeça
			if (pAnt == null && pAnda.getKey() == Key){
				pAnda.getLeft().setRight(pAnda.getRight());
				this.head = this.head.getRight();
				this.head.setLeft(pAnda.getLeft());
				pAnda.setLeft(null);
				pAnda.setRight(null);
			} else { // elemento encontra-se no meio da lista
			    pAnt.setRight(pAnda.getRight());
			    pAnda.getRight().setLeft(pAnt);
			    pAnda.setLeft(null);
			    pAnda.setRight(null);
			}
			pAnda = null;
			this.size--;
			return true;
		}
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int qtde = 0;
		sb.append("\n[Lista]\n");
	
	    sb.append("L: [ ");
	    Node2<T> pAnda = head;
	    while (qtde != size) {
	      sb.append(pAnda.getData());
	      qtde++;
	      pAnda = pAnda.getRight();
	    }
	    sb.append("]\n");
	    
	    sb.append("Qtde.: " + size);
	    sb.append("");	    
	    return sb.toString();
	}

	public void inverte(){
		if(!isEmpty()){
			if(size > 1){


				Node2<T> pAnda = head;
				Node2<T> aux = pAnda.getRight();
				
				pAnda.setRight(pAnda.getLeft());
				pAnda.setLeft(aux);

				pAnda = aux;
				aux = aux.getRight();

				while(pAnda != head){
					pAnda.setRight(pAnda.getLeft());
					pAnda.setLeft(aux);
					pAnda = aux;
					aux = aux.getRight();
				}

				head = pAnda.getRight();
			}
		}

	}
	
}
