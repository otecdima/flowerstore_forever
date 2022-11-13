package ua.edu.ucu.apps.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.demo.flower.CactusFlower;
import ua.edu.ucu.apps.demo.flower.Flower;
import ua.edu.ucu.apps.demo.flower.FlowerBucket;
import ua.edu.ucu.apps.demo.flower.RomashkaFlower;
import ua.edu.ucu.apps.demo.flower.decorators.BasketDecorator;
import ua.edu.ucu.apps.demo.flower.decorators.PaperDecorator;
import ua.edu.ucu.apps.demo.flower.decorators.RibbonDecorator;
import ua.edu.ucu.apps.demo.item.Item;


public class DecoratorTests {
    private Item item;
    private Item flowerBucket;

    @BeforeEach
    public void init() {
        item = new Flower(1, "white", 200, 200);
        item.setDescription("Beautiful flower");

        flowerBucket = new FlowerBucket();
        FlowerBucket.addFlowers(new RomashkaFlower(3, "white", 5, 200));
        FlowerBucket.addFlowers(new CactusFlower(4, "red", 50, 400));
        flowerBucket.setDescription("Beautiful bucket");
    }

    @Test
    public void testBasketDecorator() {
       item = new BasketDecorator(item);
       Assertions.assertEquals("Beautiful flower with Basket decorator", item.getDescription());

       flowerBucket = new BasketDecorator(flowerBucket);
       Assertions.assertEquals("Beautiful bucket with Basket decorator", flowerBucket.getDescription());
    }

    @Test
    public void testPaperDecorator() {
        item = new PaperDecorator(item);
        Assertions.assertEquals("Beautiful flower with Paper decorator", item.getDescription());

        flowerBucket = new PaperDecorator(flowerBucket);
        Assertions.assertEquals("Beautiful bucket with Paper decorator", flowerBucket.getDescription());
    }

    @Test
    public void testRibbonDecorator() {
        item = new RibbonDecorator(item);
        Assertions.assertEquals("Beautiful flower with Ribbon decorator", item.getDescription());

        flowerBucket = new RibbonDecorator(flowerBucket);
        Assertions.assertEquals("Beautiful bucket with Ribbon decorator", flowerBucket.getDescription());
    }
}
