package myfleet.data;
/**
 * Interface to transform the way to show data depending of the final purpose of them
 * @author vmatag
 * @version javaFx_1.0
 * @since 8
 */
public interface DataMode
{
    public String toShowFormatWithoutVehicle();
    public String toStockFormat();
}
