package Model

import java.io.Serializable

class PoemModel : Serializable{

    var poemName = ""
    var poem = ""
    var poemType = ""

    constructor(poemName : String, poem : String, poemType : String) {
        this.poemName = poemName
        this.poem = poem
        this.poemType = poemType
    }
}