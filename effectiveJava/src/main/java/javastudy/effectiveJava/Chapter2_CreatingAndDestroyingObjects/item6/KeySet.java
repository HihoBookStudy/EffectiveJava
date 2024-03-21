package javastudy.effectiveJava.Chapter2_CreatingAndDestroyingObjects.item6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySet {


    /*
    33page
    KeySet을 호출할 때 마다 새로운 Set인스턴스가 만들어지리라고 순진하게 생각할수도 있지만, 사실은 매번 같은 Set인스턴스를 반환할지도 모른다.
    반환된 Set 인스턴스가 일반적으로 가변이더라도 반환된 인스턴스들은 기능적으로 모두 똑같다.
    즉, 반환한 객체 중 하나를 수정하면 다른 모든 객체가 따라서 바뀐다.
    모두가 똒같은 Map 인스턴스를 대변하기 때문이다.
    따라서 KeySet이 뷰 객체를 여러개 만들어도 상관은 없지만, 그럴 필요도 없고 이득도 없다.

    Naively, it would seem that every call to keySet would have to create a new Set instance, but every call to
    keySet on a given Map object may return the same Set instance.
    Although the returned Set instance is typically mutable, all of the returned objects are
    functionally identical: when one of the returned objects changes,
    so do all the others, because they’re all backed by the same Map instance.
    While it is largely harmless to create multiple instances of the keySet view object,
    it is unnecessary and has no benefits.


     */

    public static void main(String[] args) {

        //Create Map instance
        Map<String, Integer> hashMap = new HashMap<>();

        //put some datas
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        System.out.println(hashMap); //{one=1, two=2, three=3}

        //Create two different Set which are backed by the same Map instance
        Set<String> sets = hashMap.keySet();
        Set<String> sets2 = hashMap.keySet();

        System.out.println(sets); //[one, two, three]
        System.out.println(System.identityHashCode(sets)); //498931366
        System.out.println(sets2); //[one, two, three]
        System.out.println(System.identityHashCode(sets2)); //498931366
        //can figure it out two set are identically same (have same address)

        //put more data
        hashMap.put("four", 4);

        //data of two sets directly follow changes of the Map instance
        System.out.println(sets);//[four, one, two, three]
        System.out.println(System.identityHashCode(sets));//498931366
        System.out.println(sets2);//[four, one, two, three]
        System.out.println(System.identityHashCode(sets2));//498931366


    }
}