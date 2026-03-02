/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atakats;

/**
 *
 * @author h
 */
public class ReconnaissanceAttack extends Attack {
    private Techniques technique;
    
    public ReconnaissanceAttack(Techniques technique) {
        super();
        this.technique = technique;
    }
    
    public ReconnaissanceAttack() {
        super();
        this.technique = Techniques.getRandomValue();
    }
    
    public Techniques getTechnique() {
        return technique;
    }
    
    public void setTechnique(Techniques technique) {
        this.technique = technique;
    }
    
    @Override
    public String getDescription() {
        return "S'ha interceptat un atac de reconeixement d'" + technique.getDescription();
    }
}
