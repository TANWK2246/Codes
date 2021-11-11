import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class BillArray implements Serializable{
	private ArrayList<Bill> bills = new ArrayList<Bill>();

	public BillArray() {}

	public ArrayList<Bill> getBills(){
		return this.bills;
	}

	public void addBill(Bill bill){
		this.bills.add(bill);
	}
	
}