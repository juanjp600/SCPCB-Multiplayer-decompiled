Function se_invokeuserfunction%(arg0.se_funcptr, arg1%)
    Local local0.se_funcptr
    Local local1.se_script
    Local local2%
    Local local3%
    Local local4.se_value
    Local local5.se_value
    Local local6%
    Local local8.se_inst
    Local local9.se_value
    Local local10.se_value
    Local local11.se_value
    Local local12%
    Local local13%
    Local local95%
    Local local97.se_funcptr
    Local local98.se_value
    Local local99%
    Local local100%
    Local local102%
    If (((arg0 = Null) Or (se_call_depth >= $40)) <> 0) Then
        Return $00
    EndIf
    se_call_depth = (se_call_depth + $01)
    local0 = se_current_function
    local1 = se_current_script
    se_current_function = arg0
    se_current_script = arg0\Field1
    local2 = se_transient_stack_level
    local3 = se_transient_stack_offset
    se_transient_stack_offset = se_transient_stack_level
    se_transient_stack_level = (se_transient_stack_level + se_current_function\Field4)
    se_growtransient()
    If (se_arguments_number > $00) Then
        se_arguments_stack_offset = (se_arguments_stack_level - se_arguments_number)
        For local6 = $00 To (se_current_function\Field5 - $01) Step $01
            If (local6 = se_arguments_number) Then
                Exit
            EndIf
            local4 = se_arguments_stack((se_arguments_stack_offset + local6))
            local5 = se_transient_stack((se_transient_stack_offset + local6))
            Select local4\Field0
                Case $01
                    local5\Field0 = $01
                    local5\Field2 = local4\Field2
                Case $02
                    local5\Field0 = $02
                    local5\Field3 = local4\Field3
                Case $03
                    local5\Field0 = $03
                    local5\Field4 = local4\Field4
                Case $05
                    local5\Field0 = $05
                    local5\Field5 = local4\Field5
                Case $07
                    local5\Field0 = $07
                    local5\Field6 = local4\Field6
                    local4\Field6\Field0 = (local4\Field6\Field0 + $01)
            End Select
        Next
    EndIf
    local8 = se_current_function\Field2
    local9 = Null
    local10 = Null
    local11 = Null
    Repeat
        local13 = (local13 + $01)
        If (local13 > $F4240) Then
            Exit
        EndIf
        local9 = local8\Field1
        local10 = local8\Field2
        local11 = local8\Field3
        local12 = $00
        If (local9 <> Null) Then
            If (local9\Field0 = $04) Then
                local9 = se_transient_stack((local9\Field2 + se_transient_stack_offset))
            EndIf
        EndIf
        If (local10 <> Null) Then
            If (local10\Field0 = $04) Then
                local10 = se_transient_stack((local10\Field2 + se_transient_stack_offset))
            EndIf
        EndIf
        If (local11 <> Null) Then
            If (local11\Field0 = $04) Then
                local11 = se_transient_stack((local11\Field2 + se_transient_stack_offset))
            EndIf
        EndIf
        Select local8\Field0
            Case $01
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                se_gccheck(local9)
                Select local10\Field0
                    Case $00
                        local9\Field0 = $00
                    Case $01
                        local9\Field0 = $01
                        local9\Field2 = local10\Field2
                    Case $02
                        local9\Field0 = $02
                        local9\Field3 = local10\Field3
                    Case $03
                        local9\Field0 = $03
                        local9\Field4 = local10\Field4
                    Case $07
                        local9\Field0 = $07
                        local9\Field6 = local10\Field6
                        local9\Field6\Field0 = (local9\Field6\Field0 + $01)
                End Select
            Case $02
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                Select local9\Field0
                    Case $00
                        Select local10\Field0
                            Case $00
                                local11\Field0 = $01
                                local11\Field2 = $00
                            Case $01
                                local11\Field0 = $01
                                local11\Field2 = local10\Field2
                            Case $02
                                local11\Field0 = $02
                                local11\Field3 = local10\Field3
                            Case $03
                                local11\Field0 = $03
                                local11\Field4 = ("null" + local10\Field4)
                            Default
                                local11\Field0 = $03
                                local11\Field4 = "nullNaN"
                        End Select
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field0 = $01
                                local11\Field2 = local9\Field2
                            Case $01
                                local11\Field0 = $01
                                local11\Field2 = (local9\Field2 + local10\Field2)
                            Case $02
                                local11\Field0 = $02
                                local11\Field3 = ((Float local9\Field2) + local10\Field3)
                            Case $03
                                local11\Field0 = $03
                                local11\Field4 = ((Str local9\Field2) + local10\Field4)
                            Default
                                local11\Field0 = $03
                                local11\Field4 = ((Str local9\Field2) + "NaN")
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field0 = $02
                                local11\Field3 = local9\Field3
                            Case $01
                                local11\Field0 = $02
                                local11\Field3 = (local9\Field3 + (Float local10\Field2))
                            Case $02
                                local11\Field0 = $02
                                local11\Field3 = (local9\Field3 + local10\Field3)
                            Case $03
                                local11\Field0 = $03
                                local11\Field4 = ((Str local9\Field3) + local10\Field4)
                            Default
                                local11\Field0 = $03
                                local11\Field4 = ((Str local9\Field3) + "NaN")
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field0 = $03
                                local11\Field4 = (local9\Field4 + "null")
                            Case $01
                                local11\Field0 = $03
                                local11\Field4 = (local9\Field4 + (Str local10\Field2))
                            Case $02
                                local11\Field0 = $03
                                local11\Field4 = (local9\Field4 + (Str local10\Field3))
                            Case $03
                                local11\Field0 = $03
                                local11\Field4 = (local9\Field4 + local10\Field4)
                            Default
                                local11\Field0 = $03
                                local11\Field4 = (local9\Field4 + "NaN")
                        End Select
                    Default
                        local11\Field0 = $03
                        local11\Field4 = "NaN"
                End Select
            Case $03
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                If (((local9\Field0 < $03) And (local10\Field0 < $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field0 = $01
                                    local11\Field2 = (- local10\Field2)
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = (- local10\Field3)
                            End Select
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = local9\Field2
                                Case $01
                                    local11\Field0 = $01
                                    local11\Field2 = (local9\Field2 - local10\Field2)
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = ((Float local9\Field2) - local10\Field3)
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $02
                                    local11\Field3 = 0.0
                                Case $01
                                    local11\Field0 = $02
                                    local11\Field3 = (local9\Field3 - (Float local10\Field2))
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = (local9\Field3 - local10\Field3)
                            End Select
                    End Select
                Else
                    local11\Field0 = $03
                    local11\Field4 = "NaN"
                EndIf
            Case $04
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                If (((local9\Field0 < $03) And (local10\Field0 < $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            local11\Field0 = $01
                            local11\Field2 = $00
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field0 = $01
                                    local11\Field2 = (local9\Field2 * local10\Field2)
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = ((Float local9\Field2) * local10\Field3)
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field0 = $02
                                    local11\Field3 = (local9\Field3 * (Float local10\Field2))
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = (local9\Field3 * local10\Field3)
                            End Select
                    End Select
                Else
                    local11\Field0 = $03
                    local11\Field4 = "NaN"
                EndIf
            Case $05
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                If (((local9\Field0 < $03) And (local10\Field0 < $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $03
                                    local11\Field4 = "NaN"
                                Case $01
                                    If (local10\Field2 <> $00) Then
                                        local11\Field0 = $01
                                        local11\Field2 = $00
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local10\Field3) Then
                                        local11\Field0 = $01
                                        local11\Field2 = $00
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                            End Select
                        Case $01
                            If (local9\Field2 <> $00) Then
                                Select local10\Field0
                                    Case $00
                                        local11\Field0 = $03
                                        local11\Field4 = "Infinity"
                                    Case $01
                                        If (local10\Field2 <> $00) Then
                                            local11\Field0 = $01
                                            local11\Field2 = (local9\Field2 / local10\Field2)
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "Infinity"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local10\Field3) Then
                                            local11\Field0 = $02
                                            local11\Field3 = ((Float local9\Field2) / local10\Field3)
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "Infinity"
                                        EndIf
                                End Select
                            Else
                                Select local10\Field0
                                    Case $00
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    Case $01
                                        If (local10\Field2 <> $00) Then
                                            local11\Field0 = $01
                                            local11\Field2 = (local9\Field2 / local10\Field2)
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "NaN"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local10\Field3) Then
                                            local11\Field0 = $02
                                            local11\Field3 = ((Float local9\Field2) / local10\Field3)
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "NaN"
                                        EndIf
                                End Select
                            EndIf
                        Case $02
                            If (local9\Field2 <> $00) Then
                                Select local10\Field0
                                    Case $00
                                        local11\Field0 = $03
                                        local11\Field4 = "Infinity"
                                    Case $01
                                        If (local10\Field2 <> $00) Then
                                            local11\Field0 = $02
                                            local11\Field2 = (Int (local9\Field3 / (Float local10\Field2)))
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "Infinity"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local10\Field3) Then
                                            local11\Field0 = $02
                                            local11\Field3 = (local9\Field3 / local10\Field3)
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "Infinity"
                                        EndIf
                                End Select
                            Else
                                Select local10\Field0
                                    Case $00
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    Case $01
                                        If (local10\Field2 <> $00) Then
                                            local11\Field0 = $02
                                            local11\Field3 = (local9\Field3 / (Float local10\Field2))
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "NaN"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local10\Field3) Then
                                            local11\Field0 = $02
                                            local11\Field3 = (local9\Field3 / local10\Field3)
                                        Else
                                            local11\Field0 = $03
                                            local11\Field4 = "NaN"
                                        EndIf
                                End Select
                            EndIf
                    End Select
                Else
                    local11\Field0 = $03
                    local11\Field4 = "NaN"
                EndIf
            Case $06
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                If (((local9\Field0 < $03) And (local10\Field0 < $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = $01
                                Case $01
                                    local11\Field0 = $01
                                    local11\Field2 = (Int (0.0 ^ (Float local10\Field2)))
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = (0.0 ^ local10\Field3)
                            End Select
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = $01
                                Case $01
                                    local11\Field0 = $01
                                    local11\Field2 = (Int ((Float local9\Field2) ^ (Float local10\Field2)))
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = ((Float local9\Field2) ^ local10\Field3)
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $01
                                    local11\Field2 = $01
                                Case $01
                                    local11\Field0 = $02
                                    local11\Field3 = (local9\Field3 ^ (Float local10\Field2))
                                Case $02
                                    local11\Field0 = $02
                                    local11\Field3 = (local9\Field3 ^ local10\Field3)
                            End Select
                    End Select
                Else
                    local11\Field0 = $03
                    local11\Field4 = "NaN"
                EndIf
            Case $07
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                If (((local9\Field0 < $03) And (local10\Field0 < $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $03
                                    local11\Field4 = "NaN"
                                Case $01
                                    If (local10\Field2 <> $00) Then
                                        local11\Field0 = $01
                                        local11\Field2 = $00
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local10\Field3) Then
                                        local11\Field0 = $02
                                        local11\Field3 = 0.0
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                            End Select
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $03
                                    local11\Field4 = "NaN"
                                Case $01
                                    If (local10\Field2 <> $00) Then
                                        local11\Field0 = $01
                                        local11\Field2 = (local9\Field2 Mod local10\Field2)
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local10\Field3) Then
                                        local11\Field0 = $02
                                        local11\Field3 = ((Float local9\Field2) Mod local10\Field3)
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field0 = $03
                                    local11\Field4 = "NaN"
                                Case $01
                                    If (local10\Field2 <> $00) Then
                                        local11\Field0 = $02
                                        local11\Field3 = (local9\Field3 Mod (Float local10\Field2))
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local10\Field3) Then
                                        local11\Field0 = $02
                                        local11\Field3 = (local9\Field3 Mod local10\Field3)
                                    Else
                                        local11\Field0 = $03
                                        local11\Field4 = "NaN"
                                    EndIf
                            End Select
                    End Select
                Else
                    local11\Field0 = $03
                    local11\Field4 = "NaN"
                EndIf
            Case $08
                local9 = se_getfinalvalue(local9)
                Select local9\Field0
                    Case $00
                        local10\Field0 = $01
                        local10\Field2 = $00
                    Case $01
                        local10\Field0 = $01
                        local10\Field2 = (- local9\Field2)
                    Case $02
                        local10\Field0 = $02
                        local10\Field3 = (- local9\Field3)
                    Default
                        local10\Field0 = $03
                        local10\Field4 = "NaN"
                End Select
            Case $09
                local9 = se_getfinalvalue(local9)
                Select local9\Field0
                    Case $00
                        local9\Field0 = $01
                        local9\Field2 = $01
                    Case $01
                        local9\Field2 = (local9\Field2 + $01)
                    Case $02
                        local9\Field3 = (local9\Field3 + 1.0)
                    Default
                        local9\Field4 = "NaN"
                End Select
            Case $0A
                local9 = se_getfinalvalue(local9)
                Select local9\Field0
                    Case $00
                        local9\Field0 = $01
                        local9\Field2 = $FFFFFFFF
                    Case $01
                        local9\Field2 = (local9\Field2 - $01)
                    Case $02
                        local9\Field3 = (local9\Field3 - 1.0)
                    Default
                        local9\Field4 = "NaN"
                End Select
            Case $0B
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                Select local9\Field0
                    Case $00
                        If (local10\Field0 = $00) Then
                            local11\Field2 = $01
                        Else
                            local11\Field2 = $00
                        EndIf
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = (local9\Field2 = local10\Field2)
                            Case $02
                                local11\Field2 = (local10\Field3 = (Float local9\Field2))
                            Case $03
                                local11\Field2 = ((Str local9\Field2) = local10\Field4)
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = ((Float local10\Field2) = local9\Field3)
                            Case $02
                                local11\Field2 = (local10\Field3 = local9\Field3)
                            Case $03
                                local11\Field2 = ((Str local9\Field3) = local10\Field4)
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = (local9\Field4 = (Str local10\Field2))
                            Case $02
                                local11\Field2 = (local9\Field4 = (Str local10\Field3))
                            Case $03
                                local11\Field2 = (local9\Field4 = local10\Field4)
                        End Select
                    Case $07
                        If (local10\Field0 = $07) Then
                            local11\Field2 = (local9\Field6 = local10\Field6)
                        Else
                            local11\Field2 = $00
                        EndIf
                End Select
            Case $0C
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                Select local9\Field0
                    Case $00
                        If (local10\Field0 = $00) Then
                            local11\Field2 = $00
                        Else
                            local11\Field2 = $01
                        EndIf
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = (local9\Field2 <> local10\Field2)
                            Case $02
                                local11\Field2 = (local10\Field3 <> (Float local9\Field2))
                            Case $03
                                local11\Field2 = ((Str local9\Field2) <> local10\Field4)
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = ((Float local10\Field2) <> local9\Field3)
                            Case $02
                                local11\Field2 = (local10\Field3 <> local9\Field3)
                            Case $03
                                local11\Field2 = ((Str local9\Field3) <> local10\Field4)
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = (local9\Field4 <> (Str local10\Field2))
                            Case $02
                                local11\Field2 = (local9\Field4 <> (Str local10\Field3))
                            Case $03
                                local11\Field2 = (local9\Field4 <> local10\Field4)
                        End Select
                    Case $07
                        If (local10\Field0 = $07) Then
                            local11\Field2 = (local9\Field6 <> local10\Field6)
                        Else
                            local11\Field2 = $01
                        EndIf
                End Select
            Case $0D
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                Select local9\Field0
                    Case $00
                        local11\Field2 = $00
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = (local9\Field2 > local10\Field2)
                            Case $02
                                local11\Field2 = (local10\Field3 < (Float local9\Field2))
                            Case $03
                                local11\Field2 = ((Str local9\Field2) > local10\Field4)
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = ((Float local10\Field2) < local9\Field3)
                            Case $02
                                local11\Field2 = (local10\Field3 < local9\Field3)
                            Case $03
                                local11\Field2 = ((Str local9\Field3) > local10\Field4)
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = (local9\Field4 > (Str local10\Field2))
                            Case $02
                                local11\Field2 = (local9\Field4 > (Str local10\Field3))
                            Case $03
                                local11\Field2 = (local9\Field4 > local10\Field4)
                        End Select
                    Case $07
                        If (local10\Field0 = $07) Then
                            local11\Field2 = (local9\Field6\Field1 > local10\Field6\Field1)
                        Else
                            local11\Field2 = $00
                        EndIf
                End Select
            Case $0E
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                Select local9\Field0
                    Case $00
                        If (local10\Field0 = $00) Then
                            local11\Field2 = $00
                        Else
                            local11\Field2 = $01
                        EndIf
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = (local9\Field2 < local10\Field2)
                            Case $02
                                local11\Field2 = (local10\Field3 > (Float local9\Field2))
                            Case $03
                                local11\Field2 = ((Str local9\Field2) < local10\Field4)
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = ((Float local10\Field2) > local9\Field3)
                            Case $02
                                local11\Field2 = (local10\Field3 > local9\Field3)
                            Case $03
                                local11\Field2 = ((Str local9\Field3) < local10\Field4)
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = (local9\Field4 < (Str local10\Field2))
                            Case $02
                                local11\Field2 = (local9\Field4 < (Str local10\Field3))
                            Case $03
                                local11\Field2 = (local9\Field4 < local10\Field4)
                        End Select
                    Case $07
                        If (local10\Field0 = $07) Then
                            local11\Field2 = (local9\Field6\Field1 < local10\Field6\Field1)
                        Else
                            local11\Field2 = $00
                        EndIf
                End Select
            Case $0F
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                Select local9\Field0
                    Case $00
                        If (local10\Field0 = $00) Then
                            local11\Field2 = $01
                        Else
                            local11\Field2 = $00
                        EndIf
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = (local9\Field2 >= local10\Field2)
                            Case $02
                                local11\Field2 = (local10\Field3 <= (Float local9\Field2))
                            Case $03
                                local11\Field2 = ((Str local9\Field2) >= local10\Field4)
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = ((Float local10\Field2) <= local9\Field3)
                            Case $02
                                local11\Field2 = (local10\Field3 <= local9\Field3)
                            Case $03
                                local11\Field2 = ((Str local9\Field3) >= local10\Field4)
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $01
                            Case $01
                                local11\Field2 = (local9\Field4 >= (Str local10\Field2))
                            Case $02
                                local11\Field2 = (local9\Field4 >= (Str local10\Field3))
                            Case $03
                                local11\Field2 = (local9\Field4 >= local10\Field4)
                        End Select
                    Case $07
                        If (local10\Field0 = $07) Then
                            local11\Field2 = (local9\Field6\Field1 >= local10\Field6\Field1)
                        Else
                            local11\Field2 = $00
                        EndIf
                End Select
            Case $10
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                Select local9\Field0
                    Case $00
                        local11\Field2 = $01
                    Case $01
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = (local9\Field2 <= local10\Field2)
                            Case $02
                                local11\Field2 = (local10\Field3 >= (Float local9\Field2))
                            Case $03
                                local11\Field2 = ((Str local9\Field2) <= local10\Field4)
                        End Select
                    Case $02
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = ((Float local10\Field2) >= local9\Field3)
                            Case $02
                                local11\Field2 = (local10\Field3 >= local9\Field3)
                            Case $03
                                local11\Field2 = ((Str local9\Field3) <= local10\Field4)
                        End Select
                    Case $03
                        Select local10\Field0
                            Case $00
                                local11\Field2 = $00
                            Case $01
                                local11\Field2 = (local9\Field4 <= (Str local10\Field2))
                            Case $02
                                local11\Field2 = (local9\Field4 <= (Str local10\Field3))
                            Case $03
                                local11\Field2 = (local9\Field4 <= local10\Field4)
                        End Select
                    Case $07
                        If (local10\Field0 = $07) Then
                            local11\Field2 = (local9\Field6\Field1 <= local10\Field6\Field1)
                        Else
                            local11\Field2 = $00
                        EndIf
                End Select
            Case $11
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                If (((local9\Field0 <= $03) And (local10\Field0 <= $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            local11\Field2 = $00
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field2 = (local9\Field2 And local10\Field2)
                                Case $02
                                    local11\Field2 = (local9\Field2 And (Int local10\Field3))
                                Case $03
                                    local11\Field2 = (local9\Field2 And (Int local10\Field4))
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) And local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) And (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) And (Int local10\Field4))
                            End Select
                        Case $03
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) And local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) And (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) And (Int local10\Field4))
                            End Select
                    End Select
                Else
                    local11\Field2 = $00
                EndIf
            Case $12
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                If (((local9\Field0 <= $03) And (local10\Field0 <= $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field2 = local10\Field2
                                Case $02
                                    local11\Field2 = (Int local10\Field3)
                                Case $03
                                    local11\Field2 = (Int local10\Field4)
                            End Select
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = local9\Field2
                                Case $01
                                    local11\Field2 = (local9\Field2 Xor local10\Field2)
                                Case $02
                                    local11\Field2 = (local9\Field2 Xor (Int local10\Field3))
                                Case $03
                                    local11\Field2 = (local9\Field2 Xor (Int local10\Field4))
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field3)
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) Xor local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) Xor (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) Xor (Int local10\Field4))
                            End Select
                        Case $03
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field4)
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) Xor local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) Xor (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) Xor (Int local10\Field4))
                            End Select
                    End Select
                Else
                    local11\Field2 = $00
                EndIf
            Case $14
                local9 = se_getfinalvalue(local9)
                local10\Field0 = $01
                Select local9\Field0
                    Case $00
                        local10\Field2 = $FFFFFFFF
                    Case $01
                        local10\Field2 = (local9\Field2 Xor $FFFFFFFF)
                    Case $02
                        local10\Field2 = ((Int local9\Field3) Xor $FFFFFFFF)
                    Case $03
                        local10\Field2 = ((Int local9\Field4) Xor $FFFFFFFF)
                    Default
                        local10\Field2 = $FFFFFFFF
                End Select
            Case $13
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                If (((local9\Field0 <= $03) And (local10\Field0 <= $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = $00
                                Case $01
                                    local11\Field2 = local10\Field2
                                Case $02
                                    local11\Field2 = (Int local10\Field3)
                                Case $03
                                    local11\Field2 = (Int local10\Field4)
                            End Select
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = local9\Field2
                                Case $01
                                    local11\Field2 = (local9\Field2 Or local10\Field2)
                                Case $02
                                    local11\Field2 = (local9\Field2 Or (Int local10\Field3))
                                Case $03
                                    local11\Field2 = (local9\Field2 Or (Int local10\Field4))
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field3)
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) Or local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) Or (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) Or (Int local10\Field4))
                            End Select
                        Case $03
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field4)
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) Or local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) Or (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) Or (Int local10\Field4))
                            End Select
                    End Select
                Else
                    local11\Field2 = $00
                EndIf
            Case $15
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                If (((local9\Field0 <= $03) And (local10\Field0 <= $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            local11\Field2 = $00
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = local9\Field2
                                Case $01
                                    local11\Field2 = (local9\Field2 Shl local10\Field2)
                                Case $02
                                    local11\Field2 = (local9\Field2 Shl (Int local10\Field3))
                                Case $03
                                    local11\Field2 = (local9\Field2 Shl (Int local10\Field4))
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field3)
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) Shl local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) Shl (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) Shl (Int local10\Field4))
                            End Select
                        Case $03
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field4)
                                Case $01
                                    local11\Field2 = ((Int local9\Field4) Shl local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field4) Shl (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field4) Shl (Int local10\Field4))
                            End Select
                    End Select
                Else
                    local11\Field2 = $00
                EndIf
            Case $16
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field0 = $01
                If (((local9\Field0 <= $03) And (local10\Field0 <= $03)) <> 0) Then
                    Select local9\Field0
                        Case $00
                            local11\Field2 = $00
                        Case $01
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = local9\Field2
                                Case $01
                                    local11\Field2 = (local9\Field2 Shr local10\Field2)
                                Case $02
                                    local11\Field2 = (local9\Field2 Shr (Int local10\Field3))
                                Case $03
                                    local11\Field2 = (local9\Field2 Shr (Int local10\Field4))
                            End Select
                        Case $02
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field3)
                                Case $01
                                    local11\Field2 = ((Int local9\Field3) Shr local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field3) Shr (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field3) Shr (Int local10\Field4))
                            End Select
                        Case $03
                            Select local10\Field0
                                Case $00
                                    local11\Field2 = (Int local9\Field4)
                                Case $01
                                    local11\Field2 = ((Int local9\Field4) Shr local10\Field2)
                                Case $02
                                    local11\Field2 = ((Int local9\Field4) Shr (Int local10\Field3))
                                Case $03
                                    local11\Field2 = ((Int local9\Field4) Shr (Int local10\Field4))
                            End Select
                    End Select
                Else
                    local11\Field2 = $00
                EndIf
            Case $17
                local9 = se_getfinalvalue(local9)
                local10\Field0 = $01
                Select local9\Field0
                    Case $00
                        local10\Field2 = $01
                    Case $01
                        local10\Field2 = (local9\Field2 = $00)
                    Case $02
                        local10\Field2 = (0.0 = local9\Field3)
                    Case $03
                        local10\Field2 = (local9\Field4 = "0")
                    Default
                        local10\Field2 = $00
                End Select
            Case $18
                local8 = local9\Field7
                local12 = $01
            Case $1A
                local9 = se_getfinalvalue(local9)
                Select local9\Field0
                    Case $00
                        local8 = local10\Field7
                        local12 = $01
                    Case $01
                        If (local9\Field2 = $00) Then
                            local8 = local10\Field7
                            local12 = $01
                        EndIf
                    Case $02
                        If (0.0 = local9\Field3) Then
                            local8 = local10\Field7
                            local12 = $01
                        EndIf
                    Case $03
                        If (local9\Field4 = "") Then
                            local8 = local10\Field7
                            local12 = $01
                        EndIf
                End Select
            Case $19
                local9 = se_getfinalvalue(local9)
                Select local9\Field0
                    Case $01
                        If (local9\Field2 <> $00) Then
                            local8 = local10\Field7
                            local12 = $01
                        EndIf
                    Case $02
                        If (0.0 <> local9\Field3) Then
                            local8 = local10\Field7
                            local12 = $01
                        EndIf
                    Case $03
                        If (local9\Field4 <> "") Then
                            local8 = local10\Field7
                            local12 = $01
                        EndIf
                    Case $07
                        local8 = local10\Field7
                        local12 = $01
                End Select
            Case $1B
                If (se_arguments_stack_level >= $1000) Then
                    Exit
                EndIf
                If (local9\Field0 = $06) Then
                    local9 = se_getaccessorvalue(local9)
                EndIf
                local95 = se_arguments_stack_level
                se_arguments_stack_level = (se_arguments_stack_level + $01)
                se_growarguments()
                Select local9\Field0
                    Case $00
                        se_arguments_stack(local95)\Field0 = $00
                    Case $01
                        se_arguments_stack(local95)\Field0 = $01
                        se_arguments_stack(local95)\Field2 = local9\Field2
                    Case $02
                        se_arguments_stack(local95)\Field0 = $02
                        se_arguments_stack(local95)\Field3 = local9\Field3
                    Case $03
                        se_arguments_stack(local95)\Field0 = $03
                        se_arguments_stack(local95)\Field4 = local9\Field4
                    Case $05
                        se_arguments_stack(local95)\Field0 = $05
                        se_arguments_stack(local95)\Field5 = local9\Field5
                    Case $07
                        se_arguments_stack(local95)\Field0 = $07
                        se_arguments_stack(local95)\Field6 = local9\Field6
                End Select
            Case $1C
                If (local10\Field0 <> $01) Then
                    Exit
                EndIf
                If ((((local10\Field2 < $00) Or (local10\Field2 > $40)) Or (local10\Field2 > se_arguments_stack_level)) <> 0) Then
                    Exit
                EndIf
                local97 = se_current_function
                local98 = se_return_value
                local99 = se_arguments_number
                local100 = se_arguments_stack_offset
                local11\Field0 = $00
                se_return_value = local11
                se_arguments_number = local10\Field2
                If (local9\Field0 = $09) Then
                    se_invokeuserfunction(local9\Field8, $00)
                EndIf
                se_current_function = local97
                se_return_value = local98
                se_arguments_number = local99
                se_arguments_stack_offset = local100
            Case $1D
                If (local10\Field0 <> $01) Then
                    Exit
                EndIf
                If ((((local10\Field2 < $00) Or (local10\Field2 > $40)) Or (local10\Field2 > se_arguments_stack_level)) <> 0) Then
                    Exit
                EndIf
                local98 = se_return_value
                local99 = se_arguments_number
                local100 = se_arguments_stack_offset
                se_return_value = local11
                se_arguments_number = local10\Field2
                se_arguments_stack_offset = (se_arguments_stack_level - se_arguments_number)
                se_invokeglobalfunction(local9\Field9, arg0)
                se_return_value = local98
                se_arguments_number = local99
                se_arguments_stack_level = se_arguments_stack_offset
                se_arguments_stack_offset = local100
            Case $1E
                local9 = se_getfinalvalue(local9)
                Select local9\Field0
                    Case $00
                        se_return_value\Field0 = $00
                    Case $01
                        se_return_value\Field0 = $01
                        se_return_value\Field2 = local9\Field2
                        If (local9\Field2 = $00) Then
                            se_return_value\Field9 = $01
                        EndIf
                    Case $02
                        se_return_value\Field0 = $02
                        se_return_value\Field3 = local9\Field3
                    Case $03
                        se_return_value\Field0 = $03
                        se_return_value\Field4 = local9\Field4
                    Case $07
                        se_return_value\Field0 = $07
                        se_return_value\Field6 = local9\Field6
                End Select
                Exit
            Case $1F
                Exit
            Case $20
                local9 = se_getfinalvalue(local9)
                If (local10 <> local9) Then
                    local10\Field0 = $05
                    local10\Field5 = local9
                Else
                    local10\Field0 = $00
                EndIf
            Case $21
                local9 = se_getfinalvalue(local9)
                local10\Field0 = $01
                local10\Field2 = local9\Field0
            Case $22
                local9\Field6 = se_argstoarray()
                If (local9\Field6 <> Null) Then
                    local9\Field0 = $07
                Else
                    local9\Field0 = $00
                EndIf
            Case $23
                If (local9\Field0 <> $01) Then
                    Exit
                EndIf
                If ((((local9\Field2 < $00) Or (local9\Field2 > $40)) Or (local9\Field2 > se_arguments_stack_level)) <> 0) Then
                    Exit
                EndIf
                local99 = se_arguments_number
                local100 = se_arguments_stack_offset
                se_arguments_number = local9\Field2
                se_arguments_stack_offset = (se_arguments_stack_level - se_arguments_number)
                se_array_create_inst(local9\Field2, local10)
                se_arguments_number = local99
                se_arguments_stack_level = se_arguments_stack_offset
                se_arguments_stack_offset = local100
            Case $24
                local9 = se_getfinalvalue(local9)
                local10 = se_getfinalvalue(local10)
                local11\Field5 = Null
                If (local9\Field0 = $07) Then
                    If (local10\Field0 = $01) Then
                        local11\Field5 = se_array_getelement(local9\Field6, local10\Field2)
                    ElseIf (local10\Field0 = $02) Then
                        local11\Field5 = se_array_getelement(local9\Field6, (Int local10\Field3))
                    ElseIf (local10\Field0 = $03) Then
                        local11\Field5 = se_array_getelement(local9\Field6, (Int local10\Field4))
                    EndIf
                    If (local11\Field5 <> Null) Then
                        local11\Field0 = $06
                    Else
                        local11\Field0 = $03
                        local11\Field4 = "undefined"
                    EndIf
                Else
                    local8\Field3\Field0 = $00
                EndIf
            Case $25
                local9 = se_getfinalvalue(local9)
                If (local9\Field0 = $03) Then
                    local10\Field0 = $01
                    local10\Field2 = len(local9\Field4)
                ElseIf (local9\Field0 = $07) Then
                    local10\Field0 = $01
                    local10\Field2 = local9\Field6\Field1
                Else
                    local10\Field0 = $03
                    local10\Field4 = "undefined"
                EndIf
        End Select
        If (local8 = se_current_function\Field3) Then
            Exit
        ElseIf (local12 = $00) Then
            local8 = local8\Field5
        EndIf
    Forever
    For local102 = se_transient_stack_offset To se_transient_stack_level Step $01
        se_gccheck(se_transient_stack(local102))
        se_transient_stack(local102)\Field0 = $00
    Next
    se_transient_stack_level = local2
    se_transient_stack_offset = local3
    se_current_function = local0
    se_current_script = local1
    se_call_depth = (se_call_depth - $01)
    Return $00
End Function
