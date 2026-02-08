const CACHE_NAME = 'tracalify-v1';
const ASSETS = [
  './',                   // The current directory
  'index.html',           // Local file
  'pages/homePage.html',  // Local folder
  'manifest.json',        // Local file
  'https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700;900&display=swap'
];

self.addEventListener('install', (e) => {
  e.waitUntil(
    caches.open(CACHE_NAME).then((cache) => {
      console.log('Caching assets...');
      return cache.addAll(ASSETS);
    })
  );
});

self.addEventListener('fetch', (e) => {
  e.respondWith(
    caches.match(e.request).then((response) => {
      return response || fetch(e.request);
    })
  );
});
