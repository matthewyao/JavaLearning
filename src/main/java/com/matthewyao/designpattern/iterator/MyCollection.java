package com.matthewyao.designpattern.iterator;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class MyCollection implements Aggregate {

    private Object[] objects = null;

    public MyCollection(Object[] objects) {
        this.objects = objects;
    }

    public int size() {
        return objects == null ? 0 : objects.length;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{

        private int index;
        private int size;

        public MyIterator() {
            this.index = 0;
            this.size = objects == null ? 0 : objects.length;
        }

        @Override
        public Object first() {
            return objects == null ? null : objects[0];
        }

        @Override
        public Object last() {
            return objects == null ? null : objects[size - 1];
        }

        @Override
        public Object next() {
            if (index >= 0 && index < size) {
                return objects[index++];
            }else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }
    }
}
