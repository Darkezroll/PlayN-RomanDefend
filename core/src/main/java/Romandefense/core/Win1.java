package Romandefense.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Pointer;
import playn.core.Sound;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Created by Chettawat on 23/3/2557.
 */
public class Win1 extends UIScreen {

    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;
    private Image btImage1;
    private ImageLayer btLayer1;
    private Image btImage2;
    private ImageLayer btLayer2;

    private Sound soundj = assets().getSound("sounds/win");

    public Win1(ScreenStack ss) {
        this.ss = ss;

    }

    @Override
    public void wasShown() {
        super.wasShown();

        soundj.play();
        onestar();

    }

    public void onestar(){

        Image bgImage = assets().getImage("images/dun1.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/1star.png");
        btLayer = graphics().createImageLayer(btImage);
        layer.add(btLayer);

        btImage1 = assets().getImage("images/continue.png");
        btLayer1 = graphics().createImageLayer(btImage1);
        btLayer1.setTranslation(251, 283);
        layer.add(btLayer1);

        btLayer1.addListener(new Pointer.Adapter() {
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                soundj.stop();

                Screen game = new GameScreen(ss);
                ss.push(game);
            }
        });

        btImage2 = assets().getImage("images/close.png");
        btLayer2 = graphics().createImageLayer(btImage2);
        btLayer2.setTranslation(295, 65);
        layer.add(btLayer2);

        btLayer2.addListener(new Pointer.Adapter() {
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                soundj.stop();

                Screen home = new HomeScreen(ss);
                ss.push(home);
            }
        });

    }
}
