package game.exceptions;

import java.util.List;

public class MultiplePlayerBaseException extends GameException {

    public static final String DEFAULT_ERROR_MESSAGE = "Multiple Player Base: The provided map file has multiple player bases.";

    /**
     * Constructs a new MultiplePlayerBaseException with a detailed error message.
     * This exception is thrown when the provided map file contains multiple player bases.
     *
     * @param levelPath The file path of the level containing the invalid map.
     * @param mapFile   The name or path of the specific map file that is invalid.
     * @param coordinates The coordinates of the multiple player bases.
     * @see game.exceptions.GameException#GameException(String)
     */
    public MultiplePlayerBaseException(String levelPath, String mapFile, List<int[][]> coordinates) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_ERROR_MESSAGE).append("\n");
        sb.append("Map File: ").append(mapFile).append("\n");
        for (int i = 0; i < coordinates.size(); i++) {
            int[][] coordinate = coordinates.get(i);
            sb.append(" - player base ")
                    .append(i + 1)
                    .append(" Coordinates: (")
                    .append(coordinate[0][0]).append(", ")
                    .append(coordinate[0][1]).append(")\n");
        }
        String fullErrorMessage = sb.toString();
        super(fullErrorMessage);
    }
}
