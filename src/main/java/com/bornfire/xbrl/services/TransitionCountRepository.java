package com.bornfire.xbrl.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

@Service
public class TransitionCountRepository {
    private static final String URL = "jdbc:oracle:thin:@103.224.241.244:1521/orcl";
    private static final String USER = "CXBRL";
    private static final String PASSWORD = "xbrl";

    public String calculateAndPrintTransitionCounts(String yearRange) {
        String sql = "SELECT status_start, status_end, transition_count " +
                     "FROM transition_data " +
                     "WHERE some_condition_based_on_year_range";  // Adjust this condition

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String statusStart = resultSet.getString("status_start");
                String statusEnd = resultSet.getString("status_end");
                int transitionCount = resultSet.getInt("transition_count");

                System.out.println(statusStart + " to " + statusEnd + ": " + transitionCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return sql;
    }

    public static void main(String[] args) {
        TransitionCountRepository repository = new TransitionCountRepository();
        repository.calculateAndPrintTransitionCounts("2014-2015");
    }
}
