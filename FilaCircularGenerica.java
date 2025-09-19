public class FilaCircularGenerica <T>{
	// Constante e Atributos Privados
	private static final int TAM_DEFAULT = 100;
	private int inicio, fim, qtde;
	private T e[ ];
	// Métodos públicos
	public FilaCircularGenerica(int tamanho) {// construtor 1 (com tamanho)
		  this.inicio = this.fim = this.qtde = 0;
		  e = (T[]) new Object[tamanho];
	}
	
	public FilaCircularGenerica() {  // construtor 2 (sem parâmetros).
		this(TAM_DEFAULT);
	}

	// verifica se a fila está vazia
	public boolean qIsEmpty() {
		return (qtde == 0);
	}
	
	// Verifica se a fila está cheia
    public boolean qIsFull() {
    	return (qtde == e.length); 	
    }
    
    // insere um elemento no final da fila
	public void enqueue(T e) throws Exception {
		if (! qIsFull( )){
			    this.e[this.fim++] = e;
			    this.fim = this.fim % this.e.length;
			    this.qtde++;
		}
		else 
			throw new Exception("Oveflow - Estouro de Fila");	
	}
	// remove um elemento do final da fila
    public T dequeue() throws Exception {
    	  T aux;
    	  if (! qIsEmpty( )){
    	   aux =  this.e[ this.inicio];
    	   this.inicio = ++this.inicio % this.e.length;
    	   this.qtde--;
    	   return aux;
    	  }else{
    		  throw new Exception("underflow - Esvaziamento de Fila");
    	  }
    }
    // retorna quem está no início da fila
    // caso a fila não esteja vazia
	public T front() throws Exception {
		if (! qIsEmpty())
			return e[inicio];
		else{
			throw new Exception("underflow - Esvaziamento de Fila");
		}			
	}
	// retorna quem está no final da fila caso ela não esteja vazia
	public T rear() throws Exception {
		if (! qIsEmpty()){
			  int pfinal;
			  if (this.fim != 0) pfinal = this.fim - 1;
			  else pfinal = this.e.length - 1;
			  return this.e[pfinal];
		}else{
			  throw new Exception("underflow - Esvaziamento de Fila");
		}			
	}
	// Retorna o total de elementos da fila
	public	int totalElementos(){
		return qtde;
	}

   public void invert(){
    if(!qIsEmpty()){
        int fimReal = (inicio + totalElementos() - 1) % e.length;
        invertAuxilia(inicio, fimReal);
        }
    }

    public void invertAuxilia(int inicio, int fim){
        if(inicio != fim && (fim + 1) % e.length != inicio){
            T auxilio = e[inicio];
            e[inicio] = e[fim];
            e[fim] = auxilio;

            inicio = (inicio + 1) % e.length;
            fim = (fim - 1 + e.length) % e.length;

            invertAuxilia(inicio, fim);
        }
    }

	public void dequeuePosOdd() throws Exception{
    	int n = totalElementos();
    	int count = 0;

    	while (count < n) {
        	if (inicio % 2 != 0) {
            	dequeue();
        	} else {
            	inicio = (inicio + 1) % e.length;
        	}
        	count++;
    	}
	}

	public void dequeuePosEven() throws Exception{
		int n = totalElementos();
    	int count = 0;

    	while (count < n) {
        	if (inicio % 2 == 0) {
            	dequeue();
        	} else {
            	inicio = (inicio + 1) % e.length;
        	}
        	count++;
    	}
	}

	public void dequeueNFirst(int n) throws Exception{

		if(n <= totalElementos()){
			while(n > 0){
				dequeue();
				n -=1;
			}
		}
	}

	public void dequeueNLast(int n) throws Exception{
		if (n > totalElementos()) {
        	throw new Exception("Tentativa de remover mais elementos do que existem na fila.");
    	}

		invert();
		dequeueNFirst(n);
		invert();
	}
}