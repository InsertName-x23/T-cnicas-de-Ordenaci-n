import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ea04_MétodosDeOrdenación.*;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class main<T>
{
    
    public static void main(String [] args) throws Exception
    {

    //Organizar una lsita de nombres --------------------------------------------------->
        ListaSimple<String> a = new ListaSimple<>();
        GeneradorADTs g = new GeneradorADTs();

        List<Person> personas = g.generar(100);

        for (Person p : personas)
            a.addHead(p.toString());
       
       ArrayList<String> items = a.sort().imprimir();

        for (String x : items) {
            System.out.println(x);
        }

    //Orgnmaizar una lista de numeros enteros assert() ------------------------------->
        // ListaSimple<Integer> enteros = new ListaSimple<>();
        // enteros.addHead(10); 
        // enteros.addHead(50); 
        // enteros.addHead(10); 
        // enteros.addHead(34); 
        // enteros.addHead(21); 
        // enteros.addHead(2); 
        // enteros.addHead(99); 
        // enteros.addHead(15); 
        // enteros.addHead(0); 
        // ListaSimple<Integer> enterosOrdenados = new ListaSimple<>();
        // enterosOrdenados.addHead(0); 
        // enterosOrdenados.addHead(2); 
        // enterosOrdenados.addHead(10); 
        // enterosOrdenados.addHead(10); 
        // enterosOrdenados.addHead(15); 
        // enterosOrdenados.addHead(21); 
        // enterosOrdenados.addHead(34); 
        // enterosOrdenados.addHead(50); 
        // enterosOrdenados.addHead(99); 
       // ArrayList<Integer> items = enteros.sort().imprimir();
        // assert(enteros == enterosOrdenados);

        // ListaSimple<Integer> n1 = new ListaSimple<>();
        // n1.addHead(0); 
        // n1.addHead(2); 
        // n1.addHead(10); 
        // n1.addHead(10); 
        // n1.addHead(15); 
        // ListaSimple<Integer> n2 = new ListaSimple<>();
        // n2.addHead(21); 
        // n2.addHead(34); 
        // n2.addHead(50); 
        // n2.addHead(99); 

        // ListaSimple<Integer> marge = n1.marge(n2);
        // ArrayList<Integer> items = marge.imprimir();

        // for (Integer x : items) {
        //     System.out.println(x); 
        // }
          
    }
}
