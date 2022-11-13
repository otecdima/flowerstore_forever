package ua.edu.ucu.apps.demo.flower.decorators;

import lombok.AllArgsConstructor;
import ua.edu.ucu.apps.demo.flower.CactusFlower;
import ua.edu.ucu.apps.demo.flower.Flower;
import ua.edu.ucu.apps.demo.flower.RomashkaFlower;
import ua.edu.ucu.apps.demo.item.Item;

import java.util.LinkedList;

@AllArgsConstructor
public class BasketDecorator extends ItemDecorator{
    private Item item;

    public double getPrice() {
        return 4 + item.price();
    }

    @Override
    public double price() {
        return getPrice();
    }

    @Override
    public String getDescription() {
        item.setDescription(item.getDescription() + " with Basket decorator");
        return item.getDescription();
    }

    public static void main(String[] args) {
        Item firstFlower = new Flower(1, "white", 200, 200);
        firstFlower.setDescription("beautiful");
        System.out.println(firstFlower.getDescription());
        System.out.println(firstFlower.price());
        firstFlower = new BasketDecorator(firstFlower);
        System.out.println(firstFlower.getDescription());
        System.out.println(firstFlower.price());
    }
}
