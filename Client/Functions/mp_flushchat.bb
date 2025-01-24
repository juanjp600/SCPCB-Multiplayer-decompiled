Function mp_flushchat%()
    mp_chat\Field5 = $00
    Delete Each mp_chatmessage
    Return $00
End Function
