package javaConcepts;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {
    @Override
    public int compare(Player player, Player otherPlayer) {
        return Integer.compare(player.ranking, otherPlayer.ranking);
    }
}
