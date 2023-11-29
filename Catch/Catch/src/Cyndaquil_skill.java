public class Cyndaquil_skill implements Skill{
    private String[] skill = {
        "분화 150",
        "이판사판태클\n120",
        "화염방사 95",
        "분연 80"
    };

    public String getName(){
        return "브케인";
    }

    public String[] getSkills() {
        return skill;
    }

    @Override
    public int first(int hp){
        return hp - 150;
    }

    @Override
    public int second(int hp){
        return hp - 120;
    }

    @Override
    public int third(int hp){
        return hp - 95;
    }

    @Override
    public int fourth(int hp){
        return hp - 80;
    }
}
