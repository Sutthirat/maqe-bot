import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        directionVersionOne();
        directionVersionTwo();
    }

    private static void directionVersionOne() {
        while (true) {
            String directions = "N";
            int X = 0;
            int Y = 0;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter input: ");
            String str = input.nextLine();
            Pattern patPackageDescription = Pattern.compile("([W][0-9]+|[A-Z,a-z])");
            Matcher matPackageDescription = patPackageDescription.matcher(str);
            while (matPackageDescription.find()) {
                String cha = matPackageDescription.group();
                switch (directions) {
                    case "N":
                        if ("R".equals(cha)) {
                            directions = "E";
                        } else if ("L".equals(cha)) {
                            directions = "W";
                        } else if (cha.contains("W")) {
                            Y += Integer.parseInt(cha.split("W")[1]);
                        }
                        break;
                    case "S":
                        if ("R".equals(cha)) {
                            directions = "W";
                        } else if ("L".equals(cha)) {
                            directions = "E";
                        } else if (cha.contains("W")) {
                            Y -= Integer.parseInt(cha.split("W")[1]);
                        }
                        break;
                    case "E":
                        if ("R".equals(cha)) {
                            directions = "S";
                        } else if ("L".equals(cha)) {
                            directions = "N";
                        } else if (cha.contains("W")) {
                            X += Integer.parseInt(cha.split("W")[1]);
                        }
                        break;
                    case "W":
                        if ("R".equals(cha)) {
                            directions = "N";
                        } else if ("L".equals(cha)) {
                            directions = "S";
                        } else if (cha.contains("W")) {
                            X -= Integer.parseInt(cha.split("W")[1]);
                        }
                        break;
                }
            }
            System.out.println("X: " + X + " Y: " + Y + " Direction: " + Utils.direction.get(directions));
        }
    }

    private static void directionVersionTwo() {
        while (true) {
            String directions = "N";
            int X = 0;
            int Y = 0;
            int turn;
            int walk;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter input: ");
            String str = input.nextLine();
            Pattern patPackageDescription = Pattern.compile("([A-Z][0-9]+|[A-Z,a-z])");
            Matcher matPackageDescription = patPackageDescription.matcher(str);
            while (matPackageDescription.find()) {
                String cha = matPackageDescription.group();
                switch (directions) {
                    case "N":
                        if (cha.contains("R")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("R")[1]);
                                if (turn % 4 == 0)
                                    directions = "N";
                                else if (turn % 4 == 1)
                                    directions = "E";
                                else if (turn % 4 == 2)
                                    directions = "S";
                                else if (turn % 4 == 3)
                                    directions = "W";
                            } else {
                                directions = "E";
                            }
                        } else if (cha.contains("L")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("L")[1]);
                                if (turn % 4 == 0)
                                    directions = "N";
                                else if (turn % 4 == 1)
                                    directions = "W";
                                else if (turn % 4 == 2)
                                    directions = "S";
                                else if (turn % 4 == 3)
                                    directions = "E";
                            } else {
                                directions = "W";
                            }
                        } else {
                            walk = cha.contains("W") ? Integer.parseInt(cha.split("W")[1]) : (Integer.parseInt(cha.split("B")[1]) * -1);
                            Y += walk;
                        }
                        break;
                    case "S":
                        if (cha.contains("R")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("R")[1]);
                                if (turn % 4 == 0)
                                    directions = "S";
                                else if (turn % 4 == 1)
                                    directions = "W";
                                else if (turn % 4 == 2)
                                    directions = "N";
                                else if (turn % 4 == 3)
                                    directions = "E";
                            } else {
                                directions = "W";
                            }
                        } else if (cha.contains("L")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("L")[1]);
                                if (turn % 4 == 0)
                                    directions = "S";
                                else if (turn % 4 == 1)
                                    directions = "E";
                                else if (turn % 4 == 2)
                                    directions = "N";
                                else if (turn % 4 == 3)
                                    directions = "W";
                            } else {
                                directions = "E";
                            }
                        } else {
                            walk = cha.contains("W") ? Integer.parseInt(cha.split("W")[1]) : (Integer.parseInt(cha.split("B")[1]) * -1);
                            Y -= walk;
                        }
                        break;
                    case "E":
                        if (cha.contains("R")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("R")[1]);
                                if (turn % 4 == 0)
                                    directions = "E";
                                else if (turn % 4 == 1)
                                    directions = "S";
                                else if (turn % 4 == 2)
                                    directions = "W";
                                else if (turn % 4 == 3)
                                    directions = "N";
                            } else {
                                directions = "S";
                            }
                        } else if (cha.contains("L")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("L")[1]);
                                if (turn % 4 == 0)
                                    directions = "E";
                                else if (turn % 4 == 1)
                                    directions = "N";
                                else if (turn % 4 == 2)
                                    directions = "W";
                                else if (turn % 4 == 3)
                                    directions = "S";
                            } else {
                                directions = "N";
                            }
                        } else {
                            walk = cha.contains("W") ? Integer.parseInt(cha.split("W")[1]) : (Integer.parseInt(cha.split("B")[1]) * -1);
                            X += walk;
                        }
                        break;
                    case "W":
                        if (cha.contains("R")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("R")[1]);
                                if (turn % 4 == 0)
                                    directions = "W";
                                else if (turn % 4 == 1)
                                    directions = "N";
                                else if (turn % 4 == 2)
                                    directions = "E";
                                else if (turn % 4 == 3)
                                    directions = "S";
                            } else {
                                directions = "N";
                            }
                        } else if (cha.contains("L")) {
                            if (cha.length() > 1) {
                                turn = Integer.parseInt(cha.split("L")[1]);
                                if (turn % 4 == 0)
                                    directions = "W";
                                else if (turn % 4 == 1)
                                    directions = "S";
                                else if (turn % 4 == 2)
                                    directions = "E";
                                else if (turn % 4 == 3)
                                    directions = "N";
                            } else {
                                directions = "S";
                            }
                        } else {
                            walk = cha.contains("W") ? Integer.parseInt(cha.split("W")[1]) : (Integer.parseInt(cha.split("B")[1]) * -1);
                            X -= walk;
                        }
                        break;
                }
            }
            System.out.println("X: " + X + " Y: " + Y + " Direction: " + Utils.direction.get(directions));
        }
    }
}
