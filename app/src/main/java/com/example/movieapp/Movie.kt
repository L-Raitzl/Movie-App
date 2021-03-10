package com.example.movieapp

data class Movie (
    var title: String = "Whiplash",
    var rating: Float = 4.0f,
    var genre: String = "Drama, Music",
    var director: String = "Damien Chazelle",
    var actors: String = "Miles Teller, J.K. Simmons",
    var story: String = "Andrew Neiman is a talented 19-year-old drummer and attends the (fictional) Shaffer Conservatory of Music in New York City. " +
            "One day he was discovered by the head of the studio band, Terence Fletcher. The band leader tries to spur his students on to top " +
            "performance through sadistic severity and verbal humiliation. Andrew is increasingly exposed to \"carrot and stick\" psychological violence. \n\n" +
            "Increasingly, he sees through the methods, but gets involved with them. He even separates from his girlfriend Nicole so that he can concentrate " +
            "exclusively on his music career. Due to Fletchers enormous pressure to be on time, Andrew causes a car accident and comes to a performance injured. " +
            "He cannot play in his condition and Fletcher throws him out of the band. Andrew freaks out, throws himself at Fletcher and beats him, whereupon he is " +
            "expelled from the Conservatory. \n\n Meanwhile, after the suicide of a former student, the supervisor learns of Fletchers degrading methods. Reluctantly, " +
            "Andrew is persuaded to testify anonymously against his teacher. Fletcher then loses his job."
)