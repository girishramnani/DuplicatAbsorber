package FileFind;

/**
 * Create interface between hashRepository and the  FileWalker
 */
public interface FileEventListener {

    public void apply(FileEvent fileEvent);


}
