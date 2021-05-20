package myfleet.data;
/**
 * Refueling is a type of management action
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class Refueling extends myfleet.data.Action implements DataMode
{
    private double litersRefueled, partialKms, totalPriceRefueling;

    /**
     * Constructor for refueling action
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param litersRefueled > number of litters refueled
     * @param partialKms > kms accumulated at that time in the vehicle
     * @param totalPriceRefueling> cost of the refueling
     */
    public Refueling(String actionDate, myfleet.data.Vehicle vehicle, double litersRefueled, double partialKms,
                     double totalPriceRefueling)
    {
        super(actionDate, vehicle);
        this.litersRefueled = litersRefueled;
        this.partialKms = partialKms;
        this.totalPriceRefueling = totalPriceRefueling;
    }

    /**
     * Method to get the litters refueled
     * @return litters refueled specified
     */
    public double getLitersRefueled()
    {
        return litersRefueled;
    }
    /**
     * Method to collect the litters refueled
     * @param litersRefueled > new litters refueled indicated
     */
    public void setLitersRefueled(double litersRefueled)
    {
        this.litersRefueled = litersRefueled;
    }
    /**
     * Method to get the kms
     * @return kms specified
     */
    public double getPartialKms()
    {
        return partialKms;
    }
    /**
     * Method to collect the kms
     * @param partialKms > new kms indicated
     */
    public void setPartialKms(double partialKms)
    {
        this.partialKms = partialKms;
    }
    /**
     * Method to get the price of the refueling
     * @return price of the refueling specified
     */
    public double getTotalPriceRefueling()
    {
        return totalPriceRefueling;
    }
    /**
     * Method to collect the price of the refueling
     * @param totalPriceRefueling > new price of the refueling indicated
     */
    public void setTotalPriceRefueling(double totalPriceRefueling)
    {
        this.totalPriceRefueling = totalPriceRefueling;
    }

    /**
     * Method to show the information of refueling
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    @Override
    public String toString() {
        return actionDate + " - " + vehicle + " - " +partialKms + "kms. " + litersRefueled + "l. " +
                totalPriceRefueling + "€";
    }
    /**
     * Another Method to show the information of refueling without de whole vehicle information
     * @return the information in the way we wanna show at JavaFX app
     */
    public String toShowFormatWithoutVehicle()
    {
        return actionDate.substring(6) + "/" + actionDate.substring(4,6) + "/" + actionDate.substring(0,4) + " - "
                + partialKms + "kms - " + litersRefueled + "l [" +  totalPriceRefueling + "€]";
    }
    /**
     * Method to store the information in a specific way at the txt
     * @return refueling information separated by |
     */
    public String toStockFormat()
    {
        return actionDate + "|" + vehicle + "|" + litersRefueled + "|" + partialKms + "|" + totalPriceRefueling;
    }
}
