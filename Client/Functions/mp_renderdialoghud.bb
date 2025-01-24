Function mp_renderdialoghud%(arg0%, arg1%)
    Local local0#
    Local local1#
    Local local2%
    Local local4$[64]
    Local local5%
    Local local6$
    Local local7$[32]
    Local local8%
    Local local9$
    Local local10#
    Local local11#
    Local local13#
    If (mp_dialog\Field0 <> 0) Then
        setfontex(fo\Field0[arg0])
        local0 = (590.0 * menuscale)
        local1 = (180.0 * menuscale)
        Select mp_dialog\Field1
            Case $00
                local5 = $00
                local2 = $00
                Repeat
                    local6 = splitstring(mp_dialog\Field3, "\n", local2)
                    local2 = (local2 + $01)
                    If (len(local6) = $00) Then
                        Exit
                    EndIf
                    local5 = (local5 + $01)
                    local4[local5] = local6
                    If (local5 >= $3F) Then
                        Exit
                    EndIf
                Forever
                For local2 = $01 To local5 Step $01
                    local1 = (((Float (getlineamount(local4[local2], (Int (local0 * 0.9)), opt\Field47, (4.5 * menuscale)) * $18)) * menuscale) + local1)
                Next
            Case $02
                local1 = (220.0 * menuscale)
                local1 = (((Float (getlineamount(mp_dialog\Field3, (Int (local0 * 0.9)), opt\Field47, (4.5 * menuscale)) * $18)) * menuscale) + local1)
            Case $01
                local1 = (150.0 * menuscale)
                local8 = $00
                local2 = $00
                Repeat
                    local9 = splitstring(mp_dialog\Field3, "\n", local2)
                    local2 = (local2 + $01)
                    If (len(local9) = $00) Then
                        Exit
                    EndIf
                    local8 = (local8 + $01)
                    local7[local8] = local9
                    If (local8 >= $1F) Then
                        Exit
                    EndIf
                Forever
                local1 = (((31.0 * (Float local8)) * menuscale) + local1)
        End Select
        If (arg1 <> 0) Then
            rendermenubuttons()
        EndIf
        local10 = (Float (opt\Field46 Sar $01))
        local11 = ((Float (opt\Field47 Sar $01)) + (15.0 * menuscale))
        color($FF, $FF, $FF)
        textex((Int local10), (Int ((local11 - (local1 / 2.0)) + (15.0 * menuscale))), mp_dialog\Field2, $01, $00)
        Select mp_dialog\Field1
            Case $00
                local13 = 0.0
                For local2 = $01 To local5 Step $01
                    rowtext(local4[local2], (Int (local10 - ((local0 * 0.9) / 2.0))), (Int (((local11 - (local1 / 2.0)) + (80.0 * menuscale)) + local13)), (Int (local0 * 0.9)), (Int local1), mp_dialog\Field8, (4.5 * menuscale))
                    local13 = ((((Float getlineamount(local4[local2], (Int (local0 * 0.9)), opt\Field47, (4.5 * menuscale))) * 24.0) * menuscale) + local13)
                Next
            Case $02
                rowtext(mp_dialog\Field3, (Int (local10 - ((local0 * 0.9) / 2.0))), (Int ((local11 - (local1 / 2.0)) + (80.0 * menuscale))), (Int (local0 * 0.9)), (Int local1), $01, (4.5 * menuscale))
                rendermenuinputboxes()
            Case $01
        End Select
    EndIf
    Return $00
End Function
