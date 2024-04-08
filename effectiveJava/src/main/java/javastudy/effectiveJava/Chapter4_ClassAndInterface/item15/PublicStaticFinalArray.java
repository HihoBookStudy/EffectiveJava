package javastudy.effectiveJava.Chapter4_ClassAndInterface.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PublicStaticFinalArray {

    public static void main(String[] args) {

        //배열의 값을 변경
        System.out.println(Arrays.toString(FruitBasket.VALUES)); //[Banana, Orange]
        FruitBasket.VALUES[1] = new Fruit("Strawberry");//클라이언트에서 값을 변경 가능
        System.out.println(Arrays.toString(FruitBasket.VALUES)); //[Banana, Strawberry]


        FruitBasket f = new FruitBasket();

        //getter를 이용해서 배열의 값을 변경
        Fruit[] fruits = f.getValues();
        System.out.println(Arrays.toString(fruits)); //[Banana, Strawberry]
        fruits[0] = new Fruit("Lemon");
        System.out.println(Arrays.toString(fruits)); //[Lemon, Strawberry]


        //방법1. private array + unmodified

        //변경시도 (add,remove,set..) 런타임 에러를 발생시킴
        //FruitBasket.IMMUTABLE_PRIVATE_VALUES.set(0,new Fruit("Mango"));


        //방법2. private array + 방어적 복사본 반환
        Fruit[] fruits2 = FruitBasket.values();
        fruits2[0] = new Fruit("Mango");
        System.out.println(Arrays.toString(fruits2));//[Mango, Orange]


        System.out.println(FruitBasket.VALUES.toString()); //@7344699f
        System.out.println(fruits.toString());//@7344699f (같은 객체임 -> 원본이 변경됨)
        System.out.println(fruits2.toString());//@6b95977 (다른객체임)


    }

}


class Fruit{
    String name;
    String nutrients;

    Fruit(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class FruitBasket{
    public static final Fruit[] VALUES = {new Fruit("Banana"), new Fruit("Orange")};
    private static final Fruit[] PRIVATE_VALUES = {new Fruit("Banana"), new Fruit("Orange")};

    public Fruit[] getValues(){
        return VALUES;
    }

    //방법1. 불변리스트
    public static final List<Fruit> IMMUTABLE_PRIVATE_VALUES =
            Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));


    //방법2. 방어적복사
    public static final Fruit[] values(){
        return PRIVATE_VALUES.clone();
    }

}
