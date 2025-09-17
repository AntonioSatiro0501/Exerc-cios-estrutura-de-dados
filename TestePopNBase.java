public class TestePopNBase {

    public static void main(String[] args){

        try{
        PilhaGenerica<Integer> p = new PilhaGenerica<Integer>();
        p.push(10);
        p.push(54);
        p.push(12);
        p.push(3);
        p.push(32);

        p.popNBase(4);

        while(!p.isEmpty()){
            System.out.print(p.pop()+ "\n");
        }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}