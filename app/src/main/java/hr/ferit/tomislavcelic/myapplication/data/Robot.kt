package hr.ferit.tomislavcelic.myapplication.data

class Robot() {
    private var x:Int = 0
    private var y:Int = 0

    init{
        x = 0
        y = 0
    }

    fun goUp(steps:Int){
        x+=steps
    }

    fun goDown(steps:Int){
        x-=steps
    }

    fun goRight(steps: Int){
        y+=steps
    }

    fun goLeft(steps: Int){
        y-=steps
    }

    fun getLocation(){
        println("($x,$y)")
    }
}
