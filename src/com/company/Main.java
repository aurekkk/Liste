package com.company;

public class Main {

    public static void main(String[] args) {
        int[] temp = {1, 1, 2, 3, 4, 8, 5, 9, 2};
        Lista ob = new Lista(temp);
        ListaOrdonata obb= new ListaOrdonata(temp);
        ob.addElement(5);
        ob.print();
        if(ob.removeElement(7)) System.out.println("elementul a fost sters" );
        else System.out.println("elementul nu a fost gasit in lista");
        ob.print();
        int count=ob.removeAll(1);
        System.out.println("elementul a fost sters de " + count + " ori");
        ob.print();
        System.out.println("elementul aflat pe pozitia 3 este " + ob.get(3));
        obb.print();
    }
}
