import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Grades_unit_test {
    private Grades grade;
	@Before
	public void setUp(){
		grade = new Grades("test","test",81,98,84,90,93);
	}
	
	@Test 
	public void testcase1_calculateToGrade() throws Exception{
		float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
		int answer = grade.calculateToGrade(weights);
		assertEquals(91,answer);
	}
	
	@Test 
	public void testcase2_calculateToGrade() throws Exception{
		float[] weights = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
		int answer = grade.calculateToGrade(weights);
		assertEquals(89,answer);
	}
	
	

}