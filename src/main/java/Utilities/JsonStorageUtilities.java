package Utilities;
import Model.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JsonStorageUtilities {
    private Gson gson;
    private Type type;

    private static final String FILEPATH = "src/main/java/Persistence/data.json";

    public JsonStorageUtilities(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        type = new TypeToken<List<Player>>() {}.getType();
    }

    public List<Player> readContentFromFile() {
        List<Player> dataList = new ArrayList<>();

        File file = new File(FILEPATH);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            dataList.clear();
            dataList = gson.fromJson(bufferedReader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return dataList;
    }

    public <Player> boolean saveDataToFile(List<Player> dataList, String fileName) {
        File file = new File(FILEPATH + fileName + ".json");

        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(dataList, type, fileWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
