package Romandefense.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Pointer;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Created by Chettawat on 26/2/2557.
 */
public class Home extends UIScreen {

    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;

    public Home(ScreenStack ss) {

        this.ss = ss;

    }

    @Override
    public void wasShown() {
        super.wasShown();

        Image bgImage = assets().getImage("images/BG.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/start.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(27,322);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                Screen home = new Dungeon(ss);
                ss.push(home);
            }
        });
    }
}
