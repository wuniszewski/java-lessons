package pl.wojtek;

public enum Sex {
    MALE, FEMALE;

    public static Sex randomSex(){
        if((int) (Math.random()*2) < 1 ){
            return Sex.FEMALE;
        }
        else {
            return Sex.MALE;
        }
    }
}
