import java.io.IOException;

public class CantainaCodeTest {

    public static void main(String[] args) {
        try {
            CantinaJsonParse parser = new CantinaJsonParse(args[0]);
            parser.run();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
