import java.util.ArrayList;
import java.io.Serializable;

/**
 * The type Bill array.
 */
public class BillArray implements Serializable{
	/**
	 * The Bills.
	 */
	private ArrayList<Bill> bills = new ArrayList<Bill>();

	/**
	 * Instantiates a new Bill array.
	 */
	public BillArray() {}

	/**
	 * Get bills array list.
	 *
	 * @return the array list
	 */
	public ArrayList<Bill> getBills(){
		return this.bills;
	}

}