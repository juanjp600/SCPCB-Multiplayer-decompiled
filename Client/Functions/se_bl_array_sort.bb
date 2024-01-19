Function se_bl_array_sort%()
    Local local0.se_array
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.se_value
    Local local6.se_value
    Local local7.se_value
    Local local8.se_value
    Local local9%
    Local local10%
    If (se_argtype($00) <> $07) Then
        Return $00
    EndIf
    local0 = se_arrayarg($00)
    local1 = se_tointarg($01, $01)
    local2 = local0\Field1
    If (local1 <> 0) Then
        Repeat
            local5 = (Object.se_value peekint(local0\Field2, (local3 Shl $02)))
            local6 = se_getfinalvalue(local5)
            local4 = $FFFFFFFF
            For local10 = (local3 + $01) To (local2 - $01) Step $01
                local7 = (Object.se_value peekint(local0\Field2, (local10 Shl $02)))
                local8 = se_getfinalvalue(local7)
                local9 = $00
                Select local8\Field0
                    Case $00
                        If (local6\Field0 = $00) Then
                            local9 = $00
                        Else
                            local9 = $01
                        EndIf
                    Case $01
                        Select local6\Field0
                            Case $00
                                local9 = $00
                            Case $01
                                local9 = (local8\Field1 < local6\Field1)
                            Case $02
                                local9 = (local6\Field2 > (Float local8\Field1))
                            Case $03
                                local9 = ((Str local8\Field1) < local6\Field3)
                        End Select
                    Case $02
                        Select local6\Field0
                            Case $00
                                local9 = $00
                            Case $01
                                local9 = ((Float local6\Field1) > local8\Field2)
                            Case $02
                                local9 = (local6\Field2 > local8\Field2)
                            Case $03
                                local9 = ((Str local8\Field2) < local6\Field3)
                        End Select
                    Case $03
                        Select local6\Field0
                            Case $00
                                local9 = $00
                            Case $01
                                local9 = (local8\Field3 < (Str local6\Field1))
                            Case $02
                                local9 = (local8\Field3 < (Str local6\Field2))
                            Case $03
                                local9 = (local8\Field3 < local6\Field3)
                        End Select
                    Case $07
                        If (local6\Field0 = $07) Then
                            local9 = (local8\Field5\Field1 < local6\Field5\Field1)
                        Else
                            local9 = $00
                        EndIf
                End Select
                If (local9 <> 0) Then
                    local4 = local10
                    local6 = local8
                    local5 = local7
                EndIf
            Next
            If (local4 >= $00) Then
                pokeint(local0\Field2, (local4 Shl $02), peekint(local0\Field2, (local3 Shl $02)))
                pokeint(local0\Field2, (local3 Shl $02), (Handle local5))
            EndIf
            local3 = (local3 + $01)
            If (local3 = local2) Then
                Exit
            EndIf
        Forever
    Else
        Repeat
            local5 = (Object.se_value peekint(local0\Field2, (local3 Shl $02)))
            local6 = se_getfinalvalue(local5)
            local4 = $FFFFFFFF
            For local10 = (local3 + $01) To (local2 - $01) Step $01
                local7 = (Object.se_value peekint(local0\Field2, (local10 Shl $02)))
                local8 = se_getfinalvalue(local7)
                local9 = $00
                Select local8\Field0
                    Case $00
                        local9 = $00
                    Case $01
                        Select local6\Field0
                            Case $00
                                local9 = $00
                            Case $01
                                local9 = (local8\Field1 > local6\Field1)
                            Case $02
                                local9 = (local6\Field2 < (Float local8\Field1))
                            Case $03
                                local9 = ((Str local8\Field1) > local6\Field3)
                        End Select
                    Case $02
                        Select local6\Field0
                            Case $00
                                local9 = $00
                            Case $01
                                local9 = ((Float local6\Field1) < local8\Field2)
                            Case $02
                                local9 = (local6\Field2 < local8\Field2)
                            Case $03
                                local9 = ((Str local8\Field2) > local6\Field3)
                        End Select
                    Case $03
                        Select local6\Field0
                            Case $00
                                local9 = $00
                            Case $01
                                local9 = (local8\Field3 > (Str local6\Field1))
                            Case $02
                                local9 = (local8\Field3 > (Str local6\Field2))
                            Case $03
                                local9 = (local8\Field3 > local6\Field3)
                        End Select
                    Case $07
                        If (local6\Field0 = $07) Then
                            local9 = (local8\Field5\Field1 > local6\Field5\Field1)
                        Else
                            local9 = $00
                        EndIf
                End Select
                If (local9 <> 0) Then
                    local4 = local10
                    local6 = local8
                    local5 = local7
                EndIf
            Next
            If (local4 >= $00) Then
                pokeint(local0\Field2, (local4 Shl $02), peekint(local0\Field2, (local3 Shl $02)))
                pokeint(local0\Field2, (local3 Shl $02), (Handle local5))
            EndIf
            local3 = (local3 + $01)
            If (local3 = local2) Then
                Exit
            EndIf
        Forever
    EndIf
    Return $00
End Function
