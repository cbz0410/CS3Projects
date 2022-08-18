public class HorseBarnA {
    public static void main(String[] args) {
        //assume requisitie code is here...
    }
}

class Horse {
    private String name;
    private int weight;

    public Horse(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

class HorseBarn {
    private Horse[] spaces;
    
    public int findHorseSpace(String name) {
        for(int i = 0; i < spaces.length; i++) {
            if(name.equals(spaces[i].getName())) {
                return i;
            }
        }
        return -1;
    }
}
