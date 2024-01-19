Function se_parsedefinition%(arg0.se_block)
    Local local0.se_token
    Local local1.se_token
    Local local2.se_node
    Local local3.se_node
    Local local4.se_node
    Local local6.se_constantdef
    Local local8%
    local0 = arg0\Field3
    local1 = local0
    Select arg0\Field0
        Case $02
            local2 = arg0\Field2\Field4[$01]
            Repeat
                If (local2 = Null) Then
                    se_error_eol(local1)
                    Return $00
                EndIf
                local1 = local2\Field0
                If (((local2\Field0\Field0 = $07) And (local2\Field0\Field1 = "=")) = $00) Then
                    se_error(local2\Field0, "constant must be initialized", $01)
                    Return $00
                EndIf
                local3 = local2\Field4[$00]
                local4 = local2\Field4[$01]
                If (local3 = Null) Then
                    se_error(local2\Field0, "expecting identifier", $01)
                    Return $00
                ElseIf (local3\Field0\Field0 <> $04) Then
                    se_error_expecting(local3\Field0, "identifier")
                    Return $00
                EndIf
                If (local4 = Null) Then
                    se_error(local2\Field0, "expecting identifier", $01)
                    Return $00
                ElseIf (local4\Field0\Field0 > $04) Then
                    se_error_expecting(local4\Field0, "constant value")
                    Return $00
                EndIf
                If (local4\Field0\Field0 = $04) Then
                    For local6 = Each se_constantdef
                        If (local6\Field0 = local4\Field0\Field1) Then
                            Exit
                        EndIf
                    Next
                    If (local6 <> Null) Then
                        If (se_defineconst(local3\Field0\Field1, local6\Field1, local6\Field2, $00, local3\Field0) <> 0) Then
                            se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                            Return $00
                        EndIf
                    Else
                        se_error(local4\Field0, (((("cannot assign value of variable '" + local4\Field0\Field1) + "' to constant '") + local3\Field0\Field1) + "'"), $01)
                        Return $00
                    EndIf
                ElseIf (se_defineconst(local3\Field0\Field1, local4\Field0\Field0, local4\Field0\Field1, $00, local3\Field0) = $00) Then
                    se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                    Return $00
                EndIf
                local2 = local2\Field8
                If (local2 = Null) Then
                    Exit
                ElseIf (local2\Field0\Field0 = $08) Then
                    local2 = local2\Field8
                EndIf
            Forever
        Case $03
            local2 = arg0\Field2\Field4[$01]
            Select arg0\Field1
                Case "local"
                    Repeat
                        If (local2 = Null) Then
                            se_error_eol(local1)
                            Return $00
                        EndIf
                        local1 = local2\Field0
                        If (local2\Field0\Field0 = $04) Then
                            If (se_definelocal(local2\Field0\Field1, $00, local2\Field0) = $00) Then
                                se_error(local2\Field0, (("duplicate identifier '" + local2\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        ElseIf (((local2\Field0\Field0 = $07) And (local2\Field0\Field1 = "=")) <> 0) Then
                            local3 = local2\Field4[$00]
                            If (local3\Field0\Field0 <> $04) Then
                                se_error_expecting(local3\Field0, "identifier")
                                Return $00
                            EndIf
                            If (se_definelocal(local3\Field0\Field1, $00, local3\Field0) = $00) Then
                                se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        Else
                            se_error_expecting(local2\Field0, "identifier")
                            Return $00
                        EndIf
                        local2 = local2\Field8
                        If (local2 = Null) Then
                            Exit
                        ElseIf (local2\Field0\Field0 = $08) Then
                            local2 = local2\Field8
                        EndIf
                    Forever
                Case "static"
                    Repeat
                        If (local2 = Null) Then
                            se_error_eol(local1)
                            Return $00
                        EndIf
                        local1 = local2\Field0
                        If (local2\Field0\Field0 = $04) Then
                            If (se_definestatic(local2\Field0\Field1, local2\Field0) = $00) Then
                                se_error(local2\Field0, (("duplicate identifier '" + local2\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        ElseIf (((local2\Field0\Field0 = $07) And (local2\Field0\Field1 = "=")) <> 0) Then
                            local3 = local2\Field4[$00]
                            If (local3\Field0\Field0 <> $04) Then
                                se_error_expecting(local3\Field0, "identifier")
                                Return $00
                            EndIf
                            If (se_definestatic(local3\Field0\Field1, local3\Field0) = $00) Then
                                se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        Else
                            se_error_expecting(local2\Field0, "identifier")
                            Return $00
                        EndIf
                        local2 = local2\Field8
                        If (local2 = Null) Then
                            Exit
                        ElseIf (local2\Field0\Field0 = $08) Then
                            local2 = local2\Field8
                        EndIf
                    Forever
                Case "global"
                    Repeat
                        If (local2 = Null) Then
                            se_error_eol(local1)
                            Return $00
                        EndIf
                        local1 = local2\Field0
                        If (local2\Field0\Field0 = $04) Then
                            If (se_defineglobal(local2\Field0\Field1, local2\Field0) = $00) Then
                                se_error(local2\Field0, (("duplicate identifier '" + local2\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        ElseIf (((local2\Field0\Field0 = $07) And (local2\Field0\Field1 = "=")) <> 0) Then
                            local3 = local2\Field4[$00]
                            If (local3\Field0\Field0 <> $04) Then
                                se_error_expecting(local3\Field0, "identifier")
                                Return $00
                            EndIf
                            If (se_defineglobal(local3\Field0\Field1, local3\Field0) = $00) Then
                                se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        Else
                            se_error_expecting(local2\Field0, "identifier")
                            Return $00
                        EndIf
                        local2 = local2\Field8
                        If (local2 = Null) Then
                            Exit
                        ElseIf (local2\Field0\Field0 = $08) Then
                            local2 = local2\Field8
                        EndIf
                    Forever
                Case "public"
                    Repeat
                        If (local2 = Null) Then
                            se_error_eol(local1)
                            Return $00
                        EndIf
                        local1 = local2\Field0
                        If (local2\Field0\Field0 = $04) Then
                            If (se_definepublic(local2\Field0\Field1, local2\Field0) = $00) Then
                                se_error(local2\Field0, (("duplicate identifier '" + local2\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        ElseIf (((local2\Field0\Field0 = $07) And (local2\Field0\Field1 = "=")) <> 0) Then
                            local3 = local2\Field4[$00]
                            If (local3\Field0\Field0 <> $04) Then
                                se_error_expecting(local3\Field0, "identifier")
                                Return $00
                            EndIf
                            If (se_definepublic(local3\Field0\Field1, local3\Field0) = $00) Then
                                se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                                Return $00
                            EndIf
                        Else
                            se_error_expecting(local2\Field0, "identifier")
                            Return $00
                        EndIf
                        local2 = local2\Field8
                        If (local2 = Null) Then
                            Exit
                        ElseIf (local2\Field0\Field0 = $08) Then
                            local2 = local2\Field8
                        EndIf
                    Forever
            End Select
        Case $04
            If (arg0\Field4 <> se_root_block) Then
                se_seterror((("error at line " + (Str local0\Field2\Field1)) + ": function can be defined only in main program"), $01)
                Return $00
            EndIf
            local2 = arg0\Field2\Field4[$01]
            If (local2 = Null) Then
                se_error(arg0\Field3, "expecting function identifier", $01)
                Return $00
            EndIf
            If (local2\Field0\Field0 <> $04) Then
                se_error_expecting(local2\Field0, "identifier")
                Return $00
            EndIf
            se_function_def = se_definefunction(local2\Field0\Field1, local2\Field0)
            If (se_function_def = Null) Then
                se_error(local0, (("duplicate identifier '" + local2\Field0\Field1) + "'"), $01)
                Return $00
            EndIf
            local2 = local2\Field4[$01]
            If (local2 = Null) Then
                se_error(local0, "expecting '('", $01)
                Return $00
            EndIf
            If (local2\Field0\Field0 <> $05) Then
                se_error_expecting(local2\Field0, "'('")
                Return $00
            EndIf
            local2 = local2\Field4[$01]
            Repeat
                If (local2\Field0\Field0 = $06) Then
                    If (local8 <> 0) Then
                        se_error_unexpected(local2\Field0)
                        Return $00
                    Else
                        Exit
                    EndIf
                ElseIf (local2\Field0\Field0 = $04) Then
                    If (se_definelocal(local2\Field0\Field1, $01, local2\Field0) = $00) Then
                        se_error(local2\Field0, (("duplicate identifier '" + local2\Field0\Field1) + "'"), $01)
                        Return $00
                    EndIf
                    local8 = $00
                ElseIf (((local2\Field0\Field0 = $07) And (local2\Field0\Field1 = "=")) <> 0) Then
                    local3 = local2\Field4[$00]
                    If (local3\Field0\Field0 <> $04) Then
                        se_error_expecting(local3\Field0, "identifier")
                        Return $00
                    EndIf
                    If (se_definelocal(local3\Field0\Field1, $01, local3\Field0) = $00) Then
                        se_error(local3\Field0, (("duplicate identifier '" + local3\Field0\Field1) + "'"), $01)
                        Return $00
                    EndIf
                    local8 = $00
                Else
                    se_error_expecting(local2\Field0, "identifier")
                    Return $00
                EndIf
                local2 = local2\Field8
                If (local2 = Null) Then
                    se_error_eol(local0)
                    Return $00
                ElseIf (local2\Field0\Field0 = $08) Then
                    local2 = local2\Field8
                    local8 = $01
                EndIf
            Forever
    End Select
    Return $00
End Function
