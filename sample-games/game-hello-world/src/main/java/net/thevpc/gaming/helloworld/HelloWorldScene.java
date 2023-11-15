package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.*;
import net.thevpc.gaming.atom.debug.AdjustViewController;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.SpriteFilter;
import net.thevpc.gaming.atom.model.Orientation;
import net.thevpc.gaming.atom.model.Point;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.presentation.*;
import net.thevpc.gaming.atom.presentation.components.SLabel;
import net.thevpc.gaming.atom.presentation.layers.ImageBoardLayer;
import net.thevpc.gaming.atom.presentation.layers.Layers;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vpc on 9/23/16.
 */
@AtomScene(
        id = "hello",
        title = "Hello World",
        tileWidth = 50,
        tileHeight = 50

)
@AtomSceneEngine(
        id="hello",
        columns = 10,
        rows = 10,
        fps = 25
)

public class HelloWorldScene {

    @Inject
    private Scene scene;
    @Inject
    private SceneEngine sceneEngine;
    private String viesLabel = "Vies : ";
private int lifes;
    @OnSceneStarted
    public void init() {
        scene.addLayer(Layers.fillBoardGradient(Color.GRAY,Color.CYAN, Orientation.NORTH));
        scene.addLayer(new ImageBoardLayer("/board.jpeg"));
        scene.addLayer(Layers.debug());
//        scene.addLayer(Layers.fillScreen(Color.red));
        scene.addController(new SpriteController(SpriteFilter.byName("Ball1")).setArrowKeysLayout());
        scene.addController(new SpriteController(SpriteFilter.byName("Ball2")).setESDFLayout());
//        scene.addController(new SpriteController(SpriteFilter.byName("Ball2")).setESDFLayout());
        scene.addController(new AdjustViewController());
        lifes = sceneEngine.findSpriteByName("Ball1").getLife()+10;
        scene.addComponent(
                new SLabel("Click CTRL-D to switch debug mode, use Arrows to move the ball")
                .setLocation(Point.ratio(0.5f,0.5f))
        );

        scene.addComponent(
                new SLabel(viesLabel)
                        .setLocation(Point.ratio(0.2f,0.5f))
        );
        scene.setSpriteView(SpriteFilter.byName("Ball1"), new ImageSpriteView("/ball.png", 8, 4));
        scene.setSpriteView(SpriteFilter.byName("Ball2"), new ImageSpriteView("/download-removebg-preview.png", 6, 3));
//        scene.setSpriteView(SpriteFilter.byName("Ball2"), new DefaultSpriteView() {
//
//            @Override
//            public void draw(SpriteDrawingContext context) {
//                Graphics2D graphics = context.getGraphics();
//                context.getSpriteBounds().toRectangle();
//
//                    graphics.draw(context.getSpriteShape());
//            }
//        });

    }




// a chaque click use mouseClicked ( e ) but can t find where to orient the ball to the point where x,y of the click


    public void aChaqueClick(){
    SceneEngine sceneEngine1 = sceneEngine.findSpriteByName("Ball2");

    }


    @OnNextFrame
    private void aChaqueTic() {
        viesLabel = "Vies : " + lifes ;
        SLabel viesSLabel = scene.getComponent("noname:2");
        viesSLabel.setText(viesLabel);
        if (lifes > 0){
            lifes = lifes +1;
        }
    }
}
