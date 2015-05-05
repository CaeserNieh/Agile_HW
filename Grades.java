/** **********************************************************************
class Grades Àx¦s ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade

calculateTotalGrade(weights)
Grades () { } //«Øºc¤l
************************************************************************/


public class Grades {
    public String ID;
	public String name;
	public int lab1;
	public int lab2;
	public int lab3;
	public int midTerm;
	public int finalExam;
	public int totalGrade;
	
	public Grades(String id,String Na,int l_1,int l_2,int l_3,int mid,int fia){
		ID = id;
		name = Na;
		lab1 = l_1;
		lab2 = l_2;
		lab3 = l_3;
		midTerm = mid;
		finalExam = fia;
	}
	
	/**--------------------calculateToGrade(weights)-----------------------
	calculateToGrade (input) return totalGrade
	parameter: weights[]  weights of grades  
	ex: {0.1, 0.1, 0.1, 0.3, 0.4}
	time:   O(1)
	------------------------------------------------------------**/
	public int calculateToGrade(float weights[]){
		return Math.round(lab1 * weights[0] +lab2 * weights[1] +lab3 * weights[2] + 
				midTerm * weights[3] +finalExam * weights[4]);
	}
}