package com.techelevator.filereader;

import com.techelevator.Money;
import com.techelevator.view.Menu;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * This would be a GREAT place to have a public method that could take a formatted String and log it out to a file.
 */
public class LogFileWriter {
    private Money money = new Money();
    private Menu menu = new Menu();
    Scanner userInput = new Scanner(System.in);
    File logFile = new File("Log.txt");

    public void logWriter(String action, double balance, double updatedBalance) {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String dateTimestamp = timeStamp.format(dateTimeFormatter);

        String logEntry = dateTimestamp + " " + action + ": $" + balance + " $" + updatedBalance;

        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(logFile, true))) {
            dataOutput.println(logEntry);

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }
}

