Function render3dhandicon%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    local0 = (Int (32.0 * menuscale))
    local1 = createpivot($00)
    positionentity(local1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
    pointentity(local1, arg1, 0.0)
    local2 = wrapangle((entityyaw(camera, $00) - entityyaw(local1, $00)), 360.0)
    If (((90.0 < local2) And (180.0 >= local2)) <> 0) Then
        local2 = 90.0
    EndIf
    If (((180.0 < local2) And (270.0 > local2)) <> 0) Then
        local2 = 270.0
    EndIf
    local3 = wrapangle((entitypitch(camera, $00) - entitypitch(local1, $00)), 360.0)
    If (((90.0 < local3) And (180.0 >= local3)) <> 0) Then
        local3 = 90.0
    EndIf
    If (((180.0 < local3) And (270.0 > local3)) <> 0) Then
        local3 = 270.0
    EndIf
    freeentity(local1)
    local1 = $00
    local4 = (((Float mo\Field9) + ((Float (opt\Field46 / $03)) * sin(local2))) - (Float local0))
    local5 = (((Float mo\Field10) - ((Float (opt\Field47 / $03)) * sin(local3))) - (Float local0))
    If (arg2 <> $FFFFFFFF) Then
        local6 = (Int (69.0 * menuscale))
        Select arg2
            Case $00
                local5 = (local5 - (Float local6))
            Case $01
                local4 = (local4 + (Float local6))
            Case $02
                local5 = (local5 + (Float local6))
            Case $03
                local4 = (local4 - (Float local6))
        End Select
    EndIf
    drawblock(t\Field0[arg0], (Int local4), (Int local5), $00)
    Return $00
End Function
