class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	public Student(String name, int exam1, int exam2, int exam3)throws Exception{
		this.name=name;
		
			if((0<=exam1)&&(exam1<=100)){
				this.exam1=exam1;
			}
			else{
				throw new Exception("Exam scores must be between 0 and 100.");
			}
			if((0<=exam2)&&(exam2<=100)){
				this.exam2=exam2;
			}
			else{
				throw new Exception("Exam scores must be between 0 and 100.");
			}
			if((0<=exam3)&&(exam3<=100)){
				this.exam3=exam3;
			}
			else{
				throw new Exception("Exam scores must be between 0 and 100.");
			}
		
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public int getExam1(){
		return exam1;
	}
	public void setExam1(int exam1){
		this.exam1=exam1;
	}
	
	public int getExam2(){
		return exam2;
	}
	public void setExam2(int exam2){
		this.exam2=exam2;
	}
	
	public int getExam3(){
		return exam3;
	}
	public void setExam3(int exam3){
		this.exam3=exam3;
	}
	
	public double calculateAverage(){
		double average;
		average=(exam1+exam2+exam3)/3.0;
		return average;
	}
}
class GradeCalculator{
	public static void main(String[] args){
		Student s1;
		try{
			s1=new Student("John",75,110,90);
			System.out.println("Name of the student: "+s1.getName()+".");
			System.out.println("The average is "+s1.calculateAverage()+".");
		}
		catch(Exception e){
			System.out.println("The entered marks is invalid");
			System.out.println(e.getMessage());
		}
	}
}
