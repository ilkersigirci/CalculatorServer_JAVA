import java.io.File;

public class MyFileWatcher extends FileWatcher
{
    public MyFileWatcher(String watchFile)
    {
        super(watchFile);
    }

    @Override
    public void onModified()
    {
        System.out.println("Modified!");
    }
}


/* String watchFile = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Test.txt";
FileWatcher fileWatcher = new MyFileWatcher(watchFile);
fileWatcher.watchFile(); */