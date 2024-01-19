Function clearchatforplayer%(arg0%)
    Local local0.chatmessage
    For local0 = Each chatmessage
        local0\Field3[arg0] = $00
    Next
    Return $00
End Function
