import java.util.ArrayList;


public class Taller_2<T>{
    
    public static void main(String [] args){
        ListaSimple<Integer> a = new ListaSimple<>();
        a.addHead(20);
        a.addHead(5);
        a.addHead(1);
        

        ListaSimple<Integer> b = new ListaSimple<>();
        b.addHead(22);
        b.addHead(8);

 

    
 


        

    //    ArrayList<Integer> items = new ArrayList<>();
        ListaSimple<Integer> items = a.marge(b);

    //    Object[] lista =  a.splitList();
    //    items = ((ListaSimple<Integer>)lista[1]).imprimir();

        for (Integer x : items) {
            System.out.println(x);
        }

    }


}
