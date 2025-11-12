public class FilaEncadeada<T>{
    private static int size = 1000;
    private Node<T> head;
    private Node<T> tail;


    public FilaEncadeada(){
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

    public void enqueue(T data) throws Exception{

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

    public Node<T> dequeue() throws Exception{

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

    public T front() throws Exception{
        if(qIsEmpty()){
            throw new Exception("Underflow- Fila Vazia");
        }

        return head.getDado();
    }

    public T rear() throws Exception{
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