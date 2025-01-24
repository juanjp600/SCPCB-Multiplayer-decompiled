Function mp_renderplayerslisthud%(arg0%)
    Local local0%
    Local local1#
    Local local2#
    Local local3.mp_player
    Local local4#
    Local local5#
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    If ((((((ismultiplayerhudenabled Lor menuopen) Lor consoleopen) = $00) And keydown($19)) Lor mp_playerslist\Field0) <> 0) Then
        If (arg0 <> 0) Then
            rendermenubuttons()
        EndIf
        local0 = $00
        setfontex(fo\Field0[$00])
        local1 = (700.0 * menuscale)
        local2 = (150.0 * menuscale)
        For local3 = Each mp_player
            local2 = ((30.0 * menuscale) + local2)
            local0 = (local0 + $01)
        Next
        local4 = (Float (opt\Field46 Sar $01))
        local5 = ((Float (opt\Field47 Sar $01)) + (15.0 * menuscale))
        color($FF, $FF, $FF)
        textex((Int local4), (Int ((local5 - (local2 / 2.0)) + (15.0 * menuscale))), (((((ue_server\Field4 + " (") + (Str local0)) + " / ") + (Str ue_server\Field8)) + ")"), $01, $00)
    EndIf
    Return $00
End Function
