package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.AtomSceneController;
import net.thevpc.gaming.atom.engine.GameEngine;
import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.presentation.Game;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;
import net.thevpc.gaming.atom.presentation.components.SList;
import net.thevpc.gaming.atom.presentation.components.STextField;
@AtomSceneController(
        scene = "welcome"
)
public class WelcomeController extends DefaultSceneController {


    public WelcomeController() {
    }

    @Override
    public void keyPressed(SceneKeyEvent e) {

        GameEngine game = e.getScene().getGame().getGameEngine();
        switch (e.getKeyCode()) {
            case SPACE: {
             //   game.setActiveSceneEngine(HelloWorldScene.class);
                break;
            }
            default:break;
        }
    }
}
