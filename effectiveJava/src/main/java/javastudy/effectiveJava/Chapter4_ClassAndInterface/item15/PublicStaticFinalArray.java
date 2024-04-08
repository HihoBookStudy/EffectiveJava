package javastudy.effectiveJava.Chapter4_ClassAndInterface.item15;

import java.util.Arrays;

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


        //두 가지 모두 같은 메모리주소를 가리킨다
        System.out.println(FruitBasket.VALUES.toString()); //@7344699f
        System.out.println(fruits.toString());//@7344699f
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

    public Fruit[] getValues(){
        return VALUES;
    }


}
