package javastudy.effectiveJava.Chapter4_ClassAndInterface.item16;

import java.awt.*;

public class DimensionPerformanceIssue {


    public static void main(String[] args) {

        Dimension dim = new Dimension(10,12);

        System.out.println(dim.toString());//java.awt.Dimension[width=10,height=12]

        //dim 객체의 사이즈를 얻기 위한 목적이었던 getSize를 이용해 height,width의 값이 변경될 수도 있기 때문에 방어적 복사가 수행되어야함
        Dimension size = dim.getSize();
        size.height = -100;
        size.width = 200;

        System.out.println(size.toString());//java.awt.Dimension[width=200,height=-100]
        System.out.println(dim.toString());//java.awt.Dimension[width=10,height=12] -> 방어적 복사가 수행되어 원본 dim의 값이 변하지 않은ㅁ

    }



}
