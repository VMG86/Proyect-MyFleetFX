package myfleet.data;
/**
 * General class that interacts with actions
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public class Vehicle
{
    private String tag, type, plate, brand, model, fuelType;
    private int tankCapacity;

    /**
     * Vehicle object Constructor
     * @param tag > an easy name to distinguish the vehicles
     * @param type > the type of the vehicle: car, motocicle...
     * @param plate > a unique ID to identify the vehicle
     * @param brand > who made it
     * @param model > specific name in the brand
     * @param fuelType > type of fuel that de vehicle needs
     * @param tankCapacity > capacity available in the fuel tank
     */
    public Vehicle(String tag, String type, String plate, String brand, String model, String fuelType,
                        int tankCapacity)
    {
        this.tag = tag;
        this.type = type;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
    }

    /**
     * Method to get the tag from the vehicle object
     * @return vehicle's tag specified
     */
    public String getTag()
    {
        return tag;
    }

    /**
     * Method to collect a new tag for a new vehicle object or to modify it
     * @param tag > new tag indicated
     */
    public void setTag(String tag)
    {
        this.tag = tag;
    }

    /**
     * Method to get the type from the vehicle object
     * @return vehicle's type specified
     */
    public String getType()
    {
        return type;
    }

    /**
     * Method to collect a new type for a new vehicle object or to modify it
     * @param type > new type indicated
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Method to get the plate from the vehicle object
     * @return vehicle's plate specified
     */
    public String getPlate()
    {
        return plate;
    }

    /**
     * Method to collect a new plate for a new vehicle object or to modify it
     * @param plate > new type indicated
     */
    public void setPlate(String plate)
    {
        this.plate = plate;
    }

    /**
     * Method to get the brand from the vehicle object
     * @return vehicle's brand specified
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Method to collect a new brand for a new vehicle object or to modify it
     * @param brand > new type indicated
     */
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    /**
     * Method to get the model from the vehicle object
     * @return vehicle's model specified
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Method to collect a new model for a new vehicle object or to modify it
     * @param model > new type indicated
     */
    public void setModel(String model)
    {
        this.model = model;
    }

    /**
     * Method to get the fuel type from the vehicle object
     * @return vehicle's fuel type specified
     */
    public String getFuelType()
    {
        return fuelType;
    }

    /**
     * Method to collect a new fuel type for a new vehicle object or to modify it
     * @param fuelType > new type indicated
     */
    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }

    /**
     * Method to get the tank capacity from the vehicle object
     * @return vehicle's tank capacity specified
     */
    public int getTankCapacity()
    {
        return tankCapacity;
    }

    /**
     * Method to collect a new tank capacity for a new vehicle object or to modify it
     * @param  tankCapacity > new type indicated
     */
    public void setTankCapacity(int tankCapacity)
    {
        this.tankCapacity = tankCapacity;
    }

    /**
     * Method to show the information
     * @return the information in the way we wanna show by the JavaFX app
     */
    @Override
    public String toString()
    {
        return tag.toUpperCase() + " - " + brand + " " + model;

        //return tag.toUpperCase() + " (" + type +") " + brand + " " + model +  " ("  + fuelType + " " + tankCapacity +
        //        " liters) - " + plate;
    }

    /**
     * Method to store the information in a specific way at the txt
     * @return vehicle's information separated by @
     */
    public String toStockFormat()
    {
        return tag + "@" + type + "@" + plate + "@" + brand + "@" + model + "@" + fuelType + "@" + tankCapacity;
    }

}