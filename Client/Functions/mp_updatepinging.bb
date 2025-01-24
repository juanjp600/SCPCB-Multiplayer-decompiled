Function mp_updatepinging%()
    Local local0.mp_serverping
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    If (mp_getdialogindex() = $03) Then
        If (mp_gettimer() > mp_ping\Field2) Then
            mp_resetdialogstates()
            mp_showlocaldialog("Connect", "Can't connect to server: Server not responding", "Ok", "", $00, $01, $01)
        EndIf
    ElseIf (mp_latestcloseddialog() = $03) Then
        For local0 = Each mp_serverping
            local0\Field4 = $00
        Next
        mp_resetdialogstates()
    EndIf
    While (recvudpmsg(mp_ping\Field0) <> 0)
        If (mp_getsocket() = $00) Then
            local1 = udpmsgip(mp_ping\Field0)
            local2 = udpmsgport(mp_ping\Field0)
            For local0 = Each mp_serverping
                If (((local0\Field0 = local1) And (local0\Field1 = local2)) <> 0) Then
                    If ((millisecs() - local0\Field6) < mp_ping\Field1) Then
                        senddebuglog(((("Receive ping from " + (Str local1)) + " Port: ") + (Str local2)))
                        receivetonetworkbuffer(mp_ping\Field0, local0\Field2)
                        senddebuglog((("Access ping. Received: " + (Str local0\Field2\Field2)) + " bytes"))
                        local3 = blitz_mp_readbyte0(local0\Field2)
                        If ((local0\Field4 And (local3 = $00)) <> 0) Then
                            mp_resetdialogstates()
                            mp_cleardialog()
                            local0\Field4 = $00
                            local0\Field3 = $00
                            local4 = mp_menustartgame(local1, local2, local0\Field2)
                            If (local4 <> $00) Then
                                mp_menuflush()
                                mp_cleardialog()
                                Select local4
                                    Case $00
                                    Case $01
                                        mp_showlocaldialog("Connect", "Can't connect to server: Wrong version", "Ok", "", $00, $01, $01)
                                    Case $02
                                        mp_showlocaldialog("Connect", "Can't connect to server: Server is full", "Ok", "", $00, $01, $01)
                                    Case $04
                                        mp_showlocaldialog("Connect", "Can't connect to server: Server not responding", "Ok", "", $00, $01, $01)
                                    Case $03
                                        mp_showlocaldialog("Connect", "Can't connect to server: Wrong seed", "Ok", "", $00, $01, $01)
                                    Default
                                        mp_showlocaldialog("Connect", "Can't connect to server: Unknown error", "Ok", "", $00, $01, $01)
                                End Select
                            EndIf
                            local0\Field5 = $00
                        Else
                            mp_receivepingtoserverlist(dottedip(local1), local2, local0\Field2, (millisecs() - local0\Field6), local3)
                            local0\Field5 = $00
                        EndIf
                    EndIf
                    Exit
                EndIf
            Next
        EndIf
    Wend
    If (mp_getsocket() = $00) Then
        For local0 = Each mp_serverping
            If (((local0\Field5 <> $00) And (millisecs() > (local0\Field5 + mp_ping\Field1))) <> 0) Then
                mp_receivepingtoserverlist(dottedip(local0\Field0), local0\Field1, Null, $00, $00)
                local0\Field5 = $00
            EndIf
        Next
    EndIf
    Return $00
End Function
