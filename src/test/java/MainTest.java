import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class MainTest {
    InitialInputCheck initialInputCheck = new InitialInputCheck();
    String inputString;


    @Before
    public void setUp(){
        inputString = "I+1";
    }
    @Test
    public void differentArguments() throws NumberFormatException{
        Throwable throwable = catchThrowable(()->{
              initialInputCheck.InputCheck(inputString);
        });
        assertThat(throwable).isInstanceOf(NumberFormatException.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }

}
