One vs. N battleship implemented with Java

  - We accept zero, one, or two command-line arguments to main():
      - If no arguments are provided, default to N=5 opponents.
      - With one or more arguments, the first argument is an integer value for N.
      - An optional second argument is the string “--cheat”

PS.
On a 10x10 board with each opponent fort of length 5, 
we support up to 20 opponents, 
but ideally we would recommend not exceeding 18 opponents.

PPS.
(With 18 opponents it takes ~1 second to create a board, but with 19... an average of 3 minutes is required.
As for 20 opponents… Forgive me, for I do not have the spare time to
wait for a randomly generated board to generate a perfectly filled board. ¯\_(ツ)_/¯)

