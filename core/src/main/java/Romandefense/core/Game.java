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
public class Game extends Screen {

    public static float M_PER_PIXEL;
    private final ScreenStack ss;
    private Image btImage;
    private ImageLayer btLayer;
    private ImageLayer btLayer1;
    private ImageLayer btLayer2;
    private ImageLayer btLayer3;

    private ares a = new ares(0,0);
    private ares a1 = new ares(0,0);
    private ares a2 = new ares(0,0);
    private ares a3 = new ares(0,0);

    private zeus z = new zeus(0,0);
    private zeus z1 = new zeus(0,0);
    private zeus z2 = new zeus(0,0);
    private zeus z3 = new zeus(0,0);

    private int count = 1;



    public Game(ScreenStack ss) {
        this.ss = ss;
    }

    @Override
    public void wasAdded() {
        super.wasAdded();


        Image bgImage = assets().getImage("images/dun1.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);


        /////////////////////////////////////////////////////////

        btImage = assets().getImage("images/btzeus.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(10,10);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                count = 0;
            }
        });

        /////////////////////////////////////////////////////////

        btImage = assets().getImage("images/btares.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(70,10);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                count = 2;
            }
        });

        ///////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(124,250);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (count == 0){
                    z = new zeus(145,240);
                    layer.add(z.layer());
                    count ++;
                }

                if (count == 2 ){
                    a = new ares(145,240);
                    layer.add(a.layer());
                    count ++;
                }

            }
        });

        //////////////////////////////////////////////////////////


        btImage = assets().getImage("images/stand.png");
        btLayer1 = graphics().createImageLayer(btImage);
        btLayer1.setTranslation(246,206);
        layer.add(btLayer1);

        btLayer1.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (count == 0){
                    z1 = new zeus(265,196);
                    layer.add(z1.layer());
                    count ++;
                }

                if (count == 2 ){
                    a1 = new ares(265,196);
                    layer.add(a1.layer());
                    count ++;
                }

            }
        });

        /////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer2 = graphics().createImageLayer(btImage);
        btLayer2.setTranslation(308,108);
        layer.add(btLayer2);

        btLayer2.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (count == 0){
                    z2 = new zeus(327,98);
                    layer.add(z2.layer());
                    count ++;
                }

                if (count == 2){
                    a2 = new ares(327,98);
                    layer.add(a2.layer());
                    count ++;
                }

            }
        });


        //////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer3 = graphics().createImageLayer(btImage);
        btLayer3.setTranslation(490,250);
        layer.add(btLayer3);

        btLayer3.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (count == 0){
                    z3 = new zeus(509,240);
                    layer.add(z3.layer());
                    count ++;
                }

                if (count == 2){
                    a3 = new ares(509,240);
                    layer.add(a3.layer());
                    count ++;
                }

            }
        });

        ///////////////////////////////////////////////////////////


        btImage = assets().getImage("images/back.png");
        btLayer = graphics().createImageLayer(btImage);
        layer.add(btLayer);

        btLayer.setTranslation(10, 400);
        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);
                ss.remove(Game.this);
            }

        });


    }

    @Override
    public void update(int delta) {
        super.update(delta);
        z.update(delta);
        z1.update(delta);
        z2.update(delta);
        z3.update(delta);

        a.update(delta);
        a1.update(delta);
        a2.update(delta);
        a3.update(delta);
    }
}
