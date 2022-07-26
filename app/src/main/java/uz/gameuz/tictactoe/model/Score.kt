package uz.gameuz.tictactoe.model

class Score {
    var position: Boolean? = null
    get() = field
    set(value) {
        field = value}
    var array: ArrayList<Int>? = null
        get() = field
        set(value) {
            field = value}
    var win: Boolean? = null
        get() = field
        set(value) {
            field = value}
    constructor(position: Boolean, array: ArrayList<Int>,win :Boolean){
        this.position = position
        this.array = array
        this.win = win
    }
    constructor(){

    }

}