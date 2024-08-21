package javastudy.effectiveJava.Chapter8_Method;


import java.util.Date;

public class PeriodTest {
    public static void main(String[] args) {


        Date start = new Date();
        Date end = new Date();

        Period period = new Period(start,end);

//        period.end().setYear(87);



        BadDate start2 = new BadDate();
        BadDate end2 = new BadDate();
//
        Period period2 = new Period(start2,end2);
//
        System.out.println("?");
        System.out.println(period2.end());
        System.out.println("?");
    }

}


