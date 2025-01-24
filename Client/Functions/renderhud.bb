Function renderhud%()
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14#
    If ((((Int me\Field0) Lor (0.0 > me\Field3)) Lor (me\Field9 = $00)) <> 0) Then
        Return $00
    EndIf
    local0 = (80.0 * menuscale)
    local1 = ((Float opt\Field47) - (15.0 * menuscale))
    local2 = (200.0 * menuscale)
    local3 = (20.0 * menuscale)
    local7 = entityy(me\Field60, $00)
    local8 = (imagewidth(t\Field0[$00]) + $02)
    local9 = (Int (50.0 * menuscale))
    local10 = (local9 + $01)
    local11 = (local8 + $02)
    local12 = (local10 + $01)
    local13 = $01
    local14 = (40.0 * menuscale)
    color($FF, $FF, $FF)
    local1 = (local1 - local14)
    If (25.0 >= me\Field17) Then
        renderbar(t\Field1[$03], (Int local0), (Int local1), (Int local2), (Int local3), me\Field17, 100.0, $32, $00, $00)
    Else
        renderbar(t\Field1[$02], (Int local0), (Int local1), (Int local2), (Int local3), me\Field17, 100.0, $32, $32, $32)
    EndIf
    If ((((((((playerroom\Field7\Field6 = $69) And (((1.0 / 0.128) > local7) Lor (10.1875 < local7))) Lor (1.5 <= me\Field31)) Lor (1.0 < me\Field18)) Lor (100.0 > me\Field20)) Lor (0.0 < i_1025\Field0[$00])) Lor (0.0 < i_966\Field1)) <> 0) Then
        color($C8, $00, $00)
        rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
    ElseIf ((((((chs\Field5 Lor (1.0 > me\Field18)) Lor (wi\Field0 >= $03)) Lor (i_1499\Field0 = $02)) Lor (wi\Field2 >= $03)) Lor ((15.0 < i_1025\Field0[$06]) And (75.0 > i_1025\Field0[$06]))) <> 0) Then
        color($00, $C8, $00)
        rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
    EndIf
    color($FF, $FF, $FF)
    rect((Int (local0 - (Float local10))), (Int local1), local8, local8, $00)
    If (me\Field39 <> 0) Then
        local4 = $02
    ElseIf ((((((keydown(key\Field7) And (invopen = $00)) And (otheropen = Null)) And (0.0 < me\Field38)) And (chs\Field3 = $00)) And (0.0 < me\Field17)) <> 0) Then
        local4 = $01
    Else
        local4 = $00
    EndIf
    drawblock(t\Field0[local4], (Int (local0 - (Float local9))), (Int (local1 + 1.0)), $00)
    color($FF, $FF, $FF)
    local1 = (local1 - local14)
    If (210.0 > me\Field10) Then
        renderbar(t\Field1[$01], (Int local0), (Int local1), (Int local2), (Int local3), min(me\Field10, me\Field11), me\Field11, $64, $00, $00)
    Else
        renderbar(blinkmeterimg, (Int local0), (Int local1), (Int local2), (Int local3), min(me\Field10, me\Field11), me\Field11, $64, $64, $64)
    EndIf
    If (((((((550.0 < me\Field49) Lor (1.0 < me\Field12)) Lor (0.0 < me\Field51)) Lor ((0.3 >= secondarylighton) And (wi\Field5 = $00))) Lor (((0.0 < me\Field14) And (wi\Field5 = $00)) And (wi\Field9 = $00))) Lor (0.0 < i_966\Field1)) <> 0) Then
        color($C8, $00, $00)
        rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
    ElseIf (((1.0 > me\Field12) Lor chs\Field1) <> 0) Then
        color($00, $C8, $00)
        rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
    EndIf
    color($FF, $FF, $FF)
    rect((Int (local0 - (Float local10))), (Int local1), local8, local8, $00)
    If (0.0 > me\Field10) Then
        local5 = $04
    Else
        local5 = $03
    EndIf
    drawblock(t\Field0[local5], (Int (local0 - (Float local9))), (Int (local1 + 1.0)), $00)
    If (mp_rendervoicehud((Float local10), (Float local8), local14, (Float local9), local0, local1, local2, local3) <> 0) Then
        local1 = (local1 - local14)
    EndIf
    If ((((i_714\Field0 > $00) And (500.0 > remove714timer)) Lor ((wi\Field2 > $00) And (500.0 > removehazmattimer))) <> 0) Then
        color($FF, $FF, $FF)
        local1 = (local1 - local14)
        If (wi\Field2 > $00) Then
            If (125.0 > removehazmattimer) Then
                renderbar(t\Field1[$01], (Int local0), (Int local1), (Int local2), (Int local3), removehazmattimer, 500.0, $64, $00, $00)
            Else
                renderbar(blinkmeterimg, (Int local0), (Int local1), (Int local2), (Int local3), removehazmattimer, 500.0, $64, $64, $64)
            EndIf
        ElseIf (125.0 > remove714timer) Then
            renderbar(t\Field1[$01], (Int local0), (Int local1), (Int local2), (Int local3), remove714timer, 500.0, $64, $00, $00)
        Else
            renderbar(blinkmeterimg, (Int local0), (Int local1), (Int local2), (Int local3), remove714timer, 500.0, $64, $64, $64)
        EndIf
        If (wi\Field2 = $04) Then
            color($00, $C8, $00)
            rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
        ElseIf (i_714\Field0 = $01) Then
            color($C8, $00, $00)
            rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
        EndIf
        color($FF, $FF, $FF)
        rect((Int (local0 - (Float local10))), (Int local1), local8, local8, $00)
        drawblock(t\Field0[$07], (Int (local0 - (Float local9))), (Int (local1 + 1.0)), $00)
    EndIf
    If (i_268\Field0 > $01) Then
        color($FF, $FF, $FF)
        local1 = (local1 - local14)
        If (175.0 > i_268\Field1) Then
            renderbar(t\Field1[$01], (Int local0), (Int local1), (Int local2), (Int local3), i_268\Field1, 700.0, $64, $00, $00)
        Else
            renderbar(blinkmeterimg, (Int local0), (Int local1), (Int local2), (Int local3), i_268\Field1, 700.0, $64, $64, $64)
        EndIf
        If (0.0 >= i_268\Field1) Then
            color($96, $96, $00)
            rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
        ElseIf (((i_714\Field0 > $00) Lor (wi\Field0 = $04)) <> 0) Then
            color($C8, $00, $00)
            rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
        ElseIf (i_268\Field0 = $03) Then
            color($00, $C8, $00)
            rect((Int (local0 - (Float local12))), (Int (local1 - (Float local13))), local11, local11, $01)
        EndIf
        color($FF, $FF, $FF)
        rect((Int (local0 - (Float local10))), (Int local1), local8, local8, $00)
        drawblock(t\Field0[$08], (Int (local0 - (Float local9))), (Int (local1 + 1.0)), $00)
    EndIf
    local1 = (local1 - local14)
    Return (Int local1)
    Return $00
End Function
