Function genforestgrid%(arg0.forest)
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
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    catcherrors("GenForestGrid()")
    local0 = rand($03, $07)
    local1 = rand($03, $07)
    For local2 = $00 To $09 Step $01
        For local3 = $00 To $09 Step $01
            arg0\Field2[((local3 * $0A) + local2)] = $00
        Next
    Next
    arg0\Field2[local0] = $03
    arg0\Field2[($5A + local1)] = $03
    local4 = local1
    local5 = $01
    local6 = $01
    arg0\Field2[((($09 - local5) * $0A) + local4)] = $01
    While (local5 < $06)
        If (local6 = $01) Then
            If (chance($28) <> 0) Then
                local6 = (rand($00, $01) Shl $01)
                local6 = turnifdeviating($03, local4, $05, local6, $00)
                local7 = turnifdeviating($03, local4, $05, local6, $01)
                If (local7 <> 0) Then
                    arg0\Field2[((($09 - local5) * $0A) + local4)] = $01
                EndIf
                local4 = moveforward(local6, local4, local5, $00)
                local5 = moveforward(local6, local4, local5, $01)
            EndIf
        Else
            local6 = turnifdeviating($03, local4, $05, local6, $00)
            local7 = turnifdeviating($03, local4, $05, local6, $01)
            If ((local7 Lor chance($1B)) <> 0) Then
                local6 = $01
            EndIf
            local4 = moveforward(local6, local4, local5, $00)
            local5 = moveforward(local6, local4, local5, $01)
            If (local6 = $01) Then
                arg0\Field2[((($09 - local5) * $0A) + local4)] = $01
                local4 = moveforward(local6, local4, local5, $00)
                local5 = moveforward(local6, local4, local5, $01)
            EndIf
        EndIf
        arg0\Field2[((($09 - local5) * $0A) + local4)] = $01
    Wend
    local6 = $01
    While (local5 < $08)
        local4 = moveforward(local6, local4, local5, $00)
        local5 = moveforward(local6, local4, local5, $01)
        arg0\Field2[((($09 - local5) * $0A) + local4)] = $01
    Wend
    If (local4 <> local0) Then
        local6 = $00
        If (local0 > local4) Then
            local6 = $02
        EndIf
        While (local4 <> local0)
            local4 = moveforward(local6, local4, local5, $00)
            local5 = moveforward(local6, local4, local5, $01)
            arg0\Field2[((($09 - local5) * $0A) + local4)] = $01
        Wend
    EndIf
    local8 = $FFFFFFFD
    While (local8 < $04)
        local8 = (local8 + $04)
        local9 = local8
        local10 = $00
        If (chance($41) <> 0) Then
            local11 = (rand($00, $01) Shl $01)
            local12 = $09
            local13 = $00
            For local2 = $00 To $09 Step $01
                If (arg0\Field2[((($09 - local8) * $0A) + local2)] = $01) Then
                    local12 = (Int min((Float local12), (Float local2)))
                    local13 = (Int max((Float local13), (Float local2)))
                EndIf
            Next
            If (local11 = $00) Then
                local10 = (local12 - $01)
            Else
                local10 = (local13 + $01)
            EndIf
            If (((((local10 >= $00) And (local10 < $0A)) And (arg0\Field2[(((($09 - local9) - $01) * $0A) + local10)] <> $01)) And (arg0\Field2[(((($09 - local9) + $01) * $0A) + local10)] <> $01)) <> 0) Then
                arg0\Field2[((($09 - local9) * $0A) + local10)] = $FFFFFFFF
                If (local11 = $00) Then
                    local10 = (local12 - $02)
                Else
                    local10 = (local13 + $02)
                EndIf
                If (((local10 >= $00) And (local10 < $0A)) <> 0) Then
                    arg0\Field2[((($09 - local9) * $0A) + local10)] = $FFFFFFFF
                    local2 = $02
                    While (local2 < $04)
                        local2 = (local2 + $01)
                        If (chance($12) <> 0) Then
                            Exit
                        EndIf
                        If (rand($00, $03) = $00) Then
                            local10 = (local10 + ($01 - ((local11 = $00) Shl $01)))
                        Else
                            local9 = (local9 + $01)
                        EndIf
                        If ((((local10 < $00) Lor (local10 >= $0A)) Lor (arg0\Field2[(((($09 - local9) - $01) * $0A) + local10)] = $01)) <> 0) Then
                            Exit
                        EndIf
                        arg0\Field2[((($09 - local9) * $0A) + local10)] = $FFFFFFFF
                        If (local9 >= $08) Then
                            Exit
                        EndIf
                    Wend
                EndIf
            EndIf
        EndIf
    Wend
    If (opt\Field51 <> 0) Then
        Repeat
            showpointer()
            cls()
            mouseposx = (Float mousex())
            mouseposy = (Float mousey())
            local2 = $09
            For local14 = $00 To $09 Step $01
                For local15 = $00 To $09 Step $01
                    If (arg0\Field2[((local15 * $0A) + local14)] = $00) Then
                        color($32, $32, $32)
                        rect((Int ((Float (local2 Shl $05)) * menuscale)), (Int ((Float (local15 Shl $05)) * menuscale)), (Int (30.0 * menuscale)), (Int (30.0 * menuscale)), $01)
                    Else
                        color($FF, $FF, $FF)
                        rect((Int ((Float (local2 Shl $05)) * menuscale)), (Int ((Float (local15 Shl $05)) * menuscale)), (Int (30.0 * menuscale)), (Int (30.0 * menuscale)), $01)
                    EndIf
                Next
                local2 = (local2 - $01)
            Next
            local2 = $09
            For local14 = $00 To $09 Step $01
                For local15 = $00 To $09 Step $01
                    If (mouseon((Int ((Float (local2 Shl $05)) * menuscale)), (Int ((Float (local15 Shl $05)) * menuscale)), (Int (32.0 * menuscale)), (Int (32.0 * menuscale))) <> 0) Then
                        color($FF, $00, $00)
                    Else
                        color($00, $00, $00)
                    EndIf
                    textex((Int ((Float ((local2 Shl $05) + $02)) * menuscale)), (Int ((Float ((local15 Shl $05) + $02)) * menuscale)), (Str arg0\Field2[((local15 * $0A) + local14)]), $00, $00)
                Next
                local2 = (local2 - $01)
            Next
            renderloadingtext(mo\Field9, (Int ((Float opt\Field47) - (35.0 * menuscale))), getlocalstring("menu", "anykey"), $01, $01)
            flip($01)
            rendercursor()
        Until (((getkey() <> $00) Lor mousehit($01)) <> 0)
    EndIf
    For local2 = $01 To $08 Step $01
        For local3 = $00 To $09 Step $01
            If (arg0\Field2[((local2 * $0A) + local3)] = $FFFFFFFF) Then
                arg0\Field2[((local2 * $0A) + local3)] = $01
            EndIf
        Next
    Next
    catcherrors("Uncaught: GenForestGrid()")
    Return $00
End Function
