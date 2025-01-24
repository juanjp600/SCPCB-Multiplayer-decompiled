Function mp_server_requestinfo%(arg0.mp_player)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    If (determinepacketflooding(arg0, $00, $0A, $1F4) <> 0) Then
        Return $00
    EndIf
    local0 = $00
    While (((mp_getbufferavail(getnetworkreadbuffer()) > $00) And (local0 < $05)) <> 0)
        local1 = mp_readbyte()
        local2 = mp_readbyte()
        local3 = local1
        If (local3 = $01) Then
            mp_writebyte($09)
            mp_writebyte(local1)
            mp_enablebuffercompression(getnetworksendbuffer())
            local4 = $00
            local5 = $00
            Repeat
                local4 = mp_readbyte()
                If ((((local4 = $00) Lor (local4 > $78)) Lor (local5 > $78)) <> 0) Then
                    Exit
                EndIf
                If (ue_players[local4] <> Null) Then
                    mp_server_fillplayerrequesting(ue_players[local4])
                EndIf
                local5 = (local5 + $01)
            Forever
            mp_writebyte($00)
            mp_sendtosender()
        EndIf
        local0 = (local0 + $01)
    Wend
    Return $00
End Function
