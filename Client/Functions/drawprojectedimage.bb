Function drawprojectedimage%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    local0 = createpivot($00)
    local1 = createpivot($00)
    positionentity(local0, entityx(arg1, $00), entityy(arg1, $00), entityz(arg1, $00), $00)
    positionentity(local1, entityx(arg2, $00), entityy(arg2, $00), entityz(arg2, $00), $00)
    pointentity(local0, local1, 0.0)
    local2 = wrapangle((entityyaw(arg1, $00) - entityyaw(local0, $00)))
    local3 = 0.0
    If (((90.0 < local2) And (180.0 >= local2)) <> 0) Then
        local3 = ((sin(90.0) / 90.0) * local2)
    ElseIf (((180.0 < local2) And (270.0 > local2)) <> 0) Then
        local3 = ((sin(270.0) / local2) * 270.0)
    Else
        local3 = sin(local2)
    EndIf
    local4 = wrapangle((entitypitch(arg1, $00) - entitypitch(local0, $00)))
    local5 = 0.0
    If (((90.0 < local4) And (180.0 >= local4)) <> 0) Then
        local5 = ((sin(90.0) / 90.0) * local4)
    ElseIf (((180.0 < local4) And (270.0 > local4)) <> 0) Then
        local5 = ((sin(270.0) / local4) * 270.0)
    Else
        local5 = sin(local4)
    EndIf
    freeentity(local0)
    freeentity(local1)
    drawimage(arg0, (Int ((local3 * (Float (graphicwidth Sar $01))) + (Float (graphicwidth Sar $01)))), (Int ((Float (graphicheight Sar $01)) - (local5 * (Float (graphicheight Sar $01))))), $00)
    Return $00
End Function
