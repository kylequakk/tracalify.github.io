document.getElementById('scanBtn').addEventListener('click', async () => {
    console.log("Button clicked);
    const fileInput = document.getElementById('cameraInput');

    if (fileInput.files.length === 0) {
        alert("Please take a photo or select an image first!");
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);

    try {
        console.log("Sending meal to backend...");

        const response = await fetch("/api/meals/analyze", {
            method: "POST",
            body: formData
        });

        if (!response.ok) throw new Error("Backend communication failed");

        const savedMeal = await response.json();

        console.log("Success! Saved Meal:", savedMeal);
        alert(`Analyzed ${savedMeal.name}: ${savedMeal.calories} calories found!`);

    } catch (error) {
        console.error("Error:", error);
        alert("Something went wrong communicating with the server.");
    }
});
