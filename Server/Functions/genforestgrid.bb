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
    Local local16%
    Local local17%
    arg0\Field7 = (local0 + $01)
    local0 = (local0 + $01)
    local1 = rand($03, $07)
    local2 = rand($03, $07)
    For local3 = $00 To $09 Step $01
        For local4 = $00 To $09 Step $01
            arg0\Field2[((local4 * $0A) + local3)] = $00
        Next
    Next
    arg0\Field2[local1] = $03
    arg0\Field2[($5A + local2)] = $03
    local5 = local2
    local6 = $01
    local7 = $01
    arg0\Field2[((($09 - local6) * $0A) + local5)] = $01
    While (local6 < $06)
        If (local7 = $01) Then
            If (chance($28) <> 0) Then
                local7 = (rand($00, $01) Shl $01)
                local7 = turn_if_deviating($03, local5, $05, local7, $00)
                local8 = turn_if_deviating($03, local5, $05, local7, $01)
                If (local8 <> 0) Then
                    arg0\Field2[((($09 - local6) * $0A) + local5)] = $01
                EndIf
                local5 = move_forward(local7, local5, local6, $00)
                local6 = move_forward(local7, local5, local6, $01)
            EndIf
        Else
            local7 = turn_if_deviating($03, local5, $05, local7, $00)
            local8 = turn_if_deviating($03, local5, $05, local7, $01)
            If ((local8 Or chance($1B)) <> 0) Then
                local7 = $01
            EndIf
            local5 = move_forward(local7, local5, local6, $00)
            local6 = move_forward(local7, local5, local6, $01)
            If (local7 = $01) Then
                arg0\Field2[((($09 - local6) * $0A) + local5)] = $01
                local5 = move_forward(local7, local5, local6, $00)
                local6 = move_forward(local7, local5, local6, $01)
            EndIf
        EndIf
        arg0\Field2[((($09 - local6) * $0A) + local5)] = $01
    Wend
    local7 = $01
    While (local6 < $08)
        local5 = move_forward(local7, local5, local6, $00)
        local6 = move_forward(local7, local5, local6, $01)
        arg0\Field2[((($09 - local6) * $0A) + local5)] = $01
    Wend
    If (local5 <> local1) Then
        local7 = $00
        If (local1 > local5) Then
            local7 = $02
        EndIf
        While (local5 <> local1)
            local5 = move_forward(local7, local5, local6, $00)
            local6 = move_forward(local7, local5, local6, $01)
            arg0\Field2[((($09 - local6) * $0A) + local5)] = $01
        Wend
    EndIf
    local9 = $FFFFFFFD
    While (local9 < $04)
        local9 = (local9 + $04)
        local10 = local9
        local11 = $00
        If (chance($41) <> 0) Then
            local12 = $FFFFFFFF
            If (chance(local14) <> 0) Then
                local12 = $FFFFFFFE
            EndIf
            local13 = (rand($00, $01) Shl $01)
            local15 = $0A
            local16 = $00
            For local3 = $00 To $0A Step $01
                If (arg0\Field2[((($09 - local9) * $0A) + local3)] = $01) Then
                    If (local3 < local15) Then
                        local15 = local3
                    EndIf
                    If (local3 > local16) Then
                        local16 = local3
                    EndIf
                EndIf
            Next
            If (local13 = $00) Then
                local11 = (local15 - $01)
            Else
                local11 = (local16 + $01)
            EndIf
            If ((((local10 <> $00) And (arg0\Field2[(((($09 - local10) + $01) * $0A) + local11)] = $01)) Or (arg0\Field2[(((($09 - local10) - $01) * $0A) + local11)] = $01)) <> 0) Then
                Exit
            EndIf
            arg0\Field2[((($09 - local10) * $0A) + local11)] = local12
            If (local13 = $00) Then
                local11 = (local15 - $02)
            Else
                local11 = (local16 + $02)
            EndIf
            arg0\Field2[((($09 - local10) * $0A) + local11)] = local12
            local3 = $02
            While (local3 < $04)
                local3 = (local3 + $01)
                If (chance($12) <> 0) Then
                    Exit
                EndIf
                If (rand($00, $03) = $00) Then
                    If (local13 = $00) Then
                        local11 = (local11 - $01)
                    Else
                        local11 = (local11 + $01)
                    EndIf
                Else
                    local10 = (local10 + $01)
                EndIf
                local17 = (((($09 - local10) + $01) * $0A) + local11)
                If (local17 < $09) Then
                    If (((local10 <> $00) And (arg0\Field2[local17] = $01)) <> 0) Then
                        Exit
                    EndIf
                EndIf
                local17 = (((($09 - local10) - $01) * $0A) + local11)
                If (local17 > $00) Then
                    If (arg0\Field2[local17] = $01) Then
                        Exit
                    EndIf
                EndIf
                arg0\Field2[((($09 - local10) * $0A) + local11)] = local12
                If (local10 >= $08) Then
                    Exit
                EndIf
            Wend
        EndIf
    Wend
    For local3 = $00 To $09 Step $01
        For local4 = $00 To $09 Step $01
            If (arg0\Field2[((local3 * $0A) + local4)] = $FFFFFFFF) Then
                arg0\Field2[((local3 * $0A) + local4)] = $01
            ElseIf (arg0\Field2[((local3 * $0A) + local4)] = $FFFFFFFE) Then
                arg0\Field2[((local3 * $0A) + local4)] = $01
            EndIf
        Next
    Next
    Return $00
End Function
