package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
public class Movie {
    private String id;
    private String title;
    private String original_title;
    private String original_title_romanised;
    private String image;
    private String movie_banner;
    private String description;
    private String director;
    private String producer;
    private int release_date;
    private int running_time;
    private int rt_score;
    private List<String> people;
    private List<String> species;
    private List<String> locations;
    private List<String> vehicles;
    private String url;
}
