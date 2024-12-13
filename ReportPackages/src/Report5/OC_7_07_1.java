package Report5;

import java.util.HashMap;
import java.util.Scanner;

class Location {
    private String cityName;
    private double latitude;
    private double longitude;

    public Location(String cityName, int latitude, int longitude) {
        this.cityName = cityName;
        this.latitude = (double)latitude;
        this.longitude = (double)longitude;
    }

    @Override
    public String toString() {
        return cityName + "\t" + latitude + "\t" + longitude;
    }
}

public class OC_7_07_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Location> locations = new HashMap<>();

        System.out.println("도시, 위도, 경도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">>");
            String input = sc.nextLine();
            String[] parts = input.split(", ");
            String cityName = parts[0];
            int latitude = Integer.parseInt(parts[1]);
            int longitude = Integer.parseInt(parts[2]);
            Location location = new Location(cityName, latitude, longitude);
            locations.put(cityName, location);
        }
        System.out.println();
        
        System.out.println("--------------------");
        for (String city : locations.keySet()) {
            System.out.println(locations.get(city));
        }
        
        System.out.println("--------------------");
        while (true) {
            System.out.print("도시 이름 >> ");
            String searchCity = sc.next();
            if (searchCity.equals("그만")) break;
            Location location = locations.get(searchCity);
            if (location != null) {
                System.out.println(location);
            } else {
                System.out.println(searchCity + "는 없습니다.");
            }
        }

        sc.close();
    }
}
