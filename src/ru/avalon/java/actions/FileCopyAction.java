package ru.avalon.java.actions;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    String source;
    String target;

    FileCopyAction(String source, String target) {
        this.source = source;
        this.target = target;
        t = new Thread(this,"copy");
        t.start();
    }

    Thread t;
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        try{
            Files.copy(Paths.get(source), Paths.get(target),
                        StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e)  {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
        try {
            this.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        System.out.println("Всё получилось");
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
}
