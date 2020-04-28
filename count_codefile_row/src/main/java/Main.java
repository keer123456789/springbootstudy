import java.io.IOException;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: PACKAGE_NAME
 * @Author: keer
 * @CreateTime: 2020-04-25 18:33
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length!=4||!(args[0].equals("path"))||args[2].equals("type")){
            System.out.println("param error");
            System.out.println("example param: path file/path type java");
            System.out.println("param type now just support: java,py");
            return;
        }

        String path= args[1];
        String type= args[3];

        FileRowCount fileRowCount = new FileRowCount(path, type);
        fileRowCount.countRow();
        System.out.println(fileRowCount.toString());
    }


}
