package kiosk.level5part2.kiosk.workOrder;

public enum RateType {
    NationalMeritorious(1, 1,"국가 유공자"),
    Soldier(2, 0.5,"군인"),
    Student(3, 0.1,"학생"),
    Ordinary(4, 0,"일반인");
    private  final int number;
    private  final double rate;
    private  final String typeName;

    RateType(int number, double rate, String typeName)
    {
        this.number = number;
        this.rate = rate;
        this.typeName = typeName;
    }

    public double getRate(){
        return rate;
    }

    public  static  RateType getRate(int number)
    {
        for(RateType rate : RateType.values()){
            if(rate.number == number)
            {
                return rate;
            }
        }
        throw  new IllegalArgumentException("해당 입력은 존재하지 않는 할인 캐아스입니다. 입력:" + number);
    }

}
