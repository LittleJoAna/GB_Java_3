package lesson_1;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList<T> boxFruit;


    public Box (T... fruit) {
        boxFruit = new ArrayList<>();
        for (int i = 0; i < fruit.length; i++) {
            boxFruit.add(fruit[i]);
        }
    }
//d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f,
//апельсина - 1.5f, не важно в каких это единицах);
    float getWeight() {
        float sum = 0;
        for (int i = 0; i < boxFruit.size(); i++) {
            sum += boxFruit.get(i).getWeight();
        }
        return sum;
    }

    //e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare
    //в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками
    //с апельсинами);
    boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    //g. Не забываем про метод добавления фрукта в коробку.
    void add(T fruit) {
        boxFruit.add(fruit);
    }


    //    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
//    нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую
//    перекидываются объекты, которые были в этой коробке;
    void pourTheFruit(Box<T> box2) {
        this.boxFruit.addAll(box2.boxFruit);
        box2.boxFruit.clear();
    }

    String info () {
        return this.getClass().getSimpleName();
    }
}
