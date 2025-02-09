
# Snake Game - Java Implementation

**Project by Aurelian-Octavian Găină**  
*Classic Snake Game developed using Java*

## 🎮 Overview

This project is a Java implementation of the classic Snake game. It consists of three main source files that interact with each other to create a dynamic and engaging gameplay experience.

## 🚀 Features

- **Classic Gameplay:** Control the snake, eat apples, and grow without hitting the walls or yourself.
- **Responsive Controls:** Smooth and responsive keyboard controls for seamless gameplay.
- **Dynamic Difficulty:** The game speed increases as the snake grows.
- **Score Tracking:** Keep track of the number of apples eaten.

## 🛠️ Technologies Used

- **Java** (Core Language)
- **Swing Library:** For creating the graphical user interface (GUI).
- **AWT Library:** For handling graphics and events.

## 📂 Project Structure

```
Snake-Java/
├── src/
│   └── snake/
│       ├── SnakeGame.java       # Entry point of the game
│       ├── GameFrame.java       # Frame that initializes the game
│       └── GamePanel.java       # Handles game logic, rendering, and controls
├── bin/                         # Compiled Java classes
├── README.md                    # Project documentation
└── .settings/                   # Eclipse project settings
```

## ⚙️ How to Run

### Prerequisites
- **Java Development Kit (JDK)** installed on your system
- **Eclipse IDE** (optional) for easier project management

### Running the Game

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/GainaOctavian/Snake-Java.git
   cd Snake-Java
   ```

2. **Compile the Source Files:**
   ```bash
   javac -d bin src/snake/*.java
   ```

3. **Run the Game:**
   ```bash
   java -cp bin snake.SnakeGame
   ```

Enjoy the game!

## 🎯 Controls

- **Arrow Keys:** Move the snake (Up, Down, Left, Right)
- **Spacebar:** Pause/Resume the game

## 📈 Future Improvements

- Adding levels with increasing difficulty
- Introducing power-ups and obstacles
- Enhanced graphics and animations

## 🙌 Credits

This project was developed by Aurelian-Octavian Găină as a hands-on exercise to practice Java programming, game development, and GUI handling using Swing and AWT.
