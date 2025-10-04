package boomyshow;

public class Movie {
    private  String movieId;
    private  String title;
    private String gene; // categories

    public Movie(String movieId, String title, String gene) {
        this.movieId = movieId;
        this.title = title;
        this.gene = gene;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGene() {
        return gene;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", gene='" + gene + '\'' +
                '}';
    }
}
