package march_daily_challenge;

public class D17_GenerateRandomPointInCircle {
}

class GenerateRandomPointInCircleSolution {
    double radius, x_center, y_center;

    public GenerateRandomPointInCircleSolution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double ang = Math.random() * 2 * Math.PI,
                hypotenuse = Math.sqrt(Math.random()) * radius,
                adjacent = Math.cos(ang) * hypotenuse,
                opposite = Math.sin(ang) * hypotenuse;
        return new double[]{x_center + adjacent, y_center + opposite};
    }
}

class GenerateRandomPointInCircleSolution2 {
    double rad, xc, yc;
    public GenerateRandomPointInCircleSolution2(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double xOrigin = xc - rad;
        double yOrigin = yc - rad;
        double x, y;
        do {
            x = xOrigin + 2 * Math.random() * rad;
            y = yOrigin + 2 * Math.random() * rad;
        } while (Math.sqrt(Math.pow(x - xc, 2.0) + Math.pow(y - yc, 2.0)) > rad);

        return new double[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */