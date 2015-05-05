import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GradeSystems_unit_test {
    
	private GradeSystems grade;
	private ByteArrayOutputStream output_console;
	
	private void console(){
		output_console = new ByteArrayOutputStream();
		System.setOut(new PrintStream( output_console ) );
	}
	
	private void consoleInput( String content ) {
        System.setIn( new ByteArrayInputStream( content.getBytes() ) );
    }
	
	
	@Before
	public void setUp() throws Exception{
		grade = new GradeSystems();
		console();
	}
	
	@Test
	public void testcase_ContainsID() throws Exception{
		boolean answer = grade.check("962001051");
		assertTrue(answer);
	}
	
	@Test 
	public void testcase_showGrade() throws Exception{
		grade.showGrade("962001051");
		String answer =  "Name : 李威廷\n"+ 
				"Student ID : 962001051\n"+
				"lab1 : 81\n"+
				"lab2 : 98\n"+
				"lab3 : 84\n"+
				"mid-term : 90\n"+
				"final exam : 93\n"+
				"total grade : 91\n";
		assertEquals(answer,output_console.toString());
	}
	
	@Test
	public void testcase_showRank() throws Exception{
		grade.showRank("962001051");
		String answer = "李威廷 排名第 22\n";
		assertEquals(answer,output_console.toString());
	}
	
	@Test
	public void testcase_UpdateWeights() throws Exception{
		
		float[] temp = {20,20,20,20,20};
		String answer =  "舊配分\n"  + 
				"lab1 : 10" + "%\n" +
				"lab2 : 10" + "%\n" + 
				"lab3 : 10" + "%\n" + 
				"mid-term : 30" + "%\n" + 
				"final exam : 40" + "%\n" +   
				"請輸入新配分(1~100)，且五個數字相加等於100 !!!\n" + 
				"lab1:\n" + 
				"lab2:\n" + 
				"lab3:\n" + 
				"mid-term:\n" + 
				"final exam:\n" + 
				"請確認新配分\n" + 
				"lab1 : "  + String.valueOf((int)temp[0]) + "%\n" +
				"lab2 : " + String.valueOf((int)temp[1]) + "%\n" +
				"lab3 : " + String.valueOf((int)temp[2])+ "%\n" +
				"mid-term : " + String.valueOf((int)temp[3])+ "%\n" +
				"final exam : " + String.valueOf((int)temp[4])+ "%\n" ;
		
		String  Input = 
				temp[0] + "\n" +
                temp[1] + "\n" +
                temp[2] + "\n" +
                temp[3] + "\n" +
                temp[4] + "\n" ;
		
		consoleInput( Input );

        grade.updateWeights();

        assertEquals( answer, output_console.toString() );
		
	}
	
	
}