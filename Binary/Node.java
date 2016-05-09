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

public class Node {
    Node parent;
    ArrayList<Node> child = new ArrayList<Node>();
    String data;
    public Node(String awal, Node parent){
        this.data = awal;
        this.parent = parent;
    }
}