package myfleet.data;
/**
 * Oil maintenance is a subtype of mechanical cost
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class OilMaintenance extends MechanicalCost implements DataMode
{
    private String oilViscosity;
    private double oilLiters;

    /**
     * Constructor for oil maintenance type of action
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param mechanicalCostType > type of cost
     * @param replacementUsed > replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehicle
     * @param totalCost > cost of the action
     * @param oilViscosity > oil viscosity used
     * @param oilLiters  litters used
     */
    public OilMaintenance(String actionDate, Vehicle vehicle, String mechanicalCostType, String replacementUsed,
                          double actualKms, double totalCost, String oilViscosity, double oilLiters)
    {
        super(actionDate, vehicle, mechanicalCostType, replacementUsed, actualKms, totalCost);
        this.oilViscosity = oilViscosity;
        this.oilLiters = oilLiters;
    }

    /**
     * Another constructor for oil maintenance type of action without mechanical cost type info
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param replacementUsed > replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehicle
     * @param totalCost > cost of the action
     * @param oilViscosity > oil viscosity used
     * @param oilLiters  litters used
     */
    public OilMaintenance(String actionDate, Vehicle vehicle, String replacementUsed,
                          double actualKms, double totalCost, String oilViscosity, double oilLiters)
    {
        super(actionDate, vehicle, "Oil maintenance", replacementUsed, actualKms, totalCost);
        this.oilViscosity = oilViscosity;
        this.oilLiters = oilLiters;
    }

    /**
     * Method to get oil's viscosity
     * @return oil's viscosity specified
     */
    public String getOilViscosity()
    {
        return oilViscosity;
    }

    /**
     * Method to collect the oil's viscosity
     * @param oilViscosity > new oil's viscosity indicated
     */
    public void setOilViscosity(String oilViscosity)
    {
        this.oilViscosity = oilViscosity;
    }

    /**
     * Method to get litters used
     * @return litters specified
     */
    public double getOilLiters()
    {
        return oilLiters;
    }

    /**
     * Method to collect the litters used
     * @param oilLiters > new litters indicated
     */
    public void setOilLiters(double oilLiters)
    {
        this.oilLiters = oilLiters;
    }

    /**
     * Method to show the information of oil maintenance
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    @Override
    public String toString()
    {
        return actionDate + " - " + vehicle + " - " + actualKms + "kms. " + mechanicalCostType + " (" + replacementUsed
                + oilViscosity + " " + oilLiters + "l.) " + totalCost + "€";
    }
    /**
     * Another Method to show the information of oil maintenance without de whole vehicle information
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    public String toShowFormatWithoutVehicle()
    {
        return actionDate.substring(6) + "/" + actionDate.substring(4,6) + "/" + actionDate.substring(0,4) + " - "
                + actualKms + "kms || " + mechanicalCostType + " - " + replacementUsed + ", " + oilViscosity + " " +
                oilLiters + " [" + totalCost + "€]";
    }
    /**
     * Method to store the information in a specific way at the txt
     * @return oils maintenance information separated by |
     */
    public String toStockFormat()
    {
        return actionDate + "|" + vehicle + "|" + mechanicalCostType + "|" + replacementUsed + "|" + actualKms + "|" +
                totalCost + "|" + oilViscosity + "|" + oilLiters;
    }
}
