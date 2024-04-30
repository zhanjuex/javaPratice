class SimpleFactory {
    public static Transport createTransport(String type) {
        if ("truck".equalsIgnoreCase(type)) {
            return new Truck();
        } else if ("ship".equalsIgnoreCase(type)) {
            return new Ship();
        }
        return null;
    }

    public static void main(String[] args) {
        Transport truck = SimpleFactory.createTransport("truck");
        truck.deliver();

        Transport ship = SimpleFactory.createTransport("ship");
        ship.deliver();
    }
}

interface Transport {
    public void deliver();
}

class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("陆地运输");
    }
}

class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("海运");
    }
}