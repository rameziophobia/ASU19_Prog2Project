package model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.player.PLAYERS;

public class PlayerPicker extends VBox {

    private ImageView buttonImage;
    private ImageView playerImage;

    private String buttonNotChosen = "file:src/model/resources/buttonSquare_grey.png";
    private String buttonChosen = "file:src/model/resources/buttonSquare_blue_pressed.png";

    private PLAYERS player;

    private boolean isChosen;


    public PlayerPicker(PLAYERS player)
    {
        this.player = player;
        buttonImage = new ImageView(buttonNotChosen);
        playerImage = new ImageView(player.URL);
        playerImage.setRotate(270);
        isChosen = false;
        this.setAlignment(Pos.CENTER);
        setSpacing(25);
        getChildren().add(buttonImage);
        getChildren().add(playerImage);
    }

    public PLAYERS getPlayer() {
        return player;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
        String imageToSet = isChosen ? buttonChosen : buttonNotChosen;
        buttonImage.setImage(new Image(imageToSet));
    }
}