Function rendermenusliders%()
    Local local0.menuslider
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    For local0 = Each menuslider
        local1 = local0\Field0
        local2 = (Int ((Float local0\Field1) - (8.0 * menuscale)))
        local3 = local0\Field1
        local4 = (Int ((Float local0\Field2) + (14.0 * menuscale)))
        local5 = (Int (4.0 * menuscale))
        local6 = (Int (9.0 * menuscale))
        local7 = (Int (10.0 * menuscale))
        local8 = $C8
        local9 = $C8
        local10 = $C8
        If (((local0\Field4 = onsliderid) Lor mouseon(local1, local2, local4, (local6 + local7))) <> 0) Then
            local8 = $00
            local9 = $C8
            local10 = $00
        EndIf
        color(local8, local9, local10)
        rect(local1, local3, local4, local7, $01)
        rect(local1, local2, local5, local6, $01)
        setfontex(fo\Field0[$00])
        If (local0\Field10 = $03) Then
            rect((Int ((Float ((local0\Field2 Sar $01) + local1)) + (5.0 * menuscale))), local2, local5, local6, $01)
            rect((Int ((Float (local0\Field2 + local1)) + (10.0 * menuscale))), local2, local5, local6, $01)
            color($AA, $AA, $AA)
            If (local0\Field3 = $00) Then
                drawblock(blinkmeterimg, local1, local2, $00)
                textex((Int ((2.0 * menuscale) + (Float local1))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field5, $01, $00)
            ElseIf (local0\Field3 = $01) Then
                drawblock(blinkmeterimg, (Int ((Float ((local0\Field2 Sar $01) + local1)) + (3.0 * menuscale))), local2, $00)
                textex((Int ((Float ((local0\Field2 Sar $01) + local1)) + (7.0 * menuscale))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field6, $01, $00)
            Else
                drawblock(blinkmeterimg, (Int ((Float (local0\Field2 + local1)) + (6.0 * menuscale))), local2, $00)
                textex((Int ((Float (local0\Field2 + local1)) + (12.0 * menuscale))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field7, $01, $00)
            EndIf
        ElseIf (local0\Field10 = $05) Then
            rect((Int ((Float ((local0\Field2 Sar $02) + local1)) + (2.5 * menuscale))), local2, local5, local6, $01)
            rect((Int ((Float ((local0\Field2 Sar $01) + local1)) + (5.0 * menuscale))), local2, local5, local6, $01)
            rect((Int ((((Float local0\Field2) * 0.75) + (Float local1)) + (7.5 * menuscale))), local2, local5, local6, $01)
            rect((Int ((Float (local0\Field2 + local1)) + (10.0 * menuscale))), local2, local5, local6, $01)
            color($AA, $AA, $AA)
            If (local0\Field3 = $00) Then
                drawblock(blinkmeterimg, local1, local2, $00)
                textex((Int ((2.0 * menuscale) + (Float local1))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field5, $01, $00)
            ElseIf (local0\Field3 = $01) Then
                drawblock(blinkmeterimg, (Int ((Float ((local0\Field2 Sar $02) + local1)) + (1.5 * menuscale))), local2, $00)
                textex((Int ((Float ((local0\Field2 Sar $02) + local1)) + (4.5 * menuscale))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field6, $01, $00)
            ElseIf (local0\Field3 = $02) Then
                drawblock(blinkmeterimg, (Int ((Float ((local0\Field2 Sar $01) + local1)) + (3.0 * menuscale))), local2, $00)
                textex((Int ((Float ((local0\Field2 Sar $01) + local1)) + (7.0 * menuscale))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field7, $01, $00)
            ElseIf (local0\Field3 = $03) Then
                drawblock(blinkmeterimg, (Int ((((Float local0\Field2) * 0.75) + (Float local1)) + (4.5 * menuscale))), local2, $00)
                textex((Int ((((Float local0\Field2) * 0.75) + (Float local1)) + (9.5 * menuscale))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field8, $01, $00)
            Else
                drawblock(blinkmeterimg, (Int ((Float (local0\Field2 + local1)) + (6.0 * menuscale))), local2, $00)
                textex((Int ((Float (local0\Field2 + local1)) + (12.0 * menuscale))), (Int ((12.0 * menuscale) + (Float local3))), local0\Field9, $01, $00)
            EndIf
        EndIf
    Next
    Return $00
End Function
