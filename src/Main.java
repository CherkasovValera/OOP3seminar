import java.util.Iterator;

//Создать список по аналогии LinkedList (список связанных элементов), реализовать в нем iterable интерфейс
public class Main {
    public static void main(String[] args) {

        LinkedCase<String> stringLinkedL = new LinkedCase<>();
        stringLinkedL.addLast("abba");
        System.out.println("1 номер");
        System.out.println((stringLinkedL.getNumberByIndex(0)));
        stringLinkedL.addLast("anna");
        System.out.println("1 номер");
        System.out.println((stringLinkedL.getNumberByIndex(0)));
        stringLinkedL.addFirst("assa");
        System.out.println("1 номер");
        System.out.println((stringLinkedL.getNumberByIndex(0)));
        System.out.println("Весь список");
        for (String s:stringLinkedL) {
            System.out.println(s);
        }
        System.out.println("Размер списка");
        System.out.println(stringLinkedL.size());
        System.out.println("Список с конца");
        Iterator iterator= stringLinkedL.descendingIt();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}