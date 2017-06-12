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

import static fr.alex.kata.marsrover.domain.exception.LocationException.STOP_FORWARD;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by alex on 02/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ForwardTest {
    @Mock
    Rover roverIn;

    Rover roverOut;

    @InjectMocks
    Forward forward;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before(){
        roverOut = Mockito.mock(Rover.class);
    }

    @Test
    public void should_FORWARD_when_rover_is_NOT_OUT_of_map() throws AbstractBusinessException {
        when(roverIn.forward()).thenReturn(roverOut);
        when(roverOut.isOut(any(MarsMap.class))).thenReturn(false);
        //when
        forward.execute();

        verify(roverIn).forward();
        verify(roverOut).isOut(any(MarsMap.class));

    }

    @Test
    public void should_REJECT_FORWARD_when_rover_is_OUT_of_map() throws AbstractBusinessException{
        expectedException.expect(LocationException.class);
        expectedException.expectMessage(STOP_FORWARD);
        when(roverIn.forward()).thenReturn(roverOut);
        when(roverOut.isOut(any(MarsMap.class))).thenReturn(true);
        //when
        forward.execute();

        verify(roverIn).forward();
        verify(roverOut).isOut(any(MarsMap.class));

    }

}