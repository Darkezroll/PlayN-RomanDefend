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
 * Created by Chettawat on 23/3/2557.
 */
public class Win extends UIScreen {

    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;
    private Image btImage1;
    private ImageLayer btLayer1;
    private Image btImage2;
    private ImageLayer btLayer2;

    public Win(ScreenStack ss) {
        this.ss = ss;

    }

    @Override
    public void wasShown() {
        super.wasShown();

       onestar();

        /*twostar();*/

        /*threestar();*/

        /*zerostar();*/

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

                Screen home = new HomeScreen(ss);
                ss.push(home);
            }
        });

    }

    public void twostar(){

        Image bgImage = assets().getImage("images/dun1.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/2star.png");
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

                Screen home = new HomeScreen(ss);
                ss.push(home);
            }
        });
    }

    public void threestar(){

        Image bgImage = assets().getImage("images/dun1.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/3star.png");
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

                Screen home = new HomeScreen(ss);
                ss.push(home);
            }
        });
    }

    public void zerostar(){

        Image bgImage = assets().getImage("images/dun1.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        btImage = assets().getImage("images/0star.png");
        btLayer = graphics().createImageLayer(btImage);
        layer.add(btLayer);

        btImage1 = assets().getImage("images/restart.png");
        btLayer1 = graphics().createImageLayer(btImage1);
        btLayer1.setTranslation(257, 220);
        layer.add(btLayer1);

        btLayer1.addListener(new Pointer.Adapter() {
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

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

                Screen home = new HomeScreen(ss);
                ss.push(home);
            }
        });
    }
}
