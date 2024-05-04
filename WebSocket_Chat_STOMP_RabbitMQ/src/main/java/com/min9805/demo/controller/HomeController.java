package com.min9805.demo.controller;

import com.min9805.demo.domain.ChatRoom;
import com.min9805.demo.service.ChatRoomService;
import com.min9805.demo.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    private final ChatRoomService chatRoomService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }
    @GetMapping("/chat/{userId}")
    public String index(@PathVariable Long userId, Model model) {
        model.addAttribute("users", userService.findAll(userId));
        model.addAttribute("chatRooms", chatRoomService.findAll(userId));
        model.addAttribute("userId", userId);
        return "index_user";
    }

    @GetMapping("/chat/{userId}/{chatUserId}")
    public String makeChat(@PathVariable Long userId,@PathVariable Long chatUserId) {
        Long chatRoomId = chatRoomService.joinChat(List.of(userId, chatUserId)).getId();
        return "redirect:/" + userId + "/chat/" + chatRoomId;
    }

    @GetMapping("/chat/{userId}/chat/{chatRoomId}")
    public String chat(@PathVariable Long userId, @PathVariable Long chatRoomId, Model model) {
        model.addAttribute("chatRoomId", chatRoomId);
        model.addAttribute("userId", userId);
        return "chatRoom";
    }
}
