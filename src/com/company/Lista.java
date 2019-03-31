package com.company;

public class Lista implements List {
    private int[] list;
    public Lista(int[] list) {
        this.list=list;
    }

    @Override
    public void addElement(Integer value) {
        if(this.list.equals(null)){
            list = new int[1];
            list[0]=value;
        }
        else{
            int[] temp = list;
            list= new int[temp.length+1];
            for (int i=0; i<temp.length; i++) list[i] = temp[i];
            list[list.length-1]=value;
        }

    }

    @Override
    public boolean removeElement(Integer value) {
        int[] temp = new int[list.length-1];
        int j=0;
        boolean deleted = false;
        for (int i=0; i<list.length; i++){
            if (list[i] != value){
                if(j != temp.length)
                    temp[j++]=list[i];
            }
            else {
                deleted=true;
            }
        }
        if(deleted == true)list=temp;
        return deleted;
    }

    @Override
    public int removeAll(Integer value) {
        int count = 0;
        int j=0;
        for (int i=0; i<list.length; i++) {
            if(list[i] == value)count++;
        }
        int[] temp = new int[list.length-count];
        for (int i=0; i<list.length; i++) {
            if (list[i] != value) {
                if (j != temp.length)
                    temp[j++] = list[i];
            }
        }
        list = temp;
        return count;
    }

    @Override
    public Integer get(int index) {
        return list[index];
    }

    @Override
    public int lungime() {
        return list.length;
    }

    public void print(){
        for (int i=0; i<list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.print("\n");
    }

}
