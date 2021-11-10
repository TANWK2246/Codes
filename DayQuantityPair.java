import java.time.LocalDate;
import java.io.Serializable;

public class DayQuantityPair implements Serializable{
    private LocalDate day;
    private int quantity;

    public DayQuantityPair(){}

    public DayQuantityPair(LocalDate day, int quantity){
        this.day = day;
        this.quantity = quantity;
    }

    public LocalDate getDay() {
        return this.day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
