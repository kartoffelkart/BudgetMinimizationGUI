/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancefactory.out;

import instancefactory.service.Graph;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Sonja Schäfer sonja_schaefer@gmx.de
 */
public class Printer {
    
       public void out(Graph currentGraph, String dateiname) {

        File file2 = new File("C:\\Users\\Soyo\\Desktop\\Bachelorarbeit\\Daten\\" + dateiname + "Daten.txt");
//        File file2 = new File("X:\\speedee\\mitarbeiter\\sonja_schäfer\\Bachelorarbeit\\SortedSellsInstance.txt");
        try {
//            file.mkdirs();
            file2.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            PrintWriter pr = new PrintWriter(file2);
            pr.println(0);

            for (int j = 0; j < currentGraph.getEintraege().size(); j++) {

                pr.println(currentGraph.getEintraege().get(j).value);
            }

            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

    }
}
