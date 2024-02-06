package org.example.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyIO {
    private BufferedReader bread = new BufferedReader(new InputStreamReader((System.in)));

    public String getUserString(String prompt, boolean isRequired) {
        String strReturn = null;
        boolean bLoop = true;
        while (bLoop) {
            if (prompt != null) {
                System.out.println(prompt);
            }
            try {
                strReturn = bread.readLine();
                bLoop = (isRequired && (strReturn.length() < 1));
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return strReturn;
    }

    public int getUserInt(String prompt, boolean isRequired) {
        boolean bLoop = true;
        int iReturn = 0;
        while (bLoop) {
            try {
                iReturn = Integer.parseInt(getUserString(prompt, isRequired));
                bLoop = false;
            } catch (Exception ex) {
                if (iReturn == 0 && !isRequired) {
                    return iReturn;
                }
                System.out.println("Invalid input, please try again.");
            }
        }
        return iReturn;
    }

    public int getUserInt(String prompt, int min, int max, boolean isRequired) {
        boolean bLoop = true;
        int userValue;
        do {
            userValue = getUserInt(prompt, isRequired);
            if (userValue >= min && userValue <= max) {
                bLoop = false;
            } else if (!isRequired) {
                bLoop = false;
            } else {
                System.out.println("Enter a value withing range.");
            }
        } while (bLoop);
        return userValue;
    }

    public void printMessages(String prompt) {
        System.out.println(prompt);
    }
}
