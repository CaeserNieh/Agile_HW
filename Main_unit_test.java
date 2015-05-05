import java.io.ByteArrayInputStream;

import org.junit.Test;

import static org.junit.Assert.*;

public class Main_unit_test {
    @Test
    public void testMain() throws Exception {
    	System.setIn( new ByteArrayInputStream( "Q".getBytes() ) );
    	Main.main( null );
    }
}