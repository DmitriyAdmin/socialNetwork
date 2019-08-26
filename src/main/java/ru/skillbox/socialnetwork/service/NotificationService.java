package ru.skillbox.socialnetwork.service;

import org.apache.commons.lang3.time.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.skillbox.socialnetwork.api.response.AuthorApi;
import ru.skillbox.socialnetwork.api.response.NotificationApi;
import ru.skillbox.socialnetwork.api.response.NotificationListApi;
import ru.skillbox.socialnetwork.api.response.ResponseApi;
import ru.skillbox.socialnetwork.dao.FriendsDAO;
import ru.skillbox.socialnetwork.dao.NotificationDAO;
import ru.skillbox.socialnetwork.dao.PersonDAO;
import ru.skillbox.socialnetwork.mapper.NotificationMapper;
import ru.skillbox.socialnetwork.model.Notification;
import ru.skillbox.socialnetwork.model.NotificationType;
import ru.skillbox.socialnetwork.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private NotificationListApi notificationListApi;

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private FriendsDAO friendsDAO;
    @Autowired
    private AccountService accountService;

    @Autowired
    private NotificationDAO notificationDAO;

    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private ModelMapper mapper;

    public ResponseApi getAllNotification(int offset, int itemPerPage) {

        postBdayNotifications();

        List<Notification> notifications = notificationDAO.getNotificationByPersonId(getCurrentPersonId());
        notifications = rangeNotifications(notifications, offset, itemPerPage);
        if (notifications == null || notifications.isEmpty()) {
            return new NotificationListApi();
        }
        ResponseApi responseApi = new ResponseApi();
        notificationListApi = new NotificationListApi();
        List<NotificationApi> notificationApis = new ArrayList<>();
        for(Notification notification : notifications)
        {
            NotificationApi notificationApi = notificationMapper.toApi(notification);
            notificationApi.setEntityAuthor(mapper.map(personDAO.getPersonById(notification.getEntityId()), AuthorApi.class));
            if(notification.getNotificationType().getName().toString().equals("FRIEND_BIRTHDAY")){
                notificationApi.setInfo("День рождение друга! Поздравьте его!");
            }
            notificationApis.add(notificationApi);
        }
//        notificationListApi.setData(notifications.stream().map(notificationMapper::toApi)
//                .collect(Collectors.toList()));
        notificationListApi.setData(notificationApis);
        notificationListApi.setTotal(notifications.size());
        notificationListApi.setOffset(offset);
        notificationListApi.setPerPage(itemPerPage);
        notificationListApi.setSuccess(true);
        return notificationListApi;
    }

    private List<Notification> rangeNotifications(List<Notification> notifications, int offset, int itemPerPage) {
        if (notifications == null || notifications.isEmpty() || offset > notifications.size()) {
            return null;
        }

        List<Notification> rangedList = new ArrayList<>();
        if (offset < 0) {
            offset = 0;
        }
        int lastNumber = offset + itemPerPage;
        if (lastNumber > notifications.size()) {
            lastNumber = notifications.size();
        }

        for (int i = offset; i < lastNumber; i++) {
            rangedList.add(notifications.get(i));
        }

        return rangedList;
    }

    public ResponseApi readNotification(int id, boolean all) {
        List<Notification> notifications;
        if (all) {
            notifications = notificationDAO.getNotificationByPersonId(getCurrentPersonId());
        } else {
            notifications = new ArrayList<>();
            notifications.add(notificationDAO.getNotificationById(id));
        }

        notifications.forEach(n -> n.setReaded(true));
        notifications.forEach(n -> notificationDAO.updateNotification(n));

        ResponseApi responseApi = new ResponseApi();
        notificationListApi = new NotificationListApi();
        notificationListApi.setData(notifications.stream().map(notificationMapper::toApi)
                .collect(Collectors.toList()));
        notifications.forEach(notificationDAO::deleteNotification);
        notificationListApi.setTotal(notifications.size());
        notificationListApi.setSuccess(true);
        return notificationListApi;
    }

    void postBdayNotifications(){
        List<Person> friends = friendsDAO.getAllFriends();

        Date today = new Date();
        for(Person friend : friends){
            if(DateUtils.isSameDay(today,friend.getBirthDate())){
                Notification notification = new Notification();
                NotificationType notificationType = notificationDAO.getNotificationTypeById(1);
                notification.setNotificationType(notificationType);
                notification.setSentTime(today);
                notification.setPerson(accountService.getCurrentUser());
                notification.setEntityId(friend.getId());
                notification.setContact(accountService.getCurrentUser().getEmail());
                notification.setReaded(false);

                notificationDAO.addNotification(notification);
            }
        }
    }

    private int getCurrentPersonId() {
        return accountService.getCurrentUser().getId();
    }
}
