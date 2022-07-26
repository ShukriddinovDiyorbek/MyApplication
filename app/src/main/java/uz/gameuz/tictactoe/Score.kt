package uz.gameuz.tictactoe

class Score {
    var position: Boolean? = null
    get() = field
    set(value) {
        field = value}
    var array: ArrayList<Int>? = null
        get() = field
        set(value) {
            field = value}

    constructor(position: Boolean, array: ArrayList<Int>){
        this.position = position
        this.array = array
    }
    constructor(){

    }

}