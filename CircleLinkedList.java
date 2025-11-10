
public class CircleLinkedList<T> {
	private Node<T> head; 
	private Node<T> tail;  
	private int size; 
	

	public CircleLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	
	public Node<T> getHead() {
		return head;
	}
	
	
	public Node<T> getTail() {
		return tail;
	}
	

	public boolean isEmpty() {
		return head == null;
	}
	

	public boolean isFull() {
		Node<T> aux = new Node<T>();
		return aux == null;
	}
	

	public int getSize() {
		return size;
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
	

	public boolean insertTail(T data){
		Node<T> aux;
	    if (!isFull()){ // Não há espaço de memória
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia insere no cabeça
	    	aux.setProx(head);
	        head = tail = aux;
	      }else { // Insere no final e atualiza os ponteiros
	    	tail.setProx(aux);
	    	aux.setProx(head);
	    	tail = aux;
	      }
	      size++;
		  return true;
	    }
	    else return false; 
	};
	

	public boolean addFirst(T data){
		Node<T> aux;
	    if (!isFull()){
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia
			head = tail = aux;
		    aux.setProx(head);
	      }else { // Insere no começo e atualiza os ponteiros
	      	aux.setProx(head);
	      	head = aux;
	      	tail.setProx(head);
	      }
	      size++;
	      return true;
	    }
	    else return false; 
	};
	

	public boolean addLast(T data){
		Node<T> aux;
	    if (!isFull()){ // Não há espaço de memória
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia insere no cabeça
	    	aux.setProx(head);
	        head = tail = aux;
	      }else { // Insere no final e atualiza os ponteiros
	    	tail.setProx(aux);
	    	aux.setProx(head);
	    	tail = aux;
	      }
	      size++;
		  return true;
	    }
	    else return false; 
	};
	

	public boolean insertHead(T data){
		Node<T> aux;
	    if (!isFull()){
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Lista está vazia
			head = tail = aux;
		    aux.setProx(head);
	      }else { // Insere no começo e atualiza os ponteiros
	      	aux.setProx(head);
	      	head = aux;
	      	tail.setProx(head);
	      }
	      size++;
	      return true;
	    }
	    else return false; 
	};
	
   
	public boolean insert(T data, int pos) {
		Node<T> aux; 
		Node<T> pAnda; 
		Node<T> pAnt = null;  
		if (pos <= 0) return false; // Se posição inválida, não insere e retorna
	    if (!isFull()){ // se há memória disponível
	      aux = new Node<T>(data, null);
	      if (isEmpty()){ // Insere no começo da lista
	    	  head = tail = aux;
	    	  // Caso a posição a iserir seja a última ou superior, insere no final
	      } else if (pos >= size+1) {
	    		insertTail(data);
	      } else {// a posição a inserir é no meio da lista
	    	// Procura a posição de inserção
	    	int cont = 1;
	        pAnda = head;  // Ponteiro que anda até a posição de inserção 
            // Procura a posição de inserção  
	        while (cont != pos){
	           pAnt = pAnda;
	           pAnda = pAnda.getProx();
	           cont++;
	        }
        	aux.setProx(pAnda);
	        if (cont == 1) { // insere no cabeça de lista
	        	head = aux;
	        	tail.setProx(head);
	        } else { // insere no meio
	        	pAnt.setProx(aux);
	        }
	      }
		  size++;
		  return true; 
	    }
	    else return false; 
	};
	

	public Node<T> search(T data){
		Node<T> pAnda;
		
	    if (isEmpty()) {
			return null; // Lista vazia
	    }else{
	      pAnda = head;
	      // procura a posição do elemento na lista
	      while ((pAnda.getProx() != head) && (pAnda.getDado().equals(data) != true))
	        pAnda = pAnda.getProx();
	      if (pAnda.getDado().equals(data))
	    	  return pAnda; // Retorna a referência para o No 
	      return null; // elemento não encontrado
	    }
	}
	

	public void print(){
		Node<T> pAnda; 
	    if (!isEmpty()) {
	    	pAnda = head;
	    	System.out.print("[ ");
	    	while (pAnda.getProx() != head) {
	    		System.out.println(pAnda.getDado()+" ");
	    		pAnda = pAnda.getProx();
	    	}
	    	System.out.println(pAnda.getDado()+" ");
	    }
	    System.out.print("], Qtde.: " + size + ".\n");
	}
	

	public void clear(){
		Node<T> pAnt, pAnda = head;
		
		while(pAnda.getProx() != head){
			pAnt = pAnda;  // Libera o nó
			pAnda = pAnda.getProx();
			pAnt.setProx(null);
			pAnt = null;
		}
		size = 0;
		tail = head = null;	
	}
	
	

	public boolean remove(T data){
		Node<T> pAnda; 
		Node<T> pAnt = null; 
	    if (isEmpty()) return false; // Se lista vazia, não é possível remover
	    else{  // caso haja elementos na lista
	      pAnda = head;
	      // procura a posição do elemento na lista
	      int contador = 1;
	      while ((contador != size) && (pAnda.getDado().equals(data) != true)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	        contador++;
	      }
	      if ((contador == size) && (pAnda.getDado().equals(data) != true))
	    	  return false; // Se não encontrou o elemento
	      else { // Se elemento foi encontrado 
	      	// se tem somente um elemento na lista
	    	if (size == 1) {
	    		head = tail = null;
	    	   // Verifica se está como cabeça da lista e remove
	    	   // e tem mais de um elemento
	    	} else if ((head == pAnda)) {
			    head = pAnda.getProx();
		        tail.setProx(head);
		    } else { // remove elemento do meio/fim da lista
		    	// Se o elemento estiver no fim
		    	if (pAnda == tail)
		    		tail = pAnt; // Atualiza o fim
		    	pAnt.setProx(pAnda.getProx());
			}
    		pAnda.setProx(null);
	      	pAnda = pAnt = null;
	    	size--;
	      	return true;    // remoção realizado como sucesso
	      }
	    }
	}
	

	public T pollFirst(){
	    if (isEmpty()) return null; // Se lista vazia, não é possível remover
	    else{  // Remove primeiro elemento da lista e retorna o dado
		  Node<T> pAux = head;
		  if (size == 1) { // caso haja somente um elemento na lista
			  head = tail = null;
		  } else { // há mais de um elemento na lista
			  head = head.getProx();
			  tail.setProx(head);
		  }
    	  size--;
	      return pAux.getDado();
	    }
	}	
	

	public T pollLast(){
	    if (isEmpty()) return null; // Se lista vazia, não é possível remover
	    else{  
		  Node<T> pAnda = head, pAnt = null;
	      // procura o elemento final da lista
		  int contador = 1;
	      while ((contador != size)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	        contador++;
	      }  // Remove o elemento e retorna o dado
	      if (size == 1) {
	    	  head = tail = null;
	      } else {
	    	  tail = pAnt;
	    	  pAnt.setProx(pAnda.getProx());
	      }
    	  size--;
	      return pAnda.getDado();
	    }
	}	

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int qtde = 0;

	    sb.append("L: [ ");
	    Node<T> pAnda = head;
	    while (qtde != size) {
	      sb.append(pAnda.getDado()+" ");
	      qtde++;
	      pAnda = pAnda.getProx();
	    }
	    sb.append("]\n");
	    
	    sb.append("Qtde.: " + size);
	    if (size != 0) {
	    	sb.append("\nPrimeiro: " + head.getDado() + 
	    			", Ultimo: " + tail.getDado());
	    }
    
	    return sb.toString();
	}
	

	public void inverte(){

		if(!isEmpty()){

			if(size > 1){

				Node<T> pAnda = head, pAnt = tail, proximo;

				proximo = pAnda.getProx();
				pAnda.setProx(pAnt);
				pAnt = pAnda;
				pAnda = proximo;

				while(pAnda != head){
					proximo = pAnda.getProx();
					pAnda.setProx(pAnt);
					pAnt = pAnda;
					pAnda = proximo;
				}

				this.head = pAnt;
				this.tail = pAnda;

			}
		}
	}

	public void concatena(CircleLinkedList<T> lista){

		if(!isEmpty() || !lista.isEmpty()){

			tail.setProx(lista.head);
			lista.tail.setProx(head);
			tail = lista.tail;
			size += lista.getSize();

		}
	}

	public void merge(CircleLinkedList<T> lista){

		if(!isEmpty() || !lista.isEmpty()){

			Node<T> pAndaPrimeira = head, pAndaSegunda = lista.head;
			while(pAndaPrimeira.getProx() != head && pAndaSegunda.getProx() != lista.head){
				Node<T> aux1 = pAndaPrimeira.getProx(), aux2 = pAndaSegunda.getProx();

				pAndaPrimeira.setProx(pAndaSegunda);
				if(!(aux1 == head)){
					pAndaSegunda.setProx(aux1);
				}

				pAndaPrimeira = aux1;
				pAndaSegunda = aux2;
			}

			

			if(size > lista.size){
				Node<T> aux = pAndaPrimeira.getProx();
				pAndaPrimeira.setProx(pAndaSegunda);
				pAndaSegunda.setProx(aux);
				tail.setProx(head);
			}
			else if(size == lista.size){
				pAndaPrimeira.setProx(pAndaSegunda);
				pAndaSegunda.setProx(head);
				tail = pAndaSegunda;
			}
			else{
				pAndaPrimeira.setProx(pAndaSegunda);
				lista.tail.setProx(head);
				tail = lista.tail;
			}
			
			size += lista.getSize();
		}
	}
}
