Function mp_updatenpctype1048%(arg0.npcs)
    Local local0%
    Local local1%
    Local local3%
    local0 = entityinview(arg0\Field0, mp_getnpctargetcamera(arg0))
    local1 = ((4.0 > entitydistancesquared(me\Field60, arg0\Field3)) And local0)
    If (local1 <> 0) Then
        giveachievement("1048", $01)
    EndIf
    arg0\Field23 = 0.3
    Select arg0\Field10
        Case 0.0
            arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
            animatenpc(arg0, 2.0, 151.0, arg0\Field23, $01)
        Case 1.0
            If (262.0 > arg0\Field14) Then
                animatenpc(arg0, 249.0, 262.0, arg0\Field23, $00)
            Else
                arg0\Field23 = 0.008
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                animatenpc(arg0, 263.0, 290.0, (arg0\Field24 * 37.5), $01)
            EndIf
        Case 2.0
            local3 = ((chs\Field2 Lor i_268\Field2) = $00)
            If ((local1 And local3) <> 0) Then
                pointentity(arg0\Field3, me\Field60, 0.0)
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
            EndIf
            arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
            arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
            If (0.0 = arg0\Field11) Then
                If ((local1 And local3) <> 0) Then
                    arg0\Field11 = 1.0
                EndIf
            ElseIf (1.0 = arg0\Field11) Then
                animatenpc(arg0, 305.0, 325.0, arg0\Field23, $00)
                If (324.9 < arg0\Field14) Then
                    arg0\Field11 = 2.0
                EndIf
            ElseIf (2.0 = arg0\Field11) Then
                animatenpc(arg0, 325.0, 305.0, ((- arg0\Field23) / 1.5), $00)
                If (((305.1 > arg0\Field14) And (local0 = $00)) <> 0) Then
                    arg0\Field11 = 3.0
                EndIf
            EndIf
        Case 3.0
            If ((local1 And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                pointentity(arg0\Field3, me\Field60, 0.0)
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
                arg0\Field11 = 1.0
            EndIf
            arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
            If (1.0 = arg0\Field11) Then
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                If (474.0 > arg0\Field14) Then
                    animatenpc(arg0, 326.0, 474.0, arg0\Field23, $00)
                Else
                    animatenpc(arg0, 475.0, 623.0, arg0\Field23, $01)
                EndIf
            EndIf
    End Select
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.08), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, -89.9, arg0\Field15, 0.0, $00)
    Return $00
End Function
