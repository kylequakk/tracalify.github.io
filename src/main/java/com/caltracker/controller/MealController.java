package com.caltracker.controller;

import com.caltracker.model.Meal;
import com.caltracker.repository.MealRepository;
import com.caltracker.service.NutritionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController // Tells Spring this class handles JSON web requests
@RequestMapping("/api/meals") // The "base" URL for this controller
@CrossOrigin(origins = "*") // Prevents "CORS" errors during your hackathon
public class MealController {

    // These are the "tools" the controller needs
    private final NutritionService nutritionService;
    private final MealRepository mealRepository;

    // Dependency Injection: Spring automatically plugs in your Service and Repo
    public MealController(NutritionService nutritionService, MealRepository mealRepository) {
        this.nutritionService = nutritionService;
        this.mealRepository = mealRepository;
    }

    /**
     * This handles the "Scan Your Meal" button click.
     * It receives an image, gets AI data, and saves it.
     */
    @PostMapping("/analyze")
    public Meal analyzeMeal(@RequestParam("file") MultipartFile file) {
        try {
            // 1. Get the raw bytes from the uploaded image
            byte[] imageBytes = file.getBytes();

            // 2. Call your AI logic (the info we already have)
            Meal meal = nutritionService.analyzeFoodImage(imageBytes);

            // 3. Save to the database (H2/SQL)
            // This returns the meal WITH its new ID
            return mealRepository.save(meal);

        } catch (Exception e) {
            // If something goes wrong, the frontend sees an error
            throw new RuntimeException("AI Analysis failed: " + e.getMessage());
        }
    }

    /**
     * This allows the frontend to load "Recent Scans"
     */
    @GetMapping("/history")
    public List<Meal> getMealHistory() {
        return mealRepository.findAll();
    }
}