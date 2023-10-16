//package net.thevpc.gaming.helloworld;
//
//import net.thevpc.gaming.atom.annotations.AtomScene;
//import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
//import net.thevpc.gaming.atom.annotations.OnInit;
//import net.thevpc.gaming.atom.model.Orientation;
//import net.thevpc.gaming.atom.model.ViewBox;
//import net.thevpc.gaming.atom.model.ViewPoint;
//import net.thevpc.gaming.atom.presentation.DefaultScene;
//import net.thevpc.gaming.atom.presentation.components.SButton;
//import net.thevpc.gaming.atom.presentation.components.SLabel;
//import net.thevpc.gaming.atom.presentation.layers.FillScreenGradientLayer;
//
//import java.awt.*;
//@AtomScene(
//        id = "welcome",
//        sceneEngine = "welcome",
//        title = "BALL ROLL",
//        tileWidth = 600,
//        tileHeight = 400
//)
//@AtomSceneEngine(
//        id="welcome",
//        columns = 10,
//        rows = 10,
//        fps = 25
//)
//public class WelcomeScene extends DefaultScene {
//    private final SButton start = new SButton("start", "Press any key to start...");
//    private SLabel title;
//    public WelcomeScene() {
//
//    }
//    @OnInit
//    public void onInstall() {
//        addLayer(new FillScreenGradientLayer(new Color(254, 6, 10), new Color(242, 254, 6), Orientation.NORTH_EAST));
//        ViewBox vp = getCamera().getViewBounds();
//        ViewBox r2 = new ViewBox(vp.getX(), vp.getY() + vp.getHeight() * 2 / 3, vp.getWidth(), vp.getHeight() / 3);
//        start.setBounds(r2);
//        title = new SLabel("BALL ROLL")
//                .setBounds(new ViewBox(0, 0, getCamera().getViewPort().getWidth(), 100))
//                .setLocation(new ViewPoint(vp.getX(), vp.getY()));
//        addComponent(start);
//        addComponent(title);
//    }
//}
