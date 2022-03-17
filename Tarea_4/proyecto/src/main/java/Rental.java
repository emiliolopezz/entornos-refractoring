
import java.util.Enumeration;
import java.util.Vector;

public class Rental {
    private Movie _movie;
    private int _daysRented;
    private Vector _rentals = new Vector();

    public Rental (Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie () {
        return _movie;
    }
    private double  getCharge()    {
        double thisAmount = 0;
        Enumeration rentals = _rentals.elements();
        Rental each = (Rental) rentals.nextElement();
            
          // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            return thisAmount;
    }
}
