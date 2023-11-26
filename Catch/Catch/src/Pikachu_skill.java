public class Pikachu_skill implements Skill{
    private String[] skill = {
        "번개 120",
        "방전 80",
        "10만볼트 95",
        "전광석화 40"
    };

    public String[] getSkills() {
        return skill;
    }

    @Override
    public int first(int hp){
        return hp - 120;
    }

    @Override
    public int second(int hp){
        return hp - 80;
    }

    @Override
    public int third(int hp){
        return hp - 95;
    }

    @Override
    public int fourth(int hp){
        return hp - 40;
    }

    
}
