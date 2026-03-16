/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package genericclasses;
/**
 *
 * @author h
 */
public class LlistaDinamica<T> {
    Node<T> inici;
    int numNodes;
    
    public LlistaDinamica() {
        inici = null;
        numNodes = 0;
    }
    
    public void BuidarLlista() {
        inici = null;
    }
    
    public int ComptarNodes() {
        while (!(inici = null)) {
            numNodes++;
        }
        return numNodes;
    }
    public void EsborrarNode() {
        if (!(inici = null)) {
            inici = null;
        }
    }
}
