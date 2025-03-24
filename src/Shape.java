public abstract class Shape {
    protected Style gangnam;

    public Shape(Style gangnam) {
        this.gangnam = gangnam;
    }

    public Shape(){
    }


    public Style getGangnam() {
        return gangnam;
    }

    public void setGangnam(Style gangnam) {
        this.gangnam = gangnam;
    }
}
