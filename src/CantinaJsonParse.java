import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CantinaJsonParse {

    private JsonNode root;

    public CantinaJsonParse(String filepath) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        root = mapper.readTree(new File(filepath));
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        do {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("q")) {
                running = false;
            } else {

                SearchNode searchNode = new SearchNode(input);
                System.out.println(search(root, searchNode));
            }

        } while (running);
        in.close();
    }

    private String search(JsonNode node, SearchNode search) {
        String ret = "";
        if (search.compare(node))
            ret += node.toString() + '\n';
        for (JsonNode n : node)
            ret += search(n, search);
        return ret;
    }

}
