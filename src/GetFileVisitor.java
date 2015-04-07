import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/* Механизм заглядывания в файл/папку при обходе дерева каталогов
 SimpleFileVisitor реализует интерфейс FileVisitor
  */

public class GetFileVisitor extends SimpleFileVisitor<Path> {
    public ArrayList<String> pathToFile; // Массив записей, куда будем класть имена файлов и папок. Далее
    private Path path;      // сменим объектом, реализовав "стратегию" , Path path - входной путь - папка,
    public GetFileVisitor (String path) { // в которой будем шариться.
        super();
        pathToFile = new ArrayList<String>(); // банальный такой конструктор =/
        this.path = Paths.get(path);
    }

    /*
        Возвращает путь к папке, где шаримся
     */

    public String getDir () {
        return path.toString();
    }

    /*
        Функция обхода следущего файла в папке (Заглядываем в файл, узнаем все о нем идем дальше)
     */

    @Override
    public FileVisitResult visitFile (Path file, BasicFileAttributes basicFileAttributes) {
        if (file.getParent().equals(path)) { // если файл который мы смотрим находится в папке path, т.е
            pathToFile.add(file.getFileName().toString());  // в которой мы шаримся, то добавляем в массив
        }                                       // вложенных в эту папку файлов наш файл.
        return FileVisitResult.CONTINUE;
    }

    /*
        Функция обхода следующей папке в данном каталоге (Заглядываем в папку, смотрим что о ней известно
        и идем смотреть на файлы что внутри нее, но так как нас это не интересует, в функции реализовано
        только получение имени данной папки)
     */

    @Override
    public FileVisitResult preVisitDirectory (Path file, BasicFileAttributes basicFileAttributes) {
        if (file.getParent().equals(path)) {    // если папка которую мы смотрим находится внутри path, т.е
            pathToFile.add(file.getFileName().toString()); // в которой мы шаримся, то добавляем в массив
        }                       // вложенных в эту папку файлов нашу папку.
        return FileVisitResult.CONTINUE;
    }
}
