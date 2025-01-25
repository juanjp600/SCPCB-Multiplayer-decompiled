Function mp_receivepacketfromclient%()
    Local local0%
    Local local1%
    Local local2.mp_player
    Local local3%
    Local local4%
    Local local6.mp_player
    Local local7.mp_playerauth
    Local local8$
    Local local9%
    Local local10$
    Local local11%
    Local local12.mp_allowedversions
    Local local13.mp_player
    local0 = getpacketip()
    local1 = getpacketport()
    local4 = mp_readbyte()
    If (local4 > $03) Then
        local3 = mp_readbyte()
        If (local3 > $78) Then
            Return $00
        EndIf
        local2 = ue_players[local3]
        If (local2 = Null) Then
            Return $00
        EndIf
        If (((local2\Field0 <> local0) Lor (local2\Field1 <> local1)) <> 0) Then
            Return $00
        EndIf
        local2\Field4\Field1 = 0.0
    EndIf
    Select local4
        Case $03
            If (mp_readbyte() = $01) Then
                mp_writebyte($01)
                mp_sendtosender()
                Return $00
            EndIf
            mp_writebyte($00)
            mp_writebyte($08)
            mp_writebyte(ue_server\Field9)
            mp_writebyte(ue_server\Field8)
            mp_writeline(ue_server\Field4)
            mp_writeline("Cooperative")
            mp_writeline(randomseed)
            mp_writebyte(opt\Field50)
            mp_writebyte(selecteddifficulty\Field10)
            If (selecteddifficulty\Field5 <> 0) Then
                mp_writebyte(selecteddifficulty\Field2)
                mp_writebyte(selecteddifficulty\Field3)
                mp_writebyte(selecteddifficulty\Field9)
                mp_writebyte(selecteddifficulty\Field4)
            EndIf
            mp_writebyte($00)
            mp_sendtosender()
        Case $01
            senddebuglog("Got request for connection.")
            For local6 = Each mp_player
                If (((local6\Field0 = local0) And (local6\Field1 = local1)) <> 0) Then
                    senddebuglog("Same IP&Port.")
                    Return $00
                EndIf
            Next
            For local7 = Each mp_playerauth
                If (((local7\Field0 = local0) And (local7\Field1 = local1)) <> 0) Then
                    senddebuglog("Same auth.")
                    Return $00
                EndIf
            Next
            local8 = mp_readline()
            local9 = mp_readint()
            local10 = mp_readline()
            If (mp_getplayerscount() >= ue_server\Field8) Then
                mp_writebyte($02)
                mp_writebyte($02)
                mp_sendtosender()
                senddebuglog("Too much players.")
                Return $00
            EndIf
            local11 = $00
            For local12 = Each mp_allowedversions
                If (local12\Field0 = local9) Then
                    local11 = $01
                    Exit
                EndIf
            Next
            If (local11 = $00) Then
                mp_writebyte($02)
                mp_writebyte($01)
                mp_sendtosender()
                senddebuglog("Not allowed version.")
                Return $00
            EndIf
            If (local10 <> randomseed) Then
                mp_writebyte($02)
                mp_writebyte($03)
                mp_sendtosender()
                senddebuglog("Wrong seed.")
                Return $00
            EndIf
            local7 = (New mp_playerauth)
            local7\Field0 = local0
            local7\Field1 = local1
            local7\Field4 = left(local8, $1F)
            local7\Field3 = local9
            mp_writebyte($02)
            mp_writebyte($00)
            mp_server_fillconnection()
            mp_sendtosender()
            senddebuglog("Sent connection accept")
        Case $02
            For local7 = Each mp_playerauth
                If (((local7\Field0 = local0) And (local7\Field1 = local1)) <> 0) Then
                    local13 = initializeplayer(getfreeplayerindex(), local0, local1)
                    If (local13 <> Null) Then
                        local13\Field2 = local7\Field3
                        local13\Field6 = local7\Field4
                        server_playerconnected(local13)
                        senddebuglog((("New player created (" + (Str local13\Field5)) + ")"))
                        mp_countplayers($01)
                    EndIf
                    Delete local7
                    Return $00
                EndIf
            Next
        Case $04
            server_playerrecv(local2)
        Case $0A
            mp_server_receivevoice(local2)
        Case $09
            mp_server_requestinfo(local2)
        Case $07
            mp_server_usedoor(local2)
        Case $08
            mp_server_itemaction(local2, mp_readbyte())
        Case $0D
            mp_server_receiveterminate(local2)
        Case $0E
            mp_server_explorecorpse(local2, mp_readbyte())
        Case $10
            mp_server_receivescp294(local2)
        Case $11
            mp_server_receiveconsole(local2)
        Case $12
            mp_server_receiveinteract(local2)
        Case $13
            mp_server_receivechatmessage(local2)
    End Select
    Return $00
End Function
