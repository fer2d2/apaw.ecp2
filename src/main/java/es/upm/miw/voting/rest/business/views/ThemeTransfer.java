package es.upm.miw.voting.rest.business.views;

public class ThemeTransfer {

    public String themeName;

    public double themeAverage;

    public ThemeTransfer(String themeName, double themeAverage) {
        super();
        this.themeName = themeName;
        this.themeAverage = themeAverage;
    }

    public String getThemeName() {
        return themeName;
    }

    public double getThemeAverage() {
        return themeAverage;
    }

}
