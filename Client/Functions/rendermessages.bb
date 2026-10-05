Function rendermessages%()
    Local local0%
    Local local1%
    If (hudenabled <> 0) Then
        setfontex(fonts[$00]\Field0)
        If (0.0 < msgtimer) Then
            local0 = $00
            If (invopen = $00) Then
                If (selecteditem <> Null) Then
                    If (((selecteditem\Field1\Field2 = "paper") Or (selecteditem\Field1\Field2 = "oldpaper")) <> 0) Then
                        local0 = $01
                    EndIf
                EndIf
                If (selectedscreen <> Null) Then
                    local0 = $01
                EndIf
            EndIf
            local1 = (Int min((msgtimer * 0.5), 255.0))
            setcolorraw($00)
            text((viewport_center_x + $01), (Int (((Float ((viewport_center_y + $C8) * (local0 = $00))) + (((Float graphicheight) * 0.95) * (Float (local0 > $00)))) + 1.0)), msg, $01, $00)
            setcolorex(local1, local1, local1)
            text(viewport_center_x, (Int ((Float ((viewport_center_y + $C8) * (local0 = $00))) + (((Float graphicheight) * 0.95) * (Float (local0 > $00))))), msg, $01, $00)
        EndIf
        If (b_br\Field9 > $00) Then
            b_br\Field9 = (Int ((Float b_br\Field9) - fpsfactor))
        EndIf
        If (0.0 < msgtimer) Then
            msgtimer = (msgtimer - fpsfactor)
        EndIf
        If (0.0 < b_br\Field0) Then
            b_br\Field0 = (b_br\Field0 - fpsfactor)
        EndIf
    EndIf
    If (showfps <> 0) Then
        setcolorraw($FFFFFF)
        text(imenuscale[$14], imenuscale[$0A], "MULTIPLAYER MOD v1.3.0R", $00, $00)
        text(imenuscale[$14], imenuscale[$1E], ("FPS: " + (Str fps)), $00, $00)
    EndIf
    If (0.0 > endingtimer) Then
        If (selectedending <> "") Then
            drawending()
        EndIf
    Else
        drawmenu()
    EndIf
    Return $00
End Function
