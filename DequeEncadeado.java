public class DequeEncadeado<T>{
    private static int size = 1000;
    private Node<T> head;
    private Node<T> tail;


    public DequeEncadeado(){
        this.head = null;
        this.tail = null;
    }

    public boolean qIsEmpty(){

        return(this.head == null);

    }

    public boolean qIsFull(){

        int countador = 0;
        Node<T> varre = head;
        while(varre.getProx() != null){
            varre = varre.getProx();
            countador += 1;
        }

        if(countador == size - 1){
            return true;
        }
        else{
            return false;
        }

    }

    public void enqueueRight(T data) throws Exception{

        if(qIsFull()){
            throw new Exception("Overflow- Fila cheia");
        }

        if(qIsEmpty()){

            Node<T> aux = new Node<T>(data, null);
            head = aux;
            tail = aux;
        }
        else{
            Node<T> pAnda = tail, aux = new Node<T>(data, null);
            pAnda.setProx(aux);
            tail = aux;
        }
    }

    public void enqueueLeft(T data) throws Exception{

        if(qIsFull()){
            throw new Exception("Overflow- Fila cheia");
        }

        if(qIsEmpty()){

            Node<T> aux = new Node<T>(data, null);
            head = aux;
            tail = aux;
        }
        else{
            Node<T> aux = new Node<T>(data, head);
            head = aux;
        }
    }

    public Node<T> dequeueLeft() throws Exception{

        if(qIsEmpty()){
            throw new Exception("Underflow- Fila Vazia");
        }

        Node<T> aux = head;
        
        if(tail == head){
            head = null;
            tail = null;
            return aux;
        }

        head = aux.getProx();
        aux.setProx(null);
        return aux;
    }

    public Node<T> dequeueRight() throws Exception{

        if(qIsEmpty()){
            throw new Exception("Underflow- Fila Vazia");
        }

        Node<T> aux = head, tailAnt = tail;
        
        if(tail == head){
            head = null;
            tail = null;
            return aux;
        }

        while(aux.getProx() != tail){
            aux = aux.getProx();
        }

        tail = aux;
        aux.setProx(null);
        return tailAnt;
    }

    public T getLeft() throws Exception{
        if(qIsEmpty()){
            throw new Exception("Underflow- Fila Vazia");
        }

        return head.getDado();
    }

    public T getRight() throws Exception{
        if(qIsEmpty()){
            throw new Exception("Underflow- Fila Vazia");
        }

        return tail.getDado();
    }

    public int totalElementos(){
        if(qIsEmpty()){
            return 0;
        }

        int cout = 1;
        Node<T> pAnda = head;
        while( pAnda != tail){
            cout += 1;
            pAnda = pAnda.getProx();
        }

        return cout;
    }
}