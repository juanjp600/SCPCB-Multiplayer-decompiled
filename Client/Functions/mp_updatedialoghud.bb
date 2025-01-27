Function mp_updatedialoghud%(arg0%)
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
    Local local12%
    Local local13%
    Local local14#
    Local local16#
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
                    local1 = (((Float (getlineamount(local4[local2], (Int (local0 * 0.9)), opt\Field50, (4.5 * menuscale)) * $18)) * menuscale) + local1)
                Next
            Case $02
                local1 = (220.0 * menuscale)
                local1 = (((Float (getlineamount(mp_dialog\Field3, (Int (local0 * 0.9)), opt\Field50, (4.5 * menuscale)) * $18)) * menuscale) + local1)
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
        local10 = (Float (opt\Field49 Sar $01))
        local11 = ((Float (opt\Field50 Sar $01)) + (15.0 * menuscale))
        updatemenubutton((Int (local10 - (local0 / 2.0))), (Int (local11 - (local1 / 2.0))), (Int local0), (Int local1), "", arg0, $00, $00, $FF, $FF, $FF, $00, 1.0, $01, $01)
        updatemenubutton((Int (local10 - (local0 / 2.0))), (Int ((local11 - (local1 / 2.0)) + (40.0 * menuscale))), (Int local0), (Int (4.0 * menuscale)), "", arg0, $00, $00, $FF, $FF, $FF, $00, 1.0, $01, $01)
        local12 = $00
        local13 = $00
        local14 = (140.0 * menuscale)
        If (mp_dialog\Field5 <> "") Then
            If (updatemenubutton((Int ((local10 - (130.0 * menuscale)) - (local14 / 2.0))), (Int (((local1 / 2.0) + local11) - (60.0 * menuscale))), (Int local14), (Int (45.0 * menuscale)), mp_dialog\Field4, arg0, $01, $00, $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                local13 = $01
                local12 = $01
            EndIf
            If (updatemenubutton((Int (((130.0 * menuscale) + local10) - (local14 / 2.0))), (Int (((local1 / 2.0) + local11) - (60.0 * menuscale))), (Int local14), (Int (45.0 * menuscale)), mp_dialog\Field5, arg0, $01, $00, $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
                local13 = $01
                local12 = $00
            EndIf
        ElseIf (updatemenubutton((Int (local10 - (local14 / 2.0))), (Int (((local1 / 2.0) + local11) - (60.0 * menuscale))), (Int local14), (Int (45.0 * menuscale)), mp_dialog\Field4, arg0, $01, $00, $FF, $FF, $FF, $00, 1.0, $00, $00) <> 0) Then
            local13 = $01
            local12 = $01
        EndIf
        Select mp_dialog\Field1
            Case $02
                mp_dialog\Field6 = updatemenuinputbox((Int (local10 - ((local0 * 0.8) / 2.0))), (Int (((local1 / 2.0) + local11) - (120.0 * menuscale))), (Int (local0 * 0.8)), (Int (45.0 * menuscale)), mp_dialog\Field6, arg0, $3E8, $40, 1.0)
            Case $01
                For local2 = $01 To local8 Step $01
                    local16 = (((local11 - (local1 / 2.0)) + (40.0 * menuscale)) + (((Float ($23 - ((local2 > $01) Shl $02))) * menuscale) * (Float (local2 - $01))))
                    If (updatemenubutton((Int (local10 - (local0 / 2.0))), (Int local16), (Int local0), (Int (35.0 * menuscale)), local7[local2], arg0, $00, (mp_dialog\Field7 = local2), $FF, $FF, $FF, $00, 0.1, $00, $00) <> 0) Then
                        mp_dialog\Field7 = local2
                        mo\Field3 = $00
                    EndIf
                    If ((mo\Field3 And mouseon((Int (local10 - (local0 / 2.0))), (Int local16), (Int local0), (Int (35.0 * menuscale)))) <> 0) Then
                        local13 = $01
                        local12 = mp_dialog\Field7
                        mo\Field3 = $00
                    EndIf
                Next
        End Select
        If (keyhit($1C) <> 0) Then
            local13 = $01
            local12 = $01
            If (mp_dialog\Field1 = $01) Then
                local12 = mp_dialog\Field7
            EndIf
        ElseIf (keyhit($01) <> 0) Then
            local13 = $01
            local12 = $00
        EndIf
        If (local13 <> 0) Then
            If (mp_dialog\Field10 <> $00) Then
                mp_dialog\Field11 = mp_dialog\Field10
                mp_dialog\Field13 = local12
                mp_dialog\Field12 = mp_dialog\Field6
            EndIf
            mp_dialog\Field9 = 20.0
            mp_cleardialog()
            shoulddeletegadgets = $01
            playsound_strict(buttonsfx[$00], $00)
        EndIf
        ismultiplayerhudenabled = $01
        menuopen = $00
        consoleopen = $00
    EndIf
    mp_dialog\Field9 = (mp_dialog\Field9 - fps\Field7[$01])
    Return $00
End Function
