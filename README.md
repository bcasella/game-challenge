# game-challenge

An java challenge that will play and game kinda like monopoly.

Gameboard are in gameconfig.txt

The game will play itself, and will say chich type of player will win more on 300 game plays, and some other information.

To run it:

With docker-compose (https://docs.docker.com/compose/install/): 

docker-compose up

Compiling and running with Java compiler (https://docs.oracle.com/en/java/javase/12/install/overview-jdk-installation.html)

On the folder of the source, run:

javac *.java
java TheGame < gameConfig.txt
