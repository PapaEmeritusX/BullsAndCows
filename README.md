# Bulls and Cows 

Advanced version of the classic game *"Bulls and Cows"*.

Example of the gameplay:

```
Input the length of the secret code:
> 4
Input the number of possible symbols in the code:
> 16
The secret is prepared: **** (0-9, a-f).
Okay, let's start a game!
Turn 1:
> 1a34
Grade: 1 bull and 1 cow
Turn 2:
> b354
Grade: 2 bulls and 1 cow
Turn 3:
> 93b4
Grade: 4 bulls
Congratulations! You guessed the secret code.
```
* Basically, the first two inputs determine the difficulty of the game. User chooses the length of the code to be generated and the number of symbols from 1 to 36, which refer to [0-9a-z]. The randomly generated code consists of distinct characters. 
* Then, the game starts and player can input a string trying to guess the generated. 
* After the input the result shows up informing that 1 bull and 1 cow is guessed. 
  * If the matching digits are in their right positions, they are "bulls", if in different positions, they are "cows".
* As the player guesses the whole string correctly with all bulls the game is over. 

The game was built in one class, all integrated with the interface, hence the code lacks overall consistency and readability, which could be improved by setting the logic in to a separate class.

The objective was to generate random numbers and charecters, store data in data structures, and handle errors.



**This was rather for fun small project)**
