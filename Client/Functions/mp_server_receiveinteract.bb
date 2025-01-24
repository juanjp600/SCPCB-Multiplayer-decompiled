Function mp_server_receiveinteract%(arg0.mp_player)
    Local local0%
    Local local1%
    If (((arg0\Field4\Field4 Lor (mp_rooms[arg0\Field22] = Null)) Lor determinepacketflooding(arg0, $05, $01, $1F4)) <> 0) Then
        Return $00
    EndIf
    local0 = mp_readbyte()
    local1 = mp_readbyte()
    mp_server_interactobject(arg0, local1, local0)
    Return $00
End Function
