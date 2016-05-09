/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_3;

import java.util.ArrayList;

/**
 *
 * @author FikriSaa
 */

public class Family_Trees {
    Node awal;
    int jumlah_node;
    public Family_Trees(String awal){
        Node s = new Node(awal,null);
        this.awal = s;
        this.jumlah_node = 1;
    }
    public int getJumlahNode(){
        return this.jumlah_node;
    }
    public void TambahAnak(String parent,String anak){
        //System.out.println(awal.data);
        Node p = searchNode(parent, awal);
        try {
            p.child.add(new Node(anak, p));
//            System.out.println("Anak yang ditambahkan adalah : "+anak);
//            System.out.println("");
        } catch (Exception e) {
            System.out.println("gagal tambah anak"+e);
        }
        jumlah_node++;
    }
    public Node searchNode(String data,Node node){
        int jmlanak = node.child.size();
//        System.out.println("jumlah anak "+jmlanak);
        Node found = null;
        if(node!=null){
            if(node.data.equals(data)){
                return node;
            }
            else {
                for(int i=0;i<jmlanak;i++){
                    found = searchNode(data, node.child.get(i));
                    if(found!=null){
                        System.out.println("data ="+found.parent.data);
                        break;
                    }
                }
            }
        }
        return found;
    }
    public Node ortu(String anak){
        Node ortu;
        ortu = searchNode(anak, awal).parent;
        return ortu;
    }
    public Node kakek(String cucu){
        Node kakek = null;
        String tmp = cucu;
        for(int i=0;i<2;i++){
            kakek = ortu(tmp);
            tmp = kakek.data;
        }
        return kakek;
    }
    public ArrayList<Node> Children(String namaOrtu){
        Node ortu = searchNode(namaOrtu, awal);
        ArrayList<Node> anak = new ArrayList<Node>();
        for(Node a : ortu.child){
            anak.add(a);
        }
        return anak;
    }
    public ArrayList<Node> Nephew (String namaKakek){
        ArrayList<Node> cucu = new ArrayList<Node>();
        for(Node a : Children(namaKakek)){
            for(Node b : Children(a.data)){
                cucu.add(b);
            }
        }
        return cucu;
    }

    public ArrayList<Node> Uncle(String ponakan){
        ArrayList<Node> paman = new ArrayList<Node>();
        for(Node a:kakek(ponakan).child){
            if(a.data!=ortu(ponakan).data){
                paman.add(a);
            }
        }
        return paman;
    }
}
