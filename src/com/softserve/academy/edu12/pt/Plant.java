package com.softserve.academy.edu12.pt;

import com.softserve.academy.edu12.pt.Exception.ColorException;
import com.softserve.academy.edu12.pt.Exception.SizeException;
import com.softserve.academy.edu12.pt.Exception.TypeException;

class Plant {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    int size;
    Color color;
    Type type;

    public Plant(int size, Color color, Type type) throws ColorException, TypeException, SizeException {
        validateSize(size);
        validateColorAndType(color, type);
        this.size = size;
        this.color = color;
        this.type = type;
    }

    public void validateSize(int size) throws SizeException {
        if (size < 1 || size > 100) {
            throw new SizeException("Size must be between 1 and 100.");
        }
    }

    public void validateColorAndType(Color color, Type type) throws ColorException, TypeException {
        if (color == null) {
            throw new ColorException("Invalid color provided.");
        }
        if (type == null) {
            throw new TypeException("Invalid type provided.");
        }
    }

    @Override
    public String toString() {
        return "Plant [size=" + size + ", color=" + color + ", type=" + type + "]";
    }
}
