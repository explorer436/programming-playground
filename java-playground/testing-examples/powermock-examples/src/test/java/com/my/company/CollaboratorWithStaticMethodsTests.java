package com.my.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.doThrow;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithStaticMethods.class})
public class CollaboratorWithStaticMethodsTests {

    @Test(expected = RuntimeException.class)
    public void givenStaticMethods_whenUsingPowerMockito_thenCorrect() {
        mockStatic(CollaboratorWithStaticMethods.class);

        when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("Hello Baeldung!");
        when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");
        doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        CollaboratorWithStaticMethods.thirdMethod();

        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");

        assertEquals("Hello Baeldung!", firstWelcome);
        assertEquals("Hello Baeldung!", secondWelcome);

        verify(CollaboratorWithStaticMethods.class, times(2));
        CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());

        verify(CollaboratorWithStaticMethods.class, Mockito.never());
        CollaboratorWithStaticMethods.secondMethod();

        CollaboratorWithStaticMethods.thirdMethod();
    }

}