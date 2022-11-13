package ua.edu.ucu.apps.demo.flower;

import ua.edu.ucu.apps.demo.item.Item;

public class ItemDiscount extends Item {
    private Item item;
    public ItemDiscount(Item item) {
        this.item = item;
    }

    @Override
    public double price() {
        return item.price() * 0.2;
    }
}
