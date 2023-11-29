public class Squirtle_skill implements Skill{
    private String[] skill = {
        "로케트박치기 130",
        "하이드로펌프 110",
        "아쿠아테일 90",
        "물의파동 60"
    };
    public String[] getSkills() {
        return skill;
    }

    public String getName(){
        return "꼬부기";
    }

    @Override
    public int first(int hp){
        return hp - 130;
    }

    @Override
    public int second(int hp){
        return hp - 110;
    }

    @Override
    public int third(int hp){
        return hp - 90;
    }

    @Override
    public int fourth(int hp){
        return hp - 60;
    }
}
