package com.matthewyao.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matthewyao on 2016/11/24.
 */
public class TestGson {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
//        List<Person> personList = Arrays.asList(
//                new Person("张三",24,"男"),
//                new Person("李四",9,"男"),
//                new Person("王五",47,"女")
//        );
//        System.out.println(gson.toJson(personList));
        String path = TestGson.class.getClassLoader().getResource("").getPath() + "person.json";
        try {
            String personJson = FileUtils.readFileToString(new File(path));
            List<Person> persons = gson.fromJson(personJson,new TypeToken<List<Person>>(){}.getType());
            System.out.println(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
