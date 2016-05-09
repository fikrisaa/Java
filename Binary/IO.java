/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author FikriSaa
 */

public class IO {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner let = new Scanner(System.in);
        String Awal = "Budi";
        Family_Trees famtr = new Family_Trees(Awal);    
        String fatherN;
        String childN;
        String searchchild;
        String grandpa;
        int sel;
        
        public void Main_Menu(){
        System.out.println("===================");
        System.out.println("The Family Tree App");
        System.out.println("===================");
        System.out.println("1.Menambahkan Anak");
        System.out.println("2.Daftar Anak");
        System.out.println("3.Pencarian Nama Kakek");
        System.out.println("4.Pencarian Nama Paman/Bibi");
        System.out.println("5.Exit");
        System.out.println("Masukkan input : ");
        sel = let.nextInt();
        
        if(sel == 1){
            try{
            System.out.print("Masukkan nama Bapak ");
            fatherN = br.readLine();
            System.out.print("Masukkan nama Anak ");
            childN = br.readLine();
            famtr.TambahAnak(fatherN, childN);
            }catch(IOException ioe){
                System.out.println("Masukkan anda error");
            }
            Main_Menu();
            
        }
        else if(sel == 2){
            try{
                System.out.println("========DAFTAR ANAK=========");
                System.out.print("Masukkan Nama Orang Tua : ");
                fatherN = br.readLine();
                System.out.println("========ANAK "+fatherN+" Adalah :");
                for(Node a : famtr.Children(fatherN))
                    System.out.println(a.data);
            }catch(IOException ioe){
                System.out.println("error");
            }
            Main_Menu();
        }
        else if(sel == 3){
            try{
                System.out.println("========PENCARIAN NAMA KAKEK========");
                System.out.print("Masukkan nama cucu : ");
                childN = br.readLine();
                Node b = famtr.kakek(childN);
                System.out.println("Nama Kakek dari "+childN+" adalah " +b.data);
            } catch(IOException ioe){
                System.out.println("error");
            }
            Main_Menu();
        }
        else if(sel == 4){
            try{
                System.out.println("==========PENCARIAN NAMA PAMAN/BIBI=======");
                System.out.print("Masukkan Nama Ponakan : ");
                childN = br.readLine();
                System.out.println("=====Paman dari "+childN+" = ");
                for(Node b : famtr.Uncle(childN))
                    System.out.println(b.data);
                
            }catch(IOException ioe){
                System.out.println("error");
            }
            Main_Menu();
        }
        else if(sel == 5){
            System.out.println("Terima kasih...");
            System.exit(0);
        }
        }
}