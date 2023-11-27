public class Jigglypuff_skill implements Skill{
    private String[] skill = {
        "이판사판태클 120",
        "치근거리기 90",
        "하이퍼보이스 90",
        "누르기 85"
    };
    public String[] getSkills() {
        return skill;
    }

    public String getName(){
        return "푸린";
    }

    @Override
    public int first(int hp){
        return hp - 120;
    }

    @Override
    public int second(int hp){
        return hp - 90;
    }

    @Override
    public int third(int hp){
        return hp - 90;
    }

    @Override
    public int fourth(int hp){
        return hp - 85;
    }
}
