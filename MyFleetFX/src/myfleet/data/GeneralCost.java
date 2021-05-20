package myfleet.data;
/**
 * General cost is a type of management action
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class GeneralCost extends myfleet.data.Action implements myfleet.data.DataMode
{
    private String costName, paidDate;
    private double totalCost;
    private boolean paid;

    /**
     * Constructor for general cost action
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param costName > name for this open cost
     * @param totalCost > cost of this action
     * @param paid > if it's paid o not
     * @param paidDate > day of payment
     */
    public GeneralCost(String actionDate, myfleet.data.Vehicle vehicle, String costName, double totalCost, boolean paid,
                       String paidDate)
    {
        super(actionDate, vehicle);
        this.costName = costName;
        this.totalCost = totalCost;
        this.paid = paid;
        this.paidDate = paidDate;
    }
    /**
     * Method to get the name of the cost
     * @return name of the cost specified
     */
    public String getCostName()
    {
        return costName;
    }
    /**
     * Method to collect the name of the cost
     * @param costName > new name of the cost indicated
     */
    public void setCostName(String costName)
    {
        this.costName = costName;
    }
    /**
     * Method to get the total cost
     * @return total cost specified
     */
    public double getTotalCost()
    {
        return totalCost;
    }
    /**
     * Method to collect the total cost
     * @param totalCost > new total cost indicated
     */
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
    /**
     * Method to get if it's paid
     * @return paid specified
     */
    public boolean getPaid()
    {
        return paid;
    }
    /**
     * Method to collect if it's paid
     * @param paid > new paid state indicated
     */
    public void setPaid(boolean paid)
    {
        this.paid = paid;
    }
    /**
     * Method to get the day of payment
     * @return  day of payment specified
     */
    public String getPaidDate()
    {
        return paidDate;
    }
    /**
     * Method to collect the day of payment
     * @param paidDate > new day of payment indicated
     */
    public void setPaidDate(String paidDate)
    {
        this.paidDate = paidDate;
    }
    /**
     * Method to show the information of general cost
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    @Override
    public String toString() {
        return actionDate + " - " + vehicle + " - " + costName + " [" + ((paid)?"Paid":"Outstanding bill") + "] " +
                ((paid)?paidDate:"") + ", " + totalCost + "€";
    }
    /**
     * Another Method to show the information of general without de whole vehicle information
     * @return the information in the way we wanna show at JavaFX app
     */
    public String toShowFormatWithoutVehicle()
    {
        return actionDate.substring(6) + "/" + actionDate.substring(4,6) + "/" + actionDate.substring(0,4) + " - "
                + costName + " - " + ((paid)?"Paid":"Outstanding bill")+ " - " +
                ((paid)?paidDate.substring(6) + "/" + paidDate.substring(4,6) + "/" + paidDate.substring(0,4):"") +
                " [" + totalCost + "€]";
    }
    /**
     * Method to store the information in a specific way at the txt
     * @return general cost information separated by |
     */
    public String toStockFormat()
    {
        return actionDate + "|" + vehicle + "|" + costName + "|" + totalCost + "|" + paid + "|" + paidDate;
    }
}
