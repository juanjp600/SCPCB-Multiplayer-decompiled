Function drawcredits%()
    Local local0#
    Local local1.creditsline
    Local local2%
    Local local3%
    Local local4.creditsline
    ready = "Not Ready"
    local0 = (((endingtimer + 2000.0) * 0.5) + (Float (graphicheight + $0A)))
    cls()
    If (rand($01, $12C) > $01) Then
        drawimage(creditsscreen, (viewport_center_x - $190), (viewport_center_y - $190), $00)
    EndIf
    local2 = $00
    local3 = $00
    local4 = Null
    setcolorraw($FFFFFF)
    For local1 = Each creditsline
        local1\Field1 = local2
        If (left(local1\Field0, $01) = "*") Then
            setfontex(fonts[$01]\Field0)
            If (local1\Field2 = $00) Then
                text(viewport_center_x, (Int (((Float (local1\Field1 * $18)) * menuscale) + local0)), right(local1\Field0, (len(local1\Field0) - $01)), $01, $00)
            EndIf
        ElseIf (left(local1\Field0, $01) = "/") Then
            local4 = (Before local1)
        Else
            setfontex(fonts[$00]\Field0)
            If (local1\Field2 = $00) Then
                text(viewport_center_x, (Int (((Float (local1\Field1 * $18)) * menuscale) + local0)), local1\Field0, $01, $00)
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
            setcolorex((Int max(min(creditstimer, 255.0), 0.0)), (Int max(min(creditstimer, 255.0), 0.0)), (Int max(min(creditstimer, 255.0), 0.0)))
        ElseIf (255.0 <= creditstimer) Then
            setcolorex($FF, $FF, $FF)
            If (500.0 < creditstimer) Then
                creditstimer = -255.0
            EndIf
        Else
            setcolorex((Int max(min((- creditstimer), 255.0), 0.0)), (Int max(min((- creditstimer), 255.0), 0.0)), (Int max(min((- creditstimer), 255.0), 0.0)))
            If (-1.0 <= creditstimer) Then
                creditstimer = -1.0
            EndIf
        EndIf
    EndIf
    If (0.0 <> creditstimer) Then
        setfontex(fonts[$00]\Field0)
        For local1 = Each creditsline
            If (local1\Field2 <> 0) Then
                If (left(local1\Field0, $01) = "/") Then
                    text(viewport_center_x, (Int ((((Float local3) * 0.5) + (Float viewport_center_y)) + ((Float (local1\Field1 * $18)) * menuscale))), right(local1\Field0, (len(local1\Field0) - $01)), $01, $00)
                Else
                    text(viewport_center_x, (Int ((((Float ((local1\Field1 - local4\Field1) * $18)) * menuscale) + (Float viewport_center_y)) - ((((Float local3) * 0.5) * 24.0) * menuscale))), local1\Field0, $01, $00)
                EndIf
            EndIf
        Next
    EndIf
    If (getkey() <> 0) Then
        creditstimer = -1.0
    EndIf
    If (-1.0 = creditstimer) Then
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
