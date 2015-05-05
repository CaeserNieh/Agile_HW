/** ##################################################################
  	本Grade system 讓使用者(學生)取得他的總成績total grade 及排名 rank.
	Total grade 基於配分weights 來算 而 weights可以update. 
	Rank 表示此 total grade 在全班學生的分數排序
	
  	Header of input file:
  	檔案路徑須為   :"D:\gradeInput.txt"
  	全班學生的分數 例如
        962001044 凌宗廷 87 86 98 88 87
		962001051   李威廷 81 98 84 90 93
           注意 data field names 如下: 
        ID name lab1 lab2 lab3 midTerm finalExam
#################################################################### **/

public class Main extends Object {
    public static void main(String[] args){
		try{
			new UI();
		}
		catch(NoSuchIDExceptions e){
			System.out.printf("ID錯了!\n");
			//e.printStackTrace();
		}
		catch(NoSuchCommandExceptions e1){
			System.out.printf("指令錯了!\n");
			//e1.printStackTrace();
		}
	}
}


