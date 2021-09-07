package PushService;

import java.util.HashMap;
import java.util.Map;

public class Push implements PushInterface {

    PushRequestManager request;
    Map<String, String> pushKeys;

    public Push(){
        this.request = new PushRequestManager(); //TODO
        this.pushKeys = new HashMap<>();
        this.pushKeys.put("p256dh","BOQi_bWvuBo7Aqyqi8-6bw8bUgmelTegUnQpNKbOA3FIrWeCucDlveHLnfZhFyYM82mo1lmL9Qy5HeRSFs9Zd_o"); //TODO
        this.pushKeys.put("auth","hKKRDK0kgozJ4jaj2qxxkw"); //TODO
    }

    @Override
    public void subscribe(String id, String projectName, String[] groupId, String status, String endpoint) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("id", id);
        requestBody.put("projectName", projectName);
        requestBody.put("groupId", groupId);
        requestBody.put("status", status);
        requestBody.put("endpoint", endpoint);
        requestBody.put("keys", this.pushKeys);

        request.sendPostRequest(requestBody,"/subscribe");
    }

    @Override
    public void deleteSubscribe(String id, String projectName) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("id", id);
        requestBody.put("projectName", projectName);

        request.sendPostRequest(requestBody,"/delete-subscribe");
    }

    @Override
    public void deleteProject(String projectName) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("projectName", projectName);

        request.sendPostRequest(requestBody,"/delete-project");

    }

    @Override
    public void setStatus(String projectName, String id, String newStatus) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("id", id);
        requestBody.put("projectName", projectName);
        requestBody.put("status", newStatus);

        request.sendPostRequest(requestBody,"/set-status");
    }

    @Override
    public void addGroup(String id, String projectName, String[] groupId) {
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("id", id);
        requestBody.put("projectName", projectName);
        requestBody.put("groupId", groupId);

        request.sendPostRequest(requestBody,"/add-group-for-subscribe");
    }

    @Override
    public void deleteGroup(String id, String projectName, String groupId) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("id", id);
        requestBody.put("projectName", projectName);
        requestBody.put("groupId", groupId);

        request.sendPostRequest(requestBody,"/delete-group-for-subscribe");
    }

    @Override
    public void createNotification(String projectName, String notificationName,
                                   String imgUrl, String iconUrl, String onclickUrl, String title, String body) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("notificationName", notificationName);
        requestBody.put("projectName", projectName);
        requestBody.put("imgUrl", imgUrl);
        requestBody.put("iconUrl", iconUrl);
        requestBody.put("onclickUrl", onclickUrl);
        requestBody.put("title", title);
        requestBody.put("body", body);

        request.sendPostRequest(requestBody,"/create-notification");
    }

    @Override
    public void deleteNotification(String projectName, String notificationName) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("projectName", projectName);
        requestBody.put("notificationName", notificationName);

        request.sendPostRequest(requestBody,"/delete-notification");
    }

    @Override
    public void createSchedule(String projectName, String notificationName, String groupId, Integer[] cron) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("projectName", projectName);
        requestBody.put("notificationName", notificationName);
        requestBody.put("groupId", groupId);
        requestBody.put("cron", cron);

        request.sendPostRequest(requestBody,"/create-schedule");
    }

    @Override
    public void cancelSchedule(String projectName, String notificationName) {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("projectName", projectName);
        requestBody.put("notificationName", notificationName);

        request.sendPostRequest(requestBody,"/cancel-schedule");
    }
}
