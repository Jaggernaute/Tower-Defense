package game.map;

import game.exceptions.GameException;
import game.exceptions.MapException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MapParser {
    
        /**
     * Parses a map file and converts it into a 2D array of Tiles.
     * <p>
     * This method reads a map file, interprets each character as a specific tile type,
     * and constructs a 2D array representing the game map. It checks for consistency
     * in map dimensions and handles various tile types.
     * </p>
     * @param mapPath  The Path object pointing to the map file to be parsed.
     * @param levelPath The Path object representing the level file, used for error reporting.
     * @return A 2D array of Tiles representing the parsed map.
     * @throws GameException If there's an error reading the file or if the map is invalid.
     * @throws MapException  For specific map-related errors.
     */
    public Tiles[][] parseMap(Path mapPath, Path levelPath) throws GameException {
        Tiles[][] parsedMap;
        List<String> lines = getStrings(mapPath);

        int rows = lines.size();
        int cols = lines.getFirst().length();
        parsedMap = new Tiles[rows][cols];
    
        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            if (line.length() != cols) {
                throw new MapException(
                        "Inconsistent map width at line " + (i + 1),
                        levelPath.toString(),
                        mapPath.toString()
                );
            }
            for (int j = 0; j < cols; j++) {
                char c = line.charAt(j);
                switch (c) {
                    case 'S':
                        parsedMap[i][j] = Tiles.ENEMY_SPAWN;
                        break;
                    case 'B':
                        parsedMap[i][j] = Tiles.PLAYER_BASE;
                        break;
                    case 'R':
                        parsedMap[i][j] = Tiles.PATH;
                        break;
                    case 'C':
                        parsedMap[i][j] = Tiles.BUILDABLE;
                        break;
                    case 'x':
                        parsedMap[i][j] = Tiles.DECORATION;
                        break;
                    default:
                        throw new MapException(
                                "Unknown tile : " + c,
                                levelPath.toString(),
                                mapPath.toString()
                        );
                }
            }
        }
    
        return parsedMap;
    }

    private static List<String> getStrings(Path path) throws GameException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader inputBuffer = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = inputBuffer.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            throw new GameException("Error while reading the map file at: " + path);
        }

        if (lines.isEmpty()) {
            throw new GameException("The map file is empty: " + path);
        }
        return lines;
    }
}

