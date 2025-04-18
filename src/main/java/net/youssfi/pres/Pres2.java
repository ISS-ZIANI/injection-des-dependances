package net.youssfi.pres;
import net.youssfi.dao.IDao;
import net.youssfi.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\Minfo\\IdeaProjects\\TP\\config.txt"));

        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d =(IDao) cDao.newInstance();


        String metierdaoClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierdaoClassName);
        IMetier metier =(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        //IMetier metier =(IMetier) cMetier.getConstructor().newInstance();
        //Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class, String.class);
        //setDao.invoke(metier,d);

        System.out.println("RES= "+metier.calcul());

    }
}
