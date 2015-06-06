import java.util.ArrayList;


public class Student {
	ArrayList<Float> assignments = new ArrayList<Float>(7);
	public char letterGrade;
	
	public static void main(String[] args){
		//Test the Student class
		Student student = new Student();
		for(int count=0; count <= 6; count++){
			float score = 100;
			try{
				student.addScore(score);
			}
			catch(IndexOutOfBoundsException e){
				System.out.println(e);
			}
		}
		System.out.println("The grade is: " + student.calculateGrade());
	}

	private void addScore(float score){
		//Add a single grade to the assignments array
		if( this.assignments.size() == 7){
			//Max number of elements already reached
			throw new IndexOutOfBoundsException("Array Limit(7) Reached");
		}
		this.assignments.add(score);
		
	}
		
	private char calculateGrade(){
		float total = 0;;
		
		//Weight the four quiz
		for(int count=0;count<=3;count++){
			float value = this.assignments.get(count);
			this.assignments.set(count, value *= .10);
		}
		
		//Weight the midterms
		for(int count=4;count<=5;count++){
			float value = this.assignments.get(count);
			if( count == 4){
				this.assignments.set(count, value *= .20);
			}
			else{
				this.assignments.set(count, value *= .15);
			}
		}
		
		//Weight the final
		float value = this.assignments.get(6);
		this.assignments.set(6, value *= .25);
		
		//Return the average
		for(float score : this.assignments){
			total += score;
		}
		
		char letterlGrade;
		if( total >= 90){
			letterGrade = 'A'; 
		}
		else if( (total <= 89) && (total >= 80)){
			letterGrade = 'B';
		}
		else if( (total <= 79) && (total >= 70)){
			letterGrade = 'C';
		}
		else if( (total <= 69) && (total >= 60)){
			letterGrade = 'D';
		}
		else {		
			letterGrade = 'F';
		}
		return letterGrade;
	}
}


