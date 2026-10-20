package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Empty() {
        TorpedoStore store = new TorpedoStore(0);

        assertThrows(IllegalArgumentException.class, () -> {
        store.fire(1);
        });

        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_Fail() {
        TorpedoStore store = new TorpedoStore(1, 1.0);

        boolean result = store.fire(1);

        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_Multiple() {
        TorpedoStore store = new TorpedoStore(3);

        boolean result1 = store.fire(1);
        boolean result2 = store.fire(1);
        boolean result3 = store.fire(1);

        assertEquals(true, result1);
        assertEquals(true, result2);
        assertEquals(true, result3);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_InvalidNumber(){
        TorpedoStore store = new TorpedoStore(1);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(-1);
        });
    }

    @Test
    void isEmpty_True() {
        TorpedoStore store = new TorpedoStore(0);

        boolean result = store.isEmpty();

        assertEquals(true, result);
    }

    @Test
    void isEmpty_False() {
        TorpedoStore store = new TorpedoStore(1);

        boolean result = store.isEmpty();

        assertEquals(false, result);
    }
}
