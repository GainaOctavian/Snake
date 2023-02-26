# Snake-Java-
In this project I made three separate source files that operate in relation to eachother.
The SnakeGame.java source file exists only to access the GameFrame.java source file every
time that it's called. When the GameFrame is accessed, the game is reintialized, thus the GamePanel initializes all of the game's elements and methods. 
In the beggining of the GamePanel there is defined the width (latime_ecran), the height (inaltime_ecran), a unit measure(marime_unitate) , number of units in 
the game (unitati_joc) and a delay. After these I initialized two vectors based on the units in the game x and y, a number of parts of the snake's body (unitati corp)
a variable that counts the number of apples eaten ( mereMancate), positioning for the apple (marX and marY), a direction that by default is right (directie), 
a timer and a random variable. After these, I made a constructor for the GamePanel that starts the game and calls a function named startGame that creates
an apple and starts the timer. Then I constructed some methods to paint the components of the game, to create a new apple and to move the 
snake using the body parts (partiCorp), unit measure (marime_unitate) and direction (directie). Then I made two check methods to check 
if an apple was eaten and to check if the snake collided with itself or one of the margins. 
Next, I made a method for the end of the game, showing the score, a text and an option to restart the game.
Lastly, I made two Override functions, the first one calling the check methods and the move method decribed above,
and the second one adapting the user keyboard input into keyevents: giving the direction (directie) variable
a value.
