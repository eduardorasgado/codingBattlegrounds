package com.eduardocode.challenges;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MaxRestTime {

    public static void main(String[] args) throws ParseException {
        String schedule1 =
                "Sun 10:00-20:00\n"
                        + "Fri 05:00-10:00\n"
                        + "Fri 16:30-23:50\n"
                        + "Sat 10:00-23:59\n"
                        + "Sun 01:00-04:00\n"
                        + "Sat 02:00-06:00\n"
                        + "Tue 03:30-18:15\n"
                        + "Tue 19:00-20:00\n"
                        + "Wed 04:25-15:14\n"
                        + "Wed 15:14-22:40\n"
                        + "Thu 00:00-23:59\n"
                        + "Mon 05:00-13:00\n"
                        + "Mon 15:00-21:00\n";
        System.out.println(solution(schedule1));

        String schedule2 =
                "Mon 01:00-23:00\n"
                        + "Tue 01:00-23:00\n"
                        + "Wed 01:00-23:00\n"
                        + "Thu 01:00-23:00\n"
                        + "Fri 01:00-23:00\n"
                        + "Sat 01:00-23:00\n"
                        + "Sun 01:00-21:00\n";

        System.out.println(solution(schedule2));
    }

    public static int solution(String S) throws ParseException {
        String[] schedules = S.split("\n");

        List<List<Date>> scheduleDates = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("EEE W HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        format.setCalendar(calendar);

        for (String schedule : schedules) {
            String[] dayAndTime = schedule.split(" ");
            String[] currTimeDuo = dayAndTime[1].split("-");

            List<Date> dateList = new ArrayList<>();
            dateList.add(format.parse(dayAndTime[0] + " " + 3 + " " + currTimeDuo[0]));
            dateList.add(format.parse(dayAndTime[0] + " " + 3 + " " + currTimeDuo[1]));

            scheduleDates.add(dateList);
        }

        List<Date> finalSchedule = new ArrayList<>() {
            {
                add(format.parse("Mon " + 4 + " " + "00:00"));
                add(format.parse("Mon " + 4 + " " + "00:00"));
            }
        };
        scheduleDates.add(finalSchedule);

        int scheduleSize = scheduleDates.size();
        for (int i = 0; i < scheduleSize - 1; i++) {
            for (int j = 0; j < scheduleSize - i - 1; j++) {
                if(scheduleDates.get(j).get(0).after(scheduleDates.get(j + 1).get(0))) {
                    Collections.swap(scheduleDates, j, j + 1);
                }
            }
        }

        long maxFreeTimeInMins = 0;
        Date bottomDate = format.parse("Mon " + 3 + " " + "00:00");

        for (int i = 0; i < scheduleDates.size(); i++) {
            List<Date> workTime = scheduleDates.get(i);

            long currFreeTimeInMins = (workTime.get(0).getTime() - bottomDate.getTime()) / 1000 / 60;
            maxFreeTimeInMins = Math.max(maxFreeTimeInMins, currFreeTimeInMins);

            bottomDate = workTime.get(1);
        }

        return (int) maxFreeTimeInMins;
    }
}
