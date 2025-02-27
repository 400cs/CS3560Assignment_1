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
    private static final String[] color = { "Red", "Blue", "Yellow", "Green"};

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
        Faces.put("left", new Face(""));
        Faces.put("right", new Face(""));
        Faces.put("bottom", new Face(""));
    }

    //should set up the cube’s edges, ensuring proper placement of tiles and their colors
    public void initializeEdges() {
        Edges.put("front", new String[] {"left", "right", "bottom"});
    }

    //Verify that each face contains exactly 9 tiles
    //Ensure that the color distribution across the cube follows the valid rules
    public void validateCube() {

    }

    public class Face {

        public Face(String color) {
            
        }
    }
}
