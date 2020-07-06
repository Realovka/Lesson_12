package com.company;

import com.company.application.config.ConsoleApplication;
import com.company.dao.SerializableCarDao;
import com.company.entity.Car;
import com.company.entity.CarsWrapper;

import javax.xml.bind.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        try {
            JAXBContext context = JAXBContext.newInstance(Car.class, CarsWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            cars = new SerializableCarDao().get();
            CarsWrapper carsWrapper = new CarsWrapper(cars);
            marshaller.marshal(carsWrapper, new File("marshaller.xml"));


        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Car.class, CarsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CarsWrapper carsWrapper = (CarsWrapper) unmarshaller.unmarshal(new File("marshaller.xml"));
            cars = carsWrapper.getCars();
            FileWriter fileWriter = new FileWriter("cars.txt");
            for(Car item: cars) {
                fileWriter.write(item.toString()+"\n");
            }
            fileWriter.close();
        }catch(JAXBException e){
                e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        ConsoleApplication.start();


    }


}
