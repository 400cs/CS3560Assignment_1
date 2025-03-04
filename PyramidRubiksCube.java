import java.util.Map;
import java.util.HashMap;

public class PyramidRubiksCube {
    
    // pick data struc -> hashmap

    // 3 type of pieces and 4 colors (red, blue, yellow, green)
    // Face of "color" has 3 tips, 3 edges and 3 centers pieces
    // Tip

    // Edge

    // Center

    private static final int num_Faces = 4;
    private static final int Tiles_Per_Face = 9;
    private static final String[] COLOR = { "Red", "Blue", "Yellow", "Green"};

    private Map<String, Face> Faces;
    private Map<String, String[]> Edges;

    public PyramidRubiksCube() {
        Faces = new HashMap<>();
        Edges = new HashMap<>();
        initializeFaces();
        initializeEdges();
    }

    //should initialize the faces of the pyramid, ensuring the correct structure is followed
    public void initializeFaces() {
        Faces.put("front", new Face("Red"));
        Faces.put("left", new Face("Blue"));
        Faces.put("right", new Face("Yellow"));
        Faces.put("bottom", new Face("Green"));
    }

    //should set up the cube’s edges, ensuring proper placement of tiles and their colors
    public void initializeEdges() {
        Edges.put("front", new String[] {"left", "right", "bottom"});
        Edges.put("left", new String[]{"front", "right", "bottom"});
        Edges.put("right", new String[]{"front", "left", "bottom"});
        Edges.put("bottom", new String[]{"front", "left", "right"});
    }

    //Verify that each face contains exactly 9 tiles
    //Ensure that the color distribution across the cube follows the valid rules
    public boolean validateCube() {
        // Validate face structure
        for (Map.Entry<String, Face> entry : Faces.entrySet()) {
            Face face = entry.getValue();
            if (face.getTileCount() != Tiles_Per_Face) {
                System.out.println("Validation failed: " + entry.getKey() + " does not have 9 tiles.");
                return false;
            }
        }

        // Validate color distribution
        Map<String, Integer> colorCount = new HashMap<>();
        for (String color : COLOR) {
            colorCount.put(color, 0);
        }

        for (Face face : Faces.values()) {
            for (String tileColor : face.getTiles()) {
                colorCount.put(tileColor, colorCount.get(tileColor) + 1);
            }
        }

        // Ensure each color appears exactly 9 times
        for (Map.Entry<String, Integer> count : colorCount.entrySet()) {
            if (count.getValue() != Tiles_Per_Face) {
                System.out.println("Validation failed: Color " + count.getKey() + " appears " + count.getValue() + " times instead of 9.");
                return false;
            }
        }

        System.out.println("Cube validation successful!");
        return true;
    }

    class Face {
        private String color;
        private String[] tiles;

        public Face(String color) {
            this.color = color;
            this.tiles = new String[Tiles_Per_Face];
            for (int i = 0; i < Tiles_Per_Face; i++) {
                tiles[i] = color; // Initialize with the correct color
            }
        }

        public int getTileCount() {
            return tiles.length;
        }

        public String[] getTiles() {
            return tiles;
        }
    }

    public static void main(String[] args) {
        PyramidRubiksCube cube = new PyramidRubiksCube();
        cube.validateCube(); // Run validation check
    }

}
