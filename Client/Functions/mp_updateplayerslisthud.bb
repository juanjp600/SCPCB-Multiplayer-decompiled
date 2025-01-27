Function mp_updateplayerslisthud%()
    Local local0#
    Local local1#
    Local local2.mp_player
    Local local3#
    Local local4#
    Local local5%
    Local local6#
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    If ((((((ismultiplayerhudenabled Lor menuopen) Lor consoleopen) = $00) And keydown($19)) Lor mp_playerslist\Field0) <> 0) Then
        ue_players[mp_getmyindex()]\Field6 = opt\Field46
        setfontex(fo\Field0[$00])
        local0 = (700.0 * menuscale)
        local1 = (150.0 * menuscale)
        For local2 = Each mp_player
            local1 = (((30.0 * menuscale) + local1) - (4.0 * menuscale))
        Next
        local3 = (Float (opt\Field49 Sar $01))
        local4 = ((Float (opt\Field50 Sar $01)) + (15.0 * menuscale))
        updatemenubutton((Int (local3 - (local0 / 2.0))), (Int (local4 - (local1 / 2.0))), (Int local0), (Int local1), "", $00, $00, $00, $FF, $FF, $FF, $00, 1.0, $01, $01)
        updatemenubutton((Int (local3 - (local0 / 2.0))), (Int ((local4 - (local1 / 2.0)) + (30.0 * menuscale))), (Int local0), (Int (4.0 * menuscale)), "", local5, $00, $00, $FF, $FF, $FF, $00, 1.0, $01, $01)
        local6 = ((local4 - (local1 / 2.0)) + (30.0 * menuscale))
        For local2 = Each mp_player
            updatemenubutton((Int (local3 - (local0 / 2.0))), (Int local6), (Int local0), (Int (30.0 * menuscale)), local2\Field6, $00, $00, $00, $FF, $FF, $FF, $01, 0.05, $01, $01)
            If (updatemenubutton((Int (((local3 - (local0 / 2.0)) + (local0 * 0.95)) - (2.0 * menuscale))), (Int local6), (Int (local0 * 0.05)), (Int (30.0 * menuscale)), "A", $09, $00, $00, $FF, $FF, $FF, $01, 1.0, $00, $00) <> 0) Then
                setplayervoicemute(local2, $FFFFFFFF)
            EndIf
            local6 = (((30.0 * menuscale) + local6) - (4.0 * menuscale))
        Next
        If (mo\Field1 <> 0) Then
            mp_playerslist\Field0 = $01
        EndIf
        If (mp_playerslist\Field0 <> 0) Then
            ismultiplayerhudenabled = $01
            menuopen = $00
            consoleopen = $00
            invopen = $00
            If (keyhit($01) <> 0) Then
                mp_playerslist\Field0 = $00
                ismultiplayerhudenabled = $00
            EndIf
        EndIf
        shoulddeletegadgets = $01
    EndIf
    Return $00
End Function
