class Student{
	
	private int studentId;
	private String name;
	private int daysAttended;
	
	public Student(int studentId, String name, int daysAttended){
		this.studentId=studentId;
		this.name=name;
		this.daysAttended=daysAttended;
	}
	
	public int getStudentId(){
		return studentId;
	}
	
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getDaysAttended(){
		return daysAttended;
	}
	
	public void setDaysAttended(int daysAttended){
		this.daysAttended=daysAttended;
	}
	
}

class ClassRoom{
	private Student[] studentObject;
	private int totalStudents;
	
	public ClassRoom(){
	studentObject =new Student[10];
	totalStudents=0;
	}
	
	public void addStudent(Student student){
		if(totalStudents<studentObject.length){
			studentObject[totalStudents++]=student;
		}
		else{
			System.out.println("Sorry,The class is full.We can't enroll a new student");
		}
	}
	
	public void updateDaysAttended(int studentID,int updatedAttendance){
		
		for(int i=0;i<totalStudents;i++){
			if(studentObject[i].getStudentId()==studentID){
				studentObject[i].setDaysAttended(updatedAttendance);
				return;
			}
		}
		
		System.out.println("Sorry,The Id number you entered "+studentID+" is wrong.");
		
	}
	
	public void displayDetails(){
		for(int i=0;i<totalStudents;i++){
			
			System.out.println("The name of the student is "+studentObject[i].getName()+". The student's id is "+studentObject[i].getStudentId()+
			". The student's attendence count is "+studentObject[i].getDaysAttended());
		
		}
	}
}

 class Main{
	public static void main(String[] args){	
		ClassRoom clsRm=new ClassRoom();
	
		clsRm.addStudent(new Student(101,"Alice Smith",12));
		clsRm.addStudent(new Student(102,"Bob Jones",15));
		clsRm.addStudent(new Student(103,"Carol Lee",10));
	
		clsRm.updateDaysAttended(102,16);
		clsRm.updateDaysAttended(104,16);
	
		clsRm.displayDetails();
	}
}