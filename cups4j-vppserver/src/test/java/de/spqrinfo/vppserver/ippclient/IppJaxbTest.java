package de.spqrinfo.vppserver.ippclient;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class IppJaxbTest {

    @Test
    public void constructorTest() throws Exception {
        final IppJaxb obj = new IppJaxb();
        assertThat(obj, CoreMatchers.notNullValue());
    }
}
