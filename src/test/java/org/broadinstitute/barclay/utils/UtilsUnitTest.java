package org.broadinstitute.barclay.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;

public class UtilsUnitTest {
    @Test
    public void testJoinCollection() {
        Assert.assertEquals("0-1-2", Utils.join("-", asList(0, 1, 2)));
        Assert.assertEquals("0", Utils.join("-", asList(0)));
        Assert.assertEquals("", Utils.join("-", asList()));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNonNullThrows(){
        final Object o = null;
        Utils.nonNull(o);
    }

    @Test
    public void testNonNullDoesNotThrow(){
        final Object o = new Object();
        Assert.assertSame(Utils.nonNull(o), o);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "^The exception message$")
    public void testNonNullWithMessageThrows() {
        Utils.nonNull(null, "The exception message");
    }

    @Test
    public void testNonNullWithMessageReturn() {
        final Object testObject = new Object();
        Assert.assertSame(Utils.nonNull(testObject, "some message"), testObject);
    }

}
