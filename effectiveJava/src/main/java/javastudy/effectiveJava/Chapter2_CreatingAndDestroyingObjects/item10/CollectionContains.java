package javastudy.effectiveJava.Chapter2_CreatingAndDestroyingObjects.item10;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionContains {

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override public boolean equals(Object o){ //MUST use "Object o" -> override from Object
            System.out.println("equals!!");
            if(!(o instanceof Point)){
                return false;
            }
            Point p = (Point)o;
            System.out.println("p.x : "+p.x);
            System.out.println("x : "+x);
            System.out.println("p.y : "+p.y);
            System.out.println("y : "+ y);


            System.out.println( p.x == x && p.y ==y);
            System.out.println("====================================");
            return p.x == x && p.y ==y;
        }


    }

    private static final Set<Point> unitCircle = Set.of(
            new Point(1,0),
            new Point(0,1),
            new Point(-1,0),
            new Point(0,-1)
    );

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
//        System.out.println("START============================================");
//
//
//        Iterator<Point> it = unitCircle.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next().toString()+" ");
//        }
//
//        Iterator<Point> it2 = unitCircle.iterator();
//        while(it2.hasNext()){
//            System.out.println(it2.next().x+" ");
//        }
//
//        Iterator<Point> it3 = unitCircle.iterator();
//        while(it3.hasNext()){
//            System.out.println(it3.next().y+" ");
//        }

        Point point = new Point(0,-1);
        System.out.println("METHOD============================================");
        System.out.println(onUnitCircle(new Point(0,-1)));
        System.out.println("NOT METHOD============================================");
        System.out.println(unitCircle.contains(point));
    }





}
