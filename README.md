```
$$\   $$\  $$$$$$\   $$$$$$\        $$\   $$\                     $$\                         $$\     $$\   
$$ |  $$ |$$  __$$\ $$  __$$\       $$ |  $$ |                    $$ |                      $$$$ |  $$$$ |  
$$ |  $$ |$$ /  \__|$$ /  $$ |      $$ |  $$ | $$$$$$\   $$$$$$$\ $$ |  $$\  $$$$$$$\       \_$$ |  \_$$ |  
$$ |  $$ |$$ |$$$$\ $$$$$$$$ |      $$$$$$$$ | \____$$\ $$  _____|$$ | $$  |$$  _____|        $$ |    $$ |  
$$ |  $$ |$$ |\_$$ |$$  __$$ |      $$  __$$ | $$$$$$$ |$$ /      $$$$$$  / \$$$$$$\          $$ |    $$ |  
$$ |  $$ |$$ |  $$ |$$ |  $$ |      $$ |  $$ |$$  __$$ |$$ |      $$  _$$<   \____$$\         $$ |    $$ |  
\$$$$$$  |\$$$$$$  |$$ |  $$ |      $$ |  $$ |\$$$$$$$ |\$$$$$$$\ $$ | \$$\ $$$$$$$  |      $$$$$$\ $$$$$$\ 
 \______/  \______/ \__|  \__|      \__|  \__| \_______| \_______|\__|  \__|\_______/       \______|\______|
```
```
 -----------------------------------------------------------------------------------------------------------
```





```
 _____                                             _                   
/__   \___  __ _ _ __ ___     /\/\   ___ _ __ ___ | |__   ___ _ __ ___ 
  / /\/ _ \/ _` | '_ ` _ \   /    \ / _ \ '_ ` _ \| '_ \ / _ \ '__/ __|
 / / |  __/ (_| | | | | | | / /\/\ \  __/ | | | | | |_) |  __/ |  \__ \
 \/   \___|\__,_|_| |_| |_| \/    \/\___|_| |_| |_|_.__/ \___|_|  |___/
```
                                                                  
```
Caleb Dominic Zonaga Gutierrez
Nikolas Pagsisihan
Kyle Quach
Dino George
```

```
    ____                                 
   / __ \__  ___________  ____  ________ 
  / /_/ / / / / ___/ __ \/ __ \/ ___/ _ \
 / ____/ /_/ / /  / /_/ / /_/ (__  )  __/
/_/    \__,_/_/  / .___/\____/____/\___/ 
                /_/                      
```

```
To provide a completely free calorie counter app powered by the Google Gemini API.
The app will have a clean and easy to navigate interface focused on accesibility.
Using cache, user data will be stored securely on device.
```

```
 ____  __    __   __    ____    _  _  ____  ____  ____ 
(_  _)/  \  /  \ (  )  / ___)  / )( \/ ___)(  __)(    \
  )( (  O )(  O )/ (_/\\___ \  ) \/ (\___ \ ) _)  ) D (
 (__) \__/  \__/ \____/(____/  \____/(____/(____)(____/
```
```
IntelliJ – Java IDE used for backend development.
Github – Used for pushing and pulling so that the code is synchronized between team members.
Gemini – Used for the application to identify food items and the associated calorie amount. (API)
Copilot – Used for advise on using the other tools to its full potential. Also used for AI image generation.
Render - Used to connect our front and back end code over a localhost.
                                                           
```
```
 ____  ____  _  _  ____  __     __  ____  _  _  ____  __ _  ____  __   __      ____  ____   __    ___  ____  ____  ____ 
(    \(  __)/ )( \(  __)(  )   /  \(  _ \( \/ )(  __)(  ( \(_  _)/ _\ (  )    (  _ \(  _ \ /  \  / __)(  __)/ ___)/ ___)
 ) D ( ) _) \ \/ / ) _) / (_/\(  O )) __// \/ \ ) _) /    /  )( /    \/ (_/\   ) __/ )   /(  O )( (__  ) _) \___ \\___ \
(____/(____) \__/ (____)\____/ \__/(__)  \_)(_/(____)\_)__) (__)\_/\_/\____/  (__)  (__\_) \__/  \___)(____)(____/(____/
```
```

Database 
In an application dedicated to tracking calories, it is certainly necessary to save the user data. Otherwise, the tracker would be useless.
Due to being first year students, our team had almost no experience dealing with databases.
 After some extensive research, it was decided that PostGre SQL should be the language in which the data base should be stored.

We chose to select only the data that is necessary for the application to work as intended.
Each user is stored as an individual object, with the instance variable of meals, calories/macros, user accounts, and timestamp.

However, connecting the front end with the back end proved extremely challenging for the group.
Plus, hosting a secure private database server on the cloud would cost a lot of money, in addition with the added responsibility for user data.
In the end, we wrote a json to the local memory cache so that the data would stay on the user’s device. It was cheap, secure, and easy to implement.
```

```
Backend

Our team decided to begin the day by wrapping up our frontend design, and cracking down on what we were actually going to try and accomplish.
 Most of the time was spent trying to use a controller to connect our front and back ends, but we decided to land on Render for hosting a free backend local host.
 We didn't know if we wanted to add sign in mechanics, but after a few hours of stuggling we decided that was a little bit over our heads. 

As we approached the end of the day, we had a rough time implementing the back end.
It all exists, and is on a seperate repo, but we just couldn't get all the pieces to fit together.
 We did what we could though, and we got the application to work with a fancy front-end and a working application for both iPhone and Android!
```

```
 _______ _     _ _______       _____   ______  _____  _____ _______ _______ _______   /
    |    |_____| |______      |_____] |_____/ |     |   |   |______ |          |     / 
    |    |     | |______      |       |    \_ |_____| __|   |______ |_____     |    .  
                                                                                       
```

```
Website URL: https://kylequakk.github.io/tracalify.github.io/
NOTE: We had to update the API key to allow frontend handling of our program. Due to the limitations of Google Gemini's API free use.
We will take full responsibility for our actions.
```
