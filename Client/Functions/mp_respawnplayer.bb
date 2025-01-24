Function mp_respawnplayer%(arg0.mp_player)
    Local local0%
    If (arg0 = ue_players[mp_getmyindex()]) Then
        If ((Int me\Field0) <> 0) Then
            resetnegativestats($01)
            If (t\Field3[$0A] <> $00) Then
                freeentity(t\Field3[$0A])
                t\Field3[$0A] = $00
            EndIf
            me\Field9 = $01
            Select mp_terminated\Field4
                Case $00
                    local0 = $03
                Case $01
                    local0 = $27
                Case $02
                    local0 = $45
                Case $C8
                    local0 = $46
                Case $C9
                    local0 = $48
                Default
                    local0 = $03
            End Select
            executeconsolecommand(("teleport " + (Str local0)))
            executeconsolecommand("god false")
            wi\Field0 = $00
            wi\Field2 = $00
            wi\Field3 = $00
            wi\Field4 = $00
            wi\Field5 = $00
            wi\Field9 = $00
            mp_terminated\Field6 = 100.0
        EndIf
    EndIf
    If ((mp_ishoster() And arg0\Field4\Field4) <> 0) Then
        arg0\Field4\Field6 = 0.0
        arg0\Field4\Field7 = 0.0
        arg0\Field4\Field8 = 0.0
        arg0\Field4\Field9 = 0.0
        arg0\Field4\Field10 = 210.0
        arg0\Field4\Field12 = 1.0
        arg0\Field4\Field13 = 0.0
        arg0\Field4\Field4 = $00
        arg0\Field4\Field15 = $00
        setplayermodel(arg0, $01, $00)
    EndIf
    Return $00
End Function
