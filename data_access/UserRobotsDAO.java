package com.example.tpd_server.data_access;

//import com.example.connection_package.ConnectionHelper;
import com.example.tpd_server.models.Robot;
import com.example.tpd_server.models.UserRobots;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRobotsDAO {

    public static ArrayList<UserRobots> getAll() {
        ArrayList<UserRobots> result = new ArrayList<>();

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM public.\"UserRobots\"")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(new UserRobots(resultSet.getInt(1),
                        resultSet.getInt(2)));
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<Robot> getRobotsForUser(int userId){
		// or userRobots _____________________________________________________________________!!!_________________________________________
		
        List<UserRobots> ownedRobots = UserRobotsDAO.getAll().stream().filter(userRobot -> userRobot.getUserId() == userId).collect(Collectors.toList());
        List<Robot> robots = new ArrayList<>();
        for(UserRobots userRobot: ownedRobots){
           robots.add(RobotDAO.get(userRobot.getRobotId()));
        }

        return robots;
    }

    public static void add(UserRobots userRobots) {
        if (userRobots == null) {
            return;
        }

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO public.\"UserRobots\"(\n" +
                     "\t\"userId\", \"RobotId\")\n" +
                     "\tVALUES (?, ?);")) {

            preparedStatement.setInt(1, userRobots.getUserId());
            preparedStatement.setInt(2, userRobots.getRobotId());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int userId, int RobotId) {

        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM public.\"userRobots\" WHERE \"userId\" = ? AND \"robotId\" = ?")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, RobotId);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
