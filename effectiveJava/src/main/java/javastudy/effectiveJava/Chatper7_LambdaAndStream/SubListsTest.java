package javastudy.effectiveJava.Chatper7_LambdaAndStream;

import java.util.ArrayList;
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


    public static <E> List<List<E>> makeListByLoop(List<E> list){

        List<List<E>> result = new ArrayList<>(List.of(Collections.emptyList()));//빈리스트 기본

        for(int start=0; start<list.size(); start++){
            for(int end=start + 1; end <= list.size(); end++){
                result.add(list.subList(start,end));
            }
        }
        return result;
    }


    public static <E> Stream<List<E>> makeListByLoopUsingStream(List<E> list){

        return IntStream.range(0, list.size())
                .mapToObj(start ->
                        IntStream.rangeClosed(start+1,list.size())
                        .mapToObj(end -> list.subList(start,end)))//list로 생성한 subList를 Stream으로 모두 변환
                .flatMap(x->x);

    }

    public static void main(String[] args) {


        List<String> list = List.of("a","b","c");

        SubLists.prefixes(list).forEach(System.out::println); //[a],[b,c], [a,b,c]
        System.out.println("===========================================================");
        SubLists.prefixes(list).flatMap(SubLists::suffixes).forEach(System.out::println); // [a], / [a,b], [b] / [a,b,c], [b,c], [c]

        System.out.println("FOR문 사용");
        System.out.println(SubListsTest.makeListByLoop(list));
    }
}
