Function mp_client_receivechatmessage%(arg0$)
    Local local0%
    local0 = mp_readint()
    If (mp_chat\Field5 < local0) Then
        mp_createchatmessage(arg0)
        mp_chat\Field5 = local0
    EndIf
    Return $00
End Function
