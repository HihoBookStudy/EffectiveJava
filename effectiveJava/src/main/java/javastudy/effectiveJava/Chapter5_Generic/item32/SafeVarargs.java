package javastudy.effectiveJava.Chapter5_Generic.item32;

import java.util.concurrent.ThreadLocalRandom;

public class SafeVarargs {

    static <T> T[] toArray(T... args) {
        return args; //"조건1 : varargs 매개변수 배열에 아무것도 저장하지 않는다"를 만족
    }


    //신뢰할 수 없는 코드에 toArray의 varargs 매개변수 배열이 노출됨!
    static <T> T[] pickTwo(T a, T b, T c) {

        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }

        throw new AssertionError(); // Can't get here

    }
    //해당 배열(또는 복제본)을 신뢰할 수 없는 코드가 수정할 수 없게 만든다" 를 불만족!


    public static void main(String[] args) {

        //신뢰할 수 없는 코드에 노출되지 않음, 클라이언트가 직접 호출 -> 안전
        String[] attributes = toArray("a","b","c");

        for (String s :attributes) {
            System.out.println(s);
        }

        //클라이언트가 신뢰할 수 없는 코드를 거쳐 toArray를 사용하게 됨 -> 안전하지 않음
        String[] attributes2 = pickTwo("a","b","c");



    }

}
