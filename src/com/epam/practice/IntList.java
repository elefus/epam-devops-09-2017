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

    /**
     * В виду того, что до тестов я еще не дошел, этим методом я тестирую
     * то что есть.
     * @param args
     */
    public static void main(String[] args) {
        IntList sampleList = new IntList();

        System.out.println("Created new IntList with size: " + sampleList.size());
        System.out.println(sampleList.getAllElements());
        System.out.println("Fulfilling IntList within sample values");
        for (int i = 0; i < sampleList.size(); i++) {
            sampleList.set(i, i);
        }
        System.out.println(sampleList.getAllElements());
        sampleList.add(99);
        System.out.println("Added 99: " + sampleList.getAllElements());
        sampleList.add(88, 3);
        sampleList.add(88, 5);
        sampleList.add(88, 7);
        System.out.println("Added 88 at positions 3,5,7: " + sampleList.getAllElements());
        System.out.println("Removed all 88 " + sampleList.removeAll(88) + sampleList.getAllElements());
        System.out.println("Trimmed to original size");
        sampleList.trimToSize();
        System.out.println(sampleList.getAllElements());
        System.out.println("Removed index [9] value " + sampleList.removeFrom(9));
        System.out.println(sampleList.getAllElements());
    }

    /**
     * добавление элемента в конец списка
     * @param value
     */
    public void add(int value) {
        arr = Arrays.copyOf( arr, (arr.length + 1));
        arr[(arr.length - 1)] = value;
    }

    /**
     * добавление элемента в указанную позицию
     * @param value
     * @param index
     */
    public void add(int value, int index) {
        int tmpArray[];
        arr = Arrays.copyOf(arr, (arr.length + 1));
        tmpArray = Arrays.copyOfRange(arr, index, (arr.length - 1));
        arr[index] = value;
        for (int i = 0; i < tmpArray.length ; i++) {
            arr[ index + i + 1 ] = tmpArray[i];
        }
    }

    /**
     * изменяет значение указанного элемента
     * @param value
     * @param index
     */
    public void set(int value, int index) {
        arr[index] = value;
    }

    /**
     * общий метод для поиска и удаления элементов массива
     *
     * @param value - значение для поиска и удаления
     * @param massFlag - флаг массового удаления.
     *                 если true - удаляет все вхождения
     *                 если false - удаляет только первое вхождение
     * @return true если был удален хотя бы один элемент
     *         false если вхождение value в массив не обнаружено
     */

    private boolean removeTemplate ( int value, boolean massFlag ) {
        int[] tmpArray;
        boolean result = false;

        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] == value) {
                tmpArray = Arrays.copyOfRange(arr, (i + 1), (arr.length));

                for (int j = i; j < (arr.length - 1) ; j++) {
                    arr[j] = tmpArray[(j - i)];
                }

                arr[(arr.length - 1)] = 0;
                result = true;

                if ( !massFlag ) {
                    break;
                }
            }
        }
        return result;
    }
    /**
     * удаление первого вхождения указанного элемента (если он присутствует в списке)
     *
     * @param value
     * @return (true - если элемент был удален, в противном случае false)
     */

    public boolean remove(int value) {
        return removeTemplate(value, false);
    }

    /**
     * удаление всех вхождений указанного элемента (если он присутствует в списке)
     * @param value
     * @return (true - если элемент был удален, в противном случае false)
     */

    public boolean removeAll(int value) {
        return removeTemplate(value, true);
    }

    /**
     * удаление элемента по указанному индексу
     *
     * @param index - индекс элемента
     * @return - удаленное значение
     */

    public int removeFrom(int index) {
        int tmpArray[];
        int returnValue = arr[index];

        if (index == arr.length) {
            arr = Arrays.copyOf(arr, (arr.length - 1));
        } else if (index > arr.length){
            throw new IndexOutOfBoundsException();
        } else if (index < arr.length) {
            tmpArray = Arrays.copyOfRange(arr, (index + 1), arr.length);
            arr = Arrays.copyOf(arr, (arr.length - 1));

            for (int i = 0; i < tmpArray.length; i++) {
                arr[(index + i)] = tmpArray[i];
            }
        }

        return returnValue;
    }

    /**
     * Возвращает значение указанного элемента
     * @param index
     * @return
     */
    public int get(int index) {
        return arr[index];
    }

    /**
     *  возвращаем все элементы массива в виде строки
     * @return
     */
    public String getAllElements() {
        String arrayText = "";
        for (int item = 0; item < this.size(); item++ ) {
            arrayText = arrayText + this.get(item);
            if (item < (this.size() - 1)) {
                arrayText = arrayText + ",";
            }
        }

        return ("[" + arrayText + "]");
    }

    /**
     * возвращаем копию внутреннего массива
     * @return
     */
    public int[] toArray() {
        int[] tmpArray = arr;
        return tmpArray;
    }

    /**
     * возвращаем текущий размер списка
     * @return
     */
    public int size() {
        return arr.length;
    }

    /**
     * поиск элемента (с головы списка к хвосту)
     * @param value
     * @return - индекс элемента. В случае, если нет вхождения, вернет -1.
     */
    public int indexOf(int value) {
        int index = -1;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * поиск элемента (c хвоста списка к голове)
     * @param value
     * @return - индекс элемента. В случае, если нет вхождения, вернет -1.
     */
    public int lastIndexOf(int value) {
        int index = -1;
        for (int i = arr.length; i <= 0 ; i--) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * уменьшает размер внутреннего массива до актуального значения
     */
    public void trimToSize() {
        int nullCounter = 0;

        for (int index = (this.arr.length - 1); index >= 0 ; index--) {
            if (arr[index] == (int) 0) {
                nullCounter++;
            } else { break; }
        }

        this.arr = Arrays.copyOf(this.arr, (this.arr.length - nullCounter));

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
