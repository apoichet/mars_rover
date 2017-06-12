package fr.alex.kata.marsrover.domain.command.impl;

import fr.alex.kata.marsrover.domain.MarsMap;
import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;
import fr.alex.kata.marsrover.domain.exception.LocationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static fr.alex.kata.marsrover.domain.exception.LocationException.STOP_BACKWARD;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by alex on 02/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class BackwardTest {


    @Mock
    Rover roverIn;

    Rover roverOut;

    @InjectMocks
    Backward bakward;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before(){
        roverOut = Mockito.mock(Rover.class);
    }

    @Test
    public void should_BACKWARD_when_rover_is_NOT_OUT_of_map() throws AbstractBusinessException{
        when(roverIn.backward()).thenReturn(roverOut);
        when(roverOut.isOut(any(MarsMap.class))).thenReturn(false);
        //when
        bakward.execute();

        verify(roverIn).backward();
        verify(roverOut).isOut(any(MarsMap.class));

    }

    @Test
    public void should_REJECT_BACKWARD_when_rover_is_OUT_of_map() throws AbstractBusinessException{
        expectedException.expect(LocationException.class);
        expectedException.expectMessage(STOP_BACKWARD);
        when(roverIn.backward()).thenReturn(roverOut);
        when(roverOut.isOut(any(MarsMap.class))).thenReturn(true);
        //when
        bakward.execute();

        verify(roverIn).backward();
        verify(roverOut).isOut(any(MarsMap.class));

    }

}