ALTER TABLE `notification_type` MODIFY `name` ENUM('FRIEND_BIRTHDAY','POST','POST_COMMENT','COMMENT_COMMENT','FRIEND_REQUEST','MESSAGE');
UPDATE `notification_type` SET `name`='FRIEND_BIRTHDAY' WHERE `name`='POST';
ALTER TABLE `notification_type` MODIFY `name` ENUM('FRIEND_BIRTHDAY','POST_COMMENT','COMMENT_COMMENT','FRIEND_REQUEST','MESSAGE');
