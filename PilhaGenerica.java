public class PilhaGenerica <T>{
    //atributos

    private final static int TAM_DEFAULT = 100;
    private int topoPilha;
    private T e[];

    //contrutores

    public int getTopoPilha(){
        return topoPilha;
    }

    public PilhaGenerica( int tamanho){
        e = (T[]) new Object[tamanho];
        topoPilha = -1;
    }
    
    // metodos

    public PilhaGenerica() {
        this(TAM_DEFAULT);
    }

    public boolean isEmpty(){

        return topoPilha == -1;
    }
    
    public boolean isFull(){

        return topoPilha == e.length -1;
    }

    public void push(T e) throws Exception{

        if(!isFull()){
            this.e[++topoPilha] = e;

        }
        else{
            throw new Exception("Overflow - Estouro da Pilha");
        }
    }
    
    public T pop() throws Exception{
        if(!isEmpty()){
            return this.e[this.topoPilha--];
        }
        else{
            throw new Exception("Underflow - Esvaziamento da Pilha");
        }
    }  

    public T topo() throws Exception{

        if(!isEmpty()){
            return this.e[this.topoPilha];
        }
        else{
            throw new Exception("Underflow - Esvaziamento da Pilha");
        }
    }

    public int sizeElements() {
        return topoPilha+1;
    }
    
public void popNTop(int n) throws Exception {
    if (n > sizeElements()) {
        throw new Exception("Underflow - Esvaziamento da Pilha");
    }

    for (int i = 0; i < n; i++) {
        pop();
    }
}

}
 