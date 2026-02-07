console.log("Script is working");
 // 1. FAILSAFE LOADER LOGIC
    const hideLoader = () => {
        const overlay = document.getElementById("loader-overlay");
        setTimeout(() => {
            if(overlay) overlay.classList.add("loader-hidden");
        }, 3500);
    };

    window.addEventListener("load", hideLoader);
    setTimeout(hideLoader, 6000);

    // 2. PWA REGISTRATION
    if ('serviceWorker' in navigator) {
        window.addEventListener('load', () => {
            navigator.serviceWorker.register('sw.js')
                .then(reg => console.log('Service Worker Registered'))
                .catch(err => console.log('Service Worker Failed:', err));
        });
    }

    // 3. PARTICLE ENGINE
    const canvas = document.getElementById('particleCanvas');
    const ctx = canvas.getContext('2d');
    const btn = document.getElementById('get-started-btn');
    let particles = [];

    function resize() { canvas.width = window.innerWidth; canvas.height = window.innerHeight; }
    window.addEventListener('resize', resize);
    resize();

    class Particle {
        constructor(x, y) {
            this.x = x; this.y = y;
            const angle = Math.random() * Math.PI * 2;
            const velocity = Math.random() * 6 + 2;
            this.dx = Math.cos(angle) * velocity;
            this.dy = Math.sin(angle) * velocity;
            this.size = Math.random() * 4 + 1.5;
            this.alpha = 1;
            this.color = Math.random() > 0.5 ? '#0ACDFF' : '#CBE896';
        }
        draw() {
            ctx.save(); ctx.globalAlpha = this.alpha; ctx.fillStyle = this.color;
            ctx.beginPath(); ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2); ctx.fill(); ctx.restore();
        }
        update() { this.x += this.dx; this.y += this.dy; this.dy += 0.1; this.alpha -= 0.025; this.size *= 0.95; }
    }

    function animate() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        particles.forEach((p, i) => { p.update(); p.draw(); if (p.alpha <= 0) particles.splice(i, 1); });
        requestAnimationFrame(animate);
    }
    animate();

    btn.addEventListener('click', () => {
        const rect = btn.getBoundingClientRect();
        const centerX = rect.left + rect.width / 2;
        const centerY = rect.top + rect.height / 2;
        for (let i = 0; i < 22; i++) particles.push(new Particle(centerX, centerY));
        setTimeout(() => { window.location.href = "pages/homePage.html"; }, 400);
    });

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
