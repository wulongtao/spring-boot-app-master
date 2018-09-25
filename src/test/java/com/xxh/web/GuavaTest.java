package com.xxh.web;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.Objects;

/**
 * @author wulongtao
 */
public class GuavaTest {

    @Test
    public void testOptional() {
        Integer i = 9;
        Optional<Integer> prossible = Optional.fromNullable(i);
        System.out.println(prossible.isPresent());
        System.out.println(prossible.or(5));

//        System.out.println(Optional.of(null).or("5"));

        System.out.println(Objects.hash("www"));
    }

    @Test
    public void testPreconditions() {
        int i = 1;
        Preconditions.checkArgument(i > 0, "error");
    }

}
