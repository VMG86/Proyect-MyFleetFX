/**
 * Management class collects all the methods that are required for the menu
 *
 * This method is only available in the NO JavaFX version
 */

/*package myfleet.no_fx;

import myfleet.data.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Management
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehicle> VehicleArrayList = new ArrayList<>();
    static ArrayList<Refueling> RefuelingArrayList = new ArrayList<>();
    static ArrayList<String> AllCostArrayList = new ArrayList<>();
    static ArrayList<OilMaintenance> OilMaintenanceArrayList = new ArrayList<>();
    static ArrayList<TireMaintenance> TireMaintenanceArrayList = new ArrayList<>();
    static ArrayList<OtherMaintenance> OtherMaintenanceArrayList = new ArrayList<>();
    static ArrayList<GeneralCost> GeneralCostArrayList = new ArrayList<>();

    public static void showMenu()
    {
        System.out.println("\nPlease, select an option:");
        System.out.println("1- Add a vehicle");
        System.out.println("2- Add a refuel");
        System.out.println("3- Add a mechanical cost");
        System.out.println("4- Add a general cost (those not directly related to mechanical issues)");
        System.out.println("5- Delete or modify data");
        System.out.println("6- Delete a vehicle");
        System.out.println("7- Show statistics");
        System.out.println("8- Show vehicles registered");
        System.out.println("9- Show vehicle history");
        System.out.println("0- Exit");
    }

    public static void AddVehicle()
    {
        String type, tag, plate, brand, model, fuelType;
        int tankCapacity;

        System.out.println("<<<<<< Please enter the data below about the vehicle >>>>>>");
        System.out.println("Tag (This is going to help us to identify it more easily): ");
        tag = sc.nextLine();
        System.out.print("Type of vehicle, ");
        String text = "1 > Car; 2 > Motorbike; 3 > Van";
        type = selectOption(text, 1, 3);
        if(type.equals("Not a valid option"))
        {
            type = "ND";
        }
        System.out.println("Plate number: ");
        plate = sc.nextLine();
        System.out.println("Brand: ");
        brand = sc.nextLine();
        System.out.println("Model: ");
        model = sc.nextLine();
        System.out.println("Fuel Type: ");
        fuelType = sc.nextLine();
        System.out.println("Tank capacity: ");
        tankCapacity = sc.nextInt();
        sc.nextLine();

        VehicleArrayList.add(new Vehicle(tag, type, plate, brand, model, fuelType, tankCapacity));
    }

    public static void addRefuel()
    {
        String dateToTransform, actionDate;
        int vehicleSelection;
        double litersRefueled, partialKms, totalPriceRefueling;

        System.out.println("<<<<<< Please enter the data below about the refueling >>>>>>");
        System.out.println("Date of refueling [DDMMAAAA]: ");
        dateToTransform = sc.nextLine();
        actionDate = dateToTransform.substring(4) + dateToTransform.substring(2,4) + dateToTransform.substring(0,2);
        System.out.print("Vehicle refueled, ");
        vehicleSelection = selectVehicle();
        System.out.println("Liters refueled: ");
        litersRefueled = sc.nextDouble();
        System.out.println("Kilometers: ");
        partialKms = sc.nextDouble();
        System.out.println("Total Cost: ");
        totalPriceRefueling = sc.nextDouble();
        sc.nextLine();

        RefuelingArrayList.add( new Refueling(actionDate, VehicleArrayList.get(vehicleSelection), litersRefueled,
                partialKms, totalPriceRefueling));

        Collections.sort(RefuelingArrayList, new Comparator<Refueling>()
        {
            @Override
            public int compare(Refueling v1, Refueling v2) {
                return CharSequence.compare(v1.getActionDate(), v2.getActionDate());
            }
        });

    }

    public static void addMechanicalCost()
    {
        String dateToTransform, actionDate;
        int vehicleSelection;
        String mechanicalCostType, replacementUsed; //Data common for all managements
        double actualKms, totalCost; //Data common for all managements
        String oilViscosity; //Oil management stuff
        double oilLiters;//Oil management stuff
        String tireType, tireMeasure, efficientyScore, position; //Tire management stuff
        String additionalDescription; //Other management stuff

        System.out.println("<<<<<< Please enter the data below about the new mechanical cost >>>>>>");
        System.out.println("Date: ");
        dateToTransform = sc.nextLine();
        actionDate = dateToTransform.substring(4) + dateToTransform.substring(2,4) + dateToTransform.substring(0,2);
        System.out.print("Vehicle concerned, ");
        vehicleSelection = selectVehicle();
        String text  = "1 > Oil Maintenance; 2 > Tire Maintenance; 3 > Other type of maintenance";
        mechanicalCostType = selectOption(text, 1, 3);
        System.out.println("Actual kms: ");
        actualKms = sc.nextDouble();
        System.out.println("Total cost: ");
        totalCost = sc.nextDouble();
        sc.nextLine();
        System.out.println("Replacement used (brand, OEM or not ref, specifications...): ");
        replacementUsed = sc.nextLine();

        switch (mechanicalCostType)
        {
            case "Oil Maintenance":

                System.out.println("Oil viscosity: ");
                oilViscosity = sc.nextLine();
                System.out.println("Oil liters used: ");
                oilLiters = sc.nextDouble();
                sc.nextLine();

                OilMaintenanceArrayList.add( new OilMaintenance(actionDate, VehicleArrayList.get(vehicleSelection),
                        replacementUsed, actualKms, totalCost, oilViscosity, oilLiters));

                Collections.sort(OilMaintenanceArrayList, new Comparator<OilMaintenance>()
                {
                    @Override
                    public int compare(OilMaintenance v1, OilMaintenance v2) {
                        return CharSequence.compare(v1.getActionDate(), v2.getActionDate());
                    }
                });
                break;
            case "Tire Maintenance":

                System.out.println("Type of tire (brand, summer/winter/both...): ");
                tireType = sc.nextLine();
                System.out.println("Tire measure: ");
                tireMeasure = sc.nextLine();
                System.out.println("Efficienty Score: ");
                efficientyScore = sc.nextLine();
                System.out.println("Position of the replaced tire/s: ");
                position = sc.nextLine();

                TireMaintenanceArrayList.add( new TireMaintenance(actionDate, VehicleArrayList.get(vehicleSelection),
                        replacementUsed, actualKms, totalCost, tireType, tireMeasure, efficientyScore, position));

                Collections.sort(TireMaintenanceArrayList, new Comparator<TireMaintenance>()
                {
                    @Override
                    public int compare(TireMaintenance v1, TireMaintenance v2) {
                        return CharSequence.compare(v1.getActionDate(), v2.getActionDate());
                    }
                });
                break;
            case "Other type of maintenance":

                System.out.println("Description of the repair carried out and spare parts used: ");
                additionalDescription = sc.nextLine();

                OtherMaintenanceArrayList.add( new OtherMaintenance(actionDate, VehicleArrayList.get(vehicleSelection),
                        replacementUsed, actualKms, totalCost, additionalDescription));

                Collections.sort(OtherMaintenanceArrayList, new Comparator<OtherMaintenance>()
                {
                    @Override
                    public int compare(OtherMaintenance v1, OtherMaintenance v2) {
                        return CharSequence.compare(v1.getActionDate(), v2.getActionDate());
                    }
                });
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }

    public static void addGeneralCost()
    {
        String dateToTransform, actionDate, generalCostName, paidDateToTransform, paidDate;
        int vehicleSelection;
        Double totalCost;
        Boolean paid;

        System.out.println("<<<<<< Please enter the data below about the new general cost >>>>>>");
        System.out.println("Date: ");
        dateToTransform = sc.nextLine();
        actionDate = dateToTransform.substring(4) + dateToTransform.substring(2,4) + dateToTransform.substring(0,2);
        System.out.print("Vehicle concerned, ");
        vehicleSelection = selectVehicle();
        System.out.println("Cost name or what is it about: ");
        generalCostName = sc.nextLine();
        System.out.println("Total cost: ");
        totalCost = sc.nextDouble();
        sc.nextLine();
        System.out.println("Payment date [DDMMAAAA] (if not, type 0): ");
        paidDateToTransform = sc.nextLine();
        if(paidDateToTransform.equals("0"))
        {
            paidDate = "00000000";
        }
        else
        {
            paidDate = paidDateToTransform.substring(4) + paidDateToTransform.substring(2,4) +
                    paidDateToTransform.substring(0,2);
        }
        paid = ((paidDateToTransform.equals("0"))?false:true);

        GeneralCostArrayList.add( new GeneralCost(actionDate, VehicleArrayList.get(vehicleSelection), generalCostName,
            totalCost, paid, paidDate));

        Collections.sort(GeneralCostArrayList, new Comparator<GeneralCost>()
        {
            @Override
            public int compare(GeneralCost v1, GeneralCost v2) {
                return CharSequence.compare(v1.getActionDate(), v2.getActionDate());
            }
        });

    }

    public static void modifyDeleteData()
    {
        int vehicleSelection, subOption;
        String option, actionType;

        System.out.println("<<<<<< Please choose the vehicle and the topic to delete or modify >>>>>>");
        System.out.print("Vehicle concerned, ");
        vehicleSelection = selectVehicle();
        String text  = "1 > Refueling; 2 > Oil Maintenance; 3 > Tire Maintenance; 4 > Other Maintenance; " +
                "5 > General Cost";
        option = selectOption(text, 1, 5);

        switch (option)
        {
            case "Refueling":
                if(RefuelingArrayList.size() == 0)
                {
                    System.out.println("There is no information " + option + " yet");
                }
                else
                {
                    System.out.println("These are the " + VehicleArrayList.get(vehicleSelection).getTag().toUpperCase() +
                            " " + option + ", which one do you want to delete or modify?");
                    for( int i = 0; i < RefuelingArrayList.size(); i++)
                    {
                        if (VehicleArrayList.get(vehicleSelection).getTag().
                                equals(RefuelingArrayList.get(i).getVehicle().getTag()))
                        {
                            System.out.println((i+1) + " - " + RefuelingArrayList.get(i).toShowFormatWithoutVehicle());
                        }

                    }
                    subOption = sc.nextInt()-1;
                    sc.nextLine();

                    System.out.println("To run a delete action, please press D, otherwise, if you want to modify press M:");
                    actionType = sc.nextLine().toUpperCase();

                    switch (actionType)
                    {
                        case "D":
                            RefuelingArrayList.remove(subOption);
                            System.out.println(actionType + " deleted");
                            break;
                        case "M":
                            System.out.println("If you don't want to change any part, press 0: ");
                            System.out.println("Old register [" +
                                    RefuelingArrayList.get(subOption).getActionDate().substring(6) + "/" +
                                    RefuelingArrayList.get(subOption).getActionDate().substring(4,6) + "/" +
                                    RefuelingArrayList.get(subOption).getActionDate().substring(0,4) +"] " +
                                    " as date registered, new register: ");
                            String newActionDate = sc.nextLine();
                            if(!newActionDate.equals("0"))
                            {
                                RefuelingArrayList.get(subOption).setActionDate(newActionDate.substring(4) +
                                        newActionDate.substring(2,4) + newActionDate.substring(0,2));
                            }

                            System.out.println("Old register [" + RefuelingArrayList.get(subOption).getLitersRefueled()
                                    + "] as liters refueled, new register: ");
                            Double newLitersRefueled = sc.nextDouble();
                            if(newLitersRefueled != 0)
                            {
                                RefuelingArrayList.get(subOption).setLitersRefueled(newLitersRefueled);
                            }

                            System.out.println("Old register [" + RefuelingArrayList.get(subOption).getPartialKms()+"] " +
                                    " as kms, new register: ");
                            Double newPartialKms = sc.nextDouble();
                            if(newLitersRefueled != 0)
                            {
                                RefuelingArrayList.get(subOption).setPartialKms(newPartialKms);
                            }

                            System.out.println("Old register [" + RefuelingArrayList.get(subOption).getTotalPriceRefueling()+
                                    "] as total price, new register: ");
                            Double newTotalPriceRefueling = sc.nextDouble();
                            if(newLitersRefueled != 0)
                            {
                                RefuelingArrayList.get(subOption).setTotalPriceRefueling(newTotalPriceRefueling);
                            }
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                }
                break;
            case "Oil Maintenance":
                if(OilMaintenanceArrayList.size() == 0)
                {
                    System.out.println("There is no information " + option + " yet");
                }
                else
                {
                    System.out.println("These are the " + VehicleArrayList.get(vehicleSelection).getTag().toUpperCase() +
                            " " + option + ", which one do you want to delete or modify?");
                    for( int i = 0; i < OilMaintenanceArrayList.size(); i++)
                    {
                        if (VehicleArrayList.get(vehicleSelection).getTag().
                                equals(OilMaintenanceArrayList.get(i).getVehicle().getTag()))
                        {
                            System.out.println((i+1) + " - " + OilMaintenanceArrayList.get(i).toShowFormatWithoutVehicle());
                        }

                    }
                    subOption = sc.nextInt()-1;
                    sc.nextLine();

                    System.out.println("To run a delete action, please press D, otherwise, if you want to modify press M:");
                    actionType = sc.nextLine().toUpperCase();

                    switch (actionType)
                    {
                        case "D":
                            OilMaintenanceArrayList.remove(subOption);
                            System.out.println(actionType + " deleted");
                            break;
                        case "M":
                            System.out.println("If you don't want to change any part, press 0: ");
                            System.out.println("Old register [" +
                                    OilMaintenanceArrayList.get(subOption).getActionDate().substring(6) + "/" +
                                    OilMaintenanceArrayList.get(subOption).getActionDate().substring(4,6) + "/" +
                                    OilMaintenanceArrayList.get(subOption).getActionDate().substring(0,4) +"] " +
                                    " as date registered, new register: ");
                            String newActionDate = sc.nextLine();
                            if(!newActionDate.equals("0"))
                            {
                                OilMaintenanceArrayList.get(subOption).setActionDate(newActionDate.substring(4) +
                                        newActionDate.substring(2,4) + newActionDate.substring(0,2));
                            }

                            System.out.println("Old register [" + OilMaintenanceArrayList.get(subOption).getActualKms()
                                    + "] of actual kms, new register: ");
                            Double newActualKms = sc.nextDouble();
                            sc.nextLine();
                            if(newActualKms != 0)
                            {
                                OilMaintenanceArrayList.get(subOption).setActualKms(newActualKms);
                            }

                            System.out.println("Old register [" + OilMaintenanceArrayList.get(subOption).getReplacementUsed()
                                    +"] as replacement used, new register: ");
                            String newReplacementUsed = sc.nextLine();
                            if(!newReplacementUsed.equals("0"))
                            {
                                OilMaintenanceArrayList.get(subOption).setReplacementUsed(newReplacementUsed);
                            }

                            System.out.println("Old register [" + OilMaintenanceArrayList.get(subOption).getTotalCost()+
                                    "] of total cost, new register: ");
                            Double newTotalCost = sc.nextDouble();
                            sc.nextLine();
                            if(newTotalCost != 0)
                            {
                                OilMaintenanceArrayList.get(subOption).setTotalCost(newTotalCost);
                            }

                            System.out.println("Old register [" + OilMaintenanceArrayList.get(subOption).getOilViscosity()
                                    +"] as oil's viscosity used, new register: ");
                            String newOilViscosity = sc.nextLine();
                            if(!newOilViscosity.equals("0"))
                            {
                                OilMaintenanceArrayList.get(subOption).setOilViscosity(newOilViscosity);
                            }

                            System.out.println("Old register [" + OilMaintenanceArrayList.get(subOption).getOilLiters()+
                                    "] of oil liters used, new register: ");
                            Double newOilLiters = sc.nextDouble();
                            sc.nextLine();
                            if(newOilLiters != 0)
                            {
                                OilMaintenanceArrayList.get(subOption).setOilLiters(newOilLiters);
                            }
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                }
                break;
            case "Tire Maintenance":
                if(TireMaintenanceArrayList.size() == 0)
                {
                    System.out.println("There is no information " + option + " yet");
                }
                else
                {
                    System.out.println("These are the " + VehicleArrayList.get(vehicleSelection).getTag().toUpperCase() +
                            " " + option + ", which one do you want to delete or modify?");
                    for( int i = 0; i < TireMaintenanceArrayList.size(); i++)
                    {
                        if (VehicleArrayList.get(vehicleSelection).getTag().
                                equals(TireMaintenanceArrayList.get(i).getVehicle().getTag()))
                        {
                            System.out.println((i+1) + " - " + TireMaintenanceArrayList.get(i).toShowFormatWithoutVehicle());
                        }

                    }
                    subOption = sc.nextInt()-1;
                    sc.nextLine();

                    System.out.println("To run a delete action, please press D, otherwise, if you want to modify press M:");
                    actionType = sc.nextLine().toUpperCase();

                    switch (actionType)
                    {
                        case "D":
                            TireMaintenanceArrayList.remove(subOption);
                            System.out.println(actionType + " deleted");
                            break;
                        case "M":
                            System.out.println("If you don't want to change any part, press 0: ");
                            System.out.println("Old register [" +
                                    TireMaintenanceArrayList.get(subOption).getActionDate().substring(6) + "/" +
                                    TireMaintenanceArrayList.get(subOption).getActionDate().substring(4,6) + "/" +
                                    TireMaintenanceArrayList.get(subOption).getActionDate().substring(0,4) +"] " +
                                    " as date registered, new register: ");
                            String newActionDate = sc.nextLine();
                            if(!newActionDate.equals("0"))
                            {
                                TireMaintenanceArrayList.get(subOption).setActionDate(newActionDate.substring(4) +
                                        newActionDate.substring(2,4) + newActionDate.substring(0,2));
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getActualKms()
                                    + "] of actual kms, new register: ");
                            Double newActualKms = sc.nextDouble();
                            sc.nextLine();
                            if(newActualKms != 0)
                            {
                                TireMaintenanceArrayList.get(subOption).setActualKms(newActualKms);
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getReplacementUsed()
                                    +"] as replacement used, new register: ");
                            String newReplacementUsed = sc.nextLine();
                            if(!newReplacementUsed.equals("0"))
                            {
                                TireMaintenanceArrayList.get(subOption).setReplacementUsed(newReplacementUsed);
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getTotalCost()+
                                    "] of total cost, new register: ");
                            Double newTotalCost = sc.nextDouble();
                            sc.nextLine();
                            if(newTotalCost != 0)
                            {
                                TireMaintenanceArrayList.get(subOption).setTotalCost(newTotalCost);
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getTireType()
                                    +"] as type of tire used, new register: ");
                            String newTireType = sc.nextLine();
                            if(!newTireType.equals("0"))
                            {
                                TireMaintenanceArrayList.get(subOption).setTireType(newTireType);
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getTireMeasure()
                                    +"] as tire measure, new register: ");
                            String newTireMeasure = sc.nextLine();
                            if(!newTireMeasure.equals("0"))
                            {
                                TireMaintenanceArrayList.get(subOption).setTireMeasure(newTireMeasure);
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getEfficientyScore()
                                    +"] as efficienty score, new register: ");
                            String newEfficientyScore = sc.nextLine();
                            if(!newEfficientyScore.equals("0"))
                            {
                                TireMaintenanceArrayList.get(subOption).setEfficientyScore(newEfficientyScore);
                            }

                            System.out.println("Old register [" + TireMaintenanceArrayList.get(subOption).getPosition()
                                    +"] as position of new tires, new register: ");
                            String newPosition = sc.nextLine();
                            if(!newPosition.equals("0"))
                            {
                                TireMaintenanceArrayList.get(subOption).setPosition(newPosition);
                            }
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                }
                break;
            case "Other Maintenance":
                if(OtherMaintenanceArrayList.size() == 0)
                {
                    System.out.println("There is no information " + option + " yet");
                }
                else
                {
                    System.out.println("These are the " + VehicleArrayList.get(vehicleSelection).getTag().toUpperCase() +
                            " " + option + ", which one do you want to delete or modify?");
                    for( int i = 0; i < OtherMaintenanceArrayList.size(); i++)
                    {
                        if (VehicleArrayList.get(vehicleSelection).getTag().
                                equals(OtherMaintenanceArrayList.get(i).getVehicle().getTag()))
                        {
                            System.out.println((i+1) + " - " + OtherMaintenanceArrayList.get(i).toShowFormatWithoutVehicle());
                        }

                    }
                    subOption = sc.nextInt()-1;
                    sc.nextLine();

                    System.out.println("To run a delete action, please press D, otherwise, if you want to modify press M:");
                    actionType = sc.nextLine().toUpperCase();

                    switch (actionType)
                    {
                        case "D":
                            OtherMaintenanceArrayList.remove(subOption);
                            System.out.println(actionType + " deleted");
                            break;
                        case "M":
                            System.out.println("If you don't want to change any part, press 0: ");
                            System.out.println("Old register [" +
                                    OtherMaintenanceArrayList.get(subOption).getActionDate().substring(6) + "/" +
                                    OtherMaintenanceArrayList.get(subOption).getActionDate().substring(4,6) + "/" +
                                    OtherMaintenanceArrayList.get(subOption).getActionDate().substring(0,4) +"] " +
                                    " as date registered, new register: ");
                            String newActionDate = sc.nextLine();
                            if(!newActionDate.equals("0"))
                            {
                                OtherMaintenanceArrayList.get(subOption).setActionDate(newActionDate.substring(4) +
                                        newActionDate.substring(2,4) + newActionDate.substring(0,2));
                            }

                            System.out.println("Old register [" + OtherMaintenanceArrayList.get(subOption).getActualKms()
                                    + "] of actual kms, new register: ");
                            Double newActualKms = sc.nextDouble();
                            sc.nextLine();
                            if(newActualKms != 0)
                            {
                                OtherMaintenanceArrayList.get(subOption).setActualKms(newActualKms);
                            }

                            System.out.println("Old register [" + OtherMaintenanceArrayList.get(subOption).getReplacementUsed()
                                    +"] as replacement used, new register: ");
                            String newReplacementUsed = sc.nextLine();
                            if(!newReplacementUsed.equals("0"))
                            {
                                OtherMaintenanceArrayList.get(subOption).setReplacementUsed(newReplacementUsed);
                            }

                            System.out.println("Old register [" + OtherMaintenanceArrayList.get(subOption).getTotalCost()+
                                    "] of total cost, new register: ");
                            Double newTotalCost = sc.nextDouble();
                            sc.nextLine();
                            if(newTotalCost != 0)
                            {
                                OtherMaintenanceArrayList.get(subOption).setTotalCost(newTotalCost);
                            }

                            System.out.println("Old register [" + OtherMaintenanceArrayList.get(subOption).getAdditionalDescription()
                                    +"] as additional description, new register: ");
                            String newAdditionalDescription = sc.nextLine();
                            if(!newAdditionalDescription.equals("0")) {
                                OtherMaintenanceArrayList.get(subOption).setAdditionalDescription(newAdditionalDescription);
                            }
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                }
                break;
            case "General Cost":
                if(GeneralCostArrayList.size() == 0)
                {
                    System.out.println("There is no information " + option + " yet");
                }
                else
                {
                    System.out.println("These are the " + VehicleArrayList.get(vehicleSelection).getTag().toUpperCase() +
                            " " + option + ", which one do you want to delete or modify?");
                    for( int i = 0; i < GeneralCostArrayList.size(); i++)
                    {
                        if (VehicleArrayList.get(vehicleSelection).getTag().
                                equals(GeneralCostArrayList.get(i).getVehicle().getTag()))
                        {
                            System.out.println((i+1) + " - " + GeneralCostArrayList.get(i).toShowFormatWithoutVehicle());
                        }

                    }
                    subOption = sc.nextInt()-1;
                    sc.nextLine();

                    System.out.println("To run a delete action, please press D, otherwise, if you want to modify press M:");
                    actionType = sc.nextLine().toUpperCase();

                    switch (actionType)
                    {
                        case "D":
                            GeneralCostArrayList.remove(subOption);
                            System.out.println(actionType + " deleted");
                            break;
                        case "M":
                            System.out.println("If you don't want to change any part, press 0: ");
                            System.out.println("Old register [" +
                                    GeneralCostArrayList.get(subOption).getActionDate().substring(6) + "/" +
                                    GeneralCostArrayList.get(subOption).getActionDate().substring(4,6) + "/" +
                                    GeneralCostArrayList.get(subOption).getActionDate().substring(0,4) +"] " +
                                    " as date registered, new register: ");
                            String newActionDate = sc.nextLine();
                            if(!newActionDate.equals("0"))
                            {
                                GeneralCostArrayList.get(subOption).setActionDate(newActionDate.substring(4) +
                                        newActionDate.substring(2,4) + newActionDate.substring(0,2));
                            }

                            System.out.println("Old register [" + GeneralCostArrayList.get(subOption).getCostName()
                                    + "] as cost name, new register: ");
                            String newCostName = sc.nextLine();
                            if(!newCostName.equals("0"))
                            {
                                GeneralCostArrayList.get(subOption).setCostName(newCostName);
                            }

                            System.out.println("Old register [" + GeneralCostArrayList.get(subOption).getTotalCost()+
                                    "] as total price, new register: ");
                            Double newTotalCost = sc.nextDouble();
                            if(newTotalCost != 0)
                            {
                                GeneralCostArrayList.get(subOption).setTotalCost(newTotalCost);
                            }

                            System.out.println("Old register [" +
                                    GeneralCostArrayList.get(subOption).getActionDate().substring(6) + "/" +
                                    GeneralCostArrayList.get(subOption).getActionDate().substring(4,6) + "/" +
                                    GeneralCostArrayList.get(subOption).getActionDate().substring(0,4) +"] " +
                                    " as date registered, new register: ");
                            String newPaidDate = sc.nextLine();
                            if(!newPaidDate.equals("0"))
                            {
                                GeneralCostArrayList.get(subOption).setPaidDate(newPaidDate.substring(4) +
                                        newPaidDate.substring(2,4) + newPaidDate.substring(0,2));
                                GeneralCostArrayList.get(subOption).setPaid(true);
                            }
                            break;
                        default:
                            System.out.println("Not a valid option");
                            break;
                    }
                }
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }

    public static void deleteVehicle()
    {
        int vehicleSelection;

        System.out.println("<<<<<< Please choose the vehicle to delete >>>>>>");
        System.out.print("Vehicles stored, ");
        vehicleSelection = selectVehicle();

        for(int i = 0; i < RefuelingArrayList.size(); i++)
        {
            if(RefuelingArrayList.get(i).getVehicle().getTag().equals(VehicleArrayList.get(vehicleSelection).getTag()))
            {
                RefuelingArrayList.remove(i);
            }
        }
        for(int i = 0; i < OilMaintenanceArrayList.size(); i++)
        {
            if(OilMaintenanceArrayList.get(i).getVehicle().getTag().equals(VehicleArrayList.get(vehicleSelection).getTag()))
            {
                OilMaintenanceArrayList.remove(i);
            }
        }
        for(int i = 0; i < TireMaintenanceArrayList.size(); i++)
        {
            if(TireMaintenanceArrayList.get(i).getVehicle().getTag().equals(VehicleArrayList.get(vehicleSelection).getTag()))
            {
                TireMaintenanceArrayList.remove(i);
            }
        }
        for(int i = 0; i < OtherMaintenanceArrayList.size(); i++)
        {
            if(OtherMaintenanceArrayList.get(i).getVehicle().getTag().equals(VehicleArrayList.get(vehicleSelection).getTag()))
            {
                OtherMaintenanceArrayList.remove(i);
            }
        }
        for(int i = 0; i < GeneralCostArrayList.size(); i++)
        {
            if(GeneralCostArrayList.get(i).getVehicle().getTag().equals(VehicleArrayList.get(vehicleSelection).getTag()))
            {
                GeneralCostArrayList.remove(i);
            }
        }

        VehicleArrayList.remove(vehicleSelection);
        System.out.println("Vehicle deleted");
    }

    public static void showStatistics()
    {
        System.out.println("TO DO 7- Show statistics");
    }

    public static void showVehiclesInfo()
    {
        for(int i = 0; i < VehicleArrayList.size(); i++)
        {
            System.out.println(VehicleArrayList.get(i));
        }
    }

    public static void showActionsPerVehicle()
    {
        int vehicleSelection;
        String info;

        System.out.println("<<<<<< Please choose the vehicle and the topic to review >>>>>>");
        System.out.print("Vehicle concerned, ");
        vehicleSelection = selectVehicle();
        String text  = "1 > Refueling; 2 > Mechanical Cost; 3 > General Cost; 4 > All types";
        info = selectOption(text, 1, 4);

        System.out.println(VehicleArrayList.get(vehicleSelection).getTag().toUpperCase() + " " + info + ":");

        for( int i = 0; i < RefuelingArrayList.size(); i++)
        {
            if (VehicleArrayList.get(vehicleSelection).getTag().
                    equals(RefuelingArrayList.get(i).getVehicle().getTag()))
            {
                AllCostArrayList.add(RefuelingArrayList.get(i).toShowFormatWithoutVehicle() + " (Rfl)");
            }
        }
        for( int i = 0; i < OilMaintenanceArrayList.size(); i++)
        {
            if (VehicleArrayList.get(vehicleSelection).getTag().
                    equals(OilMaintenanceArrayList.get(i).getVehicle().getTag()))
            {
                AllCostArrayList.add(OilMaintenanceArrayList.get(i).toShowFormatWithoutVehicle() + " (Oil)");
            }
        }

        for( int i = 0; i < TireMaintenanceArrayList.size(); i++)
        {
            if (VehicleArrayList.get(vehicleSelection).getTag().
                    equals(TireMaintenanceArrayList.get(i).getVehicle().getTag()))
            {
                AllCostArrayList.add(TireMaintenanceArrayList.get(i).toShowFormatWithoutVehicle() + " (Tir)");
            }
        }

        for( int i = 0; i < OtherMaintenanceArrayList.size(); i++)
        {
            if (VehicleArrayList.get(vehicleSelection).getTag().
                    equals(OtherMaintenanceArrayList.get(i).getVehicle().getTag()))
            {
                AllCostArrayList.add(OtherMaintenanceArrayList.get(i).toShowFormatWithoutVehicle()+ " (Oth)");
            }
        }

        for( int i = 0; i < GeneralCostArrayList.size(); i++)
        {
            if (VehicleArrayList.get(vehicleSelection).getTag().
                    equals(GeneralCostArrayList.get(i).getVehicle().getTag()))
            {
                AllCostArrayList.add(GeneralCostArrayList.get(i).toShowFormatWithoutVehicle()+ " (Gen)");
            }
        }

        Collections.sort(AllCostArrayList);

        switch (info)
        {
            case "Refueling":
                if(RefuelingArrayList.size() == 0)
                {
                    System.out.println("There is no information " + info + " yet");
                }
                else
                {
                    for (int i = 0; i < AllCostArrayList.size(); i++)
                    {
                        if (AllCostArrayList.get(i).contains("(Rfl)"))
                        {
                            System.out.println(AllCostArrayList.get(i));
                        }
                    }
                }
                break;
            case "Mechanical Cost":
                if(OilMaintenanceArrayList.size() == 0 && TireMaintenanceArrayList.size() == 0 &&
                        OtherMaintenanceArrayList.size() == 0)
                {
                    System.out.println("There is no information " + info + " yet");
                }
                else
                {
                    for (int i = 0; i < AllCostArrayList.size(); i++)
                    {
                        if (AllCostArrayList.get(i).contains("(Oil)") ||
                                AllCostArrayList.get(i).contains("(Tir)") ||
                                AllCostArrayList.get(i).contains("(Oth)")) {
                            System.out.println(AllCostArrayList.get(i));
                        }
                    }
                }
                break;
            case "General Cost":
                if(GeneralCostArrayList.size() == 0)
                {
                    System.out.println("There is no information " + info + " yet");
                }
                else
                {
                    for (int i = 0; i < AllCostArrayList.size(); i++)
                    {
                        if (AllCostArrayList.get(i).contains("(Gen)"))
                        {
                            System.out.println(AllCostArrayList.get(i));
                        }
                    }
                }
                break;
            case "All types":
                if(AllCostArrayList.size() == 0)
                {
                    System.out.println("There is no information information yet");
                }
                else
                {
                    for (int i = 0; i < AllCostArrayList.size(); i++)
                    {
                            System.out.println(AllCostArrayList.get(i).replace(" 00/00/0000 "," "));
                    }
                }
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }

        AllCostArrayList.clear();
    }

    public static int selectVehicle()
    {
        int vehicleSelection;

        System.out.println("select a vehicle: ");
        do
        {
            for(int i = 0; i < VehicleArrayList.size(); i++)
            {
                System.out.println((i+1) + " - " + VehicleArrayList.get(i).getTag());
            }
            vehicleSelection = sc.nextInt()-1;
            sc.nextLine();
        }
        while (vehicleSelection < 0 || vehicleSelection >= VehicleArrayList.size());

        return vehicleSelection;
    }

    public  static String selectOption(String text, int min, int max)
    {
        int selection = 0;
        String[] options = text.split("; ");

        System.out.println("select a topic: ");
        for( int i = 0; i < options.length; i++)
        {
            System.out.println(options[i]);
        }
       try
        {
            selection = sc.nextInt();
            while (selection < min || selection > max)
            {
                System.out.println("Please, check the chosen option\n " + text );
                selection = sc.nextInt();
            }

            sc.nextLine();
            return options[selection-1].substring(options[selection-1].indexOf('>')+2);//,options[selection-1].length());
        }
        catch (Exception e)
        {
            System.out.println("Error : " + e);
        }
       return "Not a valid option";
    }
}*/
