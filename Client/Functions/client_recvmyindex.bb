Function client_recvmyindex%()
    Local local0%
    local0 = mp_readbyte()
    If (myplayerlogic\Field0 <> local0) Then
        myplayerlogic\Field0 = local0
        mp_setspawnpoint()
    EndIf
    Return $00
End Function
