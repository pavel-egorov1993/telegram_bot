package telegram_bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update){
        String msg = update.getMessage().getText().toLowerCase();
//        sendMsg(update.getMessage().getChatId().toString(),new LogicBot().sayInReturn(msg));
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try{
            execute(sendMessage);
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername(){
        return "CuKoo_Bot";
    }

    @Override
    public String getBotToken(){
        return "1392510764:AAH_42mM3HCk72W9EucWc1wPHXLpEC6CIYs";
    }
}
