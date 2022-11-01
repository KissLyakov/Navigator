public class Car {
    private double maxSpeed; //км/ч
    private double minSpeed; //км/ч

    public Car(double maxSpeed, double minSpeed){
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
    }

    public double getCarSpeed(){
        double speed = Math.random() * (this.maxSpeed - this.minSpeed) + this.minSpeed ; //скорость в диапозоне
        return speed;
    }

}
