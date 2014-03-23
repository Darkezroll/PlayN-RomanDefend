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
    private boolean showDebugDraw = true;
    private  ScreenStack ss;
    private Image bgImage,btImage;
    private Layer bgLayer,btLayer;

    private zeus z,z1,z2,z3,z4,z5,z6;
    private ares a,a1,a2,a3,a4,a5,a6;
    private Minutor m,m1,m2,m3,m4,m5,m6,m7,m8,m9;
    private Time t;
    public int dcheck = 0;

    private Sound soundj = assets().getSound("sounds/dun1");
    private Sound soundj1 = assets().getSound("sounds/minutor");

    private boolean countz,counta,stend,stend1,stend2,stend3,stend4,stend5,stend6 = false;

    private int time1,time2,time3,time4,time5,time6,time7,time8,time9,time10 = 0;
    private int t1,t2,t3,t4,t5,t6,t7,t8,t9,t10 = 0;
    private int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 = 0;
    private int u1,u2,u3,u4,u5,u6,u7,u8,u9,u10 = 0;
    private int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10 = 0;
    private int w1,w2,w3,w4,w5,w6,w7,w8,w9,w10 = 0;
    private int e1,e2,e3,e4,e5,e6,e7,e8,e9,e10 = 0;
    private boolean start = false;


    public GameScreen(ScreenStack ss){
        this.ss = ss;
    }

    //////////////////////////////////////////////////////////


    @Override
    public void wasAdded() {
        super.wasAdded();

        soundj.play();

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

                if (start == false || dcheck == 2 || dcheck == 4 || dcheck == 6 || dcheck == 8 || dcheck == 10){

                    countz = true;
                    start = true;

                }
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

                if (dcheck == 3 || dcheck == 6 || dcheck == 9){

                    counta = true;

                }
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
        soundj1.play();
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

                if (dcheck < 8){

                    ss.push(new Lose(ss));
                }

                if (dcheck == 8){

                    ss.push(new Win1(ss));
                }

                if (dcheck == 9){

                    ss.push(new Win2(ss));
                }

                if (dcheck == 10){

                    ss.push(new Win3(ss));
                }
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

        score();

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

        if (t.time > 0 && t.time < 2){

            if (z.atk == 4){

                m.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 2){

            time1 += 1;
        }

        if (z.atk > 4 || time1 == 1){

                z.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (z.atk == 4){

                m1.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 3){

            time2 += 1;
        }

        if (z.atk > 4 || time2 == 1){

            z.atk = 0;

        }


        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z.atk == 4){

                m2.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 4){

            time3 += 1;
        }

        if (z.atk > 4 || time3 == 1){

            z.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z.atk == 4){

                m3.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            time4 += 1;
        }

        if (z.atk > 4 || time4 == 1){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z.atk == 4){

                m4.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            time5 += 1;
        }

        if (z.atk > 4 || time5 == 1){

            z.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z.atk == 4){

                m5.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            time6 += 1;
        }

        if (z.atk > 4 || time6 == 1){

            z.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z.atk == 4){

                m6.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            time7 += 1;
        }

        if (z.atk > 4 || time7 == 1){

            z.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z.atk == 4){

                m7.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            time8 += 1;
        }

        if (z.atk > 4 || time8 == 1){

            z.atk = 0;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z.atk == 4){

                m8.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            time9 += 1;
        }

        if (z.atk > 4 || time9 == 1){

            z.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z.atk == 4){

                m9.layer().destroy();
                z.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            time10 += 1;
        }

        if (z.atk > 4 || time10 == 1){

            z.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 0 && t.time < 2){

            if (a.atk == 3){

                m.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 2){

            time1 += 1;
        }

        if (a.atk > 3 || time1 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (a.atk == 3){

                m1.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 3){

            time2 += 1;
        }

        if (a.atk > 3 || time2 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a.atk == 3){

                m2.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 4){

            time3 += 1;
        }

        if (a.atk > 3 || time3 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a.atk == 3){

                m3.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            time4 += 1;
        }

        if (a.atk > 3 || time4 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a.atk == 3){

                m4.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            time5 += 1;
        }

        if (a.atk > 3 || time5 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a.atk == 3){

                m5.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            time6 += 1;
        }

        if (a.atk > 3 || time6 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a.atk == 3){

                m6.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            time7 += 1;
        }

        if (a.atk > 3 || time7 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a.atk == 3){

                m7.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            time8 += 1;
        }

        if (a.atk > 3 || time8 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a.atk == 3){

                m8.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            time9 += 1;
        }

        if (a.atk > 3 || time9 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a.atk == 3){

                m9.layer().destroy();
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            time10 += 1;
        }

        if (a.atk > 3 || time10 == 1){

            a.atk = 0;

        }

        //////////////////////////////////////////////////


    }

    public void tower2(){

        /////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (z1.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 3){

            t1 += 1;
        }

        if (z1.atk > 4 || t1 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z1.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 4){

            t2 += 1;
        }

        if (z1.atk > 4 || t2 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z1.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            t3 += 1;
        }

        if (z1.atk > 4 || t3 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z1.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            t4 += 1;
        }

        if (z1.atk > 4 || t4 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z1.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            t5 += 1;
        }

        if (z1.atk > 4 || t5 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z1.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            t6 += 1;
        }

        if (z1.atk > 4 || t6 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z1.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            t7 += 1;
        }

        if (z1.atk > 4 || t7 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z1.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            t8 += 1;
        }

        if (z1.atk > 4 || t8 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z1.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            t9 += 1;
        }

        if (z1.atk > 4 || t9 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            t10 += 1;
        }

        if (z1.atk > 4 || t10 == 1){

            z1.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (a1.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 3){

            t1 += 1;
        }

        if (a1.atk > 3 || t1 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a1.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 4){

            t2 += 1;
        }

        if (a1.atk > 3 || t2 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a1.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            t3 += 1;
        }

        if (a1.atk > 3 || t3 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a1.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            t4 += 1;
        }

        if (a1.atk > 3 || t4 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            t5 += 1;
        }

        if (a1.atk > 3 || t5 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a1.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            t6 += 1;
        }

        if (a1.atk > 3 || t6 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a1.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            t7 += 1;
        }

        if (a1.atk > 3 || t7 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a1.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            t8 += 1;
        }

        if (a1.atk > 3 || t8 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a1.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            t9 += 1;
        }

        if (a1.atk > 3 || t9 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a1.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a1.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            t10 += 1;
        }

        if (a1.atk > 3 || t10 == 1){

            a1.atk = 0;

        }

        //////////////////////////////////////////////////

    }

    public void tower3(){

        /////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z2.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 4){

            y1 += 1;
        }

        if (z2.atk > 4 || y1 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z2.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            y2 += 1;
        }

        if (z2.atk > 4 || y2 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z2.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            y3 += 1;
        }

        if (z2.atk > 4 || y3 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z2.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            y4 += 1;
        }

        if (z2.atk > 4 || y4 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z2.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            y5 += 1;
        }

        if (z2.atk > 4 || y5 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z2.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            y6 += 1;
        }

        if (z2.atk > 4 || y6 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z2.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            y7 += 1;
        }

        if (z2.atk > 4 || y7 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z2.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            y8 += 1;
        }

        if (z2.atk > 4 || y8 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z2.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            y9 += 1;
        }

        if (z2.atk > 4 || y9 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z2.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            y10 += 1;
        }

        if (z2.atk > 4 || y10 == 1){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a2.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 4){

            y1 += 1;
        }

        if (a2.atk > 3 || y1 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a2.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            y2 += 1;
        }

        if (a2.atk > 3 || y2 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a2.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            y3 += 1;
        }

        if (a2.atk > 3 || y3 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a2.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            y4 += 1;
        }

        if (a2.atk > 3 || y4 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a2.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            y5 += 1;
        }

        if (a2.atk > 3 || y5 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a2.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            y6 += 1;
        }

        if (a2.atk > 3 || y6 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a2.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            y7 += 1;
        }

        if (a2.atk > 3 || y7 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a2.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            y8 += 1;
        }

        if (a2.atk > 3 || y8 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a2.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            y9 += 1;
        }

        if (a2.atk > 3 || y9 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a2.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a2.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            y10 += 1;
        }

        if (a2.atk > 3 || y10 == 1){

            a2.atk = 0;

        }

        //////////////////////////////////////////////////
    }

    public void tower4(){

        /////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z3.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            u1 += 1;
        }

        if (z3.atk > 4 || u1 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z3.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            u2 += 1;
        }

        if (z3.atk > 4 || u2 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z3.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            u3 += 1;
        }

        if (z3.atk > 4 || u3 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z3.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            u4 += 1;
        }

        if (z3.atk > 4 || u4 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z3.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            u5 += 1;
        }

        if (z3.atk > 4 || u5 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z3.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            u6 += 1;
        }

        if (z3.atk > 4 || u6 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z3.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            u7 += 1;
        }

        if (z3.atk > 4 || u7 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z3.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            u8 += 1;
        }

        if (z3.atk > 4 || u8 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z3.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            u9 += 1;
        }

        if (z3.atk > 4 || u9 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z3.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            u10 += 1;
        }

        if (z3.atk > 4 || u10 == 1){

            z3.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a3.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 5){

            u1 += 1;
        }

        if (a3.atk > 3 || u1 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a3.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            u2 += 1;
        }

        if (a3.atk > 3 || u2 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a3.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            u3 += 1;
        }

        if (a3.atk > 3 || u3 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a3.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            u4 += 1;
        }

        if (a3.atk > 3 || u4 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a3.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            u5 += 1;
        }

        if (a3.atk > 3 || u5 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a3.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            u6 += 1;
        }

        if (a3.atk > 3 || u6 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a3.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            u7 += 1;
        }

        if (a3.atk > 3 || u7 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a3.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            u8 += 1;
        }

        if (a3.atk > 3 || u8 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a3.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            u9 += 1;
        }

        if (a3.atk > 3 || u9 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a3.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a3.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            u10 += 1;
        }

        if (a3.atk > 3 || u10 == 1){

            a3.atk = 0;

        }

        //////////////////////////////////////////////////

    }

    public void tower5(){

        /////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z4.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            q1 += 1;
        }

        if (z4.atk > 4 || q1 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z4.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            q2 += 1;
        }

        if (z4.atk > 4 || q2 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z4.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            q3 += 1;
        }

        if (z4.atk > 4 || q3 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z4.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            q4 += 1;
        }

        if (z4.atk > 4 || q4 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z4.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            q5 += 1;
        }

        if (z4.atk > 4 || q5 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z4.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            q6 += 1;
        }

        if (z4.atk > 4 || q6 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z4.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            q7 += 1;
        }

        if (z4.atk > 4 || q7 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z4.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            q8 += 1;
        }

        if (z4.atk > 4 || q8 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z4.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            q9 += 1;
        }

        if (z4.atk > 4 || q9 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z4.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 15){

            q10 += 1;
        }

        if (z4.atk > 4 || q10 == 1){

            z4.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a4.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 6){

            q1 += 1;
        }

        if (a4.atk > 3 || q1 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a4.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            q2 += 1;
        }

        if (a4.atk > 3 || q2 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a4.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            q3 += 1;
        }

        if (a4.atk > 3 || q3 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a4.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            q4 += 1;
        }

        if (a4.atk > 3 || q4 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a4.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            q5 += 1;
        }

        if (a4.atk > 3 || q5 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            q6 += 1;
        }

        if (a4.atk > 3 || q6 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a4.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            q7 += 1;
        }

        if (a4.atk > 3 || q7 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a4.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            q8 += 1;
        }

        if (a4.atk > 3 || q8 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a4.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            q9 += 1;
        }

        if (a4.atk > 3 || q9 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a4.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a4.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 15){

            q10 += 1;
        }

        if (a4.atk > 3 || q10 == 1){

            a4.atk = 0;

        }

        //////////////////////////////////////////////////

    }

    public void tower6(){

        /////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z5.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            w1 += 1;
        }

        if (z5.atk > 4 || w1 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z5.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            w2 += 1;
        }

        if (z5.atk > 4 || w2 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z5.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            w3 += 1;
        }

        if (z5.atk > 4 || w3 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z5.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            w4 += 1;
        }

        if (z5.atk > 4 || w4 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z5.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            w5 += 1;
        }

        if (z5.atk > 4 || w5 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z5.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            w6 += 1;
        }

        if (z5.atk > 4 || w6 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z5.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            w7 += 1;
        }

        if (z5.atk > 4 || w7 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z5.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            w8 += 1;
        }

        if (z5.atk > 4 || w8 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z5.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 15){

            w9 += 1;
        }

        if (z5.atk > 4 || w9 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z5.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 16){

            w10 += 1;
        }

        if (z5.atk > 4 || w10 == 1){

            z5.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a5.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 7){

            w1 += 1;
        }

        if (a5.atk > 3 || w1 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a5.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            w2 += 1;
        }

        if (a5.atk > 3 || w2 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a5.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            w3 += 1;
        }

        if (a5.atk > 3 || w3 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a5.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            w4 += 1;
        }

        if (a5.atk > 3 || w4 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a5.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            w5 += 1;
        }

        if (a5.atk > 3 || w5 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a5.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            w6 += 1;
        }

        if (a5.atk > 3 || w6 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a5.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            w7 += 1;
        }

        if (a5.atk > 3 || w7 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a5.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            w8 += 1;
        }

        if (a5.atk > 3 || w8 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a5.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 15){

            w9 += 1;
        }

        if (a5.atk > 3 || w9 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a5.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a5.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 16){

            w10 += 1;
        }

        if (a5.atk > 4 || w10 == 1){

            a5.atk = 0;

        }

        //////////////////////////////////////////////////
    }

    public void tower7(){

        /////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z6.atk == 4){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            e1 += 1;
        }

        if (z6.atk > 4 || e1 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z6.atk == 4){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            e2 += 1;
        }

        if (z6.atk > 4 || e2 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z6.atk == 4){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            e3 += 1;
        }

        if (z6.atk > 4 || e3 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z6.atk == 4){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            e4 += 1;
        }

        if (z6.atk > 4 || e4 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z6.atk == 4){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            e5 += 1;
        }

        if (z6.atk > 4 || e5 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z6.atk == 4){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            e6 += 1;
        }

        if (z6.atk > 4 || e6 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z6.atk == 4){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            e7 += 1;
        }

        if (z6.atk > 4 || e7 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z6.atk == 4){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 15){

            e8 += 1;
        }

        if (z6.atk > 4 || e8 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z6.atk == 4){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 16){

            e9 += 1;
        }

        if (z6.atk > 4 || e9 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (z6.atk == 4){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                z6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 17){

            e10 += 1;
        }

        if (z6.atk > 4 || e10 == 1){

            z6.atk = 0;

        }

        //////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a6.atk == 3){

                m.layer().destroy();
                m.body().getWorld().destroyBody(m.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 8){

            e1 += 1;
        }

        if (a6.atk > 3 || e1 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a6.atk == 3){

                m1.layer().destroy();
                m1.body().getWorld().destroyBody(m1.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 9){

            e2 += 1;
        }

        if (a6.atk > 3 || e2 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a6.atk == 3){

                m2.layer().destroy();
                m2.body().getWorld().destroyBody(m2.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 10){

            e3 += 1;
        }

        if (a6.atk > 3 || e3 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a6.atk == 3){

                m3.layer().destroy();
                m3.body().getWorld().destroyBody(m3.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 11){

            e4 += 1;
        }

        if (a6.atk > 3 || e4 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a6.atk == 3){

                m4.layer().destroy();
                m4.body().getWorld().destroyBody(m4.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 12){

            e5 += 1;
        }

        if (a6.atk > 3 || e5 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 13){

            if (a6.atk == 3){

                m5.layer().destroy();
                m5.body().getWorld().destroyBody(m5.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 13){

            e6 += 1;
        }

        if (a6.atk > 3 || e6 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a6.atk == 3){

                m6.layer().destroy();
                m6.body().getWorld().destroyBody(m6.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 14){

            e7 += 1;
        }

        if (a6.atk > 3 || e7 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a6.atk == 3){

                m7.layer().destroy();
                m7.body().getWorld().destroyBody(m7.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 15){

            e8 += 1;
        }

        if (a6.atk > 3 || e8 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a6.atk == 3){

                m8.layer().destroy();
                m8.body().getWorld().destroyBody(m8.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 16){

            e9 += 1;
        }

        if (a6.atk > 3 || e9 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (a6.atk == 3){

                m9.layer().destroy();
                m9.body().getWorld().destroyBody(m9.body());
                a6.atk = 0;
                dcheck += 1;
            }
        }

        if (t.time == 17){

            e10 += 1;
        }

        if (a6.atk > 3 || e10 == 1){

            a6.atk = 0;

        }

        //////////////////////////////////////////////////

    }

    public void score(){

        if (dcheck == 0){

            btImage = assets().getImage("images/score0.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 1){

            btImage = assets().getImage("images/score1.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 2){

            btImage = assets().getImage("images/score2.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 3){

            btImage = assets().getImage("images/score3.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 4){

            btImage = assets().getImage("images/score4.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 5){

            btImage = assets().getImage("images/score5.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 6){

            btImage = assets().getImage("images/score6.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 7){

            btImage = assets().getImage("images/score7.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 8){

            btImage = assets().getImage("images/score8.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 9){

            btImage = assets().getImage("images/score9.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

        if (dcheck == 10){

            btImage = assets().getImage("images/score10.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(510,16);
            layer.add(btLayer);

        }

    }
}
