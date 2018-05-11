The-Game-of-Nim
==============================================================
## Background
This project is with the ultimate objective of designing and implementing (in Java) a simple variant of the game of Nim. It is a two player game, and the rules of the version used here are as follows:

• The game begins with a number of objects (e.g., stones placed on a table).

• Each player takes turns removing stones from the table.

• On each turn, a player must remove at least one stone. In addition, there is an upper bound on the number of stones that can be removed in a single turn. For example, if this upper bound is 3, a player has the choice of removing 1, 2 or 3 stones on each turn.

• The game ends when there are no more stones remaining. The player who removes the last stone, loses. The other player is, of course, the winner.

• Both the initial number of stones, and the upper bound on the number that can be removed, can be varied from game to game, and must be chosen before a game commences.

## The first phase requirements 
Here is an example play-through of the game, using 12 initial stones, and an upper bound of 3 stones removed per turn.

• There are 12 stones on the table.

• Player 1 removes 3 stones. 9 stones remain.

• Player 2 removes 1 stone. 8 stones remain.

• Player 1 removes 1 stone. 7 stones remain.

• Player 2 removes 2 stones. 5 stones remain.

• Player 1 removes 3 stones. 2 stones remain.

• Player 2 removes 1 stone. 1 stone remains.

• Player 1 removes 1 stone. 0 stones remain.

• Player 2 wins. Player 1 loses.

For this project, the focus will be on creating two players and playing for one game:

• The program will begin by displaying a welcome message.

• The program will then prompt for a string (no space in the string) to be entered via standard input (the keyboard) - this will be the name of Player 1. You may assume that all inputs to the program will be valid.

• The program will then prompt for another string (no space in the string) to be entered - this will be the name of Player 2.

• The program will then prompt for an integer to be entered - this will be the upper bound on the number of stones that can be removed in a single turn.

• The program will then prompt for another integer to be entered - this will be the initial number of stones.

• The program will then print the number of stones, and will also display the stones, which will be represented by asterisks ‘*’.

• The program will then prompt for another integer to be entered - this time, a number of stones to be removed. Again, you may assume this input will be valid and will not exceed the number of stones remaining or the upper bound on the number of stones that can be removed.

• The program should then show an updated display of stones.

• The previous two steps should then be repeated until there are no stones remaining. When this occurs, the program should display ‘Game Over’, the name of the winner, and then terminate

## The second phase requirements
The game playing process is delegated from Nimsys to NimGame. Since only one game will be active at any given time, only a single NimGame instance is required by Nimsys. Nimsys should also maintain a collection of players. Initially, this collection will be empty - players will need to be added in order to play a game.

A NimGame instance needs to have the following information associated with it:

• A current stone count

• An upper bound on stone removal

• Two players

The system should allow for games of Nim to be played, with the rules of the game, and the players, specified by the user.

A player, as described by the NimPlayer class, needs to have the following information associated with it:

• A username

• A given name

• A family name

• Number of games played

• Number of games won

The system should allow players to be added. It should also allow for players to be deleted, or for their details to be edited. Players should not be able to directly edit their game statistics, although they should be able to reset them.

The system is a text based interactive program that reads and executes commands from standard input (the keyboard) until an ‘exit’ command is issued, which will terminate the program. If a command produces output, it should be printed to standard output (the terminal).

## The third phase requirements
The features to be added are:

• Handling of invalid input via Exceptions

• Write (read) the game statistics into (from) a file, i.e., one which is stored on the hard disk between executions of Nimsys

• A new type of player - an AI (Artificial Intelligence) player, whose moves are automatically determined by the computer rather than a game user

• A victory guaranteed strategy for the AI player

• An advanced Nim game and a victory guaranteed strategy for the AI player in this new game
