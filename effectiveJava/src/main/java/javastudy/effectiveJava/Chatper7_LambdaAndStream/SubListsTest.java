package javastudy.effectiveJava.Chatper7_LambdaAndStream;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubListsTest {

    public class SubLists{

        public static <E> Stream<List<E>> of(List<E> list){
            return Stream.concat(Stream.of(Collections.emptyList()) // [] -> 빈리스트 하나 추가
                    //프리픽스의 서픽스
            ,prefixes(list)//prefixes(list) -> [a],[a,b],[a,b,c]
                            .flatMap(SubLists::suffixes)); //[a],[b,c],[a,b,c].flatMap(SubLists::suffixes) -> [a], / [a,b], [b] / [a,b,c], [b,c], [c]
        }

        public static <E> Stream<List<E>> prefixes(List<E> list){
            return IntStream.rangeClosed(1,list.size()).mapToObj(end -> list.subList(0,end));
        }

        public static <E> Stream<List<E>> suffixes(List<E> list){
            return IntStream.range(0,list.size()).mapToObj(start -> list.subList(start, list.size()));
        }


    }


    public static void main(String[] args) {


        List<String> list = List.of("a","b","c");

        SubLists.prefixes(list).forEach(System.out::println); //[a],[b,c], [a,b,c]
        System.out.println("===========================================================");
        SubLists.prefixes(list).flatMap(SubLists::suffixes).forEach(System.out::println); // [a], / [a,b], [b] / [a,b,c], [b,c], [c]



    }
}
