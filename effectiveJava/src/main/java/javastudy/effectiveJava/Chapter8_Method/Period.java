package javastudy.effectiveJava.Chapter8_Method;

import java.util.Date;

public final class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
//    public Period(Date start, Date end) {
//        if (start.compareTo(end) > 0)
//            throw new IllegalArgumentException(
//                    start + " after " + end);
//        this.start = start;
//        this.end = end;
//        //this.start = new Date(); -> final이므로 할당 이후 재할당 불가
//    }

    public Period(Date start, Date end) {
        //복사본을 만들어서 사용
        this.start = (Date) start.clone();
        this.end = (Date) end.clone();

        //불변식 검사
        if (this.start.compareTo(this.end) > 0) //start 가 end보다 늦은 경우 불변식이 해쳐지고, 예외
            throw new IllegalArgumentException(start + " after " + end);
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

}
