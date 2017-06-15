package fr.alex.kata.marsrover.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LexerValidatorTest {

  @InjectMocks
  private LexerValidator validator;

  @Test
  public void should_accept_command_instruction_left_L(){
    //Given
    String left = "L";
    //When
    validator.validate(left);
  }

  @Test
  public void should_accept_command_instruction_right_R(){
    //Given
    String right = "R";
    //When
    validator.validate(right);
  }

  @Test
  public void should_accept_command_instruction_forward_F(){
    //Given
    String forward = "F";
    //When
    validator.validate(forward);
  }

  @Test
  public void should_accept_command_instruction_backard_B(){
    //Given
    String backward = "B";
    //When
    validator.validate(backward);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_reject_invalid_command(){
    //Given
    String unknown = "U";
    //When
    validator.validate(unknown);
  }




}