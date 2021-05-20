package myfleet.data;
/**
 * Other maintenance is a subtype of mechanical cost, related to typify any type of maintenance not proposed in the menu
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class OtherMaintenance extends MechanicalCost implements DataMode
{
    private String additionalDescription;

    /**
     * Constructor for other maintenance type of action
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param mechanicalCostType > type of cost
     * @param replacementUsed > replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehicle
     * @param totalCost > cost of the action
     * @param additionalDescription > any additional description
     */
    public OtherMaintenance(String actionDate, Vehicle vehicle, String mechanicalCostType, String replacementUsed,
                            double actualKms, double totalCost, String additionalDescription)
    {
        super(actionDate, vehicle, mechanicalCostType, replacementUsed, actualKms, totalCost);
        this.additionalDescription = additionalDescription;
    }

    /**
     * Constructor for other maintenance type of action without mechanical cost type info
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param replacementUsed>  replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehcile
     * @param totalCost > cost of the action
     * @param additionalDescription > any additional description
     */
    public OtherMaintenance(String actionDate, Vehicle vehicle, String replacementUsed, double actualKms,
                            double totalCost, String additionalDescription)
    {
        super(actionDate, vehicle, "Other type of maintenance", replacementUsed, actualKms, totalCost);
        this.additionalDescription = additionalDescription;
    }

    /**
     * Method to get the action's description
     * @return description specified
     */
    public String getAdditionalDescription()
    {
        return additionalDescription;
    }

    /**
     * Method to collect the additional description
     * @param additionalDescription > new additional description indicated
     */
    public void setAdditionalDescription(String additionalDescription)
    {
        this.additionalDescription = additionalDescription;
    }

    /**
     * Method to show the information of other maintenance
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    @Override
    public String toString()
    {
        return actionDate + " - " + vehicle + " - " + actualKms + "kms. " + mechanicalCostType + " (" + replacementUsed
                + additionalDescription + ") " + totalCost + "€";
    }
    /**
     * Another Method to show the information of other maintenance without de whole vehicle information
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    public String toShowFormatWithoutVehicle()
    {
        return actionDate.substring(6) + "/" + actionDate.substring(4,6) + "/" + actionDate.substring(0,4) + " - "
                + actualKms + "kms || " + mechanicalCostType + " - " + replacementUsed + ", " + additionalDescription +
                " [" + totalCost + "€]";
    }

    /**
     * Method to store the information in a specific way at the txt
     * @return other's maintenance information separated by |
     */
    public String toStockFormat()
    {
        return actionDate + "|" + vehicle + "|" + mechanicalCostType + "|" + replacementUsed + "|" + actualKms + "|" +
                totalCost + "|" + additionalDescription;
    }
}
