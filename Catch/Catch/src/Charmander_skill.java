public class Charmander_skill implements Skill{
    private String[] skill = {
        "불꽃세례 40",
        "플레어드라이브 120",
        "연옥 100",
        "화염방사 90"
    };
    public String[] getSkills() {
        return skill;
    }

    @Override
    public int first(int hp){
        return 40;
    }

    @Override
    public int second(int hp){
        return 120;
    }

    @Override
    public int third(int hp){
        return 100;
    }

    @Override
    public int fourth(int hp){
        return 90;
    }
}
//     public void fire(){

//     }
//     public void drive(){

//     }
//     public void stone(){

//     }
//     public void flame(){
        
//     }
// }
