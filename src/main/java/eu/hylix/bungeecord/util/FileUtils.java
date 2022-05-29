package eu.hylix.bungeecord.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public File folder = new File("plugins/BungeeCordSystem/");
    public File mysqlFile = new File("plugins/BungeeCordSystem/mysql.yml");

    public void setUpFiles() {
        try {
        if(!folder.exists()) {
            folder.mkdir();
        }

        if(!mysqlFile.exists()) {
                mysqlFile.createNewFile();
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFiles() {

    }

}
