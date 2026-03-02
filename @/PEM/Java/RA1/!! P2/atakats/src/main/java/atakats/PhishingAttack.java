/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package atakats;

/**
 *
 * @author h
 */
import java.util.Random;

public class PhishingAttack extends Attack implements Impactable {
    private Channels channel;
    private int impact;
    
    public PhishingAttack(Channels channel, int impact) {
        super();
        this.channel = channel;
        this.impact = impact;
    }
    
    public PhishingAttack() {
        super();
        this.channel = Channels.getRandomValue();
        this.impact = new Random().nextInt(10) + 1;
    }
    
    public Channels getChannel() {
        return channel;
    }
    
    public void setChannel(Channels channel) {
        this.channel = channel;
    }
    
    public int getImpact() {
        return impact;
    }
    
    public void setImpact(int impact) {
        this.impact = impact;
    }
    
    @Override
    public String getDescription() {
        return "Intent de Phishing enviat per: " + channel;
    }
    
    @Override
    public int impacte() {
        return impact;
    }
    
    @Override
    public String toString() {
        return super.toString().replace("}", " impacte=" + impacte() + "}");
    }
}
