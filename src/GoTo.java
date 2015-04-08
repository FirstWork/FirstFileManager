import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GoTo  {

    /*
        Механизм перехода по указанной директории
     */

    public static boolean goToPath (Path path) throws IOException {
        if(!Files.isReadable(path)) {   // Если папку path НЕЛЬЗЯ просматривать то результат неудачен, выход с ошибкой
            return false;
        }
        Files.walkFileTree(path , new GetFileVisitor(path));    // Механизм обхода дерева каталогов.
        return true;    // когда обошли все ок!
    }

    /*
        Механизм перехода в корневой каталог
     */

    public static boolean goToRoot (Path path) throws IOException {
        Files.walkFileTree(path.getRoot(), new GetFileVisitor(path.getRoot()));
        return true;
    }

    /*
        Дальше будет механизм перехода по URL, ip, ssh и telnet
     */
}
