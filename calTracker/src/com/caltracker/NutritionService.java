package com.caltracker;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

import java.util.Arrays;
import java.io.IOException;
import com.google.gson.Gson;


public class NutritionService {

    //initiate api call aspects
    private final String apiKey = "AIzaSyD-zTF59E-C2SYUN-E8QN0sV0VNG1vdLTM";
    private final Client client;

    //instantiate the nutritionService object
    public NutritionService() {
        this.client = new Client(apiKey);
    }

    public Meal analyzeFoodImage(byte[] imageBytes) {
        String prompt = "Identify the food. Return ONLY JSON: { \"name\": string, \"calories\": int, \"protein\": int, \"carbs\": int, \"fat\": int }";

        //this sends the prompt into the model
        try {
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-1.5-flash",
                    Arrays.asList(Part.fromText(prompt), Part.fromBytes(imageBytes, "image/jpeg")),
                    null
            );

            return parseJsonToMeal(response.text());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //this parse the AI response into Meal object
    private Meal parseJsonToMeal(String json)  throws IOException {
        Meal response = GSON.fromJson(json, Meal.class);
        if (response.data.length == 0) {
            throw new IOException("Cannot find any data");
        }
        return null;
    }
}
