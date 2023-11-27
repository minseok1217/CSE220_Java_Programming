public class Eevee_skill implements Skill{
    private String[] skill = {
        "뒀다쓰기 140",
        "이판사판태클 120",
        "돌진 90",
        "물기 60"
    };

    public String getName(){
        return "이브이";
    }

    public String[] getSkills() {
        return skill;
    }

    @Override
    public int first(int hp){
        return hp - 140;
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
        return hp - 60;
    }
}
