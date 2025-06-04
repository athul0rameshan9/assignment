# Android Developer Assignment - Set 1

This repository contains the solutions to the three selected questions from the Android Developer Assignment Set 1.  
All questions and their solutions are organized inside a single folder named `Set1`.  

---

## 📘 Questions Overview

### Q1. Least Recently Used (LRU) Cache
- Design and implement a fixed capacity cache.
- Evicts the least recently used item when capacity exceeds.
- Supports:
  - `get(key)`: Returns value if key exists, else -1.
  - `put(key, value)`: Inserts or updates value, evicting LRU if full.
- Operations must be O(1) time complexity.
- Implemented in C++.

---

### Q2. Custom HashMap Implementation
- Implement a simplified HashMap without using built-in hash map/dictionary libraries.
- Supports:
  - `put(key, value)`: Insert or update.
  - `get(key)`: Returns value or -1 if not found.
  - `remove(key)`: Removes key.
- Operations average O(1) time.
- Implemented in C++.

---

---

## 💡 How to Run

- **Q1 & Q2**  
  Compile and run C++ files using any standard C++ compiler (g++, clang++).  
  Example:



### Q3. Book Review App MVP (Android, Java)
- Mobile app allowing users to browse books, view details, and save favorites offline.
- Architecture: MVVM or Clean Architecture.
- Core Features:
  - Book List screen: fetch and show books from fake API (JSON/mock).
  - Book Detail screen: show description, rating, image.
  - Save favorites stored with Room (SQLite).
  - Offline access to saved books.
- Tech stack:
  - Java only (no Kotlin).
  - Retrofit or manual JSON parsing.
  - Room for persistence.
  - LiveData/Observables for UI.
  - No external image loading libraries.

---

## 📂 Folder Structure
Set1/
├── Q1_LRUCache/
│ └── LRUCache.cpp
├── Q2_CustomHashMap/
│ └── MyHashMap.cpp
└── Q3_BookReviewApp/
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/
│ │ │ │ ├── com/example/bookreviewapp/
│ │ │ │ │ ├── ui/ # UI layer (Activities/Fragments/ViewModels)
│ │ │ │ │ ├── data/ # Data layer (Room, Repository)
│ │ │ │ │ ├── domain/ # Domain layer (UseCases if Clean Architecture)
│ │ │ │ │ └── model/ # Data models (Book, etc.)
│ │ │ ├── res/ # Layouts, drawables, values, etc.
│ │ │ └── AndroidManifest.xml
│ └── build.gradle
└── README.md


Build and run the app on an emulator or physical device.

Uses mock data, no internet required.


- **Q3**  
Import the Android project (`Set1/Q3_BookReviewApp/app`) into Android Studio.  
Build and run on an emulator or device.

---

## 📋 Notes

- For Q3, the fake API is simulated using a local JSON file inside the assets folder.  
- Room database setup includes basic DAO and Entity for favorites.  
- Image loading is simulated by using ImageView resource placeholders since no external libraries are allowed.

---

## 📝 Contact

For any questions or clarifications, feel free to raise issues or contact the repo maintainer.

---

Thank you for reviewing the solutions!

---

