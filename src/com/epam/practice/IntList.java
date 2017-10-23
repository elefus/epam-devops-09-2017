package com.epam.practice;

import java.util.Arrays;
import java.util.Objects;

public class IntList {

    private int[] arr;
    private int current;

    public IntList() {
        arr = new int[16];
    }

    public IntList(int size) {
        arr = new int[size];
    }

    public void add(int value) {
        // TODO добавление элемента в конец списка
    }

    public void add(int value, int index) {
        // TODO добавление элемента в указанную позицию
    }

    public void set(int value, int index) {
        // TODO изменяет значение указанного элемента
    }

    public boolean remove(int value) {
        // TODO удаление первого вхождения указанного элемента (если он присутствует в списке)
        // TODO возвращает true - если элемент был удален, в противном случае false
        return false;
    }

    public boolean removeAll(int value) {
        // TODO удаление всех вхождений указанного элемента (если он присутствует в списке)
        // TODO возвращает true - если элемент был удален, в противном случае false
        return false;
    }

    public int removeFrom(int index) {
        // TODO удаление элемента по указанному индексу
        // TODO возвращает удаленное значение
        return 0;
    }

    public int get(int index) {
        // TODO значение указанного элемента
        return 0;
    }

    public int[] toArray() {
        // TODO возвращаем копию внутреннего массива
        return null;
    }

    public int size() {
        // TODO текущий размер списка
        return 0;
    }

    public int indexOf(int value) {
        // TODO поиск элемента (с головы списка к хвосту)
        return -1;
    }

    public int lastIndexOf(int value) {
        // TODO поиск элемента (c хвоста списка к голове)
        return -1;
    }

    public void trimToSize() {
        // TODO уменьшает размер внутреннего массива до актуального значения
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntList intList = (IntList) o;
        return Arrays.equals(arr, intList.arr);
    }

    public boolean equalsPlain(Object obj) {
        if (obj == null) {
            return false;
        }
        IntList _this = this;
        Object objectThis = (Object)this;
        if (obj == objectThis) {
            return true;
        }

        if (obj.getClass() != IntList.class) {
            return false;
        }
        if (!(obj instanceof IntList)) {
            return false;
        }

        IntList other = (IntList)obj;
        if (this.current != other.current) {
            return false;
        }
        for (int i = 0; i < this.current; i++) {
            if (arr[i] != other.arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < current; i++) {
            sum = sum * 31 +  arr[i];
        }
        return sum;
    }
}
