package javastudy.effectiveJava.Chapter8_Method;

import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BadDate extends Date {
    ObjectOutputStream o;

    private BadDate badDate;

    public BadDate() {
        super();
    }

    public BadDate(long date)
    {
        super(date);
    }

//    @Override
//    public BadDate clone() {
//        BadDate d = (BadDate) super.clone();
//        badDate = d;
//        d = new BadDate(12345678765432l);
//        return d;
//    }


    public BadDate clone() {
        BadDate d = (BadDate) super.clone();
        badDate = d;
        d = new BadDate(12345678765432l);
        return d;
    }

    public BadDate getBadDate() {
        return badDate;
    }
}
