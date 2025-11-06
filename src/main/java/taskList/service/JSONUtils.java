package taskList.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import taskList.model.Task;

public class JSONUtils {

    private static String fileName = "tasks.json";

    private static File createNewFile() {
        try {
            File tasksJSON = new File(System.getProperty("user.dir"), fileName);
            tasksJSON.createNewFile();
            return tasksJSON;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String convertTaskListToJSON(List<Task> taskList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(taskList);
    }

    private static void writeToFile(String JSON, File file) {
        try {
            FileWriter writer = new FileWriter(file.getName());
            writer.write(JSON);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Task> loadTasks() {
        File tasksJSON = new File(System.getProperty("user.dir"), fileName);
        if (tasksJSON.exists()) {
            try (FileReader reader = new FileReader(tasksJSON)) {
                TypeToken<List<Task>> taskListToken = new TypeToken<List<Task>>(){};
                return new Gson().fromJson(reader, taskListToken.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static void saveTasks(List<Task> taskList) {
        try {
            File file = createNewFile();
            String taskJSON = convertTaskListToJSON(taskList);
            writeToFile(taskJSON, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
