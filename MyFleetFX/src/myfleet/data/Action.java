package myfleet.data;
/**
 * Abstract class for every management action
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public abstract class Action
{
    protected String actionDate;
    protected myfleet.data.Vehicle vehicle;

    /**
     * Action constructor
     * @param actionDate > date where the action occurs
     * @param vehicle > vehicle on which the information will be stored
     */
    public Action(String actionDate, myfleet.data.Vehicle vehicle)
    {
        this.actionDate = actionDate;
        this.vehicle = vehicle;
    }

    /**
     * Method to get the day when the action takes place
     * @return date specified
     */
    public String getActionDate()
    {
        return actionDate;
    }

    /**
     * Method to collect the date of the action
     * @param actionDate > new day form an action indicated
     */
    public void setActionDate(String actionDate)
    {
        this.actionDate = actionDate;
    }

    /**
     * Method to get the information from the vehicle object affected
     * @return vehicle's specified
     */
    public myfleet.data.Vehicle getVehicle()
    {
        return vehicle;
    }

    /**
     * Method to collect the vehicle on which the information will be stored
     * @param vehicle > new vehicle indicated
     */
    public void setVehicle(myfleet.data.Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }
}
