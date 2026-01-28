package tendaBicis;

public class Bicicleta {
    private static int nombreBicisCreades = 0;
    private int id;
    private int nMarxes;
    private int rodaDM;
    private char talla;
    private boolean venuda;
    
    public Bicicleta(int id) throws ExcepcioBicicleta {
        if (nombreBicisCreades >= 20) {
            throw new ExcepcioBicicleta("No es poden crear més de 20 bicis");
        }
        this.id = id;
        this.venuda = false;
        nombreBicisCreades++;
    }
    
    public Bicicleta(int id, int nMarxes) throws ExcepcioBicicleta {
        if (nombreBicisCreades >= 20) {
            throw new ExcepcioBicicleta("No es poden crear més de 20 bicis");
        }
        this.id = id;
        this.nMarxes = nMarxes;
        this.venuda = false;
        nombreBicisCreades++;
    }
    
    public Bicicleta(int id, int nMarxes, int rodaDM) throws ExcepcioBicicleta {
        if (nombreBicisCreades >= 20) {
            throw new ExcepcioBicicleta("No es poden crear més de 20 bicis");
        }
        this.id = id;
        this.nMarxes = nMarxes;
        this.rodaDM = rodaDM;
        this.venuda = false;
        nombreBicisCreades++;
    }
    
    public Bicicleta(int id, int nMarxes, int rodaDM, char talla) throws ExcepcioBicicleta {
        if (nombreBicisCreades >= 20) {
            throw new ExcepcioBicicleta("No es poden crear més de 20 bicis");
        }
        this.id = id;
        this.nMarxes = nMarxes;
        this.rodaDM = rodaDM;
        this.talla = talla;
        this.venuda = false;
        nombreBicisCreades++;
    }
    
    public int getId() {
        return id;
    }
    
    public int getNMarxes() {
        return nMarxes;
    }
    
    public int getRodaDM() {
        return rodaDM;
    }
    
    public char getTalla() {
        return talla;
    }
    
    public boolean isVenuda() {
        return venuda;
    }
    
    public static int getNombreBicisCreades() {
        return nombreBicisCreades;
    }
    
    public void setId(int id) {
        if (id >= 0 && id <= 20) {
            this.id = id;
        }
    }
    
    public void setNMarxes(int nMarxes) {
        if (nMarxes >= 1 && nMarxes <= 6) {
            this.nMarxes = nMarxes;
        }
    }
    
    public void setRodaDM(int rodaDM) {
        if (rodaDM >= 14 && rodaDM <= 29) {
            this.rodaDM = rodaDM;
        }
    }
    
    public void setTalla(char talla) {
        if (talla == 'S' || talla == 'M' || talla == 'L') {
            this.talla = talla;
        }
    }
    
    public void setVenuda(boolean venuda) {
        this.venuda = venuda;
    }
    
    @Override
    public String toString() {
        return "Bicicleta [ID=" + id + 
               ", Marxes=" + nMarxes + 
               ", Roda=" + rodaDM + "\"" +
               ", Talla=" + talla + 
               ", Venuda=" + (venuda ? "Sí" : "No") + "]";
    }
}