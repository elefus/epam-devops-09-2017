package com.epam.se2.lesson14;

import java.util.Arrays;

public class ObjectList implements List {

    public static final int DEFAULTSIZE = 16;
    private Object[] arr;
    private int currentLength;

    public ObjectList(){
        this(DEFAULTSIZE);
    }

    public ObjectList(int size) {
        arr = new Object[size];
    }

    private void extendIfNeeded(){
        if (currentLength == arr.length) {
            arr = Arrays.copyOf(arr, (int)(currentLength*1.5));
        }
    }

    @Override
    public ObjectList add(Object value) {
        this.add(value, currentLength);
        //TODO add element into the list as the last item -DONE!
        return this;
    }

    @Override
    public void add(Object value, int index) {
        extendIfNeeded();
        System.arraycopy(arr, index, arr, index+1, currentLength-index );
        arr[index] = value;
        currentLength++;
        //TODO add element into the index position - DONE!
    }

    @Override
    public void set(Object value, int index){
        arr[index]=value;
        //TODO replace item with value in the index position - DONE!
    }

    @Override
    public boolean remove(Object value) {
        int index = this.indexOf(value);
        if (index == -1) {
            return false;
        }
        this.removeFrom(index);
        return true;
        //TODO find and delete first occurence of item value if exists and return true otherwise  return false - DONE!
    }

    @Override
    public boolean removeAll(Object value) {
        if (this.indexOf(value) < 0 ){
            return false;
        }
        int counter = 0;
        for (int i = 0; i < currentLength; i++) {
            if(!arr[i].equals(value)) {
                arr[i-counter] = arr[i];
            }
            else {
                counter++;
            }
        }
        currentLength -=counter;
        return true;
        //TODO find and delete all occurences of item value if exists and return true otherwise  return false -DONE!
    }

    @Override
    public Object removeFrom(int index) {
        Object item = arr[index];
        System.arraycopy(arr, index+1, arr, index, currentLength-index-1);
        currentLength--;
        return item;
        //TODO remove element at position and return the value -DONE!
    }

    @Override
    public Object get(int index) {
        return arr[index];
        //TODO return value of item at index - DONE!
    }

    @Override
    public Object[] toArray () {
        return Arrays.copyOf(arr, currentLength);
        //TODO return copy of arraylist - DONE!
    }

    @Override
    public int size() {
        return currentLength;
        //TODO get realsize of arraylist - DONE!
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < currentLength; i++) {
            if (arr[i].equals(value)){
                return i;
            }
        }
        return -1;
        //TODO find index of element from the beginning -DONE!
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = currentLength-1; i >= 0 ; i--) {
            if (arr[i].equals(value)){
                return i;
            }
        }
        return -1;
        //TODO find index of element from the end - DONE!
    }

    public void trimToSize() {
        arr = Arrays.copyOf(arr, currentLength);
        //TODO decrease array size to the currentlengths - DONE!
    }

    public int getInternalSize() {
        return arr.length;
    }

    @Override
    public String toString(){
        if (currentLength == 0)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < currentLength-1 ; i++) {
            b.append(arr[i]).append(", ");
        }
        return b.append(arr[currentLength-1]).append("]").toString();
    }

}