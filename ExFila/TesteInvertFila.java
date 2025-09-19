public class TesteInvertFila {

    public static void main(String[] args){

        try{
        FilaSequencialGenerica<Integer> p = new FilaSequencialGenerica<Integer>();
        p.enqueue(10);
        p.enqueue(54);
        p.enqueue(12);
        p.enqueue(3);
        p.enqueue(32);

        p.invert();

        while(!p.qIsEmpty()){
            System.out.print(p.dequeue()+ "\n");
        }

        }catch (Exception e) {
            System.out.println(e.getMessage());

    }
}
}