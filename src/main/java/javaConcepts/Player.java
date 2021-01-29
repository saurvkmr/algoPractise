package javaConcepts;

import org.jetbrains.annotations.NotNull;

class Player implements Comparable<Player> {

    int ranking;
    String name;
    String lastName;

    public Player(int rankValue, String nameValue, String lastNameValue) {
        this.ranking = rankValue;
        this.name = nameValue;
        this.lastName = lastNameValue;
    }

    @Override
    public int compareTo(@NotNull Player player) {
        return Integer.compare(ranking, player.ranking);
    }
}
