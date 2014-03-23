package Romandefense.core;

import playn.core.ImageLayer;
import playn.core.*;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;


public class HomeScreen extends UIScreen{

    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;

    private Sound soundj = assets().getSound("sounds/intro");

    public HomeScreen(ScreenStack ss){
        this.ss = ss;
    }

    @Override
    public void wasShown() {
        super.wasShown();

        soundj.play();

        Image bgImage = assets().getImage("images/BG.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/start.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(225, 330);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter() {
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                soundj.stop();

                Screen home = new StartScreen(ss);
                ss.push(home);
            }
        });
    }
}
