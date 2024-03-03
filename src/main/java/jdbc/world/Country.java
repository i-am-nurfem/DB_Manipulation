package jdbc.world;

public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;

    public Country(String _code, String _name, String _continent, String _region){
        this.code = _code;
        this.name = _name;
        this.continent = _continent;
        this.region = _region;
    }
}
