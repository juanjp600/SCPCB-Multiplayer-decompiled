Function rendermessages%()
    Local local0%
    If (0.0 < msgtimer) Then
        local0 = $00
        If (invopen = $00) Then
            If (selecteditem <> Null) Then
                If (((selecteditem\Field3\Field2 = "paper") Or (selecteditem\Field3\Field2 = "oldpaper")) <> 0) Then
                    local0 = $01
                EndIf
            EndIf
        EndIf
        If (local0 = $00) Then
            color($00, $00, $00)
            aatext(((graphicwidth Sar $01) + $01), ((graphicheight Sar $01) + $C9), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
            color($FF, $FF, $FF)
            If (left(msg, $0E) = "Blitz3D Error!") Then
                color($FF, $00, $00)
            EndIf
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $C8), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
        Else
            color($00, $00, $00)
            aatext(((graphicwidth Sar $01) + $01), (Int (((Float graphicheight) * 0.94) + 1.0)), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
            color($FF, $FF, $FF)
            If (left(msg, $0E) = "Blitz3D Error!") Then
                color($FF, $00, $00)
            EndIf
            aatext((graphicwidth Sar $01), (Int ((Float graphicheight) * 0.94)), msg, $01, $00, (min((msgtimer / 2.0), 255.0) / 255.0))
        EndIf
    EndIf
    renderammotext()
    color($FF, $FF, $FF)
    If (showfps <> 0) Then
        aasetfont(consolefont)
        aatext($14, $14, ("FPS: " + (Str fps)), $00, $00, 1.0)
        aasetfont(fontsl)
        aatext($14, $28, ("MULTIPLAYER MOD v" + multiplayer_version), $00, $00, 1.0)
        aasetfont(font1)
    EndIf
    If (0.0 > endingtimer) Then
        If (selectedending <> "") Then
            drawending()
        EndIf
    Else
        drawmenu()
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
    Return $00
End Function
