public class Bulbasaur_skill implements Skill {
    private String[] skill = {
        "솔라빔\n120",
        "이판사판태클\n120",
        "돌진\n90",
        "잎날가르기\n55"
    };

    @Override
    public String[] getSkills() {
        return skill;
    }

    @Override
    public int first(int hp){
        return hp - 120;
    }

    @Override
    public int second(int hp){
        return hp - 120;
    }

    @Override
    public int third(int hp){
        return hp - 90;
    }

    @Override
    public int fourth(int hp){
        return hp - 55;
    }
}