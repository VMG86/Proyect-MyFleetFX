
/**
 * Fail Utils collects exportation and extraction methods from the .txt
 *
 * This method is only available in the NO JavaFX version
 */

/*package myfleet.no_fx;

import myfleet.data.*;

import java.io.*;
import java.util.ArrayList;

public class FileUtils
{
    public static final String fileNameVehicles = "vehicles.txt";
    public static final String fileNameRefueling = "refueling.txt";
    public static final String fileNameOilMaintenance = "oil_maintenance.txt";
    public static final String fileNameTireMaintenance = "tire_maintenance.txt";
    public static final String fileNameOtherMaintenance = "other_maintenance.txt";
    public static final String fileNameGeneralCost = "general_cost.txt";
    private static PrintWriter saveFile = null;
    private static BufferedReader loadFile = null;

    public static void loadDataVehicles(ArrayList<Vehicle> VehicleArrayList)
    {
        try
        {
            if((new File(fileNameVehicles)).exists())
            {
                loadFile = new BufferedReader(new FileReader(fileNameVehicles));

                String lineInfo = null;
                while ((lineInfo = loadFile.readLine()) != null)
                {
                    String[] data = lineInfo.split("@");

                    VehicleArrayList.add(new Vehicle(data[0], data[1], data[2], data[3], data[4], data[5],
                            Integer.parseInt(data[6])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println(e);
        }finally {
            if(loadFile != null)
            {
                try
                {
                    loadFile.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }

   public static void loadDataRefueling(ArrayList<Refueling> RefuelingArrayList)
    {
        try
        {
            if((new File(fileNameRefueling)).exists())
            {
                loadFile = new BufferedReader(new FileReader(fileNameRefueling));
                ArrayList<String> RecoveredData = new ArrayList<>();
                String lineInfo = null;
                while ((lineInfo = loadFile.readLine()) != null)
                {
                    RecoveredData.add(lineInfo);
                }
                for (String reg : RecoveredData)
                {
                    String[] data = reg.split("|");
                    ArrayList<Vehicle> VehicleRecoveringDataArrayList = new ArrayList<>();
                    String[] dataVehicle = data[1].split("@");
                    String tag = dataVehicle[0];
                    String type = dataVehicle[1];
                    String plate = dataVehicle[2];
                    String brand = dataVehicle[3];
                    String model = dataVehicle[4];
                    String fuelType = dataVehicle[5];
                    int tankCapacity = Integer.parseInt(dataVehicle[6]);
                    Vehicle vehRec = new Vehicle(tag, type, plate, brand, model, fuelType,
                            tankCapacity);
                    VehicleRecoveringDataArrayList.add(vehRec);


                    RefuelingArrayList.add(new Refueling(data[0], vehRec,Double.parseDouble(data[3]),
                            Double.parseDouble(data[4]), Double.parseDouble(data[5])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println(e);
        }finally {
            if(loadFile != null)
            {
                try
                {
                    loadFile.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }



    public static void saveDataVehicles(ArrayList<Vehicle> VehicleArrayList)
    {
        try
        {
            saveFile = new PrintWriter(fileNameVehicles);

            for(int i = 0; i < VehicleArrayList.size(); i++)
            {
                saveFile.println(VehicleArrayList.get(i).toStockFormat());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(saveFile != null)
            {
                saveFile.close();
            }
        }
    }

    public static void saveDataRefueling(ArrayList<Refueling> RefuelingArrayList)
    {
        try
        {
            saveFile = new PrintWriter(fileNameRefueling);

            for(int i = 0; i < RefuelingArrayList.size(); i++)
            {
                saveFile.println(RefuelingArrayList.get(i).toStockFormat());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(saveFile != null)
            {
                saveFile.close();
            }
        }
    }

    public static void saveDataOilMaintenance(ArrayList<OilMaintenance> OilMaintenanceArrayList)
    {
        try
        {
            saveFile = new PrintWriter(fileNameOilMaintenance);

            for(int i = 0; i < OilMaintenanceArrayList.size(); i++)
            {
                saveFile.println(OilMaintenanceArrayList.get(i).toStockFormat());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(saveFile != null)
            {
                saveFile.close();
            }
        }
    }

    public static void saveDataTireMaintenance(ArrayList<TireMaintenance> TireMaintenanceArrayList)
    {
        try
        {
            saveFile = new PrintWriter(fileNameTireMaintenance);

            for(int i = 0; i < TireMaintenanceArrayList.size(); i++)
            {
                saveFile.println(TireMaintenanceArrayList.get(i).toStockFormat());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(saveFile != null)
            {
                saveFile.close();
            }
        }
    }

    public static void saveDataOtherMaintenance(ArrayList<OtherMaintenance> OtherMaintenanceArrayList)
    {
        try
        {
            saveFile = new PrintWriter(fileNameOtherMaintenance);

            for(int i = 0; i < OtherMaintenanceArrayList.size(); i++)
            {
                saveFile.println(OtherMaintenanceArrayList.get(i).toStockFormat());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(saveFile != null)
            {
                saveFile.close();
            }
        }
    }

    public static void saveDataGeneralCost(ArrayList<GeneralCost> GeneralCostArrayList)
    {
        try
        {
            saveFile = new PrintWriter(fileNameGeneralCost);

            for(int i = 0; i < GeneralCostArrayList.size(); i++)
            {
                saveFile.println(GeneralCostArrayList.get(i).toStockFormat());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(saveFile != null)
            {
                saveFile.close();
            }
        }
    }
}*/
