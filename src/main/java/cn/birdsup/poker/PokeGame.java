package cn.birdsup.poker;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 扑克牌游戏
 */
public class PokeGame {

    private final Pattern pattern = Pattern.compile("[♦|♠|♠|♥|♣]\\w{1,2}");
    private final File file;

    public PokeGame(File file) {
        this.file = file;
    }

    public String runResult() throws IOException {
        final StringBuilder resultSB = new StringBuilder();
        for(final Collection<Player> match : loadingRecords()) {
            final Player winner = match.stream()
                    .min(Comparator.comparing(Player::hand))
                    .orElseThrow();
            resultSB.append(winner.name());
        }
        return resultSB.toString();
    }

    private Collection<Collection<Player>> loadingRecords() throws IOException {
        final Collection<Collection<Player>> matches = new ArrayList<>();
        Collection<Player> match = new ArrayList<>();

        try (final Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();

                // 遇到一场比赛结束行，则新建一个新的比赛
                if (isEOG(line)) {
                    matches.add(match);
                    match = new ArrayList<>();
                    continue;
                }

                // 提取玩家编号：每行第一个字母
                final String name = line.substring(0, 1);

                // 提取扑克牌
                final List<Poke> pokes = new ArrayList<>();
                final Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    final String group = matcher.group();
                    pokes.add(new Poke(
                            mappingPokeRank(group.substring(1)),
                            mappingPokeColor(group.substring(0, 1))
                    ));
                }

                // 添加玩家到当前比赛
                match.add(new Player(name, new PokeHand(pokes.toArray(Poke[]::new))));

            }
        }
        return matches;
    }

    private static boolean isEOG(String line) {
        return line.startsWith("---");
    }

    private static Poke.Rank mappingPokeRank(String string) {
        return switch (string) {
            case "1" -> Poke.Rank.P1;
            case "2" -> Poke.Rank.P2;
            case "3" -> Poke.Rank.P3;
            case "4" -> Poke.Rank.P4;
            case "5" -> Poke.Rank.P5;
            case "6" -> Poke.Rank.P6;
            case "7" -> Poke.Rank.P7;
            case "8" -> Poke.Rank.P8;
            case "9" -> Poke.Rank.P9;
            case "10" -> Poke.Rank.P10;
            case "J" -> Poke.Rank.PJ;
            case "Q" -> Poke.Rank.PQ;
            case "K" -> Poke.Rank.PK;
            case "A" -> Poke.Rank.PA;
            default -> throw new IllegalArgumentException();
        };
    }

    private static Poke.Color mappingPokeColor(String string) {
        return switch (string) {
            case "♦" -> Poke.Color.DIAMOND;
            case "♠" -> Poke.Color.SPADE;
            case "♥" -> Poke.Color.HEART;
            case "♣" -> Poke.Color.CLUB;
            default -> throw new IllegalArgumentException();
        };
    }

    /**
     * 选手
     * @param name 名称
     * @param hand 手牌
     */
    record Player(String name, PokeHand hand) {

    }

    public static void main(String... args) throws IOException {
        final String result = new PokeGame(new File(
                "/Users/vlinux/Downloads/代码大赛初赛用例(1).txt"
                // "/Users/vlinux/Downloads/test1.txt"
        )).runResult();
        System.out.println(result);
    }

}
