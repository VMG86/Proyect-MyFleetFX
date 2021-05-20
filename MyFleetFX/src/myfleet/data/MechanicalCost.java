package myfleet.data;
/**
 * Abstract class for every mechanical action, is a type of management action
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public abstract class MechanicalCost extends myfleet.data.Action
{
    protected String mechanicalCostType, replacementUsed;
    protected double actualKms, totalCost;

    /**
     * Constructor for mechanical cost type of action
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     * @param mechanicalCostType > type of cost
     * @param replacementUsed > replacement used in the vehicle
     * @param actualKms > the kms accumulated at that time in the vehicle
     * @param totalCost > cost of the action
     */
    public MechanicalCost(String actionDate, myfleet.data.Vehicle vehicle, String mechanicalCostType, String replacementUsed,
                          double actualKms, double totalCost)
    {
        super(actionDate, vehicle);
        this.mechanicalCostType = mechanicalCostType;
        this.replacementUsed = replacementUsed;
        this.actualKms = actualKms;
        this.totalCost = totalCost;
    }

    /**
     * Method to get the mechanical cost type
     * @return mechanical cost type specified
     */
    public String getMechanicalCostType()
    {
        return mechanicalCostType;
    }

    /**
     * Method to collect the additional mechanical cost type
     * @param mechanicalCostType > new mechanical cost type indicated
     */
    public void setMechanicalCostType(String mechanicalCostType)
    {
        this.mechanicalCostType = mechanicalCostType;
    }
    /**
     * Method to get the replacement used
     * @return replacement used specified
     */
    public String getReplacementUsed()
    {
        return replacementUsed;
    }
    /**
     * Method to collect the replacement used
     * @param replacementUsed > new replacement used indicated
     */
    public void setReplacementUsed(String replacementUsed)
    {
        this.replacementUsed = replacementUsed;
    }
    /**
     * Method to get the vehicle's actual kms
     * @return vehicle's actual kms specified
     */
    public double getActualKms()
    {
        return actualKms;
    }
    /**
     * Method to collect the vehicle's kms
     * @param actualKms > new vehicle's kms indicated
     */
    public void setActualKms(double actualKms)
    {
        this.actualKms = actualKms;
    }
    /**
     * Method to get the total cost of the action
     * @return total cost of the action specified
     */
    public double getTotalCost()
    {
        return totalCost;
    }
    /**
     * Method to collect the total cost of the action
     * @param totalCost > new total cost of the action indicated
     */
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
}
