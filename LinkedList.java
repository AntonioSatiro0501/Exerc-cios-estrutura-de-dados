
public class LinkedList<T> {
	private Node<T> head; 
	private int size; 
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	
	public boolean isEmpty() {
		return getHead() == null;
	}
	
	
	public boolean isFull() {
		Node<T> aux = new Node<T>();
		return aux == null;
	}
	

	public int getSize() {
		return size;
	}


	
	public Node<T> getHead() {
		return head;
	}
	

	public Node<T> get(int pos) {
		if (isEmpty()) return null;
		if (pos <= 0 || pos > size) return null;
		int cont = 1;
		Node<T> pAnda = head;
		while (cont != pos){
			pAnda = pAnda.getProx();
			cont++;
		}
		return pAnda;
	}
   

	public boolean insert(T id, int pos) {
		Node<T> aux; // Ponteiro auxiliar para o novo nó a ser inserido
		Node<T> pAnda; // Ponteiro que anda na lista ligada	
		Node<T> pAnt = null;  // Ponteiro anterior ao que anda
		if (pos <= 0) return false; 
	    if (!isFull()){ 
	      aux = new Node<T>(id, null);
	      if (isEmpty()){ // Insere no começo da lista
	    	  head = aux;
	    	  
	      } else if (pos >= size+1)  { // Caso a posição a iserir seja a última ou superior, insere no final
	    		insertTail(id);
	      } else {// a posição a inserir é no meio da lista
	    	
	    	int cont = 1;
	        pAnda = head; 
	        while (pAnda.getProx() != null && cont != pos){
	           pAnt = pAnda;
	           pAnda = pAnda.getProx();
	           cont++;
	        }
        	aux.setProx(pAnda);
	        if (cont == 1) { // insere no cabeça de lista
	        	head = aux;
	        } else { // insere no meio
	        	pAnt.setProx(aux);
	        }
	      }
		  size++;
		  return true; 
	    }
	    else return false; 
	};
	
	
	public boolean addFirst(T id){
		Node<T> aux; // Ponteiro auxiliar para o novo nó a ser inserido
		
	    if (!isFull()){  
	      aux = new Node<T>(id, null);
	      if (isEmpty()){ // Lista está vazia
	        head = aux;
	      }else { // Insere no começo e atualiza o ponteiro
	      	aux.setProx(head);
	      	head = aux;
	      }
    	  size++;
	      return true; 
	    }
	    else return false;  
	};
	

	public boolean insertHead(T id){
		Node<T> aux; 
	    if (!isFull()){ // se a lista não está cheia
	      aux = new Node<T>(id, null);
	      if (isEmpty()){ // Lista está vazia
	        head = aux;
	      }else { // Insere no começo e atualiza o ponteiro
	      	aux.setProx(head);
	      	head = aux;
	      }
    	  size++;
	      return true; 
	    }
	    else return false; // não há espaço disponível em memória  
	};
	
	
	public boolean insertTail(T id){
		Node<T> aux; 
		Node<T> pAnda; 	
	    if (!isFull()){ // se a lista não está cheia
	      aux = new Node<T>(id, null);
	      if (isEmpty()){ // Lista está vazia
	        head = aux;
	      }else { // Insere no final e atualiza o ponteiro
	        pAnda = head;  // Ponteiro que anda até o final da lista 
	        while (pAnda.getProx() != null)
	           pAnda = pAnda.getProx();
	        pAnda.setProx( aux );
	      }
    	  size++;
		  return true;  
	    }
	    else return false;  
	};
	

	public boolean addLast(T id){
		Node<T> aux; 
		Node<T> pAnda; 
	    if (!isFull()){
	      aux = new Node<T>(id, null);
	      if (isEmpty()){ // Lista está vazia
	        head = aux;
	      }else { 
	        pAnda = head;  // Ponteiro que anda até o final da lista 
	        while (pAnda.getProx() != null)
	           pAnda = pAnda.getProx();
	        pAnda.setProx( aux ); // Insere no final e atualiza o ponteiro
	      }
    	  size++;
		  return true; 
	    }
	    else return false;  
	};
	

	public Node<T> search(T id){
		Node<T> pAnda; 
	    if (isEmpty()) {
			return null; // Lista vazia
	    }else{
	      pAnda = head;
	      // procura a posição do elemento na lista
	      while ((pAnda != null) && (pAnda.getDado().equals(id) != true))
	        pAnda = pAnda.getProx();
	      return pAnda; // Retorna a referência para o elemento	encontrado
	    }
	}
	

	public boolean remove(T id){
		Node<T> pAnda; 		
		Node<T> pAnt = null; 
	    if (isEmpty()) return false; // Se lista vazia, não é possível remover
	    else{  // caso haja elementos na lista
	      pAnda = head;
	      // procura a posição do elemento na lista
	      while ((pAnda != null) && (pAnda.getDado().equals(id) != true)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	      }
	      if (pAnda == null) return false; // Se não encontrou o elemento
	      else { // Se elemento foi encontrado 
	      	// Verifica se está como cabeça da lista e remove
	      	if ((head == pAnda)) {
			  head = pAnda.getProx();
		    } else{ // remove elemento do meio/fim da lista
		    	pAnt.setProx(pAnda.getProx());
			}
	      	pAnda = null;
	    	size--;
	      	return true;    
	      }
	    }
	}
	

	public T pollFirst(){
	    if (isEmpty()) return null; // Se lista vazia, não é possível remover
	    else{  // Remove primeiro elemento da lista e retorna o dado
		  Node<T> pAux = head;
	      head = head.getProx();
    	  size--;
	      return pAux.getDado();
	    }
	}	
	

	public T pollLast(){
	    if (isEmpty()) return null; // Se lista vazia, não é possível remover
	    else{  
		  Node<T> pAnda = head, pAnt = null;
	      // procura o elemento final da lista
	      while ((pAnda.getProx() != null)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	      }  // Remove o elemento e retorna o dado
	      pAnt.setProx(null);
    	  size--;
	      return pAnt.getDado();
	    }
	}	
	
	public void print(){
		Node<T> pAnda; 
	    pAnda = head;
	    while (pAnda != null) {
	      System.out.println(pAnda.getDado());
	      pAnda = pAnda.getProx();
	    }
	}
	

	public void clear(){
		Node<T> pAnt; // Ponteiro anterior ao que anda
		Node<T> pAnda = head;  // Ponteiro que anda na lista original
		// Percorre toda a lista original removendo cada nó percorrido
		while(pAnda != null){
			pAnt = pAnda;  
			pAnda = pAnda.getProx();
			pAnt.setProx(null);
			pAnt = null;
		}
		size = 0;
		head = null; 	 
	}
	


	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int qtde = 0;
		sb.append("\n[Lista]\n");
	
	    sb.append("L: [ ");
	    Node<T> pAnda = head;
	    while (pAnda != null) {
	      sb.append(pAnda.getDado()+" ");
	      qtde++;
	      pAnda = pAnda.getProx();
	    }
	    sb.append("]\n");
	    
	    sb.append("Qtde.: " + qtde);
	    sb.append("\n");
	    
	    return sb.toString();
	}


	public void inverte(){

		if(!isEmpty()){

			if(size > 1){

				Node<T> pAnda = head, ultimo = null, proximo = null;
	      		

				while((pAnda != null)){
					proximo = pAnda.getProx();
					pAnda.setProx(ultimo);
					ultimo = pAnda;
					pAnda = proximo;
				}

				
				this.head = ultimo;
			}
		}


	}

	public void concatena(LinkedList<T> lista){

		if(!isEmpty() || !lista.isEmpty()){

			Node<T> pAnda = head;
			while(pAnda.getProx() != null){
				pAnda = pAnda.getProx();
			}

			pAnda.setProx(lista.head);
			size += lista.getSize();
		}
	}
	
}
