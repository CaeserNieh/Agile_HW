/** **********************************************
class GradeSystems纗 a list of student grades.

	containsID(ID)  //aGradeSystemΤID
	GradeSystems () //篶
	showGrade(ID)
	showRank(ID)
	updateWeights ()

************************************************ **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeSystems {
    float weights[] = {(float)0.1, (float)0.1, (float)0.1, (float)0.3, (float)0.4};
	String name[] = {"lab1","lab2","lab3","mid-term","final exam"};
	public LinkedList <Grades> aList = new LinkedList<>();
	
	public GradeSystems(){
		try{
			FileReader file = new FileReader("D:\\gradeinput.txt");
			BufferedReader buf = new BufferedReader(file);
			String input;
			while(buf.ready()){
				input = buf.readLine();
				aList.add(buildList(input));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	/**--------------------buildList(input)-----------------------
	buildList (input) return aGrade
	parameter: input   a Line from input text file  
	ex: 962001044 ﹙ 87 86 98 88 87
	time:   O(n) n is gradeinput.txt ず戈掸计
	------------------------------------------------------------**/
	public Grades buildList(String input){
		Scanner scan = new Scanner(input);
		Grades aGrade = new Grades(scan.next(),scan.next(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
		aGrade.totalGrade = aGrade.calculateToGrade(weights);
		return aGrade;	
	}
	
	/**---------------------showGrade (ID)-------------------------
	  parameter: ID a user ID ex: 962001044
	  time: O(n) n is aGradeSystem ず痁计
	 ----------------------------------------------------------- **/
	public  void showGrade(String ID){
		Grades  temp_grade = null;
		for (Grades agrade : aList){	
			if(agrade.ID.equals(ID)){
				temp_grade = agrade;
			}
		}
		if(temp_grade != null){
			System.out.printf("Name : %s\n",temp_grade.name);
			System.out.printf("Student ID : %s\n",temp_grade.ID);
			System.out.printf("lab1 : %s\n",temp_grade.lab1);
			System.out.printf("lab2 : %s\n",temp_grade.lab2);
			System.out.printf("lab3 : %s\n",temp_grade.lab3);
			System.out.printf("mid-term : %s\n",temp_grade.midTerm);
			System.out.printf("final exam : %s\n",temp_grade.finalExam);
			System.out.printf("total grade : %s\n",temp_grade.totalGrade);
		}
		
	}
	
	/**---------------------showRank (ID)-------------------------
	  parameter: ID a user ID ex: 962001044
	  time: O(n) n is aGradeSystem ず痁计
	 ----------------------------------------------------------- **/
	public  void showRank(String ID){
		int rank = 1;
		Grades temp = find(ID);
		if(temp != null){
			for(Grades agrade : aList){
				if(agrade.totalGrade> temp.totalGrade){
					rank ++;
				}
			}
		}
		System.out.printf("%s 逼材 %d\n",temp.name,rank);
	}
	
	/**---------------------find (ID)-------------------------
	  find (ID) return temp_grade
	  parameter: ID a user ID ex: 962001044
	  time: O(n) n is aGradeSystem ず痁计
	 ----------------------------------------------------------- **/
	public  Grades find(String ID){
		Grades  temp_grade = null;
		for (Grades agrade : aList){
			if(agrade.ID.equals(ID)){
				temp_grade = agrade;
			}
		}
		if(temp_grade != null){
			return temp_grade;
		}
		return null;
	}
	
	/**---------------------check (ID)-------------------------
	  find (ID) return boolean
	  parameter: ID a user ID ex: 962001044
	  time: O(n) n is aGradeSystem ず痁计
	 ----------------------------------------------------------- **/
	public  boolean check(String ID){
		if(find(ID) != null)
			return true;
		else
			return false;
	}
	
	/**---------------------updateWeights (ID)-------------------------
	  updateWeights() throws NoSuchCommandExceptions
	  time: O(1)
	 ----------------------------------------------------------- **/
	public void updateWeights() throws NoSuchCommandExceptions{
		float temp[];
		showOldWeights();
		temp = getNewWeights();
		setWeights(temp);
		update_Total_Grades();
		
	}

	/** ---------------------setWeights (ID)--------------------- 
	 parameter: weights new weights ex:12 12 12 12 52 
	 time: O(1) 
	 ----------------------------------------------------------- */
	private void setWeights(float[] weights2) {
		this.weights = weights2;
	}

	/**---------------------getNewWeights ()-------------------------
	  getNewWeights() throws NoSuchCommandExceptions
	  time: O(1)
	 ----------------------------------------------------------- **/
	private float[] getNewWeights() throws NoSuchCommandExceptions{
		float new_weight[] = weights;
		Scanner scann = new Scanner(System.in);
		System.out.printf("叫块穝皌だ(1~100)き计单100 !!!\n");
		for(int i = 0;i<weights.length;i++){
			System.out.printf("%s:\n",name[i]);
			if(scann.hasNextFloat()){
				new_weight[i] = scann.nextFloat()/100;
			}else{
				throw new NoSuchCommandExceptions();
			}
		}
		System.out.printf("叫絋粄穝皌だ\n");
		show_weight();
		return new_weight;
	}

	private void showOldWeights() {
		System.out.printf("侣皌だ\n");
		show_weight();
	}
	
	private void show_weight(){
		System.out.printf("lab1 : %s\n",String.valueOf((int)(weights[0]*100))+"%");
		System.out.printf("lab2 : %s\n",String.valueOf((int)(weights[1]*100))+"%");
		System.out.printf("lab3 : %s\n",String.valueOf((int)(weights[2]*100))+"%");
		System.out.printf("mid-term : %s\n",String.valueOf((int)(weights[3]*100))+"%");
		System.out.printf("final exam : %s\n",String.valueOf((int)(weights[4]*100))+"%");
	}
	
	/**---------------------update_Total_Grades ()-------------------------
	  time: O(n) n is aGradeSystem ず痁计
	 ----------------------------------------------------------- **/
	private void update_Total_Grades(){
		for(Grades grade : aList){
			grade.totalGrade = grade.calculateToGrade(weights);
		}
	}
	
	
	
}