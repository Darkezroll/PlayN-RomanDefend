package Romandefense.core;

import Sprite.Minutor;
import Sprite.Time;
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
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;


public class GameScreen extends UIScreen {


    public static float M_PER_PIXEL = 1 / 26.666667f;

    private static int width  = 24;
    private static int height = 18;


    private World world;
    private DebugDrawBox2D debugDraw;
    private boolean showDebugDraw = false;
    private  ScreenStack ss;
    private Image bgImage,btImage;
    private Layer bgLayer,btLayer;

    private zeus z,z1,z2,z3,z4,z5,z6;
    private ares a,a1,a2,a3,a4,a5,a6;
    private Minutor m;
    private Time t;


    private boolean countz,counta,stend,stend1,stend2,stend3,stend4,stend5,stend6 = false;

    private float x = 50 ;
    private float y = 195;
    private Minutor m1;
    private Minutor m2;
    private int i;


    public GameScreen(ScreenStack ss){
        this.ss = ss;
    }

    //////////////////////////////////////////////////////////

    @Override
    public void wasShown() {
        super.wasShown();

        t = new Time(160,120);
        layer.add(t.layer());

        m = new Minutor(world,x,y);
        layer.add(m.layer());






    }

    //////////////////////////////////////////////////////////

    @Override
    public void wasAdded() {
        super.wasAdded();

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
        btLayer.setTranslation(85,267);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){

            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend == false){

                    z = new zeus(world,88,257);
                    layer.add(z.layer());
                    countz = false;
                    stend = true;

                }

                if (counta == true && stend == false){

                    a = new ares(world,98,257);
                    layer.add(a.layer());
                    counta = false;
                    stend = true;

                }
            }


        });

        //////////////////////////////////////////////////////////


        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(187,327);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend1 == false){
                    z1 = new zeus(world,190,317);
                    layer.add(z1.layer());
                    countz = false;
                    stend1 = true;
                }
                if (counta == true && stend1 == false){

                    a1 = new ares(world,200,317);
                    layer.add(a1.layer());
                    counta = false;
                    stend1 = true;

                }


            }
        });

        /////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(348,315);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend2 == false){
                    z2 = new zeus(world,351,305);
                    layer.add(z2.layer());
                    countz = false;
                    stend2 = true;
                }

                if (counta == true && stend2 == false){

                    a2 = new ares(world,361,305);
                    layer.add(a2.layer());
                    counta = false;
                    stend2 = true;

                }


            }
        });


        //////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(455,207);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){

            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend3 == false){
                    z3 = new zeus(world,458,197);
                    layer.add(z3.layer());
                    countz = false;
                    stend3 = true;
                }

                if (counta == true && stend3 == false){

                    a3 = new ares(world,468,197);
                    layer.add(a3.layer());
                    counta = false;
                    stend3 = true;

                }

            }
        });


        //////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(455,284);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){

            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend4 == false){
                    z4 = new zeus(world,458,278);
                    layer.add(z4.layer());
                    countz = false;
                    stend4 = true;
                }

                if (counta == true && stend4 == false){

                    a4 = new ares(world,468,278);
                    layer.add(a4.layer());
                    counta = false;
                    stend4 = true;

                }

            }
        });

        //////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(570,265);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){

            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend5 == false){
                    z5 = new zeus(world,573,255);
                    layer.add(z5.layer());
                    countz = false;
                    stend5 = true;
                }

                if (counta == true && stend5 == false){

                    a5 = new ares(world,583,255);
                    layer.add(a5.layer());
                    counta = false;
                    stend5 = true;

                }

            }
        });


        //////////////////////////////////////////////////////////

        btImage = assets().getImage("images/stand.png");
        btLayer = graphics().createImageLayer(btImage);
        btLayer.setTranslation(570,350);
        layer.add(btLayer);
        btLayer.addListener(new Pointer.Adapter(){

            @Override
            public void onPointerEnd(Pointer.Event event) {
                super.onPointerEnd(event);

                if (countz == true && stend6 == false){
                    z6 = new zeus(world,573,340);
                    layer.add(z6.layer());
                    countz = false;
                    stend6 = true;
                }

                if (counta == true && stend6 == false){

                    a6 = new ares(world,583,340);
                    layer.add(a6.layer());
                    counta = false;
                    stend6 = true;

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

        createworld();

    }

    private void createworld() {

        new zeus(world,0,0);
        z = new zeus(world,0,0);
        z1 = new zeus(world,0,0);
        z2 = new zeus(world,0,0);
        z3 = new zeus(world,0,0);
        z4 = new zeus(world,0,0);
        z5 = new zeus(world,0,0);
        z6 = new zeus(world,0,0);

        ////////////////////////////////////////////

        a = new ares(world,0,0);
        a1 = new ares(world,0,0);
        a2 = new ares(world,0,0);
        a3 = new ares(world,0,0);
        a4 = new ares(world,0,0);
        a5 = new ares(world,0,0);
        a6 = new ares(world,0,0);

        ///////////////////////////////////////////

        m = new Minutor(world,0,0);

        //////////////////////////////////////////


        Vec2 gravity = new Vec2(0.0f,0.0f);
        world = new World(gravity,true);
        world.setWarmStarting(true);
        world.setAutoClearForces(true);

        //////////////////////////////////////////

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

        world.step(0.033f, 10, 10);

        z.update(delta);
        z1.update(delta);
        z2.update(delta);
        z3.update(delta);
        z4.update(delta);
        z5.update(delta);
        z6.update(delta);

        ///////////////////////////////////

        a.update(delta);
        a1.update(delta);
        a2.update(delta);
        a3.update(delta);
        a4.update(delta);
        a5.update(delta);
        a6.update(delta);

        /////////////////////////////////


        t.update(delta);

        m.update(delta);


    }

    @Override
    public void paint(Clock clock) {
        super.paint(clock);

        z.paint(clock);
        z1.paint(clock);
        z2.paint(clock);
        z3.paint(clock);
        z4.paint(clock);
        z5.paint(clock);
        z6.paint(clock);

        /////////////////////////////////////////

        a.paint(clock);
        a1.paint(clock);
        a2.paint(clock);
        a3.paint(clock);
        a4.paint(clock);
        a5.paint(clock);
        a6.paint(clock);

        ///////////////////////////////////////////

        m.paint(clock);


        if(showDebugDraw){
            debugDraw.getCanvas().clear();
            world.drawDebugData();
        }
    }
}
