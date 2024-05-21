package com.my.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LuckyNumberGenerator.class})
public class LuckyNumberGeneratorTests {

    LuckyNumberGenerator luckyNumberGenerator;
    LuckyNumberGenerator mock;

    @Test
    public final void givenPrivateMethodWithReturn_whenUsingPowerMockito_thenCorrect() throws Exception {
        luckyNumberGenerator = new LuckyNumberGenerator();
        mock = spy(luckyNumberGenerator);

        when(mock, "getDefaultLuckyNumber").thenReturn(300);

        int result = mock.getLuckyNumber(null);

        assertEquals(300, result);
    }

    @Test
    public final void givenPrivateMethodWithArgumentAndReturn_whenUsingPowerMockito_thenCorrect() throws Exception {
        luckyNumberGenerator = new LuckyNumberGenerator();
        mock = spy(luckyNumberGenerator);

        doReturn(1).when(mock, "getComputedLuckyNumber", anyInt());

        int result = mock.getLuckyNumber("Jack");

        assertEquals(1, result);
    }

    @Test
    public final void givenPrivateMethodWithNoArgumentAndReturn_whenUsingPowerMockito_thenCorrect() throws Exception {
        LuckyNumberGenerator mock = spy(new LuckyNumberGenerator());

        int result = mock.getLuckyNumber("Tyranosorous");

        verifyPrivate(mock).invoke("saveIntoDatabase", anyString());
        assertEquals(10000, result);
    }
}
