package com.company;

public class ListaOrdonata implements List{
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    private int[] list;
    public ListaOrdonata(int[] list) {
        this.list=list;
        sort(this.list, 0, list.length-1);
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
        sort(list, 0, list.length-1);

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
        sort(list, 0, list.length-1);
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
