package com.company;


import java.io.*;

class Date_Difference {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int month[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


// if there is a leap year:

    int isLeap(int y) {
        if ((y % 400 == 0) || ((y % 100 != 0) && (y % 4 == 0)))
            return 29;
        else
            return 28;
    }

// if date is wrong- will check here

    boolean dateValidate(int d, int m, int y) {
        month[2] = isLeap(y);
        if (m < 0 || m > 12 || d < 0 || d > month[m] || y < 0 || y > 9999)
            return false;
        else
            return true;
    }

    int dayno(int d, int m, int y) {
        int dn = 0;
        month[2] = isLeap(y);

        for (int i = 1; i < m; i++) {
            dn = dn + month[i];
        }
        dn = dn + m;
        for (int i = 1; i < y; i++) {
            if (isLeap(i) == 29)
                dn = dn + 366;
            else
                dn = dn + 365;
        }

        return dn;

    }

    public static void main(String args[]) throws IOException {
        Date_Difference ob = new Date_Difference();
        System.out.print("Enter the 1st date in (mm/DD/yyyy) format: "); //user input date one
        String date1 = br.readLine().trim();
        int p, q;

        //day is pulled away from rest of the date
        p = date1.indexOf("/");
        int d1 = Integer.parseInt(date1.substring(0, p));

        //month is pulled away from rest of the date
        q = date1.lastIndexOf("/");
        int m1 = Integer.parseInt(date1.substring(p + 1, q));

        // year is pulled away from rest of the date
        int y1 = Integer.parseInt(date1.substring(q + 1));

        System.out.print("Enter the 2nd date in (mm/DD/yyyy) format: "); // user input date two
        String date2 = br.readLine().trim();

        p = date2.indexOf("/");
        int d2 = Integer.parseInt(date2.substring(0, p));

        q = date2.lastIndexOf("/");
        int m2 = Integer.parseInt(date2.substring(p + 1, q));

        int y2 = Integer.parseInt(date2.substring(q + 1));

        //Validating both the dates

        if (ob.dateValidate(m1, d1, y1) == true && ob.dateValidate(m2, d2, y2) == true) {
            int a = ob.dayno(m1, d1, y1);
            int b = ob.dayno(m2, d2, y2);

            // outputting both the dates

            System.out.println("Output: Difference in days: = " + Math.abs(m2-m1) + " days.");
            System.out.println("Output: Difference in months: = " + Math.abs(d2-d1) + " months.");
            System.out.println("Output: Difference in years: = " + Math.abs(y2-y1) + " years.");

            } else
                System.out.println("Invalid Date"); // if put in wrong date - invalid will show up


        }
    }

