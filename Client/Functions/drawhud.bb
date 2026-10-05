Function drawhud%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10#
    Local local11%
    Local local12%
    Local local13#
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    drawlevers($01)
    If (closestitem <> Null) Then
        drawhand(closestitem\Field2, closestitem\Field0, handicon2)
    EndIf
    If (eqquipedgun <> Null) Then
        drawgungui()
    EndIf
    local0 = imenuscale[$50]
    local1 = (graphicheight - imenuscale[$5F])
    local2 = imenuscale[$CC]
    local3 = imenuscale[$14]
    local4 = (local0 - imenuscale[$32])
    local5 = imenuscale[$03]
    local6 = imenuscale[$24]
    local7 = (local2 - imenuscale[$06])
    local8 = imenuscale[$08]
    local9 = (local7 / local8)
    local10 = f_clamp((blinktimer / blinkfreq), 0.0, 1.0)
    local11 = (Int ((Float local9) * local10))
    local12 = (local11 * local8)
    local13 = f_clamp((stamina * 0.01), 0.0, 1.0)
    local14 = (Int ((Float local9) * local13))
    local15 = (local14 * local8)
    local16 = (local4 - imenuscale[$01])
    local17 = (local0 + local5)
    local18 = imenuscale[$20]
    If (0.0 < eyeirritation) Then
        setcolorraw($C80000)
        rect((local4 - local5), (local1 - local5), local6, local6, $01)
    EndIf
    drawimage(blinkicon, local4, local1, $00)
    setcolorraw($FFFFFF)
    rect(local0, local1, local2, local3, $00)
    rect(local16, (local1 - imenuscale[$01]), local18, local18, $00)
    If (local12 > $00) Then
        If (blinkbar <> $00) Then
            drawimagerect(blinkbar, local17, (local1 + local5), $00, $00, local12, imenuscale[$0E], $00)
        EndIf
    EndIf
    local1 = (graphicheight - imenuscale[$37])
    If (crouch <> 0) Then
        drawimage(crouchicon, local4, local1, $00)
    Else
        drawimage(sprinticon, local4, local1, $00)
    EndIf
    rect(local0, local1, local2, local3, $00)
    rect(local16, (local1 - imenuscale[$01]), local18, local18, $00)
    If (local15 > $00) Then
        If (sprintbar <> $00) Then
            drawimagerect(sprintbar, local17, (local1 + local5), $00, $00, local15, imenuscale[$0E], $00)
        EndIf
    EndIf
    Return $00
End Function
