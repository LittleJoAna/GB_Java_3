package lesson_1;
/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя
сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f,
апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare
в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками
с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую
перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.ArrayList;

public class HomeWorkGeneric {
    public static void main(String[] args) {
        System.out.println("#1");
        BoxArray<Integer> task1 = new BoxArray<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(task1.toString());
        task1.swapTwoElements(3, 5);
        System.out.println(task1.toString());

        BoxArray<String> task2 = new BoxArray<>("Java", "The", "Best", "Programming", "Language");
        System.out.println(task2.toString());
        task2.swapTwoElements(1, 2);
        System.out.println(task2.toString());

        System.out.println("#2");
        ArrayList<Integer> arrInt = task1.convertArrayToArrayList();
        ArrayList<String> arrStr = task2.convertArrayToArrayList();
        System.out.println(arrInt);
        System.out.println(arrStr);

        System.out.println("#3");
        Box<Apple> boxApple = new Box<>(new Apple(1.0f), new Apple(1.0f), new Apple(1.0f),
                new Apple(1.0f), new Apple(1.0f));
        Box<Orange> boxOrange = new Box<>(new Orange(1.5f), new Orange(1.5f), new Orange(1.5f),
                new Orange(1.5f), new Orange(1.5f));
        System.out.println("Вес коробки с яблоками: " + boxApple.getWeight());
        System.out.println("Вес коробки с апельсинами: " + boxOrange.getWeight());
        System.out.println("\nКоробка " + boxApple.info() + " и коробка " + boxOrange.info() + " " + boxApple.compare(boxOrange));
        System.out.println("Коробка " + boxApple.info() + " и коробка " + boxApple.info() + " " + boxApple.compare(boxApple));
        System.out.println("Коробка " + boxOrange.info() + " и коробка " + boxOrange.info() + " " + boxOrange.compare(boxOrange));

        boxApple.add(new Apple(1.0f));
        System.out.println("\nВес коробки с яблоками: " + boxApple.getWeight());

        Box<Apple> box3 = new Box<>();
        Box<Orange> box4 = new Box<>();
        box3.pourTheFruit(boxApple);
        box4.pourTheFruit(boxOrange);

        System.out.println(boxApple.getWeight());
        System.out.println(boxOrange.getWeight());
        System.out.println(box3.getWeight());
        System.out.println(box4.getWeight());

    }
}


