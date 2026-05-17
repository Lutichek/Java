package Timus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1496 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        Set<String> teams = new HashSet<>();
        Set<String> spamTeams = new HashSet<>();

        for (int i = 0; i < count; i++) {
            String team = in.next();
            if (teams.contains(team)) {
                spamTeams.add(team);
            } else {
                teams.add(team);
            }
        }

        for (String team : spamTeams) {
            System.out.println(team);
        }
    }
}