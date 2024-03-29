package io.project.SpringBot.service;

import io.project.SpringBot.storageLot.AntikWeapon;
import io.project.SpringBot.storageLot.BezmonetPeriod;
import io.project.SpringBot.config.BotConfig;

import io.project.SpringBot.storageLot.Faleristika;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component

public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    //меню
    public TelegramBot(BotConfig config) {
        this.config = config;
        List<BotCommand> listOfCommand = new ArrayList<>();
        listOfCommand.add(new BotCommand("znaki_otlichiya", "фалеристика"));
        listOfCommand.add(new BotCommand("bezmonetnyy_period", "монеты древней Руси"));
        listOfCommand.add(new BotCommand("antikvarnoye_oruzhiye", "антикварное оружие"));
        listOfCommand.add(new BotCommand("monety", "монеты"));

        try {
            this.execute(new SetMyCommands(listOfCommand, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Ошибка в меню бота: " + e.getMessage());
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

    BezmonetPeriod bezmonetPeriod = new BezmonetPeriod();
    Faleristika faleristika = new Faleristika();
    AntikWeapon antikWeapon = new AntikWeapon();

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
                case "/bezmonetnyy_period":
                    for (String item : bezmonetPeriod.getProducts()) {
                        sendMessage(chatId, item);
                    }
                    break;
                case "/znaki_otlichiya":
                    for (String item : faleristika.getFalerProducts()) {
                        sendMessage(chatId, item);
                    }
                    break;
                case "/antikvarnoye_oruzhiye":
                    for (String item : antikWeapon.getAntikWeaponProducts()) {
                        sendMessage(chatId, item);
                    }
                    break;
                default:
                    sendMessage(chatId, "coming soon");
                    log.info("Текст сообщения: " + messageText + "; " + "Id чата: " + chatId);
            }
        }
    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Hi " + name + "\uD83D\uDE42";
        log.info("Reply for user " + name);

        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);


        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Weather");
        row.add("People");

        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("Some command");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("error is occured " + e.getMessage());
        }
    }
}