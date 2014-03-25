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
import tripleplay.game.Screen;
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

    private Sound soundj = assets().getSound("sounds/dun1");
    private Sound soundj1 = assets().getSound("sounds/minutor");
    private Sound soundj2 = assets().getSound("sounds/dead");

    private boolean countz,counta,stend,stend1,stend2,stend3,stend4,stend5,stend6 = false;
    private boolean moneycheck1,moneycheck2,moneycheck3,moneycheck4,moneycheck5,
                    moneycheck6,moneycheck7,moneycheck8,moneycheck9,moneycheck10 = false;

    private int time1,time2,time3,time4,time5,time6,time7,time8,time9,time10 = 0;
    private int t1,t2,t3,t4,t5,t6,t7,t8,t9,t10 = 0;
    private int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10 = 0;
    private int u1,u2,u3,u4,u5,u6,u7,u8,u9,u10 = 0;
    private int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10 = 0;
    private int w1,w2,w3,w4,w5,w6,w7,w8,w9,w10 = 0;
    private int e1,e2,e3,e4,e5,e6,e7,e8,e9,e10 = 0;
    private boolean start = false;
    private int money = 0;



    public GameScreen(ScreenStack ss){
        this.ss = ss;
    }

    //////////////////////////////////////////////////////////


    @Override
    public void wasAdded() {
        super.wasAdded();

        soundj.play();
        soundj.setLooping(true);

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

                if (start == false || money >=100){

                    countz = true;
                    start = true;
                    money -= 100;

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

                if (money >= 150){

                    counta = true;
                    money -= 150;

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

                soundj.stop();
                soundj1.stop();
                Screen start = new StartScreen(ss);
                ss.push(start);
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
                    soundj.stop();
                }

                if (dcheck == 8){

                    ss.push(new Win1(ss));
                    soundj.stop();
                }

                if (dcheck == 9){

                    ss.push(new Win2(ss));
                    soundj.stop();
                }

                if (dcheck == 10){

                    ss.push(new Win3(ss));
                    soundj.stop();
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
        money();
        checkmoney();

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

    ///////////////////////////////////////////

    public void tower1(){

        /////////////////////////////////////////////////

        if (t.time > 0 && t.time < 2){

            if (z.atk == 6){

                soundj2.play();
                m.layer().destroy();
                z.atk = 0;

                if (time1 == 0){

                    dcheck += 1;
                    time1 += 1;
                }
            }
        }

        if (t.time == 2){

            time1 += 1;
        }

        if (z.atk > 6 || time1 == 2 || time1 == 1){

            z.atk = 0;
            time1 +=2;

        }

        //////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (z.atk == 6){

                soundj2.play();
                m1.layer().destroy();
                z.atk = 0;

                if (time2 == 0){

                    dcheck += 1;
                    time2 +=1;

                }
            }
        }

        if (t.time == 3){

            time2 += 1;
        }

        if (z.atk > 6 || time2 == 2 || time2 == 1){

            z.atk = 0;
            time2 += 2;

        }


        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z.atk == 6){

                soundj2.play();
                m2.layer().destroy();
                z.atk = 0;

                if (time3 == 0){

                    dcheck += 1;
                    time3 +=1;
                }
            }
        }

        if (t.time == 4){

            time3 += 1;
        }

        if (z.atk > 6 || time3 == 2 || time3 == 1){

            z.atk = 0;
            time3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z.atk == 6){

                soundj2.play();
                m3.layer().destroy();
                z.atk = 0;

                if (time4 == 0){

                    dcheck += 1;
                    time4 +=1;
                }
            }
        }

        if (t.time == 5){

            time4 += 1;
        }

        if (z.atk > 6 || time4 == 2 || time4 == 1){

            z.atk = 0;
            time4 += 2;
        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z.atk == 6){

                soundj2.play();
                m4.layer().destroy();
                z.atk = 0;

                if (time5 == 0){

                    dcheck += 1;
                    time5 +=1;
                }
            }
        }

        if (t.time == 6){

            time5 += 1;
        }

        if (z.atk > 6 || time5 == 2 || time5 == 1){

            z.atk = 0;
            time5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z.atk == 6){

                soundj2.play();
                m5.layer().destroy();
                z.atk = 0;

                if (time6 == 0){

                    dcheck += 1;
                    time6 +=1;
                }
            }
        }

        if (t.time == 7){

            time6 += 1;
        }

        if (z.atk > 6 || time6 == 2 || time6 == 1){

            z.atk = 0;
            time6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z.atk == 6){

                soundj2.play();
                m6.layer().destroy();
                z.atk = 0;

                if (time7 == 0){

                    dcheck += 1;
                    time7 +=1;
                }
            }
        }

        if (t.time == 8){

            time7 += 1;
        }

        if (z.atk > 6 || time7 == 2 || time7 == 1){

            z.atk = 0;
            time7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z.atk == 6){

                soundj2.play();
                m7.layer().destroy();
                z.atk = 0;

                if (time8 == 0){

                    dcheck += 1;
                    time8 +=1;
                }
            }
        }

        if (t.time == 9){

            time8 += 1;
        }

        if (z.atk > 6 || time8 == 2 || time8 == 1){

            z.atk = 0;
            time8 += 2;
        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z.atk == 6){

                soundj2.play();
                m8.layer().destroy();
                z.atk = 0;

                if (time9 == 0){

                    dcheck += 1;
                    time9 +=1;
                }
            }
        }

        if (t.time == 10){

            time9 += 1;
        }

        if (z.atk > 6 || time9 == 2 || time9 == 1){

            z.atk = 0;
            time9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z.atk == 6){

                soundj2.play();
                m9.layer().destroy();
                z.atk = 0;

                if (time10 == 0){

                    dcheck += 1;
                    time10 +=1;
                }
            }
        }

        if (t.time == 11){

            time10 += 1;
        }

        if (z.atk > 6 || time10 == 2 || time10 == 1){

            z.atk = 0;
            time10 += 2;

        }

        ////////////////////////////////////////////////////////////////////////////////////////////


        if (t.time > 0 && t.time < 2){

            if (a.atk == 5){

                soundj2.play();
                m.layer().destroy();
                a.atk = 0;

                if (time1 == 0){

                    dcheck += 1;
                    time1 += 1;
                }
            }
        }

        if (t.time == 2){

            time1 += 1;
        }

        if (a.atk > 5 || time1 == 2 || time1 == 1){

            a.atk = 0;
            time1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (a.atk == 5){

                soundj2.play();
                m1.layer().destroy();
                a.atk = 0;

                if (time2 == 0){

                    dcheck += 1;
                    time2 += 1;
                }
            }
        }

        if (t.time == 3){

            time2 += 1;
        }

        if (a.atk > 5 || time2 == 2 || time2 == 1){

            a.atk = 0;
            time2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a.atk == 5){

                soundj2.play();
                m2.layer().destroy();
                a.atk = 0;

                if (time3 == 0){

                    dcheck += 1;
                    time3 += 1;
                }
            }
        }

        if (t.time == 4){

            time3 += 1;
        }

        if (a.atk > 5 || time3 == 2 || time3 == 1){

            a.atk = 0;
            time3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a.atk == 5){

                soundj2.play();
                m3.layer().destroy();
                a.atk = 0;

                if (time4 == 0){

                    dcheck += 1;
                    time4 += 1;
                }
            }
        }

        if (t.time == 5){

            time4 += 1;
        }

        if (a.atk > 5 || time4 == 2 || time4 == 1){

            a.atk = 0;
            time4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a.atk == 5){

                soundj2.play();
                m4.layer().destroy();
                a.atk = 0;

                if (time5 == 0){

                    dcheck += 1;
                    time5 += 1;
                }
            }
        }

        if (t.time == 6){

            time5 += 1;
        }

        if (a.atk > 5 || time5 == 2 || time5 == 1){

            a.atk = 0;
            time5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a.atk == 5){

                soundj2.play();
                m5.layer().destroy();
                a.atk = 0;

                if (time6 == 0){

                    dcheck += 1;
                    time6 += 1;
                }
            }
        }

        if (t.time == 7){

            time6 += 1;
        }

        if (a.atk > 5 || time6 == 2 || time6 == 1){

            a.atk = 0;
            time6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a.atk == 5){

                soundj2.play();
                m6.layer().destroy();
                a.atk = 0;

                if (time7 == 0){

                    dcheck += 1;
                    time7 += 1;
                }
            }
        }

        if (t.time == 8){

            time7 += 1;
        }

        if (a.atk > 5 || time7 == 2 || time7 == 1){

            a.atk = 0;
            time7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a.atk == 5){

                soundj2.play();
                m7.layer().destroy();
                a.atk = 0;

                if (time8 == 0){

                    dcheck += 1;
                    time8 += 1;
                }
            }
        }

        if (t.time == 9){

            time8 += 1;
        }

        if (a.atk > 5 || time8 == 2 || time8 == 1){

            a.atk = 0;
            time8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a.atk == 5){

                soundj2.play();
                m8.layer().destroy();
                a.atk = 0;

                if (time9 == 0){

                    dcheck += 1;
                    time9 += 1;
                }
            }
        }

        if (t.time == 10){

            time9 += 1;
        }

        if (a.atk > 5 || time9 == 2 || time9 == 1){

            a.atk = 0;
            time9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a.atk == 5){

                soundj2.play();
                m9.layer().destroy();
                a.atk = 0;

                if (time10 == 0){

                    dcheck += 1;
                    time10 += 1;
                }
            }
        }

        if (t.time == 11){

            time10 += 1;
        }

        if (a.atk > 5 || time10 == 2 || time10 == 1){

            a.atk = 0;
            time10 += 2;

        }
    }

    public void tower2(){


        if (t.time > 1 && t.time < 3){

            if (z1.atk == 6){

                soundj2.play();
                m.layer().destroy();
                z1.atk = 0;

                if (t1 == 0){

                    dcheck += 1;
                    t1 += 1;
                }
            }
        }

        if (t.time == 3){

            t1 += 1;
        }

        if (z1.atk > 6 || t1 == 2 || t1 == 1){

            z1.atk = 0;
            t1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z1.atk == 6){

                soundj2.play();
                m1.layer().destroy();
                z1.atk = 0;

                if (t2 == 0){

                    dcheck += 1;
                    t2 += 1;
                }
            }
        }

        if (t.time == 4){

            t2 += 1;
        }

        if (z1.atk > 6 || t2 == 2 || t2 == 1){

            z1.atk = 0;
            t2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z1.atk == 6){

                soundj2.play();
                m2.layer().destroy();
                z1.atk = 0;

                if (t3 == 0){

                    dcheck += 1;
                    t3 += 1;
                }
            }
        }

        if (t.time == 5){

            t3 += 1;
        }

        if (z1.atk > 6 || t3 == 2 || t3 == 1){

            z1.atk = 0;
            t3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z1.atk == 6){

                soundj2.play();
                m3.layer().destroy();
                z1.atk = 0;

                if (t4 == 0){

                    dcheck += 1;
                    t4 += 1;
                }
            }
        }

        if (t.time == 6){

            t4 += 1;
        }

        if (z1.atk > 6 || t4 == 2 || t4 == 1){

            z1.atk = 0;
            t4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z1.atk == 6){

                soundj2.play();
                m4.layer().destroy();
                z1.atk = 0;

                if (t5 == 0){

                    dcheck += 1;
                    t5 += 1;
                }
            }
        }

        if (t.time == 7){

            t5 += 1;
        }

        if (z1.atk > 6 || t5 == 2 || t5 == 1){

            z1.atk = 0;
            t5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z1.atk == 6){

                soundj2.play();
                m5.layer().destroy();
                z1.atk = 0;

                if (t6 == 0){

                    dcheck += 1;
                    t6 += 1;
                }
            }
        }

        if (t.time == 8){

            t6 += 1;
        }

        if (z1.atk > 6 || t6 == 2 || t6 == 1){

            z1.atk = 0;
            t6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z1.atk == 6){

                soundj2.play();
                m6.layer().destroy();
                z1.atk = 0;

                if (t7 == 0){

                    dcheck += 1;
                    t7 += 1;
                }
            }
        }

        if (t.time == 9){

            t7 += 1;
        }

        if (z1.atk > 6 || t7 == 2 || t7 == 1){

            z1.atk = 0;
            t7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z1.atk == 6){

                soundj2.play();
                m7.layer().destroy();
                z1.atk = 0;

                if (t8 == 0){

                    dcheck += 1;
                    t8 += 1;
                }
            }
        }

        if (t.time == 10){

            t8 += 1;
        }

        if (z1.atk > 6 || t8 == 2 || t8 == 1){

            z1.atk = 0;
            t8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z1.atk == 6){

                soundj2.play();
                m8.layer().destroy();
                z1.atk = 0;

                if (t9 == 0){

                    dcheck += 1;
                    t9 += 1;
                }
            }
        }

        if (t.time == 11){

            t9 += 1;
        }

        if (z1.atk > 6 || t9 == 2 || t9 == 1){

            z1.atk = 0;
            t9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z.atk == 6){

                soundj2.play();
                m9.layer().destroy();
                z1.atk = 0;

                if (t10 == 0){

                    dcheck += 1;
                    t10 += 1;
                }
            }
        }

        if (t.time == 12){

            t10 += 1;
        }

        if (z1.atk > 6 || t10 == 2 || t10 == 1){

            z1.atk = 0;
            t10 +=2;

        }

        ////////////////////////////////////////////////////////////////////////////////////////////////

        if (t.time > 1 && t.time < 3){

            if (a1.atk == 5){

                soundj2.play();
                m.layer().destroy();
                a1.atk = 0;

                if (t1 == 0){

                    dcheck += 1;
                    t1 += 1;
                }
            }
        }

        if (t.time == 3){

            t1 += 1;
        }

        if (a1.atk > 5 || t1 == 2 || t1 == 1){

            a1.atk = 0;
            t1 += 1;

        }

        //////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a1.atk == 5){

                soundj2.play();
                m1.layer().destroy();
                a1.atk = 0;

                if (t2 == 0){

                    dcheck += 1;
                    t2 += 1;
                }
            }
        }

        if (t.time == 4){

            t2 += 1;
        }

        if (a1.atk > 5 || t2 == 2 || t2 == 1){

            a1.atk = 0;
            t2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a1.atk == 5){

                soundj2.play();
                m2.layer().destroy();
                a1.atk = 0;

                if (t3 == 0){

                    dcheck += 1;
                    t3 += 1;
                }
            }
        }

        if (t.time == 5){

            t3 += 1;
        }

        if (a1.atk > 5 || t3 == 2 || t3 == 1){

            a1.atk = 0;
            t3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a1.atk == 5){

                soundj2.play();
                m3.layer().destroy();
                a1.atk = 0;

                if (t4 == 0){

                    dcheck += 1;
                    t4 += 1;
                }
            }
        }

        if (t.time == 6){

            t4 += 1;
        }

        if (a1.atk > 5 || t4 == 2 || t4 == 1){

            a1.atk = 0;
            t4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a.atk == 5){

                soundj2.play();
                m4.layer().destroy();
                a1.atk = 0;

                if (t5 == 0){

                    dcheck += 1;
                    t5 += 1;
                }
            }
        }

        if (t.time == 7){

            t5 += 1;
        }

        if (a1.atk > 5 || t5 == 2 || t5 == 1){

            a1.atk = 0;
            t5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a1.atk == 5){

                soundj2.play();
                m5.layer().destroy();
                a1.atk = 0;

                if (t6 == 0){

                    dcheck += 1;
                    t6 += 1;
                }
            }
        }

        if (t.time == 8){

            t6 += 1;
        }

        if (a1.atk > 5 || t6 == 2 || t6 == 1){

            a1.atk = 0;
            t6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a1.atk == 5){

                soundj2.play();
                m6.layer().destroy();
                a1.atk = 0;

                if (t7 == 0){

                    dcheck += 1;
                    t7 += 1;
                }
            }
        }

        if (t.time == 9){

            t7 += 1;
        }

        if (a1.atk > 5 || t7 == 2 || t7 == 1){

            a1.atk = 0;
            t7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a1.atk == 5){

                soundj2.play();
                m7.layer().destroy();
                a1.atk = 0;

                if (t8 == 0){

                    dcheck += 1;
                    t8 += 1;
                }
            }
        }

        if (t.time == 10){

            t8 += 1;
        }

        if (a1.atk > 5 || t8 == 2 || t8 == 1){

            a1.atk = 0;
            t8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a1.atk == 5){

                soundj2.play();
                m8.layer().destroy();
                a1.atk = 0;

                if (t9 == 0){

                    dcheck += 1;
                    t9 += 1;
                }
            }
        }

        if (t.time == 11){

            t9 += 1;
        }

        if (a1.atk > 5 || t9 == 2 || t9 == 1){

            a1.atk = 0;
            t9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a1.atk == 5){

                soundj2.play();
                m9.layer().destroy();
                a1.atk = 0;

                if (t10 == 0){

                    dcheck += 1;
                    t10 += 1;
                }
            }
        }

        if (t.time == 12){

            t10 += 1;
        }

        if (a1.atk > 5 || t10 == 2 || t10 == 1){

            a1.atk = 0;
            t10 += 2;

        }
    }

    public void tower3(){

        /////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (z2.atk == 6){

                m.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y1 == 0){

                    dcheck += 1;
                    y1 += 1;
                }
            }
        }

        if (t.time == 4){

            y1 += 1;
        }

        if (z2.atk > 6 || y1 == 2 || y1 == 1){

            z2.atk = 0;
            y1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 6){

            if (z2.atk == 4){

                m1.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y2 == 0){

                    dcheck += 1;
                    y2 += 1;
                }
            }
        }

        if (t.time == 5){

            y2 += 1;
        }

        if (z2.atk > 6 || y2 == 2 || y2 == 1){

            z2.atk = 0;
            y2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z2.atk == 6){

                m2.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y3 == 0){

                    dcheck += 1;
                    y3 += 1;
                }
            }
        }

        if (t.time == 6){

            y3 += 1;
        }

        if (z2.atk > 6 || y3 == 2 || y3 == 1){

            z2.atk = 0;
            y3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z2.atk == 6){

                m3.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y4 == 0){

                    dcheck += 1;
                    y4 += 1;
                }
            }
        }

        if (t.time == 7){

            y4 += 1;
        }

        if (z2.atk > 6 || y4 == 2 || y4 == 1){

            z2.atk = 0;
            y4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z2.atk == 6){

                m4.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y5 == 0){

                    dcheck += 1;
                    y5 += 1;
                }
            }
        }

        if (t.time == 8){

            y5 += 1;
        }

        if (z2.atk > 6 || y5 == 2){

            z2.atk = 0;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z2.atk == 6){

                m5.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y6 == 0){

                    dcheck += 1;
                    y6 += 1;
                }
            }
        }

        if (t.time == 9){

            y6 += 1;
        }

        if (z2.atk > 6 || y6 == 2 || y6 == 1){

            z2.atk = 0;
            y6 +=2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z2.atk == 6){

                m6.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y7 == 0){

                    dcheck += 1;
                    y7 += 1;
                }
            }
        }

        if (t.time == 10){

            y7 += 1;
        }

        if (z2.atk > 6 || y7 == 2 || y7 == 1){

            z2.atk = 0;
            y7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z2.atk == 6){

                m7.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y8 == 0){

                    dcheck += 1;
                    y8 += 1;
                }
            }
        }

        if (t.time == 11){

            y8 += 1;
        }

        if (z2.atk > 6 || y8 == 2 || y8 ==1){

            z2.atk = 0;
            y8+=2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z2.atk == 6){

                m8.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y9 == 0){

                    dcheck += 1;
                    y9 += 1;
                }
            }
        }

        if (t.time == 12){

            y9 += 1;
        }

        if (z2.atk > 6 || y9 == 2 || y9 == 1){

            z2.atk = 0;
            y9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z2.atk == 6){

                m9.layer().destroy();
                soundj2.play();
                z2.atk = 0;

                if (y10 == 0){

                    dcheck += 1;
                    y10 += 1;
                }
            }
        }

        if (t.time == 13){

            y10 += 1;
        }

        if (z2.atk > 6 || y10 == 2 || y10 == 1){

            z2.atk = 0;
            y10 += 2;

        }

        //////////////////////////////////////////////////////////////////////////////////////////

        if (t.time > 2 && t.time < 4){

            if (a2.atk == 5){

                m.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y1 == 0){

                    dcheck += 1;
                    y1 += 1;
                }
            }
        }

        if (t.time == 4){

            y1 += 1;
        }

        if (a2.atk > 5 || y1 == 2 || y1 == 1){

            a2.atk = 0;
            y1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a2.atk == 5){

                m1.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y2 == 0){

                    dcheck += 1;
                    y2 += 1;
                }
            }
        }

        if (t.time == 5){

            y2 += 1;
        }

        if (a2.atk > 5 || y2 == 2 || y2 == 1){

            a2.atk = 0;
            y1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a2.atk == 5){

                m2.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y3 == 0){

                    dcheck += 1;
                    y3 += 1;
                }
            }
        }

        if (t.time == 6){

            y3 += 1;
        }

        if (a2.atk > 5 || y3 == 2 || y3 == 1){

            a2.atk = 0;
            y3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a2.atk == 5){

                m3.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y4 == 0){

                    dcheck += 1;
                    y4 += 1;
                }
            }
        }

        if (t.time == 7){

            y4 += 1;
        }

        if (a2.atk > 5 || y4 == 2 || y4 == 1){

            a2.atk = 0;
            y4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a2.atk == 5){

                m4.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y5 == 0){

                    dcheck += 1;
                    y5 += 1;
                }
            }
        }

        if (t.time == 8){

            y5 += 1;
        }

        if (a2.atk > 5 || y5 == 2 || y5 == 1){

            a2.atk = 0;
            y5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a2.atk == 5){

                m5.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y6 == 0){

                    dcheck += 1;
                    y6 += 1;
                }
            }
        }

        if (t.time == 9){

            y6 += 1;
        }

        if (a2.atk > 5 || y6 == 2 || y6 == 1){

            a2.atk = 0;
            y6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a2.atk == 5){

                m6.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y7 == 0){

                    dcheck += 1;
                    y7 += 1;
                }
            }
        }

        if (t.time == 10){

            y7 += 1;
        }

        if (a2.atk > 5 || y7 == 2 || y7 == 1){

            a2.atk = 0;
            y7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a2.atk == 5){

                m7.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y8 == 0){

                    dcheck += 1;
                    y8 += 1;
                }
            }
        }

        if (t.time == 11){

            y8 += 1;
        }

        if (a2.atk > 5 || y8 == 2 || y8 == 1){

            a2.atk = 0;
            y8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a2.atk == 5){

                m8.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y9 == 0){

                    dcheck += 1;
                    y9 += 1;
                }
            }
        }

        if (t.time == 12){

            y9 += 1;
        }

        if (a2.atk > 5 || y9 == 2 || y9 == 1){

            a2.atk = 0;
            y9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a2.atk == 5){

                m9.layer().destroy();
                soundj2.play();
                a2.atk = 0;

                if (y10 == 0){

                    dcheck += 1;
                    y10 += 1;
                }
            }
        }

        if (t.time == 13){

            y10 += 1;
        }

        if (a2.atk > 5 || y10 == 2 || y10 == 1){

            a2.atk = 0;
            y10 += 2;

        }
    }

    public void tower4(){

        /////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (z3.atk == 6){

                m.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u1 == 0){

                    dcheck += 1;
                    u1 += 1;
                }
            }
        }

        if (t.time == 5){

            u1 += 1;
        }

        if (z3.atk > 6 || u1 == 2 || u1 == 1){

            z3.atk = 0;
            u1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z3.atk == 6){

                m1.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u2 == 0){

                    dcheck += 1;
                    u2 += 1;
                }
            }
        }

        if (t.time == 6){

            u2 += 1;
        }

        if (z3.atk > 6 || u2 == 2 || u2 == 1){

            z3.atk = 0;
            u2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z3.atk == 6){

                m2.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u3 == 0){

                    dcheck += 1;
                    u3 += 1;
                }
            }
        }

        if (t.time == 7){

            u3 += 1;
        }

        if (z3.atk > 6 || u3 == 2 || u3 == 1){

            z3.atk = 0;
            u3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z3.atk == 6){

                m3.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u4 == 0){

                    dcheck += 1;
                    u4 += 1;
                }
            }
        }

        if (t.time == 8){

            u4 += 1;
        }

        if (z3.atk > 6 || u4 == 2 || u4 == 1){

            z3.atk = 0;
            u4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z3.atk == 6){

                m4.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u5 == 0){

                    dcheck += 1;
                    u5 += 1;
                }
            }
        }

        if (t.time == 9){

            u5 += 1;
        }

        if (z3.atk > 6 || u5 == 2 || u5 == 1){

            z3.atk = 0;
            u5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z3.atk == 6){

                m5.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u6 == 0){

                    dcheck += 1;
                    u6 += 1;
                }
            }
        }

        if (t.time == 10){

            u6 += 1;
        }

        if (z3.atk > 6 || u6 == 2 || u6 == 1){

            z3.atk = 0;
            u6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z3.atk == 6){

                m6.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u7 == 0){

                    dcheck += 1;
                    u7 += 1;
                }
            }
        }

        if (t.time == 11){

            u7 += 1;
        }

        if (z3.atk > 6 || u7 == 2 || u7 ==1){

            z3.atk = 0;
            u7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z3.atk == 6){

                m7.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u8 == 0){

                    dcheck += 1;
                    u8 += 1;
                }
            }
        }

        if (t.time == 12){

            u8 += 1;
        }

        if (z3.atk > 6 || u8 == 2 || u8 == 1){

            z3.atk = 0;
            u8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z3.atk == 6){

                m8.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u9 == 0){

                    dcheck += 1;
                    u9 += 1;
                }
            }
        }

        if (t.time == 13){

            u9 += 1;
        }

        if (z3.atk > 6 || u9 == 2 || u9 == 1){

            z3.atk = 0;
            u9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z3.atk == 6){

                m9.layer().destroy();
                soundj2.play();
                z3.atk = 0;

                if (u10 == 0){

                    dcheck += 1;
                    u10 += 1;
                }
            }
        }

        if (t.time == 14){

            u10 += 1;
        }

        if (z3.atk > 6 || u10 == 2 || u10 == 1){

            z3.atk = 0;
            u10 += 2;

        }

        ////////////////////////////////////////////////////////////////////////////////////////////

        if (t.time > 3 && t.time < 5){

            if (a3.atk == 5){

                m.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u1 == 0){

                    dcheck += 1;
                    u1 += 1;
                }
            }
        }

        if (t.time == 5){

            u1 += 1;
        }

        if (a3.atk > 5 || u1 == 2 || u1 == 1){

            a3.atk = 0;
            u1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a3.atk == 5){

                m1.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u2 == 0){

                    dcheck += 1;
                    u2 += 1;
                }
            }
        }

        if (t.time == 6){

            u2 += 1;
        }

        if (a3.atk > 5 || u2 == 2 || u2 == 1){

            a3.atk = 0;
            u2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a3.atk == 5){

                m2.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u3 == 0){

                    dcheck += 1;
                    u3 += 1;
                }
            }
        }

        if (t.time == 7){

            u3 += 1;
        }

        if (a3.atk > 5 || u3 == 2 || u3 == 1){

            a3.atk = 0;
            u3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a3.atk == 5){

                m3.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u4 == 0){

                    dcheck += 1;
                    u4 += 1;
                }
            }
        }

        if (t.time == 8){

            u4 += 1;
        }

        if (a3.atk > 5 || u4 == 2 || u4 == 1){

            a3.atk = 0;
            u4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a3.atk == 5){

                m4.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u5 == 0){

                    dcheck += 1;
                    u5 += 1;
                }
            }
        }

        if (t.time == 9){

            u5 += 1;
        }

        if (a3.atk > 5 || u5 == 2 || u5 == 1){

            a3.atk = 0;
            u5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a3.atk == 5){

                m5.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u6 == 0){

                    dcheck += 1;
                    u6 += 1;
                }
            }
        }

        if (t.time == 10){

            u6 += 1;
        }

        if (a3.atk > 5 || u6 == 2 || u6 == 1){

            a3.atk = 0;
            u6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a3.atk == 5){

                m6.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u7 == 0){

                    dcheck += 1;
                    u7 += 1;
                }
            }
        }

        if (t.time == 11){

            u7 += 1;
        }

        if (a3.atk > 5 || u7 == 2 || u7 == 1){

            a3.atk = 0;
            u7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a3.atk == 5){

                m7.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u8 == 0){

                    dcheck += 1;
                    u8 += 1;
                }
            }
        }

        if (t.time == 12){

            u8 += 1;
        }

        if (a3.atk > 5 || u8 == 2 || u8 == 1){

            a3.atk = 0;
            u8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a3.atk == 5){

                m8.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u9 == 0){

                    dcheck += 1;
                    u9 += 1;
                }
            }
        }

        if (t.time == 13){

            u9 += 1;
        }

        if (a3.atk > 5 || u9 == 2 || u9 == 1){

            a3.atk = 0;
            u9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a3.atk == 5){

                m9.layer().destroy();
                soundj2.play();
                a3.atk = 0;

                if (u10 == 0){

                    dcheck += 1;
                    u10 += 1;
                }
            }
        }

        if (t.time == 14){

            u10 += 1;
        }

        if (a3.atk > 5 || u10 == 2 || u10 == 1){

            a3.atk = 0;
            u10 += 2;

        }
    }

    public void tower5(){

        /////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (z4.atk == 6){

                m.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q1 == 0){

                    dcheck += 1;
                    q1 += 1;
                }
            }
        }

        if (t.time == 6){

            q1 += 1;
        }

        if (z4.atk > 6 || q1 == 2 || q1 == 1){

            z4.atk = 0;
            q1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z4.atk == 6){

                m1.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q2 == 0){

                    dcheck += 1;
                    q2 += 1;
                }
            }
        }

        if (t.time == 7){

            q2 += 1;
        }

        if (z4.atk > 6 || q2 == 2 || q2 == 1){

            z4.atk = 0;
            q2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z4.atk == 6){

                m2.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q3 == 0){

                    dcheck += 1;
                    q3 += 1;
                }
            }
        }

        if (t.time == 8){

            q3 += 1;
        }

        if (z4.atk > 6 || q3 == 2 || q3 == 1){

            z4.atk = 0;
            q3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z4.atk == 6){

                m3.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q4 == 0){

                    dcheck += 1;
                    q4 += 1;
                }
            }
        }

        if (t.time == 9){

            q4 += 1;
        }

        if (z4.atk > 6 || q4 == 2 || q4 == 1){

            z4.atk = 0;
            q4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z4.atk == 6){

                m4.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q5 == 0){

                    dcheck += 1;
                    q5 += 1;
                }
            }
        }

        if (t.time == 10){

            q5 += 1;
        }

        if (z4.atk > 6 || q5 == 2 || q5 == 1){

            z4.atk = 0;
            q5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z4.atk == 6){

                m5.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q6 == 0){

                    dcheck += 1;
                    q6 += 1;
                }
            }
        }

        if (t.time == 11){

            q6 += 1;
        }

        if (z4.atk > 6 || q6 == 2 || q6 == 1){

            z4.atk = 0;
            q6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z4.atk == 6){

                m6.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q7 == 0){

                    dcheck += 1;
                    q7 += 1;
                }
            }
        }

        if (t.time == 12){

            q7 += 1;
        }

        if (z4.atk > 6 || q7 == 2 || q7 == 1){

            z4.atk = 0;
            q7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z4.atk == 6){

                m7.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q8 == 0){

                    dcheck += 1;
                    q8 += 1;
                }
            }
        }

        if (t.time == 13){

            q8 += 1;
        }

        if (z4.atk > 6 || q8 == 2 || q8 == 1){

            z4.atk = 0;
            q8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z4.atk == 6){

                m8.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q9 == 0){

                    dcheck += 1;
                    q9 += 1;
                }
            }
        }

        if (t.time == 14){

            q9 += 1;
        }

        if (z4.atk > 6 || q9 == 2 || q9 == 1){

            z4.atk = 0;
            q9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z4.atk == 6){

                m9.layer().destroy();
                soundj2.play();
                z4.atk = 0;

                if (q10 == 0){

                    dcheck += 1;
                    q10 += 1;
                }
            }
        }

        if (t.time == 15){

            q10 += 1;
        }

        if (z4.atk > 6 || q10 == 2 || q10 == 1){

            z4.atk = 0;
            q10 += 2;

        }

        //////////////////////////////////////////////////////////////////////////////////////////////////

        if (t.time > 4 && t.time < 6){

            if (a4.atk == 5){

                m.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q1 == 0){

                    dcheck += 1;
                    q1 += 1;
                }
            }
        }

        if (t.time == 6){

            q1 += 1;
        }

        if (a4.atk > 5 || q1 == 2 || q1 == 1){

            a4.atk = 0;
            q1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a4.atk == 5){

                m1.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q2 == 0){

                    dcheck += 1;
                    q2 += 1;
                }
            }
        }

        if (t.time == 7){

            q2 += 1;
        }

        if (a4.atk > 5 || q2 == 2 || q2 == 1){

            a4.atk = 0;
            q2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a4.atk == 5){

                m2.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q3 == 0){

                    dcheck += 1;
                    q3 += 1;
                }
            }
        }

        if (t.time == 8){

            q3 += 1;
        }

        if (a4.atk > 5 || q3 == 2 || q3 == 1){

            a4.atk = 0;
            q3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a4.atk == 5){

                m3.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q4 == 0){

                    dcheck += 1;
                    q4 += 1;
                }
            }
        }

        if (t.time == 9){

            q4 += 1;
        }

        if (a4.atk > 5 || q4 == 2 || q4 == 1){

            a4.atk = 0;
            q4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a4.atk == 5){

                m4.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q5 == 0){

                    dcheck += 1;
                    q5 += 1;
                }
            }
        }

        if (t.time == 10){

            q5 += 1;
        }

        if (a4.atk > 5 || q5 == 2 || q5 == 1){

            a4.atk = 0;
            q5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a.atk == 5){

                m5.layer().destroy();
                soundj2.play();
                a.atk = 0;

                if (q6 == 0){

                    dcheck += 1;
                    q6 += 1;
                }
            }
        }

        if (t.time == 11){

            q6 += 1;
        }

        if (a4.atk > 5 || q6 == 2 || q6 == 1){

            a4.atk = 0;
            q6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a4.atk == 5){

                m6.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q7 == 0){

                    dcheck += 1;
                    q7 += 1;
                }
            }
        }

        if (t.time == 12){

            q7 += 1;
        }

        if (a4.atk > 5 || q7 == 2 || q7 == 1){

            a4.atk = 0;
            q7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a4.atk == 5){

                m7.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q8 == 0){

                    dcheck += 1;
                    q8 += 1;
                }
            }
        }

        if (t.time == 13){

            q8 += 1;
        }

        if (a4.atk > 5 || q8 == 2 || q8 == 1){

            a4.atk = 0;
            q8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a4.atk == 5){

                m8.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q9 == 0){

                    dcheck += 1;
                    q9 += 1;
                }
            }
        }

        if (t.time == 14){

            q9 += 1;
        }

        if (a4.atk > 5 || q9 == 2 || q9 == 1){

            a4.atk = 0;
            q9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a4.atk == 5){

                m9.layer().destroy();
                soundj2.play();
                a4.atk = 0;

                if (q10 == 0){

                    dcheck += 1;
                    q10 += 1;
                }
            }
        }

        if (t.time == 15){

            q10 += 1;
        }

        if (a4.atk > 5 || q10 == 2 || q10 == 1){

            a4.atk = 0;
            q10 += 2;

        }
    }

    public void tower6(){

        /////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (z5.atk == 6){

                m.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w1 == 0){

                    dcheck += 1;
                    w1 += 1;
                }
            }
        }

        if (t.time == 7){

            w1 += 1;
        }

        if (z5.atk > 6 || w1 == 2 || w1 == 1){

            z5.atk = 0;
            w1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z5.atk == 6){

                m1.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w2 == 0){

                    dcheck += 1;
                    w2 += 1;
                }
            }
        }

        if (t.time == 8){

            w2 += 1;
        }

        if (z5.atk > 6 || w2 == 2 || w2 == 1){

            z5.atk = 0;
            w2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z5.atk == 6){

                m2.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w3 == 0){

                    dcheck += 1;
                    w3 += 1;
                }
            }
        }

        if (t.time == 9){

            w3 += 1;
        }

        if (z5.atk > 6 || w3 == 2 || w3 == 1){

            z5.atk = 0;
            w3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z5.atk == 6){

                m3.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w4 == 0){

                    dcheck += 1;
                    w4 += 1;
                }
            }
        }

        if (t.time == 10){

            w4 += 1;
        }

        if (z5.atk > 6 || w4 == 2 || w4 == 1){

            z5.atk = 0;
            w4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z5.atk == 6){

                m4.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w5 == 0){

                    dcheck += 1;
                    w5 += 1;
                }
            }
        }

        if (t.time == 11){

            w5 += 1;
        }

        if (z5.atk > 6 || w5 == 2 || w5 == 1){

            z5.atk = 0;
            w5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z5.atk == 6){

                m5.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w6 == 0){

                    dcheck += 1;
                    w6 += 1;
                }
            }
        }

        if (t.time == 12){

            w6 += 1;
        }

        if (z5.atk > 6 || w6 == 2 || w6 == 1){

            z5.atk = 0;
            w6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z5.atk == 6){

                m6.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w7 == 0){

                    dcheck += 1;
                    w7 += 1;
                }
            }
        }

        if (t.time == 13){

            w7 += 1;
        }

        if (z5.atk > 6 || w7 == 2 || w7 == 1){

            z5.atk = 0;
            w7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z5.atk == 6){

                m7.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w8 == 0){

                    dcheck += 1;
                    w8 += 1;
                }
            }
        }

        if (t.time == 14){

            w8 += 1;
        }

        if (z5.atk > 6 || w8 == 2 || w8 == 1){

            z5.atk = 0;
            w8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z5.atk == 6){

                m8.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w9 == 0){

                    dcheck += 1;
                    w9 += 1;
                }
            }
        }

        if (t.time == 15){

            w9 += 1;
        }

        if (z5.atk > 6 || w9 == 2 || w9 == 1){

            z5.atk = 0;
            w9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z5.atk == 6){

                m9.layer().destroy();
                soundj2.play();
                z5.atk = 0;

                if (w10 == 0){

                    dcheck += 1;
                    w10 += 1;
                }
            }
        }

        if (t.time == 16){

            w10 += 1;
        }

        if (z5.atk > 6 || w10 == 2 || w10 == 1){

            z5.atk = 0;
            w10 += 2;

        }

        /////////////////////////////////////////////////////////////////////////////////////////

        if (t.time > 5 && t.time < 7){

            if (a5.atk == 5){

                m.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w1 == 0){

                    dcheck += 1;
                    w1 += 1;
                }
            }
        }

        if (t.time == 7){

            w1 += 1;
        }

        if (a5.atk > 5 || w1 == 2 || w1 == 1){

            a5.atk = 0;
            w1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a5.atk == 5){

                m1.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w2 == 0){

                    dcheck += 1;
                    w2 += 1;
                }
            }
        }

        if (t.time == 8){

            w2 += 1;
        }

        if (a5.atk > 5 || w2 == 2 || w2 == 1){

            a5.atk = 0;
            w2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a5.atk == 5){

                m2.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w3 == 0){

                    dcheck += 1;
                    w3 += 1;
                }
            }
        }

        if (t.time == 9){

            w3 += 1;
        }

        if (a5.atk > 5 || w3 == 2 || w3 == 1){

            a5.atk = 0;
            w3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a5.atk == 5){

                m3.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w4 == 0){

                    dcheck += 1;
                    w4 += 1;
                }
            }
        }

        if (t.time == 10){

            w4 += 1;
        }

        if (a5.atk > 5 || w4 == 2 || w4 == 1){

            a5.atk = 0;
            w4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a5.atk == 5){

                m4.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w5 == 0){

                    dcheck += 1;
                    w5 += 1;
                }
            }
        }

        if (t.time == 11){

            w5 += 1;
        }

        if (a5.atk > 5 || w5 == 2 || w5 == 1){

            a5.atk = 0;
            w5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a5.atk == 5){

                m5.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w6 == 0){

                    dcheck += 1;
                    w6 += 1;
                }
            }
        }

        if (t.time == 12){

            w6 += 1;
        }

        if (a5.atk > 5 || w6 == 2 || w6 == 1){

            a5.atk = 0;
            w6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (a5.atk == 5){

                m6.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w7 == 0){

                    dcheck += 1;
                    w7 += 1;
                }
            }
        }

        if (t.time == 13){

            w7 += 1;
        }

        if (a5.atk > 5 || w7 == 2 || w7 == 1){

            a5.atk = 0;
            w7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a5.atk == 5){

                m7.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w8 == 0){

                    dcheck += 1;
                    w8 += 1;
                }
            }
        }

        if (t.time == 14){

            w8 += 1;
        }

        if (a5.atk > 5 || w8 == 2 || w8 == 1){

            a5.atk = 0;
            w8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a5.atk == 5){

                m8.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w9 == 0){

                    dcheck += 1;
                    w9 += 1;
                }
            }
        }

        if (t.time == 15){

            w9 += 1;
        }

        if (a5.atk > 5 || w9 == 2 || w9 == 1){

            a5.atk = 0;
            w9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a5.atk == 5){

                m9.layer().destroy();
                soundj2.play();
                a5.atk = 0;

                if (w10 == 0){

                    dcheck += 1;
                    w10 += 1;
                }
            }
        }

        if (t.time == 16){

            w10 += 1;
        }

        if (a5.atk > 5 || w10 == 2 || w10 == 1){

            a5.atk = 0;
            w10 += 2;

        }
    }

    public void tower7(){

        /////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (z6.atk == 6){

                m.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e1 == 0){

                    dcheck += 1;
                    e1 += 1;
                }
            }
        }

        if (t.time == 8){

            e1 += 1;
        }

        if (z6.atk > 6 || e1 == 2 || e1 == 1){

            z6.atk = 0;
            e1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (z6.atk == 6){

                m1.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e2 == 0){

                    dcheck += 1;
                    e2 += 1;
                }
            }
        }

        if (t.time == 9){

            e2 += 1;
        }

        if (z6.atk > 6 || e2 == 2 || e2 == 1){

            z6.atk = 0;
            e2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (z6.atk == 6){

                m2.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e3 == 0){

                    dcheck += 1;
                    e3 += 1;
                }
            }
        }

        if (t.time == 10){

            e3 += 1;
        }

        if (z6.atk > 6 || e3 == 2 || e3 == 1){

            z6.atk = 0;
            e3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (z6.atk == 6){

                m3.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e4 == 0){

                    dcheck += 1;
                    e4 += 1;
                }
            }
        }

        if (t.time == 11){

            e4 += 1;
        }

        if (z6.atk > 6 || e4 == 2 | e4 == 1){

            z6.atk = 0;
            e4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (z6.atk == 6){

                m4.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e5 == 0){

                    dcheck += 1;
                    e5 += 1;
                }
            }
        }

        if (t.time == 12){

            e5 += 1;
        }

        if (z6.atk > 6 || e5 == 2 || e5 == 1){

            z6.atk = 0;
            e5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 11 && t.time < 13){

            if (z6.atk == 6){

                m5.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e6 == 0){

                    dcheck += 1;
                    e6 += 1;
                }
            }
        }

        if (t.time == 13){

            e6 += 1;
        }

        if (z6.atk > 6 || e6 == 2 || e6 == 1){

            z6.atk = 0;
            e6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (z6.atk == 6){

                m6.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e7 == 0){

                    dcheck += 1;
                    e7 += 1;
                }
            }
        }

        if (t.time == 14){

            e7 += 1;
        }

        if (z6.atk > 6 || e7 == 2 || e7 == 1){

            z6.atk = 0;
            e7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (z6.atk == 6){

                m7.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e8 == 0){

                    dcheck += 1;
                    e8 += 1;
                }
            }
        }

        if (t.time == 15){

            e8 += 1;
        }

        if (z6.atk > 6 || e8 == 2 || e8 == 1){

            z6.atk = 0;
            e8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (z6.atk == 6){

                m8.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e9 == 0){

                    dcheck += 1;
                    e9 += 1;
                }
            }
        }

        if (t.time == 16){

            e9 += 1;
        }

        if (z6.atk > 6 || e9 == 2 || e9 == 1){

            z6.atk = 0;
            e9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (z6.atk == 6){

                m9.layer().destroy();
                soundj2.play();
                z6.atk = 0;

                if (e10 == 0){

                    dcheck += 1;
                    e10 += 1;
                }
            }
        }

        if (t.time == 17){

            e10 += 1;
        }

        if (z6.atk > 6 || e10 == 2 || e10 == 1){

            z6.atk = 0;
            e10 += 2;

        }

        ///////////////////////////////////////////////////////////////////////////////////////////

        if (t.time > 6 && t.time < 8){

            if (a6.atk == 5){

                m.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e1 == 0){

                    dcheck += 1;
                    e1 += 1;
                }
            }
        }

        if (t.time == 8){

            e1 += 1;
        }

        if (a6.atk > 5 || e1 == 2 || e1 == 1){

            a6.atk = 0;
            e1 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 7 && t.time < 9){

            if (a6.atk == 5){

                m1.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e2 == 0){

                    dcheck += 1;
                    e2 += 1;
                }
            }
        }

        if (t.time == 9){

            e2 += 1;
        }

        if (a6.atk > 5 || e2 == 2 || e2 == 1){

            a6.atk = 0;
            e2 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 8 && t.time < 10){

            if (a6.atk == 5){

                m2.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e3 == 0){

                    dcheck += 1;
                    e3 += 1;
                }
            }
        }

        if (t.time == 10){

            e3 += 1;
        }

        if (a6.atk > 5 || e3 == 2 || e3 == 1){

            a6.atk = 0;
            e3 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 9 && t.time < 11){

            if (a6.atk == 5){

                m3.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e4 == 0){

                    dcheck += 1;
                    e4 += 1;
                }
            }
        }

        if (t.time == 11){

            e4 += 1;
        }

        if (a6.atk > 5 || e4 == 2 || e4 == 1){

            a6.atk = 0;
            e4 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 10 && t.time < 12){

            if (a6.atk == 5){

                m4.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e5 == 0){

                    dcheck += 1;
                    e5 += 1;
                }
            }
        }

        if (t.time == 12){

            e5 += 1;
        }

        if (a6.atk > 5 || e5 == 2 || e5 == 1){

            a6.atk = 0;
            e5 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 13){

            if (a6.atk == 5){

                m5.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e6 == 0){

                    dcheck += 1;
                    e6 += 1;
                }
            }
        }

        if (t.time == 13){

            e6 += 1;
        }

        if (a6.atk > 5 || e6 == 2 || e6 == 1){

            a6.atk = 0;
            e6 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 12 && t.time < 14){

            if (a6.atk == 5){

                m6.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e7 == 0){

                    dcheck += 1;
                    e7 += 1;
                }
            }
        }

        if (t.time == 14){

            e7 += 1;
        }

        if (a6.atk > 5 || e7 == 2 || e7 == 1){

            a6.atk = 0;
            e7 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 13 && t.time < 15){

            if (a6.atk == 5){

                m7.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e8 == 0){

                    dcheck += 1;
                    e8 += 1;
                }
            }
        }

        if (t.time == 15){

            e8 += 1;
        }

        if (a6.atk > 5 || e8 == 2 || e8 == 1){

            a6.atk = 0;
            e8 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 14 && t.time < 16){

            if (a6.atk == 5){

                m8.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e9 == 0){

                    dcheck += 1;
                    e9 += 1;
                }
            }
        }

        if (t.time == 16){

            e9 += 1;
        }

        if (a6.atk > 5 || e9 == 2 || e9 == 1){

            a6.atk = 0;
            e9 += 2;

        }

        //////////////////////////////////////////////////

        if (t.time > 15 && t.time < 17){

            if (a6.atk == 5){

                m9.layer().destroy();
                soundj2.play();
                a6.atk = 0;

                if (e10 == 0){

                    dcheck += 1;
                    e10 += 1;
                }
            }
        }

        if (t.time == 17){

            e10 += 1;
        }

        if (a6.atk > 5 || e10 == 2 || e10 == 1){

            a6.atk = 0;
            e10 += 2;

        }
    }

    ////////////////////////////////////////////

    public void score(){

        if (dcheck == 0){

            btImage = assets().getImage("images/score0.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 1){

            btImage = assets().getImage("images/score1.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 2){


            btImage = assets().getImage("images/score2.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 3){


            btImage = assets().getImage("images/score3.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 4){


            btImage = assets().getImage("images/score4.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 5){


            btImage = assets().getImage("images/score5.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 6){


            btImage = assets().getImage("images/score6.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 7){


            btImage = assets().getImage("images/score7.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 8){


            btImage = assets().getImage("images/score8.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 9){

            btImage = assets().getImage("images/score9.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

        if (dcheck == 10){


            btImage = assets().getImage("images/score10.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,10);
            layer.add(btLayer);

        }

    }

    public void money(){

        if (money == 0){

            btImage = assets().getImage("images/0.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 50){

            btImage = assets().getImage("images/50.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 100){

            btImage = assets().getImage("images/100.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 150){

            btImage = assets().getImage("images/150.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 200){

            btImage = assets().getImage("images/200.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 250){

            btImage = assets().getImage("images/250.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 300){

            btImage = assets().getImage("images/300.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 350){

            btImage = assets().getImage("images/350.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 400){

            btImage = assets().getImage("images/400.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 450){

            btImage = assets().getImage("images/450.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }
        if (money == 500){

            btImage = assets().getImage("images/500.png");
            btLayer = graphics().createImageLayer(btImage);
            btLayer.setTranslation(520,45);
            layer.add(btLayer);

        }

    }

    public void checkmoney(){

        if (dcheck == 1){

            if (moneycheck1 == false){

                money += 50+100;
                moneycheck1 = true;

                System.out.print(money);

            }
        }
        if (dcheck == 2){

            if (moneycheck2 == false){

                money += 50;
                moneycheck2 = true;
            }
        }
        if (dcheck == 3){

            if (moneycheck3 == false){

                money += 50;
                moneycheck3 = true;

            }
        }
        if (dcheck == 4){

            if (moneycheck4 == false){

                money += 50;
                moneycheck4 = true;

            }
        }
        if (dcheck == 5){

            if (moneycheck5 == false){

                money += 50;
                moneycheck5 = true;

            }
        }
        if (dcheck == 6){

            if (moneycheck6 == false){

                money += 50;
                moneycheck6 = true;

            }
        }
        if (dcheck == 7){

            if (moneycheck7 == false){

                money += 50;
                moneycheck7 = true;

            }
        }
        if (dcheck == 8){

            if (moneycheck8 == false){

                money += 50;
                moneycheck8 = true;

            }
        }
        if (dcheck == 9){

            if (moneycheck9 == false){

                money += 50;
                moneycheck9 = true;

            }
        }
        if (dcheck == 10){

            if (moneycheck10 == false){

                money += 50;
                moneycheck10 = true;

            }
        }

    }
}
