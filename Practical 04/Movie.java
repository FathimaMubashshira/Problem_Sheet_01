class CinemaTicket{
	private int ticketNumber;
	private String customerName;
	private int seatNumber;
	
	public CinemaTicket(int ticketNumber, String customerName, int seatNumber){
		this.ticketNumber=ticketNumber;
		this.customerName=customerName;
		this.seatNumber=seatNumber;
	}
	
	public int getTicketNumber(){
		return ticketNumber;
	}
	
	public void setTicketNumber(int ticketNumber){
		this.ticketNumber=ticketNumber;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public void setCustomerName(String customerName){
		this.customerName=customerName;
	}
	
	public int getSeatNumber(){
		return seatNumber;
	}
	
	public void setSeatNumber(int seatNumber){
		this.seatNumber=seatNumber;
	}
}

class BookingSystem{
	private CinemaTicket[] tickets;
	private int bookedSeats;
	
	public BookingSystem(){
		tickets =new CinemaTicket[10];
		bookedSeats=0;
	}
	
	public void bookticket(CinemaTicket cinematicket){
		if(bookedSeats<tickets.length){
			tickets[bookedSeats++]=cinematicket;
		}
		
		else{
			System.out.println("Sorry! No seats avilable.");
		}
	}
	
	public void cancelTicket(int ticketnumber){
		for(int i=0;i<bookedSeats;i++){
			if(tickets[i].getTicketNumber() == ticketnumber){
				for(int j=i;j<bookedSeats-1;j++){
					tickets[j]= tickets[j+1];
				}
				tickets[bookedSeats - 1] = null;
				bookedSeats--;
				System.out.println("The ticket with the number " + ticketnumber + " has been cancelled.");
				return;
			}
		}
	}
	
	public void displayBookedDetails(){
		for(int i=0;i<bookedSeats;i++){
			System.out.println("Ticket number: "+tickets[i].getTicketNumber()+" Customer name: "+tickets[i].getCustomerName()+
			" Seat number: "+tickets[i].getSeatNumber());
		}
	}
}

class Main{
	public static void main(String[] args){
		BookingSystem bookingsystem= new  BookingSystem();
		
		bookingsystem.bookticket(new CinemaTicket(1,"Alice",1));
		bookingsystem.bookticket(new CinemaTicket(2,"Adam",2));
		bookingsystem.bookticket(new CinemaTicket(3,"Bob",3));
		
		bookingsystem.displayBookedDetails();
		
		bookingsystem.cancelTicket(2);
		
		bookingsystem.displayBookedDetails();
	}
}