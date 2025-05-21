class Vehicles{
	private String licensePlate;
	private String ownerName;
	private int hoursParked;
	
	public Vehicles(String licensePlate,String ownerName,int hoursParked ){
		this.licensePlate=licensePlate;
		this.ownerName=ownerName;
		this.hoursParked=hoursParked;
	}
	
	public String getLicensePlate(){
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate){
		this.licensePlate=licensePlate;
	}
	
	public String getOwnerName(){
		return ownerName;
	}
	
	public void setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}
	
	public int getHoursParked(){
		return hoursParked;
	}
	
	public void setHoursParked(int hoursParked){
		this.hoursParked=hoursParked;
	}
}

class ParkingLot{
	private Vehicles[] vehicleCount;
	private int totalVehicles=0;
	
	public ParkingLot(){
		vehicleCount = new Vehicles[5];
		totalVehicles=0;
	}
	
	public void addVehicle(Vehicles vehicle){
		 if(totalVehicles<vehicleCount.length){
			 vehicleCount[totalVehicles++]=vehicle;
		 }
		 
		 else{
			 System.out.println("The parking is already fill.");
		 }
	}
	
	public void removeVehicle(String licenseplate){
		for(int i=0;i<totalVehicles;i++){
			if(vehicleCount[i].getLicensePlate()==licenseplate){
				for(int j=i;j<totalVehicles-1;j++){
					vehicleCount[j]=vehicleCount[j+1];
				}
				vehicleCount[totalVehicles - 1] = null;
				totalVehicles--;
				System.out.println("Vehicle with license plate " + licenseplate + " has been removed.");
				return;
			}
			//System.out.println("The entered licenseplate number "+licenseplate+" is wrong");
		}
	}
	
	public void displayVehicles(){
		for(int i=0;i<totalVehicles;i++){
			System.out.println("The owner of the vehicle is "+vehicleCount[i].getOwnerName()+" and the license plate is "+vehicleCount[i].getLicensePlate()+
			" ,and Parked hours: "+vehicleCount[i].getHoursParked());
		}
	}
	
	
}
class Main{
	public static void main(String[] args){
	
	ParkingLot parking=new ParkingLot();
	
	parking.addVehicle(new Vehicles( "ABC123", "John Doe",2));
	parking.addVehicle(new Vehicles( "XYZ789", "Jane Smith",4));
	parking.addVehicle(new Vehicles( "LMN456","Bob Brown" ,1));
	
	parking.displayVehicles();
	
	parking.removeVehicle("XYZ789");
	
	parking.displayVehicles();
	
	}
	
}