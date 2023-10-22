
public class Time {
   private int hour;
   private int minutes;
   private int second;
   
   
   public String toUniversalString() {
      return String.format("%2d : %2d : %2d",getHour(),getMinutes(),getSecond());
   }
   
   public String toString() {
      return String.format("%2d : %2d : %2d %s",(hour==0||hour==12)? 12 : hour%12,
            minutes,second,(hour<12 ? "AM":"PM"));
   }
   public void nextSecond() {
        this.second = this.second + 1;
        if(this.second > 60 ){
            this.minutes += 1;
            this.second -= 60;
        }
        if(this.minutes > 60){
            this.hour += 1;
            this.minutes -= 60;
        }
        if(this.hour > 24){
            this.hour -= 24;
        }
   }
   public void nextMinutes() {
        this.second = this.second + 1;
        if(this.minutes > 60){
            this.hour += 1;
            this.minutes -= 60;
        }
        if(this.hour > 24){
            this.hour -= 24;
        }
   }
   public void nextHour() {
        this.hour += 1;
        if(this.hour > 24){
            this.hour -= 24;
        }
   }
   public void tick() {
        this.second = this.second + 1;
        if(this.second > 60 ){
            this.minutes += 1;
            this.second -= 60;
        }
        if(this.minutes > 60){
            this.hour += 1;
            this.minutes -= 60;
        }
        if(this.hour > 24){
            this.hour -= 24;
        }

   }
   
    public void tickBack() {
        this.second -= 1;
        if(this.second < 0 ){
            this.minutes -= 1;
            this.second += 60;
        }
        if(this.minutes < 0){
            this.hour -= 1;
            this.minutes += 60;
        }
        if(this.hour < 0){
            this.hour += 24;
        }

    }
   
   public Time(Time T) {
      this.hour=T.hour;
      this.minutes=T.minutes;
      this.second=T.second;
   }
   
   public Time() {
      this(0,0,0);
   }
   
   public Time(int h) {
      //this.hour=h;
      //this.minutes=m;
      //this.second=s;
      setTime(h,0,0);
   }
   
   public Time(int h,int m) {
      //this.hour=h;
      //this.minutes=m;
      //this.second=s;
      setTime(h,m,0);
   }
   
   public Time(int h,int m,int s ) {
      //this.hour=h;
      //this.minutes=m;
      //this.second=s;
      setTime(h,m,s);
   }
   
   public void setTime(int h,int m,int s) {
      this.hour=h;
      this.minutes=m;
      this.second=s;
   }
   public int getHour() {
      return hour;
   }
   public void setHour(int hour) {
      this.hour = hour;
   }
   public int getMinutes() {
      return minutes;
   }
   public void setMinutes(int minutes) {
      this.minutes = minutes;
   }
   public int getSecond() {
      return second;
   }
   public void setSecond(int second) {
      this.second = second;
   }
}