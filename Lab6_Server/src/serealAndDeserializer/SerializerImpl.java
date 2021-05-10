package serealAndDeserializer;


import domain.Vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * класс, реализующий интерфейс сериализации
 */
public class SerializerImpl implements Serializer {
    /**
     *
     * @param file
     * @return
     */
    private File createFile(File file){
        if ((!file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error while creating a file in serializing process");
            }
        }
        return file;
    }



    /**
     *
     * @param linkedList cвязный список, из которого необходимо достать объекты для записи в файл
     * @param file куда будет происходить запись
     */
    public void serialize(LinkedList<Vehicle> linkedList, File file) {
        Collections.sort(linkedList);
        FileWriter fWriter;
        BufferedWriter bWriter = null;


        try {

            fWriter = new FileWriter(createFile(file).getAbsoluteFile());
            bWriter = new BufferedWriter(fWriter);
            for (int j = 0; j < linkedList.size(); ++j) {
                bWriter.write("{\n");

                bWriter.write("\"Id\": " + linkedList.get(j).getId() + ",\n");


                if (linkedList.get(j).getName() != "null") {
                    bWriter.write("\"Name\": " + "\"" + linkedList.get(j).getName() + "\",\n");
                }

                if (linkedList.get(j).getCoordinates() != null) {
                    bWriter.write("\"Coordinates\": " + "[" + linkedList.get(j).getCoordinates().getX() + ", " + linkedList.get(j).getCoordinates().getY() + "],\n");
                }

                if (linkedList.get(j).getType() != null) {
                    bWriter.write("\"VehicleType\": " + "\"" + linkedList.get(j).getType() + "\",\n");
                }

                if (linkedList.get(j).getFuelType() != null) {
                    bWriter.write("\"FuelType\": " + "\"" + linkedList.get(j).getFuelType() + "\",\n");
                }

                if (linkedList.get(j).getCreationDate() != null) {
                    bWriter.write("\"CreationDate\": " + "\"" + linkedList.get(j).getCreationDate() + "\",\n");
                }

                if (linkedList.get(j).getEnginePower() != null) {
                    bWriter.write("\"EnginePower\": " + linkedList.get(j).getEnginePower() + ",\n");
                }
                if (j == (linkedList.size() - 1)) {    // это условие только для того чтобы в конце не поставить лишнюю запятую после "}"
                    bWriter.write("}\n");
                } else bWriter.write("},\n");
            }

        }
        catch (IOException e) {    // позже разделю ошибки :)
            System.out.println("Error while serializing");
        }
        finally {
            try {
                bWriter.close();
            } catch (IOException e) {
                System.out.println("Error while closing the file after serializing");
            }
        }

    }



    public void serialize2(LinkedList<Vehicle> linkedList, File file) {
        Collections.sort(linkedList);
        FileWriter fWriter;
        BufferedWriter bWriter = null;


        try {

            fWriter = new FileWriter(createFile(file).getAbsoluteFile());
            bWriter = new BufferedWriter(fWriter);
            for (int j = 0; j < linkedList.size(); ++j) {
                bWriter.write("{\n");

                bWriter.write("\"Id\": " + linkedList.get(j).getId() + ",\n");


                if (linkedList.get(j).getName() != "null") {
                    bWriter.write("\"Name\": " + "\"" + linkedList.get(j).getName() + "\",\n");
                }

                if (linkedList.get(j).getCoordinates() != null) {
                    bWriter.write("\"Coordinates\": " + "[" + linkedList.get(j).getCoordinates().getX() + ", " + linkedList.get(j).getCoordinates().getY() + "],\n");
                }

                if (linkedList.get(j).getType() != null) {
                    bWriter.write("\"VehicleType\": " + "\"" + linkedList.get(j).getType() + "\",\n");
                }

                if (linkedList.get(j).getFuelType() != null) {
                    bWriter.write("\"FuelType\": " + "\"" + linkedList.get(j).getFuelType() + "\",\n");
                }

                if (linkedList.get(j).getCreationDate() != null) {
                    bWriter.write("\"CreationDate\": " + "\"" + linkedList.get(j).getCreationDate() + "\",\n");
                }

                if (linkedList.get(j).getEnginePower() != null) {
                    bWriter.write("\"EnginePower\": " + linkedList.get(j).getEnginePower() + ",\n");
                }
                if (j == (linkedList.size() - 1)) {    // это условие только для того чтобы в конце не поставить лишнюю запятую после "}"
                    bWriter.write("}\n");
                } else bWriter.write("},\n");
            }

        }
        catch (IOException e) {    // позже разделю ошибки :)
            System.out.println("Error while serializing");
        }
        finally {
            try {
                bWriter.close();
            } catch (IOException e) {
                System.out.println("Error while closing the file after serializing");
            }
        }

    }


}
