import javafx.stage.FileChooser;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by GrayOwl on 12/27/17.
 */
public class Coreui {
    private File mediaFile;

    public void play() throws FileNotFoundException {
        System.out.println("play clicked");
        new Thread(()->{
            try {
                Player player = new Player(new FileInputStream(mediaFile));
                player.play();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();


    }

    public void browse(){
        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Select a file");
            mediaFile = chooser.showOpenDialog(null);

            if (mediaFile != null){
                System.out.println(mediaFile.getName() + " selected");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
