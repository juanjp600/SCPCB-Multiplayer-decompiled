Function mp_server_sendsinglechatmessage%(arg0.mp_player, arg1$)
    Local local0%
    If (arg0 = ue_players[mp_getmyindex()]) Then
        mp_createchatmessage(arg1)
        Return $00
    EndIf
    mp_chat\Field5 = (mp_chat\Field5 + $01)
    For local0 = $00 To $01 Step $01
        mp_writebyte($13)
        mp_writeline(arg1)
        mp_writeint(mp_chat\Field5)
        mp_send(arg0\Field0, arg0\Field1)
    Next
    Return $00
End Function
