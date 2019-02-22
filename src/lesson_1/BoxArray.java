package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxArray <T> {
    private T[] array;

    public BoxArray(T... array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    void swapTwoElements (int second, int first) {
        T elm1 = null;
        T elm2 = null;

        for (int i = 0; i < array.length; i++) {
            if (i == second) {
                elm1 = array[i]; //запоминает в переменную elm1 значение в ячейке массива под первым переданным индексом
            }
            if (i == first) {
                elm2 = array[i]; //запоминает в переменную elm2 значение в ячейке массива под вторым переданным индексом
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(i == second) {
                array[i] = elm2; //в ячейку с первым переданным индексом записывается значение из переменной elm2
            }
            if (i == first) {
                array[i] = elm1; //в ячейку со вторым переданным индексом записывается значение из переменной elm1
            }
        }
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    ArrayList<T> convertArrayToArrayList () {
        ArrayList<T> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
