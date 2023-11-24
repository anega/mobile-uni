package com.example.lab3.models

import com.example.lab3.models.Data.Movie
import com.example.lab3.models.Data.Person

class DataRepository {
    fun getData(): List<Any> {
        return listOf(
            Movie(
                id = 1075794,
                posterPath = "https://image.tmdb.org/t/p/w342/gSOVog7ydsaF1YpgAqBqnKYFGY.jpg",
                title = "Leo",
                overview = "Jaded 74-year-old lizard Leo has been stuck in the same Florida classroom for decades with his terrarium-mate turtle. When he learns he only has one year left to live, he plans to escape to experience life on the outside but instead gets caught up in the problems of his anxious students — including an impossibly mean substitute teacher.",
                mediaType = "movie",
                releaseDate = "2023-11-11",
                voteAverage = 7.18,
                voteCount = 25
            ),
            Person(
                id = 1373659,
                name = "Melissa Barrera",
                profilePath = "https://image.tmdb.org/t/p/w342/kJMecAOP5DEhJEQ6ScM23MfKPn3.jpg",
                mediaType = "person",
                gender = "female",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Scream", "Scream VI", "Bed Rest")
            ),
            Person(
                id = 2963,
                name = "Nicolas Cage",
                profilePath = "https://image.tmdb.org/t/p/w342/ar33qcWbEgREn07ZpXv5Pbj8hbM.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("The Croods", "National Treasure", "Ghost Rider")
            ),
            Movie(
                id = 872585,
                posterPath = "https://image.tmdb.org/t/p/w342/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
                title = "Oppenheimer",
                overview = "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.",
                mediaType = "movie",
                releaseDate = "2023-07-19",
                voteAverage = 8.178,
                voteCount = 4751
            ),
            Movie(
                id = 901362,
                posterPath = "https://image.tmdb.org/t/p/w342/bkpPTZUdq31UGDovmszsg2CchiI.jpg",
                title = "Trolls Band Together",
                overview = "When Branch’s brother, Floyd, is kidnapped for his musical talents by a pair of nefarious pop-star villains, Branch and Poppy embark on a harrowing and emotional journey to reunite the other brothers and rescue Floyd from a fate even worse than pop-culture obscurity.",
                mediaType = "movie",
                releaseDate = "2023-10-12",
                voteAverage = 6.508,
                voteCount = 60
            ),
            Person(
                id = 138,
                name = "Quentin Tarantino",
                profilePath = "https://image.tmdb.org/t/p/w342/1gjcpAa99FAOWGnrUvHEXXsRs7o.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Directing",
                knownFor = arrayOf("Pulp Fiction", "Django Unchained", "Inglourious Basterds")
            ),
            Movie(
                id = 695721,
                posterPath = "https://image.tmdb.org/t/p/w342/mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg",
                title = "The Hunger Games: The Ballad of Songbirds & Snakes",
                overview = "64 years before he becomes the tyrannical president of Panem, Coriolanus Snow sees a chance for a change in fortunes when he mentors Lucy Gray Baird, the female tribute from District 12.",
                mediaType = "movie",
                releaseDate = "2023-11-15",
                voteAverage = 7.238,
                voteCount = 294
            ),
            Person(
                id = 1311463,
                name = "Francisco Payó González",
                profilePath = null,
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Writing",
                knownFor = arrayOf("Saving Private Pérez", "Cinderello", "Flying low")
            ),
            Person(
                id = 1622390,
                name = "Lee Chae-dam",
                profilePath = "https://image.tmdb.org/t/p/w342/7wMyr6F3yzvbSpu2XMxSW3vObED.jpg",
                mediaType = "person",
                gender = "female",
                knownForDepartment = "Acting",
                knownFor = arrayOf("My Wife's Sister", "Mother's Job", "Swapping: A Divorce Trip Between Two Couples")
            ),
            Person(
                id = 500,
                name = "Tom Cruise",
                profilePath = "https://image.tmdb.org/t/p/w342/eOh4ubpOm2Igdg0QH2ghj0mFtC.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Edge of Tomorrow", "Oblivion", "Mission: Impossible - Ghost Protocol")
            ),
            Movie(
                id = 670292,
                posterPath = "https://image.tmdb.org/t/p/w342/vBZ0qvaRxqEhZwl6LWmruJqWE8Z.jpg",
                title = "The Creator",
                overview = "Amid a future war between the human race and the forces of artificial intelligence, a hardened ex-special forces agent grieving the disappearance of his wife, is recruited to hunt down and kill the Creator, the elusive architect of advanced AI who has developed a mysterious weapon with the power to end the war—and mankind itself.",
                mediaType = "movie",
                releaseDate = "2023-09-27",
                voteAverage = 7.218,
                voteCount = 985
            ),
            Person(
                id = 1708576,
                name = "Ahn So-hee",
                profilePath = "https://image.tmdb.org/t/p/w342/q6DJet94KucWTMFxpsQvPPYSf82.jpg",
                mediaType = "person",
                gender = "female",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Prostitution", "What Happened at the Carpenter's Shop", "Young Mother: The Original")
            ),
            Movie(
                id = 798362,
                posterPath = "https://image.tmdb.org/t/p/w342/bcuEjrwhp5HgEUnFe5lc4xpEqzt.jpg",
                title = "The Marsh King's Daughter",
                overview = "Helena, a woman living a seemingly ordinary life, hides a dark secret—her father is the infamous 'Marsh King', the man who kept her and her mother captive in the wilderness for years. After a lifetime of trying to escape her past, Helena is forced to face her demons when her father unexpectedly escapes from prison.",
                mediaType = "movie",
                releaseDate = "2023-09-28",
                voteAverage = 5.909,
                voteCount = 11
            ),
            Movie(
                id = 753342,
                posterPath = "https://image.tmdb.org/t/p/w342/xzUnkQGqPjL14wQYBk2MnpKF9kl.jpg",
                title = "Napoleon",
                overview = "A personal look at the French military leader’s origins and swift, ruthless climb to emperor, viewed through the prism of Napoleon’s addictive, volatile relationship with his wife and one true love, Josephine.",
                mediaType = "movie",
                releaseDate = "2023-11-22",
                voteAverage = 6.7,
                voteCount = 16
            ),
            Movie(
                id = 1001884,
                posterPath = "https://image.tmdb.org/t/p/w342/AnfXxsoLBS6JDpu65vHsEvEcWSA.jpg",
                title = "Dashing Through the Snow",
                overview = "Eddie Garrick is a good-hearted man who has lost his belief in the wonder of Christmas. While spending time with his nine-year-old daughter Charlotte on Christmas Eve, he befriends a mysterious man in a red suit named Nick.",
                mediaType = "movie",
                releaseDate = "2023-11-17",
                voteAverage = 7.9,
                voteCount = 20
            ),
            Movie(
                id = 1022796,
                posterPath = "https://image.tmdb.org/t/p/w342/vgJZSqKMXWDDx09iSIStGKfHMku.jpg",
                title = "Wish",
                overview = "Asha, a sharp-witted idealist, makes a wish so powerful that it is answered by a cosmic force – a little ball of boundless energy called Star. Together, Asha and Star confront a most formidable foe - the ruler of Rosas, King Magnifico - to save her community and prove that when the will of one courageous human connects with the magic of the stars, wondrous things can happen.",
                mediaType = "movie",
                releaseDate = "2023-11-13",
                voteAverage = 7.5,
                voteCount = 13
            ),
            Person(
                id = 18897,
                name = "Jackie Chan",
                profilePath = "https://image.tmdb.org/t/p/w342/nraZoTzwJQPHspAVsKfgl3RXKKa.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Rush Hour", "Rush Hour 2", "Rush Hour 3")
            ),
            Person(
                id = 976,
                name = "Jason Statham",
                profilePath = "https://image.tmdb.org/t/p/w342/whNwkEQYWLFJA8ij0WyOOAD5xhQ.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Snatch", "The Meg", "The Transporter")
            ),
            Person(
                id = 5292,
                name = "Denzel Washington",
                profilePath = "https://image.tmdb.org/t/p/w342/jj2Gcobpopokal0YstuCQW0ldJ4.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("The Equalizer", "The Book of Eli", "Flight")
            ),
            Movie(
                id = 507089,
                posterPath = "https://image.tmdb.org/t/p/w342/j9mH1pr3IahtraTWxVEMANmPSGR.jpg",
                title = "Five Nights at Freddy's",
                overview = "Recently fired and desperate for work, a troubled young man named Mike agrees to take a position as a night security guard at an abandoned theme restaurant: Freddy Fazbear's Pizzeria. But he soon discovers that nothing at Freddy's is what it seems.",
                mediaType = "movie",
                releaseDate = "2023-10-25",
                voteAverage = 7.901,
                voteCount = 2410
            ),
            Person(
                id = 1336,
                name = "Jet Li",
                profilePath = "https://image.tmdb.org/t/p/w342/c4s8INzU0ZAujCQ1YmphCmcsNzl.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("The Expendables", "The Expendables 2", "The Mummy: Tomb of the Dragon Emperor")
            ),
            Person(
                id = 3292,
                name = "Nicholas Hoult",
                profilePath = "https://image.tmdb.org/t/p/w342/laeAYQVBV9U3DkJ1B4Cn1XhpT8P.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Mad Max: Fury Road", "Warm Bodies", "X-Men: Apocalypse")
            ),
            Person(
                id = 974169,
                name = "Jenna Ortega",
                profilePath = "https://image.tmdb.org/t/p/w342/q1NRzyZQlYkxLY07GO9NVPkQnu8.jpg",
                mediaType = "person",
                gender = "female",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Wednesday", "Scream", "X")
            ),
            Person(
                id = 5655,
                name = "Wes Anderson",
                profilePath = "https://image.tmdb.org/t/p/w342/5z2WroP0CgQ5vI17M0hzi8o5NAn.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Directing",
                knownFor = arrayOf("The Grand Budapest Hotel", "Moonrise Kingdom", "Fantastic Mr. Fox")
            ),
            Person(
                id = 1814668,
                name = "James L. Heyward",
                profilePath = null,
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Directing",
                knownFor = arrayOf("Outer Banks", "The System", "Sophie and the Rising Sun")
            ),
            Person(
                id = 19292,
                name = "Adam Sandler",
                profilePath = "https://image.tmdb.org/t/p/w342/hf5NHpMg8o9zGRHVNgNSl1re6AY.jpg",
                mediaType = "person",
                gender = "male",
                knownForDepartment = "Acting",
                knownFor = arrayOf("Hotel Transylvania", "Pixels", "50 First Dates")
            )
        )
    }
}