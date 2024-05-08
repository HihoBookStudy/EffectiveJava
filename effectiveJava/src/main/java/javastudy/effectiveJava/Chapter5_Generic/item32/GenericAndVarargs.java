package javastudy.effectiveJava.Chapter5_Generic.item32;

import java.util.List;

public class GenericAndVarargs {

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);

        Object[] objects = stringLists;
//        System.out.println(objects.length); // size = 2
//        for (Object o :objects) {
//            System.out.println(o.toString()); // [aa, bb, cc], [dd, ee, ff]
//        }

        objects[0] = intList;
//        System.out.println(objects.length); // size = 2
//        for (Object o :objects) {
//            System.out.println(o.toString()); // [42], [dd, ee, ff]
//        }

        //heap pollution error
        //stringLists[0] -> intList
        //stringLists[0].get(0) -> 42
        String s = stringLists[0].get(0); // anticipate to print 42

    }

    public static void main(String[] args) {
        dangerous(List.of("aa","bb","cc"),List.of("dd","ee","ff"));

    }


}
