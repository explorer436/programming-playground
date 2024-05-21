package com.my.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithFinalMethods.class})
public class CollaboratorWithFinalMethodsTests {

    @Test
    public void givenFinalMethods_whenUsingPowerMockito_thenCorrect() throws Exception {
        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);

        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();

        when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");
        String welcome = collaborator.helloMethod();
        verify(collaborator).helloMethod();
        assertEquals("Hello Baeldung!", welcome);
    }

}
