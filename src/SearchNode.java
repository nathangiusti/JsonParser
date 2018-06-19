import com.fasterxml.jackson.databind.JsonNode;

public class SearchNode {
    private String classStr = null;
    private String className = null;
    private String identifier = null;

    public SearchNode(String str) {
        if (str.startsWith("."))
            className = str.substring(1);
        else if (str.startsWith("#"))
            identifier = str.substring(1);
        else
            classStr = str;
    }

    public boolean compare(JsonNode node) {

        if (node == null)
            return false;

        boolean retVal = false;

        if (classStr != null && node.get("class") != null) {
            retVal = classStr.equals(node.get("class").asText());
        } else if (className != null && node.get("classNames") != null) {
            for (JsonNode child : node.get("classNames"))
                if (className.equals(child.asText()))
                    retVal = true;
        } else if (identifier != null && node.get("identifier") != null) {
            retVal = identifier.equals(node.get("identifier").asText());
        }

        return retVal;
    }

    public String toString() {
        String retVal = "";
        retVal += "Class: " + classStr + '\n';
        retVal += "Class Name: " + className + '\n';
        retVal += "Identifier: " + identifier + '\n';
        return retVal;
    }
}
