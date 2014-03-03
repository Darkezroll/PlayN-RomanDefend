package Romandefense.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Pointer;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Created by Chettawat on 26/2/2557.
 */
public class Dungeon extends Screen {

    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;

    public Dungeon(ScreenStack ss) {

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

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                Screen game = new Game(ss);
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
                ss.remove(Dungeon.this);
            }

        });
    }
}
