package io.project.SpringBot.service;

import io.project.SpringBot.config.BotConfig;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Component
public class TelegramBot extends TelegramLongPollingBot {
//
//    @Autowired
//    private UserRepository userRepository;

    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
        List<BotCommand> listOfCommand = new ArrayList<>();
        listOfCommand.add(new BotCommand("/mydata", "This my data with BD"));
        try {
            this.execute(new SetMyCommands(listOfCommand, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("this error bots command: " + e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":
//                    registerUser(update.getMessage());
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                    sendMessage(chatId, "coming soon");
                    log.info("Текст сообщения: " + messageText + "; " + "Id чата: " + chatId);
            }

        }
    }

//    private void registerUser(Message msg) {
//        if (userRepository.findById(msg.getChatId()).isEmpty()) {
//            var chatId = msg.getChatId();
//            var chat = msg.getChat();
//
//            User user = new User();
//            user.setChatId(chatId);
//            user.setFirstName(chat.getFirstName());
//            user.setLastName(chat.getLastName());
//            user.setUserName(chat.getUserName());
////            user.setRegister(new TimeStamp(System.currentTimeMillis()));
//
//            userRepository.save(user);
//            log.info("User saved: " + user);
//
//        }
//    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Hi " + name + "\uD83D\uDE42";
        log.info("Reply for user " + name);

        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("error is occured " + e.getMessage());
        }

    }
}
