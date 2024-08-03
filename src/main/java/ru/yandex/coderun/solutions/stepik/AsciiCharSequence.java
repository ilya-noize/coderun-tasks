package ru.yandex.coderun.solutions.stepik;

/**
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 */
public class AsciiCharSequence implements CharSequence {
    private final byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    public AsciiCharSequence(String array) {
        this.array = array.getBytes();
    }

    @Override
    public int length() {

        return array.length;
    }

    @Override
    public char charAt(int index) {

        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subArray = new byte[end - start];
        int j = 0;
        for (int i = start; i < end; i++) {
            subArray[j++] = array[i];
        }

        return new AsciiCharSequence(subArray);
    }

    @Override
    public String toString() {

        return new String(array);
    }
}

