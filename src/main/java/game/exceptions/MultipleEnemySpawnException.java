package game.exceptions;

import java.util.List;

public class MultipleEnemySpawnException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Multiple Enemy Spawn: The provided map file has multiple enemy spawns.";

    /**
     * Constructs a new MultipleEnemySpawnException with a detailed error message.
     * This exception is thrown when the provided map file contains multiple enemy bases.
     *
     * @param levelPath The file path of the level containing the invalid map.
     * @param mapFile   The name or path of the specific map file that is invalid.
     * @param coordinates The coordinates of the multiple enemy spawns.
     * @see game.exceptions.GameException#GameException(String)
     */
    public MultipleEnemySpawnException(String levelPath, String mapFile, List<int[][]> coordinates) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Map File: ").append(mapFile).append("\n");
        for (int i = 0; i < coordinates.size(); i++) {
            int[][] coordinate = coordinates.get(i);
            sb.append(" - enemy spawn ")
                    .append(i + 1)
                    .append(" Coordinates: (")
                    .append(coordinate[0][0]).append(", ")
                    .append(coordinate[0][1]).append(")\n");
        }
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
