package fun_with_arrays.introduction;

public class DVDCollection {
    public static void main(String[] args) {
        DVD[] dvdCollection = new DVD[15];

        // Let's put the DVD for The Avengers into the eighth place of the Array we created above.
        DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon");
        dvdCollection[7] = avengersDVD;

        // And that's it. We've put the DVD for The Avengers into our Array! Let's put a few more DVD's in.
        DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird" );
        DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
        DVD lionKingDVD = new DVD("The Lion King", 2019, "Josh Favreau");
        // Put "The Incredibles" into the 4th place: index 3
        dvdCollection[3] = incrediblesDVD;
        // Put "Finding Dory" into the 10th place: index 9
        dvdCollection[9] = findingDoryDVD;
        // Put "The Lion King" into the 3rd place: index 2
        dvdCollection[2] = lionKingDVD;

        // Overwriting an array cell
//        DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
//        dvdCollection[3] = starWarsDVD;

        // Reading Items from an Array
        // Print out what's in indexes 7, 10, and 3.
        System.out.println(dvdCollection[7]);
        System.out.println(dvdCollection[10]);
        System.out.println(dvdCollection[3]);
    }
}

class DVD {
    String name;
    int releaseYear;
    String director;

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
//        System.out.println(this.name + ", directed by " + this.director + ", released in " + this.releaseYear);
        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
    }
}