package com.epam.kotov;

import java.lang.reflect.Array;

public class IntList implements List{

    private int[] arr;
    private int arrElements = 0;
    private static final int INITSIZE = 16;

    private IntList() {
        this(INITSIZE);
    }

    private IntList(int size) {
        arr = new int[size];
    }

    public void add(int value) {
        checkSizeUp();

        arr[arrElements] = value;
        arrElements++;

    }

    public void add(int value, int index) {
        checkSizeUp();

        System.arraycopy(arr, index, arr, index + 1, arrElements - index);
        arr[index] = value;

    }

    public void set(int value, int index) {
        arr[index] = value;
    }

    public boolean remove(int value) {

        for (int i = 0; i < arrElements; i++) {
            if (arr[i] == value) {
                arrElements--;
                System.arraycopy(arr, i + 1, arr, i, arrElements - i);
                return true;
            }
        }

        return false;

    }

    public boolean removeAll(int value) {
        int position = 0;
        boolean valueFound = false;

        for (int i = 0; i < arrElements; i++) {
            if (arr[i] == value) {
                valueFound = true;
                continue;
            }

            if (valueFound) {
                arr[position] = arr[i];
            }

            position++;
        }

        arrElements = position;

        return valueFound;
    }

    public int removeFrom(int index) {
        int value = arr[index];

        arrElements--;
        System.arraycopy(arr, index + 1, arr, index, arrElements - index);

        return value;
    }

    public int get (int index) {
        return arr[index];
    }

    public int[] toArray() {
        int[] returnArr = new int[arrElements];
        System.arraycopy(arr,0,returnArr, 0 , arrElements);
        return returnArr;
    }

    public int size() {
        return arrElements;
    }

    public int indexOf(int value) {
        for (int i = 0; i < arrElements; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        for (int i = arrElements - 1; i >= 0 ; i--) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void trimToSize() {
        changeArrSize(arrElements + 1);
    }

    private void checkSizeUp() {
        if (arrElements >= arr.length) {
            changeArrSize(arr.length * 2);
        }

    }

    private void changeArrSize(int size) {
        int[] newArr = new int[size];
        System.arraycopy(arr, 0, newArr, 0, arrElements);
        arr = newArr;
    }

}
