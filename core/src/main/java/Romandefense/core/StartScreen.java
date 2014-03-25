package Romandefense.core;

import playn.core.*;
import react.UnitSlot;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Created by AprilMcBkPro on 22/01/2014.
 */
public class StartScreen extends UIScreen {


    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;

    public StartScreen(ScreenStack ss){
        this.ss = ss;
    }

    @Override
    public void wasAdded() {
        super.wasAdded();

        Image bgImage = assets().getImage("images/bgdun.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/select.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(380,210);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter() {
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                Screen game = new GameScreen(ss);
                ss.push(game);
            }

        });


        btImage = assets().getImage("images/back.png");
        btLayer = graphics().createImageLayer(btImage);
        layer.add(btLayer);
        btLayer.setTranslation(10, 400);
        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                Screen home = new HomeScreen(ss);
                ss.push(home);
            }

        });
    }

}
