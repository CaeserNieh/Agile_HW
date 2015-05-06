import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import static java.lang.System.lineSeparator;

public class UI_unit_test {
    
	public GradeSystems aGradeSystem;
	private String ID;
	public boolean exit = false;
	private UI aUI;
	private ByteArrayOutputStream output_console;

	/**output_console**/
	private void consoleOutput(){
		output_console = new ByteArrayOutputStream();
		System.setOut(new PrintStream( output_console ) );
	}
	
	/**content**/
	private void consoleInput( String content ) {
        System.setIn( new ByteArrayInputStream( content.getBytes() ) );
    }
	
	@Before
	public void setup() throws Exception{
		consoleInput("Q");
		aUI = new UI();
		consoleOutput();
	}
	
	
	@Test 
	public void testcase_checkID() throws Exception{
		boolean answer = aUI.checkID("955002056");
		assertTrue(answer);
	}
	
	@Test
	public void testcase_G_R_E_promptCommand() throws Exception{
		consoleInput("955002056\nG\nR\nE\nQ");
		aUI = new UI();
		
		String expectedOutput =
                "��J ID �άO Q(����) \n"+
                "Welcome �\����\n"+
                "��J���O  : 1) G ��ܦ��Z (Grade)\n"+
                "        2) R ��ܱƦW (Rank)\n"+
                "        3) W ��s�t�� (Weight)\n"+
                "        4) E ���}��� (Exit)\n"+
                "Name : �\����\n"+
                "Student ID : 955002056\n"+
                "lab1 : 88\n"+
                "lab2 : 92\n"+
                "lab3 : 88\n"+
                "mid-term : 98\n"+
                "final exam : 91\n"+
                "total grade : 93\n"+
                "��J���O  : 1) G ��ܦ��Z (Grade)\n"+
                "        2) R ��ܱƦW (Rank)\n"+
                "        3) W ��s�t�� (Weight)\n"+
                "        4) E ���}��� (Exit)\n"+
                "�\���� �ƦW�� 9\n"+
                "��J���O  : 1) G ��ܦ��Z (Grade)\n"+
                "        2) R ��ܱƦW (Rank)\n"+
                "        3) W ��s�t�� (Weight)\n"+
                "        4) E ���}��� (Exit)\n"+
                "��J ID �άO Q(����) \n"+ 
                "�����o!!!\n";

        assertEquals( expectedOutput, output_console.toString() );
	}

	//lineSeparator() detect println();
	//"\n" detect printf("\n")
		
	@Test 
	public void testcase_promptID() throws Exception{
		aUI.promptID();
		String exceptOutput = "��J ID �άO Q(����) \n";
		assertEquals( exceptOutput , output_console.toString() );
	}
	
	@Test
	public void testcase_showFinishMsg() throws Exception{
		aUI.showFinishMsg();
		assertEquals( "�����o!!!\n" , output_console.toString() );
		
	}
	
	@Test
	public void testcase_showWelcomeMsg() throws Exception{
		aUI.showWelcomeMsg();
		assertEquals( "Welcome " , output_console.toString() );
	}
	
}