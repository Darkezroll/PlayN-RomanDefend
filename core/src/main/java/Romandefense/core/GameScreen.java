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
    private Minutor m,m1,m2,m3,m4,m5,m6,m7,m8,m9;
    private Time t;
    public int dcheck = 0;


    private boolean countz,counta,stend,stend1,stend2,stend3,stend4,stend5,stend6 = false;


    public GameScreen(ScreenStack ss){
        this.ss = ss;
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

        t = new Time(160,120);
        layer.add(t.layer());

        m = new Minutor(world,0,0);
        m1 = new Minutor(world,0,0);
        m2 = new Minutor(world,0,0);
        m3 = new Minutor(world,0,0);
        m4 = new Minutor(world,0,0);
        m5 = new Minutor(world,0,0);
        m6 = new Minutor(world,0,0);
        m7 = new Minutor(world,0,0);
        m8 = new Minutor(world,0,0);
        m9 = new Minutor(world,0,0);

        layer.add(m.layer());
        layer.add(m1.layer());
        layer.add(m2.layer());
        layer.add(m3.layer());
        layer.add(m4.layer());
        layer.add(m5.layer());
        layer.add(m6.layer());
        layer.add(m7.layer());
        layer.add(m8.layer());
        layer.add(m9.layer());


        btImage = assets().getImage("images/dun1hid.png");
        btLayer = graphics().createImageLayer(btImage);
        layer.add(btLayer);

        btLayer.setTranslation(128, 0);

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

        if (t.time >= 0){

            m.update(delta);
        }

        if (t.time >= 1){

            m1.update(delta);
        }
        if (t.time >= 2){

            m2.update(delta);
        }
        if (t.time >= 3){

            m3.update(delta);
        }
        if (t.time >= 4){

            m4.update(delta);
        }
        if (t.time >= 5){

            m5.update(delta);
        }
        if (t.time >= 6){

            m6.update(delta);
        }
        if (t.time >= 7){

            m7.update(delta);
        }
        if (t.time >= 8){

            m8.update(delta);

        }
        if (t.time >= 9){

            t.layer().destroy();

            m9.update(delta);

            if (m9.gameend == true){

                ss.push(new Win(ss));
            }
        }

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

        tower1();
        tower2();
        tower3();
        tower4();
        tower5();
        tower6();
        tower7();

        System.out.println(dcheck);



    }

    @Override
    public void paint(Clock clock) {
        super.paint(clock);

        m.paint(clock);
        m1.paint(clock);
        m2.paint(clock);
        m3.paint(clock);
        m4.paint(clock);
        m5.paint(clock);
        m6.paint(clock);
        m7.paint(clock);
        m8.paint(clock);
        m9.paint(clock);

        //////////////////////////////////////////

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


        if(showDebugDraw){
            debugDraw.getCanvas().clear();
            world.drawDebugData();
        }
    }

    public void tower1(){

        /////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (z.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (z.atk > 4){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (a.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a.atk > 3){

            a.atk = 0;
        }

        //////////////////////////////////////////////////


    }

    public void tower2(){

        /////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z1.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z1.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z1.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z1.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z1.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z1.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z1.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z1.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z1.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (z1.atk > 4){

            z1.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a1.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a1.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a1.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a1.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a1.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a1.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a1.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a1.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a1.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (a1.atk > 3){

            a1.atk = 0;
        }

        //////////////////////////////////////////////////

    }

    public void tower3(){

        /////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z2.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z2.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z2.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z2.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z2.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z2.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z2.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z2.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z2.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z2.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (z2.atk > 4){

            z2.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a2.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a2.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a2.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a2.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a2.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a2.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a2.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a2.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a2.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a2.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (a2.atk > 3){

            a2.atk = 0;
        }

        //////////////////////////////////////////////////
    }

    public void tower4(){

        /////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z3.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z3.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z3.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z3.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z3.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z3.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z3.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (z3.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (z3.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (z3.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (z3.atk > 4){

            z3.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a3.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a3.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a3.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a3.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a3.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a3.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a3.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (a3.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (a3.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (a3.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (a3.atk > 3){

            a3.atk = 0;
        }

        //////////////////////////////////////////////////

    }

    public void tower5(){

        /////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z4.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z4.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z4.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z4.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z4.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z4.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (z4.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (z4.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (z4.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 18 && t.time < 20){

            if (z4.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (z4.atk > 4){

            z4.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a4.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a4.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a4.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a4.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a4.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (a4.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (a4.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (a4.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 18 && t.time < 20){

            if (a4.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (a4.atk > 3){

            a4.atk = 0;
        }

        //////////////////////////////////////////////////

    }

    public void tower6(){

        /////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z5.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z5.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z5.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z5.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z5.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (z5.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (z5.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (z5.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 18 && t.time < 20){

            if (z5.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 19 && t.time < 21){

            if (z5.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (z5.atk > 4){

            z5.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a5.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a5.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a5.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a5.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a5.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (a5.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (a5.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (a5.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 18 && t.time < 20){

            if (a5.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 19 && t.time < 21){

            if (a5.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (a5.atk > 3){

            a5.atk = 0;
        }

        //////////////////////////////////////////////////
    }

    public void tower7(){

        /////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z6.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z6.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z6.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z6.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (z6.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (z6.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (z6.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 18 && t.time < 20){

            if (z6.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 19 && t.time < 21){

            if (z6.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 20 && t.time < 22){

            if (z6.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (z6.atk > 4){

            z6.atk = 0;
        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a6.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a6.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a6.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a6.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (a6.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 16 && t.time < 18){

            if (a6.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 17 && t.time < 19){

            if (a6.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 18 && t.time < 20){

            if (a6.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 19 && t.time < 21){

            if (a6.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 20 && t.time < 22){

            if (a6.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (a6.atk > 3){

            a6.atk = 0;
        }

        //////////////////////////////////////////////////

    }
}
