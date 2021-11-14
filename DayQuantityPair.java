import java.time.LocalDate;
import java.io.Serializable;

/**
 * The type Day quantity pair.
 */
public class DayQuantityPair implements Serializable{
    /**
     * The Day.
     */
    private LocalDate day;
    /**
     * The Quantity.
     */
    private int quantity;

    /**
     * Instantiates a new Day quantity pair.
     */
    public DayQuantityPair(){}

    /**
     * Instantiates a new Day quantity pair.
     *
     * @param day      the day
     * @param quantity the quantity
     */
    public DayQuantityPair(LocalDate day, int quantity){
        this.day = day;
        this.quantity = quantity;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public LocalDate getDay() {
        return this.day;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(LocalDate day) {
        this.day = day;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
