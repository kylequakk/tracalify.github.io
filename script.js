async function uploadAndAnalyze() {
    const fileInput = document.getElementById('myImageInput'); // Your <input type="file"> ID
    const statusDiv = document.getElementById('status');

    if (!fileInput.files[0]) {
        alert("Please select an image first!");
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);

    try {
        statusDiv.innerText = "Processing...";

        const response = await fetch("/api/meals/analyze", {
            method: "POST",
            body: formData
        });

        if (!response.ok) {
            throw new Error("Server error");
        }

        const mealData = await response.json();

        displayResults(mealData);

    } catch (error) {
        console.error("Upload failed:", error);
        statusDiv.innerText = "Error: " + error.message;
    }
}