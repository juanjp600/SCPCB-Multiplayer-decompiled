Function drawcredits%()
    Local local0#
    Local local1.creditsline
    Local local2%
    Local local3%
    Local local4.creditsline
    ready = "Not Ready"
    local0 = (((endingtimer + 2000.0) / 2.0) + (Float (graphicheight + $0A)))
    cls()
    If (rand($01, $12C) > $01) Then
        drawimage(creditsscreen, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
    EndIf
    local2 = $00
    local3 = $00
    local4 = Null
    color($FF, $FF, $FF)
    For local1 = Each creditsline
        local1\Field1 = local2
        If (left(local1\Field0, $01) = "*") Then
            setfont(creditsfont2)
            If (local1\Field2 = $00) Then
                text((graphicwidth Sar $01), (Int (((Float (local1\Field1 * $18)) * menuscale) + local0)), right(local1\Field0, (len(local1\Field0) - $01)), $01, $00)
            EndIf
        ElseIf (left(local1\Field0, $01) = "/") Then
            local4 = (Before local1)
        Else
            setfont(creditsfont)
            If (local1\Field2 = $00) Then
                text((graphicwidth Sar $01), (Int (((Float (local1\Field1 * $18)) * menuscale) + local0)), local1\Field0, $01, $00)
            EndIf
        EndIf
        If (local4 <> Null) Then
            If (local1\Field1 > local4\Field1) Then
                local1\Field2 = $01
            EndIf
        EndIf
        If (local1\Field2 <> 0) Then
            local3 = (local3 + $01)
        EndIf
        local2 = (local2 + $01)
    Next
    If ((Float (- stringheight(local4\Field0))) > (((Float (local4\Field1 * $18)) * menuscale) + local0)) Then
        creditstimer = ((0.5 * fpsfactor2) + creditstimer)
        If (((0.0 <= creditstimer) And (255.0 > creditstimer)) <> 0) Then
            color((Int max(min(creditstimer, 255.0), 0.0)), (Int max(min(creditstimer, 255.0), 0.0)), (Int max(min(creditstimer, 255.0), 0.0)))
        ElseIf (255.0 <= creditstimer) Then
            color($FF, $FF, $FF)
            If (500.0 < creditstimer) Then
                creditstimer = -255.0
            EndIf
        Else
            color((Int max(min((- creditstimer), 255.0), 0.0)), (Int max(min((- creditstimer), 255.0), 0.0)), (Int max(min((- creditstimer), 255.0), 0.0)))
            If (-1.0 <= creditstimer) Then
                creditstimer = -1.0
            EndIf
        EndIf
        debuglog((Str creditstimer))
    EndIf
    If (0.0 <> creditstimer) Then
        For local1 = Each creditsline
            If (local1\Field2 <> 0) Then
                setfont(creditsfont)
                If (left(local1\Field0, $01) = "/") Then
                    text((graphicwidth Sar $01), (Int ((Float ((graphicheight Sar $01) + (local3 Sar $01))) + ((Float (local1\Field1 * $18)) * menuscale))), right(local1\Field0, (len(local1\Field0) - $01)), $01, $00)
                Else
                    text((graphicwidth Sar $01), (Int ((((Float ((local1\Field1 - local4\Field1) * $18)) * menuscale) + (Float (graphicheight Sar $01))) - ((Float ((local3 Sar $01) * $18)) * menuscale))), local1\Field0, $01, $00)
                EndIf
            EndIf
        Next
    EndIf
    If (getkey() <> 0) Then
        creditstimer = -1.0
    EndIf
    If (-1.0 = creditstimer) Then
        freefont(creditsfont)
        freefont(creditsfont2)
        freeimage(creditsscreen)
        creditsscreen = $00
        freeimage(endingscreen)
        endingscreen = $00
        Delete Each creditsline
        stopstream_strict(musicchn)
        shouldplay = $15
        disconnectserver("", $01)
    EndIf
    Return $00
End Function
