package service;

import com.google.gson.Gson;
import model.DataObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasa implementuje mechanizm parsowania danych w formacie JSON na obiekty modelu
 */
public class JsonParser {

    /**
     * Metoda odczytuje plik z danymi wejœciowymi, a nastepnie przetwarza je na obiekt javowy
     * <p>
     *
     * @return      DataObject
     * @see         DataObject
     */
    public static DataObject fromJson() {
        Gson gson = new Gson();
        DataObject object = new DataObject();


        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("data.json"));


            object = gson.fromJson(br, DataObject.class);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;

    }


}
