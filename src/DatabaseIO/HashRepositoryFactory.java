package DatabaseIO;

/**
 * Created by Girish on 09-03-2015.
 */
public class HashRepositoryFactory {
    private static HashRepository hashRepository =null;

    private HashRepositoryFactory(){

    }
    public static HashRepository getInstance(){
        if(hashRepository ==null){
            hashRepository = new SetHashRepository();
        }
        return hashRepository;
    }

}
