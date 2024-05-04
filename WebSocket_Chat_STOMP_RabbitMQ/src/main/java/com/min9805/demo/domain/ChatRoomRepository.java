package com.min9805.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findByUserChatsUserIdIn(List<Long> userIds);

    @Query("SELECT cr FROM ChatRoom cr " +
            "JOIN cr.userChats uc " +
            "WHERE uc.user.id IN :userIds " +
            "GROUP BY cr " +
            "HAVING COUNT(DISTINCT uc.user) = :userCount")
    List<ChatRoom> findChatRoomsByUserIds(@Param("userIds") List<Long> userIds,
                                          @Param("userCount") Long userCount);
}
