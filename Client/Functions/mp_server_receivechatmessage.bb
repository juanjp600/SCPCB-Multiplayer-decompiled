Function mp_server_receivechatmessage%(arg0.mp_player)
    Local local0$
    Local local1%
    local0 = mp_readline()
    local1 = mp_readint()
    If (((arg0\Field4\Field35 < local1) And (determinepacketflooding(arg0, $05, $01, $FA) = $00)) <> 0) Then
        local0 = left(local0, $90)
        mp_createchatmessage(((arg0\Field6 + ": ") + local0))
        mp_server_sendchatmessage(arg0, ((arg0\Field6 + ": ") + local0))
        arg0\Field4\Field35 = local1
    EndIf
    Return $00
End Function
