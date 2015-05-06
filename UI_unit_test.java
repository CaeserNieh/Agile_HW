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
                "輸入 ID 或是 Q(結束) \n"+
                "Welcome 許文馨\n"+
                "輸入指令  : 1) G 顯示成績 (Grade)\n"+
                "        2) R 顯示排名 (Rank)\n"+
                "        3) W 更新配分 (Weight)\n"+
                "        4) E 離開選單 (Exit)\n"+
                "Name : 許文馨\n"+
                "Student ID : 955002056\n"+
                "lab1 : 88\n"+
                "lab2 : 92\n"+
                "lab3 : 88\n"+
                "mid-term : 98\n"+
                "final exam : 91\n"+
                "total grade : 93\n"+
                "輸入指令  : 1) G 顯示成績 (Grade)\n"+
                "        2) R 顯示排名 (Rank)\n"+
                "        3) W 更新配分 (Weight)\n"+
                "        4) E 離開選單 (Exit)\n"+
                "許文馨 排名第 9\n"+
                "輸入指令  : 1) G 顯示成績 (Grade)\n"+
                "        2) R 顯示排名 (Rank)\n"+
                "        3) W 更新配分 (Weight)\n"+
                "        4) E 離開選單 (Exit)\n"+
                "輸入 ID 或是 Q(結束) \n"+ 
                "結束囉!!!\n";

        assertEquals( expectedOutput, output_console.toString() );
	}

	//lineSeparator() detect println();
	//"\n" detect printf("\n")
		
	@Test 
	public void testcase_promptID() throws Exception{
		aUI.promptID();
		String exceptOutput = "輸入 ID 或是 Q(結束) \n";
		assertEquals( exceptOutput , output_console.toString() );
	}
	
	@Test
	public void testcase_showFinishMsg() throws Exception{
		aUI.showFinishMsg();
		assertEquals( "結束囉!!!\n" , output_console.toString() );
		
	}
	
	@Test
	public void testcase_showWelcomeMsg() throws Exception{
		aUI.showWelcomeMsg();
		assertEquals( "Welcome " , output_console.toString() );
	}
	
}