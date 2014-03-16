package Sprite;

import Romandefense.core.GameScreen;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.World;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import playn.core.Layer;
import playn.core.Pointer;
import playn.core.util.Callback;
import playn.core.util.Clock;



public class Minutor {

    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasLoaded = false;
    private Body body;

    private float n,b,c,d,f,g,h,i,j,k,l,m,o,p = 0;

    public Minutor(final World world, final float x,final float y){
        sprite = SpriteLoader.getSprite("images/minutor.json");
        sprite.addCallback(new Callback<Sprite>() {
            @Override
            public void onSuccess(Sprite result) {

                sprite.setSprite(spriteIndex);
                sprite.layer().setOrigin(sprite.width()/2f,sprite.height()/2f);
                sprite.layer().setTranslation(x,y);


                body = initPhysicsBody(world,GameScreen.M_PER_PIXEL * x,GameScreen.M_PER_PIXEL * y);

                hasLoaded = true;

            }

            @Override
            public void onFailure(Throwable cause) {

            }
        });

    }


    private Body initPhysicsBody(World world,float x,float y){

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.STATIC;
        bodyDef.position = new Vec2(0,0);
        Body body = world.createBody(bodyDef);


        ///EdgeShape shape = new EdgeShape();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(66 * GameScreen.M_PER_PIXEL /2, sprite.layer().height()* GameScreen.M_PER_PIXEL /2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.4f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.35f;
        body.createFixture(fixtureDef);

        body.setLinearDamping(0.2f);
        body.setTransform(new Vec2(x,y),0f);

        return body;
    }

    public Layer layer(){

        return sprite.layer();
    }

    public void paint(Clock clock) {

        if (!hasLoaded)
            return;

        sprite.layer().setTranslation((body.getPosition().x/GameScreen.M_PER_PIXEL),
                (body.getPosition().y/GameScreen.M_PER_PIXEL));

        sprite.layer().setRotation(body.getAngle());

        ///////////////////////////////////////////////////////////////////////

        body.setTransform(new Vec2(5.9f,(n+2.6f)),body.getAngle());

        if (b > 6.3){

            b = 0;
        }
        if (n > 6.3){

            body.setTransform(new Vec2(5.9f-b,8.9f),body.getAngle());
        }

        ////////////////////////////////////////////////////////////////////////

        if (c > 10.3){

            c = 0;

        }
        if (n > 10.3){

            body.setTransform(new Vec2(1.9f,c+8.9f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (d > 14.1){

            d = 0;

        }
        if (n > 14.1){

            body.setTransform(new Vec2(d+1.9f,12.7f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (f > 18.0){

            f = 0;

        }
        if (n > 18.0){

            body.setTransform(new Vec2(5.8f,f+12.7f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (g > 20.2){

            g = 0;

        }
        if (n > 20.2){

            body.setTransform(new Vec2(g+5.8f,14.9f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (h > 24.2){

            h = 0;

        }
        if (n > 24.2){

            body.setTransform(new Vec2(9.8f,14.9f-h),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (i > 26.5){

            i = 0;

        }
        if (n > 26.5){

            body.setTransform(new Vec2(i+9.8f,12.6f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (j > 28.7){

            j = 0;

        }
        if (n > 28.7){

            body.setTransform(new Vec2(12.0f,12.6f-j),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (k > 34.7){

            k = 0;

        }
        if (n > 34.7){

            body.setTransform(new Vec2(12.0f+k,6.6f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (l > 38.7){

            l = 0;

        }
        if (n > 38.7){

            body.setTransform(new Vec2(16.0f,6.6f+l),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (m > 46.9){

            m = 0;

        }
        if (n > 46.9){

            body.setTransform(new Vec2(16.0f+m,14.8f),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (o > 50.9){

            o = 0;

        }
        if (n > 50.9){

            body.setTransform(new Vec2(20.0f,14.8f-o),body.getAngle());
        }

        //////////////////////////////////////////////////////////////////////////

        if (p > 56.9){

            p = 0;

        }
        if (n > 56.9){

            body.setTransform(new Vec2(20.0f+p,8.8f),body.getAngle());
        }

    }



    public enum State{
        WALK
    }

    private State state=State.WALK;
    private int offset=0;
    private int e=0;



    public void update(int delta){
        if (!hasLoaded) return;

        e += delta;
        if (e > 170){
            switch (state){
                case WALK: offset = 0;

                    n = n + 0.2f;
                    b = b + 0.2f;
                    c = c + 0.2f;
                    d = d + 0.2f;
                    f = f + 0.2f;
                    g = g + 0.2f;
                    h = h + 0.2f;
                    i = i + 0.2f;
                    j = j + 0.2f;
                    k = k + 0.2f;
                    l = l + 0.2f;
                    m = m + 0.2f;
                    o = o + 0.2f;
                    p = p + 0.2f;

                    break;

            }

            spriteIndex = offset + ((spriteIndex+1)%4);
            sprite.setSprite(spriteIndex);
            e=0;

        }

    }



}
