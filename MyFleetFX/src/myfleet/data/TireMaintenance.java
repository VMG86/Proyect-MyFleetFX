package myfleet.data;
/**
 * Tire maintenance is a subtype of mechanical cost
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class TireMaintenance extends MechanicalCost implements DataMode
{
    private String tireType, tireMeasure, efficientyScore, position;

    /**
     * Constructor for tyre maintenance type of action
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param mechanicalCostType > type of cost
     * @param replacementUsed > replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehicle
     * @param totalCost > cost of the action
     * @param tireType > type of tyre used
     * @param tireMeasure > tyre's measure
     * @param efficientyScore > tyre's efficienty score
     * @param position > wht tyre have been replaced
     */
    public TireMaintenance(String actionDate, Vehicle vehicle, String mechanicalCostType, String replacementUsed,
                           double actualKms, double totalCost, String tireType, String tireMeasure,
                           String efficientyScore, String position)
    {
        super(actionDate, vehicle, mechanicalCostType, replacementUsed, actualKms, totalCost);
        this.tireType = tireType;
        this.tireMeasure = tireMeasure;
        this.efficientyScore = efficientyScore;
        this.position = position;
    }

    /**
     * Constructor for tyre maintenance type of action without mechanical cost type info
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param replacementUsed > replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehicle
     * @param totalCost > cost of the action
     * @param tireType > type of tyre used
     * @param tireMeasure > tyre's measure
     * @param efficientyScore > tyre's efficienty score
     * @param position > wht tyre have been replaced
     */
    public TireMaintenance(String actionDate, Vehicle vehicle, String replacementUsed, double actualKms,
                           double totalCost, String tireType, String tireMeasure, String efficientyScore, String position)
    {
        super(actionDate, vehicle, "Tire Maintenance", replacementUsed, actualKms, totalCost);
        this.tireType = tireType;
        this.tireMeasure = tireMeasure;
        this.efficientyScore = efficientyScore;
        this.position = position;
    }

    /**
     * Method to get the tyre type
     * @return tyre type specified
     */
    public String getTireType()
    {
        return tireType;
    }
    /**
     * Method to collect the type of tyre
     * @param tireType > new type of tyre indicated
     */
    public void setTireType(String tireType)
    {
        this.tireType = tireType;
    }
    /**
     * Method to get the tyre measure
     * @return tyre measure specified
     */
    public String getTireMeasure()
    {
        return tireMeasure;
    }
    /**
     * Method to collect the tyre measure
     * @param tireMeasure > new tyre measure indicated
     */
    public void setTireMeasure(String tireMeasure)
    {
        this.tireMeasure = tireMeasure;
    }
    /**
     * Method to get the tyre efficienty score
     * @return tyre efficienty score specified
     */
    public String getEfficientyScore()
    {
        return efficientyScore;
    }
    /**
     * Method to collect the tyre efficienty score
     * @param efficientyScore > new tyre efficienty score indicated
     */
    public void setEfficientyScore(String efficientyScore)
    {
        this.efficientyScore = efficientyScore;
    }
    /**
     * Method to get the tyre position
     * @return tyre position specified
     */
    public String getPosition() {
        return position;
    }
    /**
     * Method to collect the tyre position
     * @param position > new tyre position indicated
     */
    public void setPosition(String position)
    {
        this.position = position;
    }
    /**
     * Method to show the information of tyre maintenance
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    @Override
    public String toString()
    {
        return actionDate + " - " + vehicle + " - " + actualKms + "kms. " + mechanicalCostType + " (" + replacementUsed
                + tireType + " " + tireMeasure + " " + efficientyScore + " " + position + ") " + totalCost + "€";
    }
    /**
     * Another Method to show the information of tyre maintenance without de whole vehicle information
     * @return the information in the way we wanna show (not used by the JavaFX app)
     */
    public String toShowFormatWithoutVehicle()
    {
        return actionDate.substring(6) + "/" + actionDate.substring(4,6) + "/" + actionDate.substring(0,4) + " - "
                + actualKms + "kms || " + mechanicalCostType + " - " + replacementUsed + ", " + tireType + " " +
                tireMeasure + " " + efficientyScore + " " + position + " [" + totalCost + "€]";
    }
    /**
     * Method to store the information in a specific way at the txt
     * @return tyre's maintenance information separated by |
     */
    public String toStockFormat()
    {
        return actionDate + "|" + vehicle + "|" + mechanicalCostType + "|" + replacementUsed + "|" + actualKms + "|" +
                totalCost + "|" + tireType + "|" + tireMeasure + "|" + efficientyScore + "|" + position;
    }
}
