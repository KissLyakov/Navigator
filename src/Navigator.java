public class Navigator implements Runnable {
    private double distance;
    private Car car;

    public Navigator(double distance, Car car){
        this.distance = distance;
        this.car = car;
    }

    @Override
    public void run(){

        double midSpeed = 0.0; //средняя скорость
        int ticker = 0;
        double sumSpeed = 0;
        double leftDistance = this.distance * 1000; //оставшееся расстояние в метрах
        int leftTime = 0; //оставшееся время

        while (leftDistance > 0.0){

            ++ticker;
            double carSpeed = car.getCarSpeed() * 1000/3600;
            leftDistance -= carSpeed * ticker;
            sumSpeed += carSpeed;
            midSpeed = sumSpeed/ticker;
            leftTime = (int) (leftDistance/(midSpeed*1000/3600));
            if (leftDistance < 0){
                leftDistance = 0;
                leftTime = 0;
            }
            System.out.printf("Текущая скорость: %.0f км/ч   Средняя скорость: %.0f км/ч     Осталось ехать: %.3f км %d сек\n",
                                carSpeed / 1000*3600, midSpeed/1000*3600, leftDistance/1000, leftTime);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Вы приехали");
    }
}
