package FileWork;

/**
 * Created by Girish on 10-03-2015.
 */
public enum Algorithm {
    SHA1,MD5;

    @Override
    public String toString() {
        switch (this){
            case SHA1:
                return "SHA-1";
            default:
                return super.name();
        }
    }
}
