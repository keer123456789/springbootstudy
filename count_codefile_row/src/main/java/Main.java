import java.io.IOException;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: PACKAGE_NAME
 * @Author: keer
 * @CreateTime: 2020-04-25 18:33
 * @Description:
 */
public class Main {
    static long fileCount = 0;
    static long allFileRow = 0;
    static long codeLines = 0;
    static long commentLines = 0;
    static long blankLines = 0;

    public static void main(String[] args) throws IOException {
        String path = "E:/code/java/spring-boot-study";
        String glob = "java";
        FileRowCount fileRowCount = new FileRowCount(path, glob);
        fileRowCount.countRow();
        System.out.println(fileRowCount.toString());
    }


}
