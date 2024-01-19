Function se_invokeuserfunction%(arg0.se_funcptr, arg1%)
    Local local0%
    Local local1%
    Local local2.se_value
    Local local3.se_value
    Local local4%
    Local local6.se_inst
    Local local7.se_value
    Local local8.se_value
    Local local9.se_value
    Local local10%
    Local local92%
    Local local94.se_funcptr
    Local local95.se_value
    Local local96%
    Local local97%
    Local local99%
    se_current_function = arg0
    se_current_script = arg0\Field1
    local0 = se_transient_stack_level
    local1 = se_transient_stack_offset
    se_transient_stack_offset = se_transient_stack_level
    se_transient_stack_level = (se_transient_stack_level + se_current_function\Field4)
    se_growtransient()
    If (se_arguments_number > $00) Then
        se_arguments_stack_offset = (se_arguments_stack_level - se_arguments_number)
        For local4 = $00 To (se_current_function\Field5 - $01) Step $01
            If (local4 = se_arguments_number) Then
                Exit
            EndIf
            local2 = se_arguments_stack((se_arguments_stack_offset + local4))
            local3 = se_transient_stack((se_transient_stack_offset + local4))
            Select local2\Field0
                Case $01
                    local3\Field0 = $01
                    local3\Field1 = local2\Field1
                Case $02
                    local3\Field0 = $02
                    local3\Field2 = local2\Field2
                Case $03
                    local3\Field0 = $03
                    local3\Field3 = local2\Field3
                Case $05
                    local3\Field0 = $05
                    local3\Field4 = local2\Field4
                Case $07
                    local3\Field0 = $07
                    local3\Field5 = local2\Field5
                    local2\Field5\Field0 = (local2\Field5\Field0 + $01)
            End Select
        Next
    EndIf
    local6 = se_current_function\Field2
    local7 = Null
    local8 = Null
    local9 = Null
    Repeat
        local7 = local6\Field1
        local8 = local6\Field2
        local9 = local6\Field3
        local10 = $00
        If (local7 <> Null) Then
            If (local7\Field0 = $04) Then
                local7 = se_transient_stack((local7\Field1 + se_transient_stack_offset))
            EndIf
        EndIf
        If (local8 <> Null) Then
            If (local8\Field0 = $04) Then
                local8 = se_transient_stack((local8\Field1 + se_transient_stack_offset))
            EndIf
        EndIf
        If (local9 <> Null) Then
            If (local9\Field0 = $04) Then
                local9 = se_transient_stack((local9\Field1 + se_transient_stack_offset))
            EndIf
        EndIf
        Select local6\Field0
            Case $01
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                se_gccheck(local7)
                Select local8\Field0
                    Case $00
                        local7\Field0 = $00
                    Case $01
                        local7\Field0 = $01
                        local7\Field1 = local8\Field1
                    Case $02
                        local7\Field0 = $02
                        local7\Field2 = local8\Field2
                    Case $03
                        local7\Field0 = $03
                        local7\Field3 = local8\Field3
                    Case $07
                        local7\Field0 = $07
                        local7\Field5 = local8\Field5
                        local7\Field5\Field0 = (local7\Field5\Field0 + $01)
                End Select
            Case $02
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                Select local7\Field0
                    Case $00
                        Select local8\Field0
                            Case $00
                                local9\Field0 = $01
                                local9\Field1 = $00
                            Case $01
                                local9\Field0 = $01
                                local9\Field1 = local8\Field1
                            Case $02
                                local9\Field0 = $02
                                local9\Field2 = local8\Field2
                            Case $03
                                local9\Field0 = $03
                                local9\Field3 = ("null" + local8\Field3)
                            Default
                                local9\Field0 = $03
                                local9\Field3 = "nullNaN"
                        End Select
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field0 = $01
                                local9\Field1 = local7\Field1
                            Case $01
                                local9\Field0 = $01
                                local9\Field1 = (local7\Field1 + local8\Field1)
                            Case $02
                                local9\Field0 = $02
                                local9\Field2 = ((Float local7\Field1) + local8\Field2)
                            Case $03
                                local9\Field0 = $03
                                local9\Field3 = ((Str local7\Field1) + local8\Field3)
                            Default
                                local9\Field0 = $03
                                local9\Field3 = ((Str local7\Field1) + "NaN")
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field0 = $02
                                local9\Field2 = local7\Field2
                            Case $01
                                local9\Field0 = $02
                                local9\Field2 = (local7\Field2 + (Float local8\Field1))
                            Case $02
                                local9\Field0 = $02
                                local9\Field2 = (local7\Field2 + local8\Field2)
                            Case $03
                                local9\Field0 = $03
                                local9\Field3 = ((Str local7\Field2) + local8\Field3)
                            Default
                                local9\Field0 = $03
                                local9\Field3 = ((Str local7\Field2) + "NaN")
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field0 = $03
                                local9\Field3 = (local7\Field3 + "null")
                            Case $01
                                local9\Field0 = $03
                                local9\Field3 = (local7\Field3 + (Str local8\Field1))
                            Case $02
                                local9\Field0 = $03
                                local9\Field3 = (local7\Field3 + (Str local8\Field2))
                            Case $03
                                local9\Field0 = $03
                                local9\Field3 = (local7\Field3 + local8\Field3)
                            Default
                                local9\Field0 = $03
                                local9\Field3 = (local7\Field3 + "NaN")
                        End Select
                    Default
                        local9\Field0 = $03
                        local9\Field3 = "NaN"
                End Select
            Case $03
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                If (((local7\Field0 < $03) And (local8\Field0 < $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field0 = $01
                                    local9\Field1 = (- local8\Field1)
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = (- local8\Field2)
                            End Select
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = local7\Field1
                                Case $01
                                    local9\Field0 = $01
                                    local9\Field1 = (local7\Field1 - local8\Field1)
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = ((Float local7\Field1) - local8\Field2)
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $02
                                    local9\Field2 = 0.0
                                Case $01
                                    local9\Field0 = $02
                                    local9\Field2 = (local7\Field2 - (Float local8\Field1))
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = (local7\Field2 - local8\Field2)
                            End Select
                    End Select
                Else
                    local9\Field0 = $03
                    local9\Field3 = "NaN"
                EndIf
            Case $04
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                If (((local7\Field0 < $03) And (local8\Field0 < $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            local9\Field0 = $01
                            local9\Field1 = $00
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field0 = $01
                                    local9\Field1 = (local7\Field1 * local8\Field1)
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = ((Float local7\Field1) * local8\Field2)
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field0 = $02
                                    local9\Field2 = (local7\Field2 * (Float local8\Field1))
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = (local7\Field2 * local8\Field2)
                            End Select
                    End Select
                Else
                    local9\Field0 = $03
                    local9\Field3 = "NaN"
                EndIf
            Case $05
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                If (((local7\Field0 < $03) And (local8\Field0 < $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $03
                                    local9\Field3 = "NaN"
                                Case $01
                                    If (local8\Field1 <> $00) Then
                                        local9\Field0 = $01
                                        local9\Field1 = $00
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local8\Field2) Then
                                        local9\Field0 = $01
                                        local9\Field1 = $00
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                            End Select
                        Case $01
                            If (local7\Field1 <> $00) Then
                                Select local8\Field0
                                    Case $00
                                        local9\Field0 = $03
                                        local9\Field3 = "Infinity"
                                    Case $01
                                        If (local8\Field1 <> $00) Then
                                            local9\Field0 = $01
                                            local9\Field1 = (local7\Field1 / local8\Field1)
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "Infinity"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local8\Field2) Then
                                            local9\Field0 = $02
                                            local9\Field2 = ((Float local7\Field1) / local8\Field2)
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "Infinity"
                                        EndIf
                                End Select
                            Else
                                Select local8\Field0
                                    Case $00
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    Case $01
                                        If (local8\Field1 <> $00) Then
                                            local9\Field0 = $01
                                            local9\Field1 = (local7\Field1 / local8\Field1)
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "NaN"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local8\Field2) Then
                                            local9\Field0 = $02
                                            local9\Field2 = ((Float local7\Field1) / local8\Field2)
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "NaN"
                                        EndIf
                                End Select
                            EndIf
                        Case $02
                            If (local7\Field1 <> $00) Then
                                Select local8\Field0
                                    Case $00
                                        local9\Field0 = $03
                                        local9\Field3 = "Infinity"
                                    Case $01
                                        If (local8\Field1 <> $00) Then
                                            local9\Field0 = $02
                                            local9\Field1 = (Int (local7\Field2 / (Float local8\Field1)))
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "Infinity"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local8\Field2) Then
                                            local9\Field0 = $02
                                            local9\Field2 = (local7\Field2 / local8\Field2)
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "Infinity"
                                        EndIf
                                End Select
                            Else
                                Select local8\Field0
                                    Case $00
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    Case $01
                                        If (local8\Field1 <> $00) Then
                                            local9\Field0 = $02
                                            local9\Field2 = (local7\Field2 / (Float local8\Field1))
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "NaN"
                                        EndIf
                                    Case $02
                                        If (0.0 <> local8\Field2) Then
                                            local9\Field0 = $02
                                            local9\Field2 = (local7\Field2 / local8\Field2)
                                        Else
                                            local9\Field0 = $03
                                            local9\Field3 = "NaN"
                                        EndIf
                                End Select
                            EndIf
                    End Select
                Else
                    local9\Field0 = $03
                    local9\Field3 = "NaN"
                EndIf
            Case $06
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                If (((local7\Field0 < $03) And (local8\Field0 < $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = $01
                                Case $01
                                    local9\Field0 = $01
                                    local9\Field1 = (Int (0.0 ^ (Float local8\Field1)))
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = (0.0 ^ local8\Field2)
                            End Select
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = $01
                                Case $01
                                    local9\Field0 = $01
                                    local9\Field1 = (Int ((Float local7\Field1) ^ (Float local8\Field1)))
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = ((Float local7\Field1) ^ local8\Field2)
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $01
                                    local9\Field1 = $01
                                Case $01
                                    local9\Field0 = $02
                                    local9\Field2 = (local7\Field2 ^ (Float local8\Field1))
                                Case $02
                                    local9\Field0 = $02
                                    local9\Field2 = (local7\Field2 ^ local8\Field2)
                            End Select
                    End Select
                Else
                    local9\Field0 = $03
                    local9\Field3 = "NaN"
                EndIf
            Case $07
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                If (((local7\Field0 < $03) And (local8\Field0 < $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $03
                                    local9\Field3 = "NaN"
                                Case $01
                                    If (local8\Field1 <> $00) Then
                                        local9\Field0 = $01
                                        local9\Field1 = $00
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local8\Field2) Then
                                        local9\Field0 = $02
                                        local9\Field2 = 0.0
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                            End Select
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $03
                                    local9\Field3 = "NaN"
                                Case $01
                                    If (local8\Field1 <> $00) Then
                                        local9\Field0 = $01
                                        local9\Field1 = (local7\Field1 Mod local8\Field1)
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local8\Field2) Then
                                        local9\Field0 = $02
                                        local9\Field2 = ((Float local7\Field1) Mod local8\Field2)
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field0 = $03
                                    local9\Field3 = "NaN"
                                Case $01
                                    If (local8\Field1 <> $00) Then
                                        local9\Field0 = $02
                                        local9\Field2 = (local7\Field2 Mod (Float local8\Field1))
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                                Case $02
                                    If (0.0 <> local8\Field2) Then
                                        local9\Field0 = $02
                                        local9\Field2 = (local7\Field2 Mod local8\Field2)
                                    Else
                                        local9\Field0 = $03
                                        local9\Field3 = "NaN"
                                    EndIf
                            End Select
                    End Select
                Else
                    local9\Field0 = $03
                    local9\Field3 = "NaN"
                EndIf
            Case $08
                local7 = se_getfinalvalue(local7)
                Select local7\Field0
                    Case $00
                        local8\Field0 = $01
                        local8\Field1 = $00
                    Case $01
                        local8\Field0 = $01
                        local8\Field1 = (- local7\Field1)
                    Case $02
                        local8\Field0 = $02
                        local8\Field2 = (- local7\Field2)
                    Default
                        local8\Field0 = $03
                        local8\Field3 = "NaN"
                End Select
            Case $09
                local7 = se_getfinalvalue(local7)
                Select local7\Field0
                    Case $00
                        local7\Field0 = $01
                        local7\Field1 = $01
                    Case $01
                        local7\Field1 = (local7\Field1 + $01)
                    Case $02
                        local7\Field2 = (local7\Field2 + 1.0)
                    Default
                        local7\Field3 = "NaN"
                End Select
            Case $0A
                local7 = se_getfinalvalue(local7)
                Select local7\Field0
                    Case $00
                        local7\Field0 = $01
                        local7\Field1 = $FFFFFFFF
                    Case $01
                        local7\Field1 = (local7\Field1 - $01)
                    Case $02
                        local7\Field2 = (local7\Field2 - 1.0)
                    Default
                        local7\Field3 = "NaN"
                End Select
            Case $0B
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                Select local7\Field0
                    Case $00
                        If (local8\Field0 = $00) Then
                            local9\Field1 = $01
                        Else
                            local9\Field1 = $00
                        EndIf
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = (local7\Field1 = local8\Field1)
                            Case $02
                                local9\Field1 = (local8\Field2 = (Float local7\Field1))
                            Case $03
                                local9\Field1 = ((Str local7\Field1) = local8\Field3)
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = ((Float local8\Field1) = local7\Field2)
                            Case $02
                                local9\Field1 = (local8\Field2 = local7\Field2)
                            Case $03
                                local9\Field1 = ((Str local7\Field2) = local8\Field3)
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = (local7\Field3 = (Str local8\Field1))
                            Case $02
                                local9\Field1 = (local7\Field3 = (Str local8\Field2))
                            Case $03
                                local9\Field1 = (local7\Field3 = local8\Field3)
                        End Select
                    Case $07
                        If (local8\Field0 = $07) Then
                            local9\Field1 = (local7\Field5 = local8\Field5)
                        Else
                            local9\Field1 = $00
                        EndIf
                End Select
            Case $0C
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                Select local7\Field0
                    Case $00
                        If (local8\Field0 = $00) Then
                            local9\Field1 = $00
                        Else
                            local9\Field1 = $01
                        EndIf
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = (local7\Field1 <> local8\Field1)
                            Case $02
                                local9\Field1 = (local8\Field2 <> (Float local7\Field1))
                            Case $03
                                local9\Field1 = ((Str local7\Field1) <> local8\Field3)
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = ((Float local8\Field1) <> local7\Field2)
                            Case $02
                                local9\Field1 = (local8\Field2 <> local7\Field2)
                            Case $03
                                local9\Field1 = ((Str local7\Field2) <> local8\Field3)
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = (local7\Field3 <> (Str local8\Field1))
                            Case $02
                                local9\Field1 = (local7\Field3 <> (Str local8\Field2))
                            Case $03
                                local9\Field1 = (local7\Field3 <> local8\Field3)
                        End Select
                    Case $07
                        If (local8\Field0 = $07) Then
                            local9\Field1 = (local7\Field5 <> local8\Field5)
                        Else
                            local9\Field1 = $01
                        EndIf
                End Select
            Case $0D
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                Select local7\Field0
                    Case $00
                        local9\Field1 = $00
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = (local7\Field1 > local8\Field1)
                            Case $02
                                local9\Field1 = (local8\Field2 < (Float local7\Field1))
                            Case $03
                                local9\Field1 = ((Str local7\Field1) > local8\Field3)
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = ((Float local8\Field1) < local7\Field2)
                            Case $02
                                local9\Field1 = (local8\Field2 < local7\Field2)
                            Case $03
                                local9\Field1 = ((Str local7\Field2) > local8\Field3)
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = (local7\Field3 > (Str local8\Field1))
                            Case $02
                                local9\Field1 = (local7\Field3 > (Str local8\Field2))
                            Case $03
                                local9\Field1 = (local7\Field3 > local8\Field3)
                        End Select
                    Case $07
                        If (local8\Field0 = $07) Then
                            local9\Field1 = (local7\Field5\Field1 > local8\Field5\Field1)
                        Else
                            local9\Field1 = $00
                        EndIf
                End Select
            Case $0E
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                Select local7\Field0
                    Case $00
                        If (local8\Field0 = $00) Then
                            local9\Field1 = $00
                        Else
                            local9\Field1 = $01
                        EndIf
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = (local7\Field1 < local8\Field1)
                            Case $02
                                local9\Field1 = (local8\Field2 > (Float local7\Field1))
                            Case $03
                                local9\Field1 = ((Str local7\Field1) < local8\Field3)
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = ((Float local8\Field1) > local7\Field2)
                            Case $02
                                local9\Field1 = (local8\Field2 > local7\Field2)
                            Case $03
                                local9\Field1 = ((Str local7\Field2) < local8\Field3)
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = (local7\Field3 < (Str local8\Field1))
                            Case $02
                                local9\Field1 = (local7\Field3 < (Str local8\Field2))
                            Case $03
                                local9\Field1 = (local7\Field3 < local8\Field3)
                        End Select
                    Case $07
                        If (local8\Field0 = $07) Then
                            local9\Field1 = (local7\Field5\Field1 < local8\Field5\Field1)
                        Else
                            local9\Field1 = $00
                        EndIf
                End Select
            Case $0F
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                Select local7\Field0
                    Case $00
                        If (local8\Field0 = $00) Then
                            local9\Field1 = $01
                        Else
                            local9\Field1 = $00
                        EndIf
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = (local7\Field1 >= local8\Field1)
                            Case $02
                                local9\Field1 = (local8\Field2 <= (Float local7\Field1))
                            Case $03
                                local9\Field1 = ((Str local7\Field1) >= local8\Field3)
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = ((Float local8\Field1) <= local7\Field2)
                            Case $02
                                local9\Field1 = (local8\Field2 <= local7\Field2)
                            Case $03
                                local9\Field1 = ((Str local7\Field2) >= local8\Field3)
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $01
                            Case $01
                                local9\Field1 = (local7\Field3 >= (Str local8\Field1))
                            Case $02
                                local9\Field1 = (local7\Field3 >= (Str local8\Field2))
                            Case $03
                                local9\Field1 = (local7\Field3 >= local8\Field3)
                        End Select
                    Case $07
                        If (local8\Field0 = $07) Then
                            local9\Field1 = (local7\Field5\Field1 >= local8\Field5\Field1)
                        Else
                            local9\Field1 = $00
                        EndIf
                End Select
            Case $10
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                Select local7\Field0
                    Case $00
                        local9\Field1 = $01
                    Case $01
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = (local7\Field1 <= local8\Field1)
                            Case $02
                                local9\Field1 = (local8\Field2 >= (Float local7\Field1))
                            Case $03
                                local9\Field1 = ((Str local7\Field1) <= local8\Field3)
                        End Select
                    Case $02
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = ((Float local8\Field1) >= local7\Field2)
                            Case $02
                                local9\Field1 = (local8\Field2 >= local7\Field2)
                            Case $03
                                local9\Field1 = ((Str local7\Field2) <= local8\Field3)
                        End Select
                    Case $03
                        Select local8\Field0
                            Case $00
                                local9\Field1 = $00
                            Case $01
                                local9\Field1 = (local7\Field3 <= (Str local8\Field1))
                            Case $02
                                local9\Field1 = (local7\Field3 <= (Str local8\Field2))
                            Case $03
                                local9\Field1 = (local7\Field3 <= local8\Field3)
                        End Select
                    Case $07
                        If (local8\Field0 = $07) Then
                            local9\Field1 = (local7\Field5\Field1 <= local8\Field5\Field1)
                        Else
                            local9\Field1 = $00
                        EndIf
                End Select
            Case $11
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                If (((local7\Field0 <= $03) And (local8\Field0 <= $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            local9\Field1 = $00
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field1 = (local7\Field1 And local8\Field1)
                                Case $02
                                    local9\Field1 = (local7\Field1 And (Int local8\Field2))
                                Case $03
                                    local9\Field1 = (local7\Field1 And (Int local8\Field3))
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) And local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) And (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) And (Int local8\Field3))
                            End Select
                        Case $03
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) And local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) And (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) And (Int local8\Field3))
                            End Select
                    End Select
                Else
                    local9\Field1 = $00
                EndIf
            Case $12
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                If (((local7\Field0 <= $03) And (local8\Field0 <= $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field1 = local8\Field1
                                Case $02
                                    local9\Field1 = (Int local8\Field2)
                                Case $03
                                    local9\Field1 = (Int local8\Field3)
                            End Select
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = local7\Field1
                                Case $01
                                    local9\Field1 = (local7\Field1 Xor local8\Field1)
                                Case $02
                                    local9\Field1 = (local7\Field1 Xor (Int local8\Field2))
                                Case $03
                                    local9\Field1 = (local7\Field1 Xor (Int local8\Field3))
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field2)
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) Xor local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) Xor (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) Xor (Int local8\Field3))
                            End Select
                        Case $03
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field3)
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) Xor local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) Xor (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) Xor (Int local8\Field3))
                            End Select
                    End Select
                Else
                    local9\Field1 = $00
                EndIf
            Case $14
                local7 = se_getfinalvalue(local7)
                local8\Field0 = $01
                Select local7\Field0
                    Case $00
                        local8\Field1 = $FFFFFFFF
                    Case $01
                        local8\Field1 = (local7\Field1 Xor $FFFFFFFF)
                    Case $02
                        local8\Field1 = ((Int local7\Field2) Xor $FFFFFFFF)
                    Case $03
                        local8\Field1 = ((Int local7\Field3) Xor $FFFFFFFF)
                    Default
                        local8\Field1 = $FFFFFFFF
                End Select
            Case $13
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                If (((local7\Field0 <= $03) And (local8\Field0 <= $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = $00
                                Case $01
                                    local9\Field1 = local8\Field1
                                Case $02
                                    local9\Field1 = (Int local8\Field2)
                                Case $03
                                    local9\Field1 = (Int local8\Field3)
                            End Select
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = local7\Field1
                                Case $01
                                    local9\Field1 = (local7\Field1 Or local8\Field1)
                                Case $02
                                    local9\Field1 = (local7\Field1 Or (Int local8\Field2))
                                Case $03
                                    local9\Field1 = (local7\Field1 Or (Int local8\Field3))
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field2)
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) Or local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) Or (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) Or (Int local8\Field3))
                            End Select
                        Case $03
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field3)
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) Or local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) Or (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) Or (Int local8\Field3))
                            End Select
                    End Select
                Else
                    local9\Field1 = $00
                EndIf
            Case $15
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                If (((local7\Field0 <= $03) And (local8\Field0 <= $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            local9\Field1 = $00
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = local7\Field1
                                Case $01
                                    local9\Field1 = (local7\Field1 Shl local8\Field1)
                                Case $02
                                    local9\Field1 = (local7\Field1 Shl (Int local8\Field2))
                                Case $03
                                    local9\Field1 = (local7\Field1 Shl (Int local8\Field3))
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field2)
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) Shl local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) Shl (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) Shl (Int local8\Field3))
                            End Select
                        Case $03
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field3)
                                Case $01
                                    local9\Field1 = ((Int local7\Field3) Shl local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field3) Shl (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field3) Shl (Int local8\Field3))
                            End Select
                    End Select
                Else
                    local9\Field1 = $00
                EndIf
            Case $16
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field0 = $01
                If (((local7\Field0 <= $03) And (local8\Field0 <= $03)) <> 0) Then
                    Select local7\Field0
                        Case $00
                            local9\Field1 = $00
                        Case $01
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = local7\Field1
                                Case $01
                                    local9\Field1 = (local7\Field1 Shr local8\Field1)
                                Case $02
                                    local9\Field1 = (local7\Field1 Shr (Int local8\Field2))
                                Case $03
                                    local9\Field1 = (local7\Field1 Shr (Int local8\Field3))
                            End Select
                        Case $02
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field2)
                                Case $01
                                    local9\Field1 = ((Int local7\Field2) Shr local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field2) Shr (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field2) Shr (Int local8\Field3))
                            End Select
                        Case $03
                            Select local8\Field0
                                Case $00
                                    local9\Field1 = (Int local7\Field3)
                                Case $01
                                    local9\Field1 = ((Int local7\Field3) Shr local8\Field1)
                                Case $02
                                    local9\Field1 = ((Int local7\Field3) Shr (Int local8\Field2))
                                Case $03
                                    local9\Field1 = ((Int local7\Field3) Shr (Int local8\Field3))
                            End Select
                    End Select
                Else
                    local9\Field1 = $00
                EndIf
            Case $17
                local7 = se_getfinalvalue(local7)
                local8\Field0 = $01
                Select local7\Field0
                    Case $00
                        local8\Field1 = $01
                    Case $01
                        local8\Field1 = (local7\Field1 = $00)
                    Case $02
                        local8\Field1 = (0.0 = local7\Field2)
                    Case $03
                        local8\Field1 = (local7\Field3 = "0")
                    Default
                        local8\Field1 = $00
                End Select
            Case $18
                local6 = local7\Field6
                local10 = $01
            Case $1A
                local7 = se_getfinalvalue(local7)
                Select local7\Field0
                    Case $00
                        local6 = local8\Field6
                        local10 = $01
                    Case $01
                        If (local7\Field1 = $00) Then
                            local6 = local8\Field6
                            local10 = $01
                        EndIf
                    Case $02
                        If (0.0 = local7\Field2) Then
                            local6 = local8\Field6
                            local10 = $01
                        EndIf
                    Case $03
                        If (local7\Field3 = "") Then
                            local6 = local8\Field6
                            local10 = $01
                        EndIf
                End Select
            Case $19
                local7 = se_getfinalvalue(local7)
                Select local7\Field0
                    Case $01
                        If (local7\Field1 <> $00) Then
                            local6 = local8\Field6
                            local10 = $01
                        EndIf
                    Case $02
                        If (0.0 <> local7\Field2) Then
                            local6 = local8\Field6
                            local10 = $01
                        EndIf
                    Case $03
                        If (local7\Field3 <> "") Then
                            local6 = local8\Field6
                            local10 = $01
                        EndIf
                    Case $07
                        local6 = local8\Field6
                        local10 = $01
                End Select
            Case $1B
                If (local7\Field0 = $06) Then
                    local7 = se_getaccessorvalue(local7)
                EndIf
                local92 = se_arguments_stack_level
                se_arguments_stack_level = (se_arguments_stack_level + $01)
                se_growarguments()
                Select local7\Field0
                    Case $00
                        se_arguments_stack(local92)\Field0 = $00
                    Case $01
                        se_arguments_stack(local92)\Field0 = $01
                        se_arguments_stack(local92)\Field1 = local7\Field1
                    Case $02
                        se_arguments_stack(local92)\Field0 = $02
                        se_arguments_stack(local92)\Field2 = local7\Field2
                    Case $03
                        se_arguments_stack(local92)\Field0 = $03
                        se_arguments_stack(local92)\Field3 = local7\Field3
                    Case $05
                        se_arguments_stack(local92)\Field0 = $05
                        se_arguments_stack(local92)\Field4 = local7\Field4
                    Case $07
                        se_arguments_stack(local92)\Field0 = $07
                        se_arguments_stack(local92)\Field5 = local7\Field5
                End Select
            Case $1C
                local94 = se_current_function
                local95 = se_return_value
                local96 = se_arguments_number
                local97 = se_arguments_stack_offset
                local9\Field0 = $00
                se_return_value = local9
                se_arguments_number = local8\Field1
                If (local7\Field0 = $09) Then
                    se_invokeuserfunction(local7\Field7, $00)
                EndIf
                se_current_function = local94
                se_return_value = local95
                se_arguments_number = local96
                se_arguments_stack_offset = local97
            Case $1D
                local95 = se_return_value
                local96 = se_arguments_number
                local97 = se_arguments_stack_offset
                se_return_value = local9
                se_arguments_number = local8\Field1
                se_arguments_stack_offset = (se_arguments_stack_level - se_arguments_number)
                se_invokeglobalfunction(local7\Field8, arg0)
                se_return_value = local95
                se_arguments_number = local96
                se_arguments_stack_level = se_arguments_stack_offset
                se_arguments_stack_offset = local97
            Case $1E
                local7 = se_getfinalvalue(local7)
                Select local7\Field0
                    Case $00
                        se_return_value\Field0 = $00
                    Case $01
                        se_return_value\Field0 = $01
                        se_return_value\Field1 = local7\Field1
                        If (local7\Field1 = $00) Then
                            se_return_value\Field8 = $01
                        EndIf
                    Case $02
                        se_return_value\Field0 = $02
                        se_return_value\Field2 = local7\Field2
                    Case $03
                        se_return_value\Field0 = $03
                        se_return_value\Field3 = local7\Field3
                    Case $07
                        se_return_value\Field0 = $07
                        se_return_value\Field5 = local7\Field5
                End Select
                Exit
            Case $1F
                Exit
            Case $20
                local7 = se_getfinalvalue(local7)
                If (local8 <> local7) Then
                    local8\Field0 = $05
                    local8\Field4 = local7
                Else
                    local8\Field0 = $00
                EndIf
            Case $21
                local7 = se_getfinalvalue(local7)
                local8\Field0 = $01
                local8\Field1 = local7\Field0
            Case $22
                local7\Field5 = se_argstoarray()
                If (local7\Field5 <> Null) Then
                    local7\Field0 = $07
                Else
                    local7\Field0 = $00
                EndIf
            Case $23
                local96 = se_arguments_number
                local97 = se_arguments_stack_offset
                se_arguments_number = local7\Field1
                se_arguments_stack_offset = (se_arguments_stack_level - se_arguments_number)
                se_array_create_inst(local7\Field1, local8)
                se_arguments_number = local96
                se_arguments_stack_level = se_arguments_stack_offset
                se_arguments_stack_offset = local97
            Case $24
                local7 = se_getfinalvalue(local7)
                local8 = se_getfinalvalue(local8)
                local9\Field4 = Null
                If (local7\Field0 = $07) Then
                    If (local8\Field0 = $01) Then
                        local9\Field4 = se_array_getelement(local7\Field5, local8\Field1)
                    ElseIf (local8\Field0 = $02) Then
                        local9\Field4 = se_array_getelement(local7\Field5, (Int local8\Field2))
                    ElseIf (local8\Field0 = $03) Then
                        local9\Field4 = se_array_getelement(local7\Field5, (Int local8\Field3))
                    EndIf
                    If (local9\Field4 <> Null) Then
                        local9\Field0 = $06
                    Else
                        local9\Field0 = $03
                        local9\Field3 = "undefined"
                    EndIf
                Else
                    local6\Field3\Field0 = $00
                EndIf
            Case $25
                local7 = se_getfinalvalue(local7)
                If (local7\Field0 = $03) Then
                    local8\Field0 = $01
                    local8\Field1 = len(local7\Field3)
                ElseIf (local7\Field0 = $07) Then
                    local8\Field0 = $01
                    local8\Field1 = local7\Field5\Field1
                Else
                    local8\Field0 = $03
                    local8\Field3 = "undefined"
                EndIf
        End Select
        If (local6 = se_current_function\Field3) Then
            Exit
        ElseIf (local10 = $00) Then
            local6 = local6\Field5
        EndIf
    Forever
    For local99 = se_transient_stack_offset To se_transient_stack_level Step $01
        se_gccheck(se_transient_stack(local99))
        se_transient_stack(local99)\Field0 = $00
    Next
    se_transient_stack_level = local0
    se_transient_stack_offset = local1
    Return $00
End Function
