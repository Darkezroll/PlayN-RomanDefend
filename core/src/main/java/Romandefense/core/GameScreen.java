package Romandefense.core;

import Sprite.ares;
import Sprite.zeus;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;
import playn.core.*;
import playn.core.util.Callback;
import playn.core.util.Clock;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;

import java.util.ArrayList;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;


public class GameScreen extends UIScreen {

    public static float M_PER_PIXEL = 1 / 26.666667f;
    //size of world
    private static int width  = 24;  // 640 pixel in physic unit (meter)
    private static int height = 18;  // 480 pixel in physic unit (meter)

    private World world;
    private DebugDrawBox2D debugDraw;
    private boolean showDebugDraw = true;

    private  ScreenStack ss;

    private Image bgImage;
    private Layer bgLayer;
    private Image btImage;
    private Layer btLayer;

    private zeus z,z1,z2,z3;
    private ares a,a1,a2,a3;

    private boolean countz = false;
    private boolean counta = false;

    private boolean stend = false;
    private boolean stend1 = false;
    private boolean stend2 = false;
    private boolean stend3 = false;


    public GameScreen(ScreenStack ss){
        this.ss = ss;
    }



    @Override
    public void wasAdded() {
        super.wasAdded();

        z = new zeus(world,0,0);
        z1 = new zeus(world,0,0);
        z2 = new zeus(world,0,0);
        z3 = new zeus(world,0,0);

        a = new ares(world,0,0);
        a1 = new ares(world,0,0);
        a2 = new ares(world,0,0);
        a3 = new ares(world,0,0);


        Vec2 gravity = new Vec2(0.0f,0.0f);
        world = new World(gravity,true);
        world.setWarmStarting(true);
        world.setAutoClearForces(true);


        bgImage = assets().getImage("images/dun1.png");
        bgImage.addCallback(new Callback<Image>() {
            @Override
            public void onSuccess(Image result) {

            }

            @Override
            public void onFailure(Throwable cause) {

            }
        });


        bgLayer = PlayN.graphics().createImageLayer(bgImage);
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

                countz = true;
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

                counta = true;
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

                if (countz == true && stend == false){

                    z = new zeus(world,145,240);
                    layer.add(z.layer());
                    countz = false;
                    stend = true;

                }

                if (counta == true && stend == false){

                    a = new ares(world,145,240);
                    layer.add(a.layer());
                    counta = false;
                    stend = true;

                }
            }


        });

        //////////////////////////////////////////////////////////


        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(246,206);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend1 == false){
                    z1 = new zeus(world,265,196);
                    layer.add(z1.layer());
                    countz = false;
                    stend1 = true;
                }
                if (counta == true && stend1 == false){

                    a1 = new ares(world,265,196);
                    layer.add(a1.layer());
                    counta = false;
                    stend1 = true;

                }


            }
        });

        /////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(308,108);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend2 == false){
                    z2 = new zeus(world,327,98);
                    layer.add(z2.layer());
                    countz = false;
                    stend2 = true;
                }

                if (counta == true && stend2 == false){

                    a2 = new ares(world,327,98);
                    layer.add(a2.layer());
                    counta = false;
                    stend2 = true;

                }


            }
        });


        //////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(490,250);
        layer.add(btLayer);

        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend3 == false){
                    z3 = new zeus(world,509,240);
                    layer.add(z3.layer());
                    countz = false;
                    stend3 = true;
                }

                if (counta == true && stend3 == false){

                    a3 = new ares(world,509,240);
                    layer.add(a3.layer());
                    counta = false;
                    stend3 = true;

                }


            }
        });



        btImage = assets().getImage("images/back.png");
        btLayer = graphics().createImageLayer(btImage);
        layer.add(btLayer);

        btLayer.setTranslation(10, 400);
        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {

                ss.remove(GameScreen.this);
            }
        });

        if(showDebugDraw){
            CanvasImage image = graphics().createImage(
                    (int) (width / GameScreen.M_PER_PIXEL),
                    (int) (height / GameScreen.M_PER_PIXEL));
            layer.add(graphics().createImageLayer(image));
            debugDraw = new DebugDrawBox2D();
            debugDraw.setCanvas(image);
            debugDraw.setFlipY(false);
            debugDraw.setStrokeAlpha(150);
            debugDraw.setFillAlpha(75);
            debugDraw.setStrokeWidth(2.0f);
            debugDraw.setFlags(DebugDraw.e_shapeBit |
                              DebugDraw.e_jointBit  |
                              DebugDraw.e_aabbBit);
            debugDraw.setCamera(0, 0, 1f / GameScreen.M_PER_PIXEL);
            world.setDebugDraw(debugDraw);
        }

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
        world.step(0.033f, 10, 10);
    }

    @Override
    public void paint(Clock clock) {
        super.paint(clock);
        z.paint(clock);
        z1.paint(clock);
        z2.paint(clock);
        z3.paint(clock);

        a.paint(clock);
        a1.paint(clock);
        a2.paint(clock);
        a3.paint(clock);

        if(showDebugDraw){
            debugDraw.getCanvas().clear();
            world.drawDebugData();
        }
    }
}
