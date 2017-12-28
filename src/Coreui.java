import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by GrayOwl on 12/27/17.
 */
public class Coreui {
    //Parent root = FXMLLoader.load(getClass().getResource("coreui.fxml"));
    //Scene scene = new Scene(root);
    private File mediaFile;
    private boolean playState = false;

    public Coreui() throws IOException {
    }

    @FXML
    private Button playBtn;

    public void play() throws FileNotFoundException {
        System.out.println("play/pause clicked");

        if (playState == true){
            playState = false;
            playBtn.setText("Play");

        }
        else if (playState == false){
            playState = true;
            playBtn.setText("Pause");
            new Thread(()->{
                try {
                    Player player = new Player(new FileInputStream(mediaFile));
                    player.play();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }).start();

        }




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
