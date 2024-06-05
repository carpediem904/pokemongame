import java.util.*;
import java.util.stream.IntStream;
public class Game {
    private List<Player> players;
    private List<Card> totalCards;
    private List<String> pokemonNames;

    private List<Player> roundWinners;


    public Game(int numPlayers) {
        players = new ArrayList<>(); // number of players for game
        totalCards = new ArrayList<>();
        roundWinners = new ArrayList<>();

        // Create and shuffle the deck
        pokemonList();
        createCards();
        Collections.shuffle(totalCards);

        // Create players and distribute cards
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i));
        }
        // Distribute cards to players
        distributeCardsEqually();

    }

    public void playRound() {
        List<Card> roundCards = new ArrayList<>();

        // Each player selects a card to play
        for (Player player : players) {
            System.out.println(player.getName() + ", it's your turn.");
            System.out.println("Your hand: " + player.getHand());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the index of the card you want to play: ");
            int index = scanner.nextInt();

            Card playedCard = player.playCard(index);
            if (playedCard != null) {
                roundCards.add(playedCard);
                System.out.println(player.getName() + " played " + playedCard.getName() + ".");
            } else {
                System.out.println("Invalid choice. You miss your turn.");
            }
        }

        // Determine the winner of the round
        Card roundWinner = determineRoundWinner(roundCards);
        roundWinners.add(roundWinner != null ? getPlayerByCard(roundWinner) : null);

        // Display the round result
        System.out.println("Round winner: " + (roundWinner != null ? roundWinner.getName() : "No one"));
    }

    public Card determineRoundWinner(List<Card> roundCards) {
        if (roundCards.isEmpty()) {
            return null;
        }

        Card roundWinner = roundCards.get(0);
        for (Card card : roundCards) {
            if (card.getOverall() > roundWinner.getOverall()) {
                roundWinner = card;
            }
        }
        return roundWinner;
    }


    /**
     * to create a list of all pokemons
     */
    public List<String> pokemonList() {
        pokemonNames = new ArrayList<>();
        pokemonNames.add("Pikachu");
        pokemonNames.add("Bulbasaur");
        pokemonNames.add("Charmander");
        pokemonNames.add("Squirtle");
        pokemonNames.add("Jigglypuff");
        pokemonNames.add("Meowth");
        pokemonNames.add("Psyduck");
        pokemonNames.add("Machop");
        pokemonNames.add("Geodude");
        pokemonNames.add("Slowpoke");
        pokemonNames.add("Magnemite");
        pokemonNames.add("Doduo");
        pokemonNames.add("Gastly");
        pokemonNames.add("Onix");
        pokemonNames.add("Drowzee");
        pokemonNames.add("Voltorb");
        pokemonNames.add("Cubone");
        pokemonNames.add("Hitmonlee");
        pokemonNames.add("Hitmonchan");
        pokemonNames.add("Lickitung");
        pokemonNames.add("Chansey");
        pokemonNames.add("Kangaskhan");
        pokemonNames.add("Horsea");
        pokemonNames.add("Goldeen");
        return pokemonNames;
    }

    /**
     * to create a random number between 500-999
     */
    public int randomCreation() {
        Random random = new Random();
        int min = 500;
        int max = 999;
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * to create a deck of full cards
     */
    public List<Card> createCards() {
        for (int i = 0; i < pokemonNames.size(); i++) {
            totalCards.add(new Card(pokemonNames.get(i), randomCreation(), randomCreation(), randomCreation()));
        }
        return totalCards;

    }

    /**
     * Distribute cards to players equally
     */
    public void distributeCardsEqually() {
        int cardsPerPlayer = totalCards.size() / players.size();

        for (Player player : players) {
            for (int i = 0; i < cardsPerPlayer; i++) {
                Card card = totalCards.get(i);
                player.addCardToHand(card);
            }
        }
    }
/**
 * method to determine the overall winner of the game based on the most round wins:
 */


    public Player determineOverallWinner() {
        Map<Player, Integer> playerWins = new HashMap<>();

        for (Player player : roundWinners) {
            if (player != null) {
                playerWins.put(player, playerWins.getOrDefault(player, 0) + 1);
            }
        }

        Player overallWinner = null;
        int maxWins = -1;

        for (Map.Entry<Player, Integer> entry : playerWins.entrySet()) {
            if (entry.getValue() > maxWins) {
                maxWins = entry.getValue();
                overallWinner = entry.getKey();
            }
        }

        return overallWinner;
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        int numRounds = 2;//totalCards.size() / players.size(); // Number of rounds to play (adjust as needed)

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("=== Round " + round + " ===");
            playRound();
            System.out.println();
        }

        System.out.println("=== Game Over ===");
        Player gameWinner = determineOverallWinner();
        if (gameWinner != null) {
            System.out.println("Overall winner: " + gameWinner.getName());
        } else {
            System.out.println("No overall winner.");
        }
    }
    public Player getPlayerByCard(Card card) {
        for (Player player : players) {
            if (player.getHand().contains(card)) {
                return player;
            }
        }
        return null;
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int numPlayers = 0;

            while (numPlayers < 2 || numPlayers > 4) {
                System.out.print("Enter the number of players (between 2 and 4): ");
                numPlayers = scanner.nextInt();

                if (numPlayers < 2 || numPlayers > 4) {
                    System.out.println("Invalid number of players. Please enter a value between 2 and 4.");
                }
            }

            Game game = new Game(numPlayers);
            game.start();
        }


    }


