import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("a1");
        test.add("br2");
        test.add("ce3");
        test.add("rew4");
        test.add("e5");
        test.add("uer6");
        test.add("y7");
        test.add("e8");
        test.add("pew9");
        test.add("m10");

        // task 1
        System.out.println("========================");
        System.out.println(Module11.namesParser(test));

        // task 2
        System.out.println("========================");
        Module11.reverseSort(test).forEach(System.out::println);

        // task 3
        System.out.println("========================");
        int[] arr = new int[]{1, 34, 21, 7, 4, 2, 9, 8, 4, 15};
        System.out.println(Module11.sortAndString(arr));

        //task 4
        System.out.println("========================");
        Module11.randomizer(25214903917L, 11L, (long) Math.pow(2, 48)).limit(10).forEach(System.out::println);

        //task 5
        System.out.println("========================");
        List<String> test2 = new ArrayList<>();
        test2.add("test1");
        test2.add("test2");
        test2.add("test3");
        test2.add("test4");
        test2.add("test5");

        Module11.zip(test2.stream(), test.stream()).forEach(System.out::println);
    }
}
