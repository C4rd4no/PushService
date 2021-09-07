package PushService;

import java.util.Arrays;
import java.util.List;

public interface PushInterface {


    //FELIRATKOZÁS KEZELÉS//


    //A pushManager.subscribe metódusa visszatér egy object-el. Ez lesz kiegészítve egy egyedi id-val, group id-kal,projekt névvel.
    void subscribe(String id, String projectName, String[] groupId, String status, String endpoint); //TODO

    //Az id és a projekt nevével lehet törölni a feliratkozást.
    void deleteSubscribe(String id, String projectName);

    //Adott projekt névvel lehet törölni az ahhoz tartozó összes felirakozást.
    void deleteProject(String projectName);

    //Ha a status "IGNORE" akkor nem kapja meg az értesitéseket, itt érdemes lehet addig IGNORE-ba rakni és a kérdőív generálásával átrakni "OK"-ba.
    void setStatus(String projectName, String id ,String newStatus);

    //Az id és a projekt név alapján hozzá lehet adni csoportokat egy feliratkozóhoz.
    void addGroup(String id, String projectName, String[] groupId);

    //Az id és a projekt név alapján le lehet venni megadott csoportról a feliratkozót.
    void deleteGroup(String id, String projectName, String groupId);


    //ÉRTESITÉS KEZELÉS (Ebben a projektben csak egy fajta értesítés lesz használva)//


    //A projekt és az értesítés nevét megadva tudsz lementi egy értesitést.
    void createNotification(String projectName,String notificationName,
                            String imgUrl, String iconUrl, String onclickUrl, String title, String body);

    //Az értesítés és a projekt nevével tudod törölni az értesítést.
    void deleteNotification(String projectName,String notificationName);


    //ÉRTESITÉS KÜLDÉS//


    //Ezzel tudsz adott projekten belül, egy csoporthoz hozzárendelni időzítést ami az értesítés elküldéséért felel.
    void createSchedule(String projectName, String notificationName, String groupId, Integer[] cron);

    //A projekt és a csoport nevével tudod törölni az időzitést.
    void cancelSchedule(String projectName, String notificationName);

}
