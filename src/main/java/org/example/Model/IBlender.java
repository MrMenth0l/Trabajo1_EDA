package org.example.Model;

public interface IBlender {
    public byte checkPowerStatus();
    public byte switchPowerStatus();
    /**
    * Method to fill the blender with a product.
    * @param prod A string representing the product the user is filling the
    blender with.
    * @return None
    * This method doesn't return any value as it is simply used to fill the
    blender with the specified product.
    **/
    public void fillBlender(String prod, float ml);
    public float actualCapacity();
    public void fillBlender(String prod);
    /**
    * Method to increase the speed of the blender.
    * @return None
    * This method increases the speed of the blender by one unit.
    * No value is returned since the operation modifies the internal state of
    the blender.
    **/
    public void increaseSpeed();
    /**
    * Method to decrease the speed of the blender.
    * @return None
    * This method decreases the speed of the blender by one unit.
    * No value is returned since the operation modifies the internal state of
    the blender.
    **/
    public void decreaseSpeed();
    /**
    * Method to check the current speed of the blender.
    * @return byte The current speed of the blender.
    * This method returns the current speed of the blender as a byte value.
    **/
    public byte checkSpeed();
    /**
    * Method to check if the blender is full.
    * @return boolean True if the blender is full, false otherwise.
    * This method checks whether the blender has reached its maximum capacity.
    **/
    public boolean isFull();
    /**
    * Method to empty the blender.
    * @return None
    * This method empties the contents of the blender.
    * No value is returned since the operation modifies the internal state of
    the blender.
    **/
    public void emptyBlender();
    public void emptyBlender(float ml);
    }
