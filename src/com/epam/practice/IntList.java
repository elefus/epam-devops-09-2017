package com.epam.practice;

public class IntList {

    private int[] arr;

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
}
