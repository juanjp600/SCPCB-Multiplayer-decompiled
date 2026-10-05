Function updatesteamgameserverconnection%()
    If (((gs_isloggedon() = $01) And (prevloggedon = $01)) <> 0) Then
        prevloggedon = $01
        addlog("SteamGameServer successfully started.", $00, $00, $00, $C0, $C0, $C0)
    EndIf
    If (((gs_getsteamserversconnected() <> $00) And (prevconnection <> $01)) <> 0) Then
        If (gs_getsteamserversconnected() = $01) Then
            prevconnection = $01
            addlog("SteamGameServer successfully connected.", $00, $00, $00, $C0, $C0, $C0)
        ElseIf (failedconnectionalreadysaid = $00) Then
            failedconnectionalreadysaid = $01
            addlog((("SteamGameServer failed to connect. [ERROR CODE: " + (Str gs_getsteamserversconnected())) + "]"), $00, $00, $00, $C0, $C0, $C0)
        EndIf
    EndIf
    Return $00
End Function
