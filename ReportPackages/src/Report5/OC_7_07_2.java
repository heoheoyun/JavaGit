package Report5;

import java.util.ArrayList;
import java.util.Scanner;

class Location2 {
    private String cityName;
    private double latitude;
    private double longitude;

    public Location2(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return cityName + "\t" + latitude + "\t" + longitude;
    }
}

public class OC_7_07_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Location2> locations = new ArrayList<>();

        System.out.println("도시, 위도, 경도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String input = sc.nextLine();
            String[] parts = input.split(", ");
            String cityName = parts[0];
            double latitude = Double.parseDouble(parts[1]);
            double longitude = Double.parseDouble(parts[2]);
            Location2 location = new Location2(cityName, latitude, longitude);
            locations.add(location);
        }
        System.out.println();

        System.out.println("--------------------");
        for (Location2 location : locations) {
            System.out.println(location);
        }

        System.out.println("--------------------");
        while (true) {
            System.out.print("도시 이름 >> ");
            String searchCity = sc.next();
            if (searchCity.equals("그만")) break;

            Location2 foundLocation = null;
            for (Location2 location : locations) {
                if (location.getCityName().equals(searchCity)) {
                    foundLocation = location;
                    break;
                }
            }

            if (foundLocation != null) {
                System.out.println(foundLocation);
            } else {
                System.out.println(searchCity + "는 없습니다.");
            }
        }

        sc.close();
    }
}
