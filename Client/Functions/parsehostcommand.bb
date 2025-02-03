Function parsehostcommand%(arg0$)
    Local local1%
    Select splitstring(arg0, " ", $00)
        Case "/op"
            local1 = (Int splitstring(arg0, " ", $01))
            If ((((local1 <> mp_getmyindex()) And (local1 < $78)) And (ue_players[local1] <> Null)) <> 0) Then
                mp_broadcastchatmessage(("Opped " + ue_players[local1]\Field6))
                ue_players[local1]\Field4\Field36 = $01
            EndIf
        Case "/deop"
            local1 = (Int splitstring(arg0, " ", $01))
            If ((((local1 <> mp_getmyindex()) And (local1 < $78)) And (ue_players[local1] <> Null)) <> 0) Then
                mp_broadcastchatmessage(("Deopped " + ue_players[local1]\Field6))
                ue_players[local1]\Field4\Field36 = $00
            EndIf
    End Select
    Return $00
End Function
