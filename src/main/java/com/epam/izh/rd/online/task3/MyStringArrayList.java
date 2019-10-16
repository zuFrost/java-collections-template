package com.epam.izh.rd.online.task3;

import java.util.*;

import static java.util.Collections.*;

public class MyStringArrayList implements List<String> {

    private String[] values;

    /**
     * @return Текущий размер этой коллекции
     */
    @Override
    public int size() {
        return 0; //TODO
    }

    /**
     * @return Пустая или нет эта коллекция
     */
    @Override
    public boolean isEmpty() {
        return false; //TODO
    }

    /**
     * @return Содержит ли эта коллекция параметр o
     */
    @Override
    public boolean contains(Object o) {
        return false; //TODO
    }

    /**
     * @return Копию массива {@link MyStringArrayList#values}
     */
    @Override
    public Object[] toArray() {
        return new Object[0]; //TODO
    }

    /**
     * @param s Элемент для добавления в эту коллекцию
     * @return Был ли добавлен элемент
     */
    @Override
    public boolean add(String s) {
        return false; //TODO
    }

    /**
     * @param o Элемент для удаления из этой коллекции
     * @return Был ли удален элемент
     */
    @Override
    public boolean remove(Object o) {
        return false; //TODO
    }

    /**
     * @param c Коллекция для проверки
     * @return Содержатся ли элементы из коллекции с в этой коллекции
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return false; //TODO
    }

    /**
     * @param c Коллекция для добавления в конец {@link MyStringArrayList}
     * @return Добавился ли хоть один элемент из коллекции c
     */
    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false; //TODO
    }

    /**
     * Метод полного очищения этой коллекции
     */
    @Override
    public void clear() {
        //TODO
    }

    /**
     * @param index элемента из этой коллекции
     * @return элемент
     */
    @Override
    public String get(int index) {
        return null; //TODO
    }

    /**
     * @param index заменяемого элемента
     * @param element на который заменяется
     * @return элемент, который был заменен
     */
    @Override
    public String set(int index, String element) {
        return null; //TODO
    }

    /**
     * @param index на место которого встанет новый элемент. Сдвигает все элементы справа на 1 позицию вперед
     * @param element новый
     */
    @Override
    public void add(int index, String element) {
        //TODO
    }

    /**
     * @param index удаляемого элемента. Все элементы справа на 1 позицию назад
     * @return элемент
     */
    @Override
    public String remove(int index) {
        return null; //TODO
    }

    /**
     * @param o искомый элемент
     * @return первый индекс, в котором находится искомый элемент
     */
    @Override
    public int indexOf(Object o) {
        return 0; //TODO
    }


    // -----------------------------------------------------------------------------------------------------
    // Методы ниже реализовывать не требуется
    // -----------------------------------------------------------------------------------------------------
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return emptyList();
    }

    @Override
    public ListIterator<String> listIterator() {
        return emptyListIterator();
    }
    @Override
    public ListIterator<String> listIterator(int index) {
        return emptyListIterator();
    }

    @Override
    public Iterator<String> iterator() {
        return emptyListIterator();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
}
