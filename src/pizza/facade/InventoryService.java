package pizza.facade;

public class InventoryService {
    private int availablePortions;

    public InventoryService(int availablePortions) {
        if (availablePortions < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.availablePortions = availablePortions;
    }

    public void reserve(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > availablePortions) {
            throw new IllegalStateException("Not enough ingredient portions.");
        }
        availablePortions -= quantity;
    }

    public void release(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        availablePortions = Math.addExact(availablePortions, quantity);
    }

    public int getAvailablePortions() {
        return availablePortions;
    }
}
