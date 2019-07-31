

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class TheGame {


    private static List<Property> getGameInitialConfig() {
        List<Property> properties = new ArrayList<Property> ();   

        Scanner scan = new Scanner(System.in);
        Integer in = scan.nextInt();
        boolean inputEnd = false;
        int count=0;
        while (!inputEnd) 
        {
            Integer value = in;
            Integer rent = scan.nextInt();
            Property property = new Property(value,rent, count);
            if (scan.hasNext()) {
                value = scan.nextInt();
            }
            else {
                inputEnd = true;
            }
            properties.add(property);
            count++;
        }

        return properties;
    }

    private static List<Gamer> initiateGamers() {
        List <Gamer> gamers = new ArrayList<Gamer> ();
        List<Integer> gamerTypes = new ArrayList<Integer> ();
        Random rand = new Random(); 

        gamerTypes.add(0);
        gamerTypes.add(1);
        gamerTypes.add(2);
        gamerTypes.add(3);

        for(int i = 4; i>0; i--) {
            int randType = rand.nextInt(gamerTypes.size());
            gamers.add(new Gamer(gamerTypes.get(randType)));
            gamerTypes.remove(randType);
        }
        return gamers;
    }

    public static  int rollDice(int nSides) { 
        Random  r = new Random(); 
        return (r.nextInt(nSides)+1);
    } 

    public static void main(String[] args) {
        //0 = impulsive, 1=demanding, 2=carefull, 3=random
        int impulsiveWins = 0;
        int demandingWins = 0;
        int carefullWins = 0;
        int randomWins = 0;

        List<Integer> countWinnersList = new  ArrayList<Integer> ();
        countWinnersList.add(0);
        countWinnersList.add(0);
        countWinnersList.add(0);
        countWinnersList.add(0);

        final int numberOfGames = 300;
        final int maxGameRounds = 1000;
        int totalNumberOfRounds = 0;
        int timeEndedGames = 0;

        List<Property> properties = getGameInitialConfig();

        for (int gameNumber = 0; gameNumber < numberOfGames; gameNumber++) {
            //System.out.println("passei1");
            List<Gamer> gamers = initiateGamers();
            int totalPlayers = 4;
            boolean normalWin = false;
            for(int gameRoundNumber = 0; gameRoundNumber < maxGameRounds; gameRoundNumber++) {
                //System.out.println("TOTAAAAALLL PLAYERRRRR: "+totalPlayers);
                if (totalPlayers==1) {
                    normalWin = true;
                    for(Gamer gamer: gamers) {
                        if (gamer.isInGame()) {
                            int gamerType = gamer.getType();
                            //System.out.println("TIPOOOOOOOOOOO "+gamerType );
                            countWinnersList.set(gamerType,(countWinnersList.get(gamerType)+1));
                        }
                    }
                    break;
                }
                
                for(Gamer gamer: gamers) {
                    if ( !gamer.isInGame()) {
                        break;
                    }
                    int toWalk = rollDice(6);
                    gamer.walk(toWalk);
                    gamer.makePlay(properties.get(gamer.getPosition()));
                    totalNumberOfRounds++;
                    if ( !gamer.isInGame()) {
                        totalPlayers--;
                    }

                    //verify if still playing - ok
                    //rolldice -ok
                    //walk -ok
                    //verify if have to receive 100 gold
                    //maketheplay - ok
                    //System.out.println(gamer.getMoney());
                }
                
            }
            if (!normalWin) {
                normalWin=false;
                timeEndedGames++;
                int gamerType = gamers.get(0).getType();
                countWinnersList.set(gamerType,(countWinnersList.get(gamerType)+1));
            }
        }
        //0 = impulsive, 1=demanding, 2=carefull, 3=random

        System.out.println("Numero de partidas do estilo impulsivo (tipo 1): " + countWinnersList.get(0) + " ou " + (countWinnersList.get(0)*100/numberOfGames) + '%');
        System.out.println("Numero de partidas do estilo exigente (tipo 2): " + countWinnersList.get(1) + " ou " + (countWinnersList.get(1)*100/numberOfGames) + '%');
        System.out.println("Numero de partidas do estilo cauteloso (tipo 3): " + countWinnersList.get(2) + " ou " + (countWinnersList.get(2)*100/numberOfGames) + '%');
        System.out.println("Numero de partidas do estilo aleatorio (tipo 4): " + countWinnersList.get(3) + " ou " + (countWinnersList.get(3)*100/numberOfGames) + '%');
        int humanGamerType = countWinnersList.indexOf(Collections.max(countWinnersList))+1;
        System.out.println("Tipo de jogador que mais ganhou: " + humanGamerType);

        System.out.println("Quantas rodadas em media um jogo demora pra terminar ?  " + totalNumberOfRounds /numberOfGames );

        System.out.println("Quantas partidas terminaram pelo critério de tempo? " + timeEndedGames);

    }
}