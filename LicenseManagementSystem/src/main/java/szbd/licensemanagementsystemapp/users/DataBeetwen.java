package szbd.licensemanagementsystemapp.users;

import java.time.LocalDate;

public class DataBeetwen {
	LocalDate Start=LocalDate.now();
	LocalDate End=LocalDate.now();
	
	
	
	public LocalDate getStart() {
		return Start;
	}
	public void setStart(LocalDate start) {
		this.Start = start;
	}
	public LocalDate getEnd() {
		return End;
	}
	public void setEnd(LocalDate end) {
		this.End = end;
	}
	
	

}
