Function rendernvg%()
    Local local0.npcs
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13$
    Local local14%
    If (((wi\Field8 > $00) And ((-6.0 < me\Field10) Lor (-11.0 > me\Field10))) <> 0) Then
        If (wi\Field9 = $02) Then
            local4 = distancesquared(entityx(me\Field60, $01), n_i\Field2\Field44, entityy(me\Field60, $01), n_i\Field2\Field45, entityz(me\Field60, $01), n_i\Field2\Field46)
            color($64, $64, $64)
            setfontex(fo\Field0[$02])
            If (n_i\Field3\Field65 <> 0) Then
                textex(mo\Field9, (Int (60.0 * menuscale)), "SCP-106 Contatined", $01, $00)
            Else
                textex(mo\Field9, (Int (60.0 * menuscale)), ((Str (Int (n_i\Field3\Field11 / 70.0))) + " seconds left before SCP-106 arrives"), $01, $00)
            EndIf
            If (256.0 > local4) Then
                If (entityinview(n_i\Field2\Field3, camera) <> 0) Then
                    cameraproject(camera, n_i\Field2\Field44, (n_i\Field2\Field45 + 0.2), n_i\Field2\Field46)
                    local5 = projectedx()
                    local6 = projectedy()
                    local7 = (Int (15.0 * menuscale))
                    local8 = (Int (50.0 * menuscale))
                    local9 = (16.0 / sqr(local4))
                    local10 = (Int ((Float local7) * local9))
                    local11 = (Int ((Float local8) * local9))
                    rect((Int (local5 - (Float (local10 Sar $01)))), (Int (local6 - (Float (local11 Sar $01)))), local10, local11, $00)
                EndIf
            EndIf
        ElseIf (wi\Field5 = $02) Then
            color($64, $64, $FF)
            setfontex(fo\Field0[$02])
            local12 = $00
            local12 = $28
            local13 = getlocalstring("msg", "refresh")
            local14 = instr(local13, "%s", $01)
            textex(mo\Field9, (Int (60.0 * menuscale)), trim(left(local13, (local14 - $01))), $01, $00)
            textex(mo\Field9, (Int (100.0 * menuscale)), (Str max((Float floattostring((wi\Field6 / 60.0), $01)), 0.0)), $01, $00)
            textex(mo\Field9, (Int (140.0 * menuscale)), trim(right(local13, ((len(local13) - local14) - $01))), $01, $00)
            For local0 = Each npcs
                If (((local0\Field47 <> "") And (local0\Field43 = $00)) <> 0) Then
                    local4 = distancesquared(entityx(me\Field60, $01), local0\Field44, entityy(me\Field60, $01), local0\Field45, entityz(me\Field60, $01), local0\Field46)
                    If (256.0 > local4) Then
                        If (wi\Field7 = $00) Then
                            cameraproject(camera, local0\Field44, (local0\Field45 + 0.5), local0\Field46)
                            local5 = projectedx()
                            local6 = projectedy()
                            textex((Int local5), (Int local6), local0\Field47, $01, $01)
                            textex((Int local5), (Int (local6 - (25.0 * menuscale))), (floattostring(sqr(local4), $01) + " m"), $01, $01)
                        EndIf
                    EndIf
                EndIf
            Next
            color($00, $00, $37)
        ElseIf (wi\Field5 = $01) Then
            color($00, $37, $00)
        Else
            color($37, $37, $37)
        EndIf
        For local2 = $00 To $0A Step $01
            rect((Int (45.0 * menuscale)), (Int ((Float mo\Field10) - ((Float (local2 * $14)) * menuscale))), (Int (54.0 * menuscale)), (Int (10.0 * menuscale)), $01)
        Next
        If (wi\Field5 = $02) Then
            color($64, $64, $FF)
            drawimage(t\Field1[$06], (Int (40.0 * menuscale)), (Int ((Float mo\Field10) + (30.0 * menuscale))), $01)
        ElseIf (wi\Field5 = $01) Then
            color($64, $FF, $64)
            drawimage(t\Field1[$06], (Int (40.0 * menuscale)), (Int ((Float mo\Field10) + (30.0 * menuscale))), $00)
        Else
            color($FF, $FF, $FF)
            drawimage(t\Field1[$06], (Int (40.0 * menuscale)), (Int ((Float mo\Field10) + (30.0 * menuscale))), $02)
        EndIf
        local2 = (Int min(floor(((Float (wi\Field8 + $32)) * 0.01)), 11.0))
        For local3 = $00 To local2 Step $01
            rect((Int (45.0 * menuscale)), (Int ((Float mo\Field10) - ((Float (local3 * $14)) * menuscale))), (Int (54.0 * menuscale)), (Int (10.0 * menuscale)), $01)
        Next
        If (local2 < $03) Then
            If (70.0 <= batmsgtimer) Then
                color($FF, $00, $00)
                setfontex(fo\Field0[$02])
                textex(mo\Field9, (Int (20.0 * menuscale)), getlocalstring("msg", "battery.low"), $01, $00)
            EndIf
        EndIf
    EndIf
    color($FF, $FF, $FF)
    Return $00
End Function
