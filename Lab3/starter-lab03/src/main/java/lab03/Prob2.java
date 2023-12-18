package lab03;

import world.*;
import image.*;

public class Prob2 {
    public static void main(String[] args) {
        Snowman snowman = Snowman.build(3);
        //Snowman snowman = Snowman.build(5);
        var scene = snowman.drawAt(new EmptyScene(800, 600), 300);
        World.display(scene);
    }
}

interface Snowman {
    static Snowman build(int height) {
        if (height == 0) {
            return new Hat();
        }
        else {
            var top = build(height - 1);
            return new Ball(top);
        }
    }

    int height();

    Image image();
    Scene drawAt(Scene scene, int yy);
}

record Hat() implements Snowman {
    public int height() {
        return 30;
    }

    @Override
    public Image image() {
        return new Rectangle(30, 60, "solid", "black");
    }

    @Override
    public Scene drawAt(Scene scene, int yy) {
        return scene.placeImage(this.image(), 400, yy);
    }
}

record Ball(Snowman above) implements Snowman {
    public int height() {
        return 2 * above.height();
    }

    @Override
    public Image image() {
        return new Circle(this.height() / 2, "outline", "black");
    }

    @Override
    public Scene drawAt(Scene scene, int yy) {
        int dy = this.height() / 2;
        var scene1 = above.drawAt(scene, yy - dy);
        return scene1.placeImage(this.image(), 400, yy + dy);
    }
}
