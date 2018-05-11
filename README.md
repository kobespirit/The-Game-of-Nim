The-Game-of-Nim
==============================================================
## Background
This project is with the ultimate objective of designing and implementing (in Java) a simple variant of the game of Nim. It is a two player game, and the rules of the version used here are as follows:

• The game begins with a number of objects (e.g., stones placed on a table).

• Each player takes turns removing stones from the table.

• On each turn, a player must remove at least one stone. In addition, there is an upper bound on the number of stones that can be removed in a single turn. For example, if this upper bound is 3, a player has the choice of removing 1, 2 or 3 stones on each turn.

• The game ends when there are no more stones remaining. The player who removes the last stone, loses. The other player is, of course, the winner.

• Both the initial number of stones, and the upper bound on the number that can be removed, can be varied from game to game, and must be chosen before a game commences.

## Example 
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
